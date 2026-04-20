from __future__ import annotations

from pathlib import Path
import re
import xml.etree.ElementTree as ET

ROOT = Path(__file__).resolve().parent.parent
REPORTS = ROOT / "target" / "surefire-reports"
TARGET = ROOT / "target"
SERVICE_DIR = ROOT / "src" / "main" / "java" / "com" / "ejemplo" / "service"

PESOS_TESTS = {
    "propietario": 3.0,
    "inmueble": 5.0,
}

PESOS_DOCUMENTACION = {
    "propietario": 1.0,
    "inmueble": 1.0,
}

INTERFACES = {
    "propietario": SERVICE_DIR / "IPropietarioService.java",
    "inmueble": SERVICE_DIR / "IInmuebleService.java",
}

METODOS_ESPERADOS = {
    "propietario": {
        "crear": ["crea", "propietario"],
        "buscarPorDni": ["busca", "dni"],
        "listarTodos": ["lista", "propietarios"],
        "actualizar": ["actualiza", "propietario"],
        "eliminar": ["elimina", "dni"],
        "listarActivos": ["activos"],
        "buscarPorCiudad": ["ciudad"],
    },
    "inmueble": {
        "crear": ["crea", "inmueble"],
        "buscarPorId": ["busca", "identificador"],
        "listarTodos": ["lista", "inmuebles"],
        "actualizar": ["actualiza", "inmueble"],
        "eliminar": ["elimina", "identificador"],
        "listarPorPropietario": ["propietario", "dni"],
        "listarVendidos": ["vendidos"],
        "listarDisponibles": ["disponibles"],
        "cambiarPropietario": ["propietario", "dni"],
        "marcarComoVendido": ["vendido"],
        "actualizarMetrosCuadrados": ["metros cuadrados"],
    },
}

def detectar_bloque(nombre_clase: str) -> str:
    nombre = nombre_clase.lower()
    if "propietario" in nombre:
        return "propietario"
    if "inmueble" in nombre:
        return "inmueble"
    return "otros"


def normalizar_texto(texto: str) -> str:
    texto = texto.lower().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u")
    texto = re.sub(r"\s+", " ", texto)
    return texto.strip()


def extraer_javadocs_por_metodo(interface_path: Path) -> dict[str, str]:
    if not interface_path.exists():
        return {}

    texto = interface_path.read_text(encoding="utf-8")
    patron = re.compile(
        r"/\*\*(?P<javadoc>[\s\S]*?)\*/\s*(?:public\s+)?[\w<>\[\], ?]+\s+(?P<metodo>\w+)\s*\(",
        flags=re.MULTILINE,
    )

    resultado: dict[str, str] = {}
    for match in patron.finditer(texto):
        metodo = match.group("metodo")
        javadoc = match.group("javadoc")
        resultado[metodo] = normalizar_texto(javadoc)
    return resultado


def puntuar_documentacion_interface(interface_path: Path, bloque: str) -> dict:
    esperados = METODOS_ESPERADOS[bloque]
    encontrados: list[str] = []
    faltantes: list[str] = []
    sin_javadoc: list[str] = []
    javadocs = extraer_javadocs_por_metodo(interface_path)

    for metodo, palabras_clave in esperados.items():
        texto = javadocs.get(metodo)
        if texto is None:
            faltantes.append(metodo)
            sin_javadoc.append(metodo)
            continue

        if all(normalizar_texto(palabra) in texto for palabra in palabras_clave):
            encontrados.append(metodo)
        else:
            faltantes.append(metodo)

    ratio = 0.0 if not esperados else len(encontrados) / len(esperados)
    puntos = round(ratio * PESOS_DOCUMENTACION[bloque], 2)

    return {
        "puntos": puntos,
        "encontrados": encontrados,
        "faltantes": faltantes,
        "sin_javadoc": sin_javadoc,
        "ruta": str(interface_path),
    }


def puntuar_documentacion_interfaces() -> dict:
    return {
        bloque: puntuar_documentacion_interface(ruta, bloque)
        for bloque, ruta in INTERFACES.items()
    }


def calcular_resumen_tests(report_files: list[Path]) -> dict:
    resumen = {
        "propietario": {"total": 0, "passed": 0, "failed": 0},
        "inmueble": {"total": 0, "passed": 0, "failed": 0},
    }

    for file in report_files:
        root = ET.parse(file).getroot()
        suite_name = root.attrib.get("name", "desconocido")
        bloque = detectar_bloque(suite_name)
        if bloque not in resumen:
            continue

        tests = int(root.attrib.get("tests", 0))
        failures = int(root.attrib.get("failures", 0))
        errors = int(root.attrib.get("errors", 0))
        skipped = int(root.attrib.get("skipped", 0))

        failed = failures + errors + skipped
        passed = max(0, tests - failed)

        resumen[bloque]["total"] += tests
        resumen[bloque]["passed"] += passed
        resumen[bloque]["failed"] += failed

    return resumen


def calcular_nota_bloque(total: int, passed: int, peso_tests: float) -> tuple[float, float]:
    if total == 0:
        return 0.0, 0.0
    ratio = passed / total
    nota_sobre_10 = round(10 * ratio, 2)
    nota_ponderada = round(ratio * peso_tests, 2)
    return nota_sobre_10, nota_ponderada


def generar_informe() -> str:
    report_files = sorted(REPORTS.glob("TEST-*.xml"))
    resumen = calcular_resumen_tests(report_files)
    documentacion = puntuar_documentacion_interfaces()

    total_nota = 0.0
    lineas = []
    lineas.append("=== CALIFICACION AUTOMATICA POR BLOQUE ===")
    lineas.append("")
    lineas.append("Pesos: Propietario = 4.00 (3.00 tests + 1.00 documentacion)")
    lineas.append("       Inmueble = 6.00 (5.00 tests + 1.00 documentacion)")
    lineas.append("")

    for bloque in ("propietario", "inmueble"):
        total = resumen[bloque]["total"]
        passed = resumen[bloque]["passed"]
        failed = resumen[bloque]["failed"]
        nota_sobre_10, nota_tests = calcular_nota_bloque(total, passed, PESOS_TESTS[bloque])
        nota_doc = documentacion[bloque]["puntos"]
        subtotal = round(nota_tests + nota_doc, 2)
        max_bloque = round(PESOS_TESTS[bloque] + PESOS_DOCUMENTACION[bloque], 2)
        total_nota += subtotal

        lineas.append(f"{bloque.upper()} -> tests totales: {total}, pasados: {passed}, fallados: {failed}")
        lineas.append(f"{bloque.upper()} -> nota tests: {nota_sobre_10:.2f}/10, aportacion tests: {nota_tests:.2f}/{PESOS_TESTS[bloque]:.2f}")
        lineas.append(f"{bloque.upper()} -> documentacion interfaz: {nota_doc:.2f}/{PESOS_DOCUMENTACION[bloque]:.2f}")
        lineas.append(f"{bloque.upper()} -> interfaz revisada: {documentacion[bloque]['ruta']}")

        if documentacion[bloque]["faltantes"]:
            lineas.append(f"{bloque.upper()} -> metodos no documentados correctamente: {', '.join(documentacion[bloque]['faltantes'])}")
        else:
            lineas.append(f"{bloque.upper()} -> interfaz completa para este bloque")

        lineas.append(f"{bloque.upper()} -> subtotal: {subtotal:.2f}/{max_bloque:.2f}")
        lineas.append("")

    total_nota = round(total_nota, 2)
    lineas.append("=== NOTA FINAL ===")
    lineas.append(f"Nota final: {total_nota:.2f}/10")
    return "
".join(lineas) + "
"


def main() -> int:
    informe = generar_informe()
    TARGET.mkdir(parents=True, exist_ok=True)
    salida = TARGET / "nota.txt"
    salida.write_text(informe, encoding="utf-8")
    print(informe, end="")
    print(f"Fichero generado: {salida}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())

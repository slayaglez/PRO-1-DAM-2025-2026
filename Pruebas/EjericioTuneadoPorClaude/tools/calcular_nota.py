from __future__ import annotations

from pathlib import Path
import re
import xml.etree.ElementTree as ET

ROOT = Path(__file__).resolve().parent.parent
REPORTS = ROOT / 'target' / 'surefire-reports'
TARGET = ROOT / 'target'
SERVICE_DIR = ROOT / 'src' / 'main' / 'java' / 'com' / 'ejemplo' / 'service'

PESOS_TESTS = {
    'employee': 4.0,
    'skill': 4.0,
}

PESOS_DOCUMENTACION = {
    'employee': 1.0,
    'skill': 1.0,
}

INTERFACES = {
    'employee': SERVICE_DIR / 'IEmployeeService.java',
    'skill': SERVICE_DIR / 'ISkillService.java',
}

METODOS_ESPERADOS = {
    'employee': {
        'crear': ['crea', 'empleado'],
        'buscarPorId': ['busca', 'identificador'],
        'listarTodos': ['lista', 'empleados'],
        'actualizar': ['actualiza', 'empleado'],
        'eliminar': ['elimina', 'empleado'],
        'listarPorRol': ['rol'],
        'listarManagers': ['managers'],
        'cambiarManager': ['manager'],
        'contarSubordinados': ['subordinados'],
        'buscarPorApellido': ['apellido'],
    },
    'skill': {
        'crear': ['crea', 'skill'],
        'buscarPorId': ['busca', 'identificador'],
        'listarTodas': ['lista', 'skills'],
        'actualizar': ['actualiza', 'skill'],
        'eliminar': ['elimina', 'skill'],
        'listarPorCategoria': ['categoria'],
        'asignarEmpleado': ['asigna', 'empleado'],
        'listarPorEmpleado': ['empleado'],
        'contarEmpleadosConSkill': ['empleados', 'skill'],
        'listarSinAsignar': ['sin asignar'],
    },
}


def detectar_bloque(nombre_clase: str) -> str:
    nombre = nombre_clase.lower()
    if 'employee' in nombre:
        return 'employee'
    if 'skill' in nombre:
        return 'skill'
    return 'otros'


def normalizar_texto(texto: str) -> str:
    texto = texto.lower().replace('á', 'a').replace('é', 'e').replace('í', 'i').replace('ó', 'o').replace('ú', 'u')
    texto = re.sub(r'\s+', ' ', texto)
    return texto.strip()


def extraer_javadocs_por_metodo(interface_path: Path) -> dict[str, str]:
    if not interface_path.exists():
        return {}

    texto = interface_path.read_text(encoding='utf-8')
    patron = re.compile(r'/\*\*(?P<javadoc>[\s\S]*?)\*/\s*(?:public\s+)?[\w<>\[\], ?]+\s+(?P<metodo>\w+)\s*\(', flags=re.MULTILINE)

    resultado: dict[str, str] = {}
    for match in patron.finditer(texto):
        resultado[match.group('metodo')] = normalizar_texto(match.group('javadoc'))
    return resultado


def puntuar_documentacion_interface(interface_path: Path, bloque: str) -> dict:
    esperados = METODOS_ESPERADOS[bloque]
    encontrados = []
    faltantes = []
    javadocs = extraer_javadocs_por_metodo(interface_path)

    for metodo, palabras_clave in esperados.items():
        texto = javadocs.get(metodo)
        if texto is None:
            faltantes.append(metodo)
            continue
        if all(normalizar_texto(palabra) in texto for palabra in palabras_clave):
            encontrados.append(metodo)
        else:
            faltantes.append(metodo)

    ratio = 0.0 if not esperados else len(encontrados) / len(esperados)
    puntos = round(ratio * PESOS_DOCUMENTACION[bloque], 2)
    return {'puntos': puntos, 'faltantes': faltantes, 'ruta': str(interface_path)}


def calcular_resumen_tests(report_files: list[Path]) -> dict:
    resumen = {
        'employee': {'total': 0, 'passed': 0, 'failed': 0},
        'skill': {'total': 0, 'passed': 0, 'failed': 0},
    }

    for file in report_files:
        root = ET.parse(file).getroot()
        bloque = detectar_bloque(root.attrib.get('name', 'desconocido'))
        if bloque not in resumen:
            continue
        tests = int(root.attrib.get('tests', 0))
        failures = int(root.attrib.get('failures', 0))
        errors = int(root.attrib.get('errors', 0))
        skipped = int(root.attrib.get('skipped', 0))
        failed = failures + errors + skipped
        passed = max(0, tests - failed)
        resumen[bloque]['total'] += tests
        resumen[bloque]['passed'] += passed
        resumen[bloque]['failed'] += failed
    return resumen


def generar_informe() -> str:
    report_files = sorted(REPORTS.glob('TEST-*.xml'))
    resumen = calcular_resumen_tests(report_files)
    documentacion = {bloque: puntuar_documentacion_interface(ruta, bloque) for bloque, ruta in INTERFACES.items()}

    total_nota = 0.0
    lineas = []
    lineas.append('=== CALIFICACION AUTOMATICA POR BLOQUE ===')
    lineas.append('')

    for bloque in ('employee', 'skill'):
        total = resumen[bloque]['total']
        passed = resumen[bloque]['passed']
        ratio = 0.0 if total == 0 else passed / total
        nota_tests = round(ratio * PESOS_TESTS[bloque], 2)
        nota_doc = documentacion[bloque]['puntos']
        subtotal = round(nota_tests + nota_doc, 2)
        total_nota += subtotal

        lineas.append(f"{bloque.upper()} -> tests totales: {total}, pasados: {passed}, fallados: {resumen[bloque]['failed']}")
        lineas.append(f"{bloque.upper()} -> aportacion tests: {nota_tests:.2f}/{PESOS_TESTS[bloque]:.2f}")
        lineas.append(f"{bloque.upper()} -> documentacion interfaz: {nota_doc:.2f}/{PESOS_DOCUMENTACION[bloque]:.2f}")
        if documentacion[bloque]['faltantes']:
            lineas.append(f"{bloque.upper()} -> metodos no documentados correctamente: {', '.join(documentacion[bloque]['faltantes'])}")
        else:
            lineas.append(f"{bloque.upper()} -> interfaz completa para este bloque")
        lineas.append('')

    lineas.append('=== NOTA FINAL ===')
    lineas.append(f'Nota final: {round(total_nota, 2):.2f}/10')
    return '\n'.join(lineas) + '\n'


def main() -> int:
    informe = generar_informe()
    TARGET.mkdir(parents=True, exist_ok=True)
    salida = TARGET / 'nota.txt'
    salida.write_text(informe, encoding='utf-8')
    print(informe, end='')
    print(f'Fichero generado: {salida}')
    return 0


if __name__ == '__main__':
    raise SystemExit(main())

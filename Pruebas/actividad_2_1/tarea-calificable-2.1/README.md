# Ejercicio Calificable 2.1

## Ejercicio 1

### Objetivo

- Modelar una entidad simple (`Persona`) con **identidad lógica por `id`**.  
- ¿Qué debes de implementar?:
  - Constructores (por defecto y completo).
  - Encapsulamiento (getters/setters).
  - Contrato `equals`/`hashCode`.
  - Representación legible con `toString`.Incluye la palabra **"Persona{id=..."**. _Analiza los test para ver la definición exacta_.

### Lista de verificación

- Constructor por defecto inicializa a `null/0` sin lanzar excepciones.  
- Constructor completo asigna `id`, `nombre`, `edad`.  
- Getters y setters funcionan correctamente.  
- `equals` cumple **reflexividad, simetría, transitividad**, maneja `null` y otra clase.  
- `equals` usa **solo `id`** y devuelve `false` si algún `id` es `null`.  
- `hashCode` es consistente con `equals`.  
- `toString` es legible y muestra los tres campos.

## Ejercicio 2

### Objetivo

Implementa un método que cuente la cantidad de vocales en una cadena de texto **(contarVocales)**. Las vocales pueden ser tanto mayúsculas como minúsculas (a, e, i, o, u).

## Ejercicio 3

### Objetivo

Calcula el área de un triángulo usando la **fórmula de Herón**, que se calcula según la fórmula:

ados los tres lados `a`, `b`, `c`:

```
s    = (a + b + c) / 2
area = sqrt( s * (s - a) * (s - b) * (s - c) )
```

donde `s` es el **semiperímetro** y `sqrt` denota la raíz cuadrada.

---

## Reglas que se deben cumplir

- `a > 0`, `b > 0`, `c > 0`  
- **Desigualdad triangular estricta** (evita triángulos degenerados):
  - `a + b > c`
  - `a + c > b`
  - `b + c > a`
- Si no se cumple alguna regla, **o el área calculada no es estrictamente positiva**, la función **retorna `-1.0`**.

## Ejercicio 4

### Objetivo

Dada una **frase** `frase` y una **palabra** `palabra`, implementa un algoritmo que:

- Devuelva el **número de caracteres** de `palabra` si **aparece como palabra completa** en `frase`.
- Devuelva **`0`** en caso contrario (no aparece, aparece solo parcialmente o la entrada es inválida).

**Definiciones**

- **Palabra**: bloque contiguo de **letras o dígitos**.
- **Separadores**: todo lo que **no** sea letra ni dígito (espacios, puntuación, guiones, emojis, etc.).
- La búsqueda es **insensible a mayúsculas/minúsculas** (case-insensitive).

### La función que debes de implementar

```java
public static int tamPalabraEnFrase(String frase, String palabra)
```

## Ejercicio 5

### Objetivo

En este ejercicio que deben definirse las utilidades basadas en el **Teorema de Pitágoras**.

---

### Métodos

#### 1) `hipotenusa(double a, double b)`

**Descripción**  

Calcula la hipotenusa de un triángulo rectángulo con catetos `a` y `b` usando:
\[ c = \sqrt{a^2 + b^2} \]

**Detalles de implementación**

- **Política de entradas inválidas**: si `a <= 0` o `b <= 0` ⇒ devuelve **`-1.0`**.

---

#### 2) `catetoDesdeHipotenusa(double c, double otroCateto)`

**Descripción**  

Calcula el **cateto faltante** a partir de la hipotenusa `c` y el **otro** cateto (`b`):
\[ a = \sqrt{c^2 - b^2} \]

**Detalles de implementación**

- Valida que **`c > otroCateto > 0`**.  
  Si no se cumple (o por redondeo `c^2 - b^2 < 0`) ⇒ devuelve **`-1.0`**.

### Requisitos (restricciones que deben cumplirse)

1. **Entradas positivas**
   - Para *cálculo* (`hipotenusa`, `catetoDesdeHipotenusa`): todos los lados provistos deben ser **> 0**.

2. **Orden y relaciones válidas**

   - En `catetoDesdeHipotenusa`: debe cumplirse **`c > otroCateto`**; de lo contrario devuelve `-1.0`.

3. **Política de error**

   - Métodos que **devuelven `double`**: regresan **`-1.0`** ante entradas inválidas o relaciones imposibles.

---

### Fórmulas usadas

- **Hipotenusa**: \( c = \sqrt{a^2 + b^2} \)
- **Cateto**: \( a = \sqrt{c^2 - b^2} \)  *(requiere \( c > b \))*

---

### Ejemplos rápidos

```text
hipotenusa(3, 4);                // 5.0
catetoDesdeHipotenusa(13, 5);    // 12.0

hipotenusa(-3, 4);               // -1.0 (inválido)
catetoDesdeHipotenusa(5, 7);     // -1.0 (c <= cateto)
```


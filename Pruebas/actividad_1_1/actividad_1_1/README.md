# ¡Bienvenido, joven aprendiz de programador (**Java**!) 🧙‍♂️☕  

Aquí tienes las **misiones** que debes de completar.

- **Entrada de datos por teclado**  
- **Condicionales**  
- **Funciones matemáticas**  

___Acepta el reto y… ¡que la JVM te acompañe!___

## Misión 1: El Oráculo del Teclado

El programa deberá:

1. Preguntar tu **nombre**, **edad** y **ciudad**.
2. Devolver un mensaje digno de una tarjeta de presentación digital:  

   ```code
   Hola Marta, tienes 22 años y vives en Barcelona.
   ```

> **Pista secreta:** Usa `Scanner`. No olvides cerrarlo, ¡los recursos se fugan más que el café en la oficina!  

---

## Misión 2: El Guardián de las Decisiones

Tu código deberá:

1. Preguntar un **número entero** y decidir:
   - ¿Es positivo, negativo o cero?
2. Mostrar el **día de la semana**:
   - 1 = Lunes, 2 = Martes, …, 7 = Domingo.  
   - Si alguien escribe el **8 o superior**, responde con un sonoro:  

     ```code
     ¡Ese día no existe, viajero del tiempo!
     ```

📌 **Ejemplo de ejecución:**

```code
Introduce un número del 1 al 7: -5
```

```code
El número es negativo, viajero del tiempo.
```

```code
Introduce un número del 1 al 7: 0
```

```code
Piensa un numero viajero del tiempo.
```


```code
Introduce un número del 1 al 7: 3
```

```code
El día es Miércoles. Sigue así viajero.
```

---

## Misión 3: El Maestro de las Áreas

Un menú místico aparecerá en consola con tres caminos:

1. Círculo 🌀  
2. Cuadrado ⬛  
3. Triángulo 🔺  

Según tu elección:

- Preguntará los datos necesarios.  
- Usará su poder matemágico para calcular el área.  

 **Fórmulas legendarias:**

- Círculo: `π * radio^2`  
- Cuadrado: `lado^2`  
- Triángulo: `(base * altura) / 2`  

>**π=3.14**

**Ejemplo de ejecución:**

```code
Elige una figura para calcular el área maestro:
```

El maestro selecciona la opción 1.

```code
Introduce el radio: 5
```

```code
El área del círculo es maestro: 78.54
```

El maestro selecciona la opción 2.

```code
Introduce el lado: 5
```

```code
El área del cuadrado es maestro: 25
```

El maestro selecciona la opción 3.

```code
Introduce la alura: 5
Introduce la base: 5
```

```code
El área del triángulo es maestro: 12.5
```

## Misión 4: El Guardián del Array

Tu programa debe trabajar con un **array de números enteros**. La misión es:
  
1. Recorrer el array y mostrar:  
   - Los números **positivos**.  
   - Los números **negativos**.  
   - Los **ceros** que se han encontrado.  
2. Además, determinar cuál es el **número mayor** y el **número menor** del array.

📌 **Ejemplo de array:**

```code
{-5,0,7,3,-2}
```

```code
numero negativo=-5
```

```code
cero detectado=0
```

```code
numero positivo=7
```

```code
numero positivo=3
```

```code
numero negativo=-2
```

---

> **¡Tu reto comienza ahora!**

## Rúbrica de Evaluación - Misiones Java

Cada misión se evalúa sobre **2,5 puntos**, distribuidos así:  

- **Funciona correctamente** → 1,5 puntos  
- **Está documentado (comentarios / claridad)** → 0,5 puntos  
- ⚡ **Es óptimo (eficiente, buenas prácticas, estilo de código limpio)** → 0,5 puntos  

---

## Tabla general de rúbrica

| Misión | Funciona (1,5) | Documentado (0,5) | Óptimo (0,5) | Total (2,5) |
|--------|----------------|-------------------|--------------|-------------|
| **Misión 1: El Oráculo del Teclado** | Lee nombre, edad y ciudad, muestra mensaje correcto | Código con comentarios explicativos | Uso correcto de `Scanner` y cierre adecuado | 2,5 |
| **Misión 2: El Guardián de las Decisiones** | Detecta positivo/negativo/cero y muestra día correcto | Comentarios adecuados | Uso claro de estructuras | 2,5 |
| **Misión 3: El Maestro de las Áreas** | Calcula correctamente áreas de círculo, cuadrado y triángulo | Comentarios que expliquen fórmulas | Estructuras claras y código óptimo | 2,5 |
| **Misión 4: El Guardián del Array** | ➡️ Desglose abajo | Comentarios en recorrido del array | Uso eficiente del bucle (mínimos recorridos) | 2,5 |

---

## 📌 Desglose detallado de la Misión 4 (2,5 puntos)

| Subcriterio M4 | Descripción | Puntos |
|----------------|-------------|--------|
| Detección de **ceros** | El programa cuenta correctamente la cantidad de `0` en el array | 0,5 |
| Detección de **positivos** | Muestra correctamente los números positivos del array | 0,5 |
| Detección de **negativos** | Muestra correctamente los números negativos del array | 0,5 |
| Determina **mayor y menor** | Identifica el valor máximo y mínimo en el array | 0,5 |
| Documentado y óptimo | Código con comentarios claros y bucle eficiente | 0,5 |

---


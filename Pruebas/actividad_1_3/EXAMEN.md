
Crea/Corrige las clases (constructores/gettes/setters/equals/toString) para que el programa se ejecute de la siguente forma:

Ejercicio1

```code
== Pruebas Punto2D ==
p1.equals(p2): true
hash(p1) == hash(p2): true
p1.equals(null): false
p1.equals(new Object()): false

-- getters/setters --
p0 -> x=3,0, y=-4,0

-- propiedades equals --
Reflexiva:  true
Simétrica:  true
Transitiva: true

-- mutación y comparación --
Tras p2.setY(2.1): p1.equals(p2) -> false

-- listado --
1) (x=3.0, y=-4.0)
2) (x=1.5, y=2.0)
3) (x=1.5, y=2.1)
4) (x=1.5, y=2.0)

```

Ejercicio2:

```code
== Pruebas Libro ==
"Clean Code" de Robert C. Martin (ISBN: 9780132350884)
"Otro" de Alguien (ISBN: 9780132350884)
"Refactoring" de Martin Fowler (ISBN: 032135668X)
"Refactoring 2" de Martin Fowler (ISBN: 032135668x)

-- equals/hashCode --
a.equals(b) (mismo ISBN): true
c.equals(d) (X/x): true
hash(a) == hash(b): true

Tamaño del set (esperado 2): 2

-- getters/setters --
b -> titulo=Clean Code (Edición bolsillo), autor=Robert C. Martin, isbn=9780132350884

-- cambio de ISBN --
a.equals(b) antes: true
a.equals(b) después: false
"Clean Code (Edición bolsillo)" de Robert C. Martin (ISBN: 1111111111)
´´

Ejercicio3:

```code
== Pruebas CuentaBancaria ==
ES12-3456 - Ana - saldo=0.0
es12-3456 - Ana María - saldo=100.0
XX00-0001 - Luis - saldo=250.5

-- equals/hashCode --
a.equals(b) (mismo número): true
a.hashCode() == b.hashCode(): true
a.equals(c): false
a.equals(null): false

-- getters/setters --
Titular c (antes): Luis
Titular c (después): Luis P.
Número c (antes): XX00-0001
Número c (después): XX00-0002

-- cambio de número --
a.equals(b) antes: true
a.equals(b) después: false
b -> ES12-9999 - Ana María - saldo=100.0

-- listado --
1) ES12-3456 - Ana - saldo=0.0
2) ES12-9999 - Ana María - saldo=100.0
3) XX00-0002 - Luis P. - saldo=250.5
```

Ejercicio4:

```code
== Pruebas Coche ==
coche1: (Marca desconocida) (Modelo desconocido) ((Año desconocido)) - sin matrícula
coche2: Toyota Corolla (2018) - 1234-ABC
coche3: Toyota Auris (2016) - 1234-abc
c3: SEAT Ibiza (2020) - 9999-ZZZ

-- equals --
coche2.equals(coche3): true
coche2.equals(c3): false
coche2.equals(null): false

-- getters/setters --
Antes -> coche1: (Marca desconocida) (Modelo desconocido) ((Año desconocido)) - sin matrícula
Después -> coche1: Ford Focus (2012) - 0000-AAA
coche1.getMatricula()=0000-AAA, getMarca()=Ford, getModelo()=Focus, getAnio()=2012

-- cambio de matrícula --
coche2.equals(coche3) antes: true
coche2.equals(coche3) después: false
coche3 actualizado: Toyota Auris (2016) - 1234-XYZ
```

Ejercicio5:

```code
== Pruebas Estudiante ==
estudiante1: 111A - Lucía
estudiante2: 111a - Lucía G.
estudiante3: 222B - Hugo

-- equals --
estudiante1.equals(estudiante2): true
estudiante1.equals(estudiante3): false
estudiante1.equals(null): false

-- getters/setters --
Nombre estudiante3 (antes): Hugo
Nombre estudiante3 (después): Hugo P.
DNI estudiante3 (antes): 222B
DNI estudiante3 (después): 222B-NEW

-- cambio de DNI --
estudiante1.equals(estudiante2) antes: true
estudiante1.equals(estudiante2) después: false
estudiante2 actualizado: 333C - Lucía G.

-- listado --
1) 111A - Lucía
2) 333C - Lucía G.
3) 222B-NEW - Hugo P.

Pruebas completas.
```
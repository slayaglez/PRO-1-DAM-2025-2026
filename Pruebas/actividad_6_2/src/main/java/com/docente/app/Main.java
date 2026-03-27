package com.docente.app;

import com.docente.modelo.Alumno;
import com.docente.modelo.AlumnoMatriculado;
import com.docente.modelo.Asignatura;
import com.docente.servicio.AlumnoMatriculadoService;
import com.docente.servicio.AlumnoService;
import com.docente.servicio.AsignaturaService;
import com.docente.servicio.IAlumnoMatriculadoService;
import com.docente.servicio.IAlumnoService;
import com.docente.servicio.IAsignaturaService;

import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        IAlumnoService alumnoService = new AlumnoService();
        IAsignaturaService asignaturaService = new AsignaturaService();
        IAlumnoMatriculadoService alumnoMatriculadoService = new AlumnoMatriculadoService();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerEntero(scanner, "Seleccione una opción: ");
            scanner.nextLine();

            switch (opcion) {
                case 1 -> crearAlumno(scanner, alumnoService);
                case 2 -> listarAlumnos(alumnoService);
                case 3 -> crearAsignatura(scanner, asignaturaService);
                case 4 -> listarAsignaturas(asignaturaService);
                case 5 -> buscarAsignatura(scanner, asignaturaService);
                case 6 -> modificarAsignatura(scanner, asignaturaService);
                case 7 -> eliminarAsignatura(scanner, asignaturaService);
                case 8 -> crearAlumnoMatriculado(scanner, alumnoMatriculadoService);
                case 9 -> listarAlumnosMatriculados(alumnoMatriculadoService);
                case 10 -> matricularAsignatura(scanner, alumnoMatriculadoService);
                case 11 -> desmatricularAsignatura(scanner, alumnoMatriculadoService);
                case 12 -> consultarNumeroAsignaturas(scanner, alumnoMatriculadoService);
                case 13 -> consultarMatriculacion(scanner, alumnoMatriculadoService);
                case 14 -> buscarAlumnoMatriculado(scanner, alumnoMatriculadoService);
                case 0 -> System.out.println("Programa finalizado.");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n--- MENÚ CRUD ACADEMIA ---");
        System.out.println("1. Crear alumno");
        System.out.println("2. Listar alumnos");
        System.out.println("3. Crear asignatura");
        System.out.println("4. Listar asignaturas");
        System.out.println("5. Buscar asignatura");
        System.out.println("6. Modificar asignatura");
        System.out.println("7. Eliminar asignatura");
        System.out.println("8. Crear alumno matriculado");
        System.out.println("9. Listar alumnos matriculados");
        System.out.println("10. Matricular alumno en asignatura");
        System.out.println("11. Desmatricular alumno de asignatura");
        System.out.println("12. Consultar número de asignaturas de un alumno");
        System.out.println("13. Consultar si un alumno está matriculado en una asignatura");
        System.out.println("14. Buscar alumno matriculado");
        System.out.println("0. Salir");
    }

    private static void crearAlumno(Scanner scanner, IAlumnoService servicio) {
        System.out.print("Identificador (ej. ALU001): ");
        String identificador = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        int edad = leerEntero(scanner, "Edad: ");
        scanner.nextLine();
        System.out.print("Curso (ej. 1DAM, 2ESO, 1BACH): ");
        String curso = scanner.nextLine();

        boolean resultado = servicio.crearAlumno(identificador, nombre, edad, curso);
        System.out.println(resultado ? "El alumno se ha creado correctamente" : "Se ha producido un error creando el alumno");
    }

    private static void listarAlumnos(IAlumnoService servicio) {
        List<String> alumnos = servicio.read();
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }
        alumnos.forEach(System.out::println);
    }

    private static void crearAsignatura(Scanner scanner, IAsignaturaService servicio) {
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        int horas = leerEntero(scanner, "Horas semanales: ");
        scanner.nextLine();

        boolean resultado = servicio.crearAsignatura(codigo, nombre, horas);
        System.out.println(resultado ? "Asignatura creada correctamente" : "No se pudo crear la asignatura");
    }

    private static void listarAsignaturas(IAsignaturaService servicio) {
        List<String> asignaturas = servicio.read();
        if (asignaturas.isEmpty()) {
            System.out.println("No hay asignaturas registradas.");
            return;
        }
        asignaturas.forEach(System.out::println);
    }

    private static void buscarAsignatura(Scanner scanner, IAsignaturaService servicio) {
        System.out.print("Código de la asignatura: ");
        String codigo = scanner.nextLine();
        Asignatura asignatura = servicio.buscarAsignatura(codigo);
        System.out.println(asignatura != null ? asignatura : "Asignatura no encontrada");
    }

    private static void modificarAsignatura(Scanner scanner, IAsignaturaService servicio) {
        System.out.print("Código de la asignatura a modificar: ");
        String codigo = scanner.nextLine();
        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();
        int horas = leerEntero(scanner, "Nuevas horas semanales: ");
        scanner.nextLine();

        boolean resultado = servicio.actualizarAsignatura(codigo, nombre, horas);
        System.out.println(resultado ? "Asignatura modificada correctamente" : "No se pudo modificar la asignatura");
    }

    private static void eliminarAsignatura(Scanner scanner, IAsignaturaService servicio) {
        System.out.print("Código de la asignatura a eliminar: ");
        String codigo = scanner.nextLine();
        boolean resultado = servicio.deleteAsignatura(codigo);
        System.out.println(resultado ? "Asignatura eliminada correctamente" : "No se pudo eliminar la asignatura");
    }

    private static void crearAlumnoMatriculado(Scanner scanner, IAlumnoMatriculadoService servicio) {
        System.out.print("Identificador: ");
        String identificador = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        int edad = leerEntero(scanner, "Edad: ");
        scanner.nextLine();
        System.out.print("Curso: ");
        String curso = scanner.nextLine();

        boolean resultado = servicio.crearAlumnoMatriculado(identificador, nombre, edad, curso);
        System.out.println(resultado ? "Alumno matriculado creado correctamente" : "No se pudo crear el alumno matriculado");
    }

    private static void listarAlumnosMatriculados(IAlumnoMatriculadoService servicio) {
        List<String> alumnos = servicio.read();
        if (alumnos.isEmpty()) {
            System.out.println("No hay alumnos matriculados.");
            return;
        }
        alumnos.forEach(System.out::println);
    }

    private static void matricularAsignatura(Scanner scanner, IAlumnoMatriculadoService servicio) {
        System.out.print("Identificador del alumno: ");
        String identificador = scanner.nextLine();
        System.out.print("Código de la asignatura: ");
        String codigo = scanner.nextLine();
        boolean resultado = servicio.matricularAsignatura(identificador, codigo);
        System.out.println(resultado ? "Matrícula realizada correctamente" : "No se pudo realizar la matrícula");
    }

    private static void desmatricularAsignatura(Scanner scanner, IAlumnoMatriculadoService servicio) {
        System.out.print("Identificador del alumno: ");
        String identificador = scanner.nextLine();
        System.out.print("Código de la asignatura: ");
        String codigo = scanner.nextLine();
        boolean resultado = servicio.desmatricularAsignatura(identificador, codigo);
        System.out.println(resultado ? "Desmatriculación realizada correctamente" : "No se pudo desmatricular la asignatura");
    }

    private static void consultarNumeroAsignaturas(Scanner scanner, IAlumnoMatriculadoService servicio) {
        System.out.print("Identificador del alumno: ");
        String identificador = scanner.nextLine();
        int numero = servicio.getNumeroAsignaturas(identificador);
        System.out.println(numero >= 0 ? "Número de asignaturas: " + numero : "Alumno no encontrado");
    }

    private static void consultarMatriculacion(Scanner scanner, IAlumnoMatriculadoService servicio) {
        System.out.print("Identificador del alumno: ");
        String identificador = scanner.nextLine();
        System.out.print("Código de la asignatura: ");
        String codigo = scanner.nextLine();
        boolean resultado = servicio.estaMatriculadoEn(identificador, codigo);
        System.out.println(resultado ? "Sí, el alumno está matriculado en esa asignatura" : "No, el alumno no está matriculado en esa asignatura");
    }

    private static void buscarAlumnoMatriculado(Scanner scanner, IAlumnoMatriculadoService servicio) {
        System.out.print("Identificador del alumno: ");
        String identificador = scanner.nextLine();
        AlumnoMatriculado alumno = servicio.buscarAlumnoMatriculado(identificador);
        System.out.println(alumno != null ? alumno : "Alumno matriculado no encontrado");
    }

    private static int leerEntero(Scanner scanner, String mensaje) {
        while (true) {
            System.out.print(mensaje);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("Debe introducir un número entero.");
            scanner.nextLine();
        }
    }
}

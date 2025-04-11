package Vista;

import Controlador.ElControlador;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElControlador controlador = new ElControlador();
        String opcion = "";

        while (!opcion.equals("4")) {
            System.out.println("\n***** SISTEMA DE GESTIÓN ACADÉMICA *****");
            System.out.println("1) Gestión de Departamentos");
            System.out.println("2) Gestión de Asignaturas");
            System.out.println("3) Gestión de Asistencias");
            System.out.println("4) Salir");
            System.out.print("Digite la opción deseada: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    menuDepartamentos(controlador, scanner);
                    break;
                case "2":
                    menuAsignaturas(controlador, scanner);
                    break;
                case "3":
                    menuAsistencias(controlador, scanner);
                    break;
                case "4":
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
        scanner.close();
    }

    private static void menuDepartamentos(ElControlador controlador, Scanner scanner) {
        String opcion = "";
        while (!opcion.equals("4")) {
            System.out.println("\n***** GESTIÓN DE DEPARTAMENTOS *****");
            System.out.println("1) Crear Departamento");
            System.out.println("2) Consultar Departamento");
            System.out.println("3) Actualizar Departamento");
            System.out.println("4) Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre del Departamento: ");
                    String nombre = scanner.nextLine();
                    controlador.crearDepartamento(nombre);
                    System.out.println("Departamento creado exitosamente.");
                    break;
                case "2":
                    String nombreDepto = controlador.consultarDepartamento();
                    System.out.println("Nombre del Departamento: " + nombreDepto);
                    break;
                case "3":
                    System.out.print("Nuevo nombre del Departamento: ");
                    String nuevoNombre = scanner.nextLine();
                    controlador.actualizarDepartamento(nuevoNombre);
                    System.out.println("Departamento actualizado exitosamente.");
                    break;
                case "4":
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    private static void menuAsignaturas(ElControlador controlador, Scanner scanner) {
        String opcion = "";
        while (!opcion.equals("5")) {
            System.out.println("\n***** GESTIÓN DE ASIGNATURAS *****");
            System.out.println("1) Agregar Asignatura");
            System.out.println("2) Consultar Asignatura");
            System.out.println("3) Modificar Asignatura");
            System.out.println("4) Eliminar Asignatura");
            System.out.println("5) Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Nombre de la Asignatura: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Código de la Asignatura: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    String grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    String semestre = scanner.nextLine();
                    System.out.print("Créditos: ");
                    int creditos = Integer.parseInt(scanner.nextLine());

                    boolean agregada = controlador.agregarAsignatura(nombre, creditos, codigo, grupo, semestre);
                    if (agregada) {
                        System.out.println("Asignatura añadida correctamente.");
                    } else {
                        System.out.println("Error al agregar la asignatura.");
                    }
                    break;
                case "2":
                    System.out.print("Código de la Asignatura: ");
                    codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    semestre = scanner.nextLine();

                    Object asignatura = controlador.consultarAsignatura(codigo, grupo, semestre);
                    if (asignatura != null) {
                        System.out.println("Asignatura encontrada: " + asignatura.toString());
                    } else {
                        System.out.println("Asignatura no encontrada.");
                    }
                    break;
                case "3":
                    System.out.print("Código de la Asignatura a modificar: ");
                    codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    semestre = scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Nuevos créditos: ");
                    creditos = Integer.parseInt(scanner.nextLine());

                    boolean modificada = controlador.modificarAsignatura(codigo, grupo, semestre, nombre, creditos);
                    if (modificada) {
                        System.out.println("Asignatura modificada correctamente.");
                    } else {
                        System.out.println("Error al modificar la asignatura.");
                    }
                    break;
                case "4":
                    System.out.print("Código de la Asignatura a eliminar: ");
                    codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    semestre = scanner.nextLine();

                    boolean eliminada = controlador.eliminarAsignatura(codigo, grupo, semestre);
                    if (eliminada) {
                        System.out.println("Asignatura eliminada correctamente.");
                    } else {
                        System.out.println("Error al eliminar la asignatura.");
                    }
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    private static void menuAsistencias(ElControlador controlador, Scanner scanner) {
        String opcion = "";
        while (!opcion.equals("5")) {
            System.out.println("\n***** GESTIÓN DE ASISTENCIAS *****");
            System.out.println("1) Registrar Asistencia");
            System.out.println("2) Consultar Asistencia");
            System.out.println("3) Modificar Asistencia");
            System.out.println("4) Eliminar Asistencia");
            System.out.println("5) Volver al menú principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("Código de la Asignatura: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    String grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    String semestre = scanner.nextLine();
                    System.out.print("Fecha de la Asistencia (aaaa/mm/dd): ");
                    String fecha = scanner.nextLine();
                    System.out.print("Hora de Inicio (hh:mm): ");
                    String horaInicio = scanner.nextLine();
                    System.out.print("Hora Final (hh:mm): ");
                    String horaFinal = scanner.nextLine();

                    ArrayList<String> codigosAA = new ArrayList<>();
                    ArrayList<String> estados = new ArrayList<>();

                    System.out.print("Número de estudiantes: ");
                    int numEstudiantes = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < numEstudiantes; i++) {
                        System.out.print("Código del estudiante " + (i + 1) + ": ");
                        String codigoEstudiante = scanner.nextLine();
                        System.out.print("Estado (0: A tiempo, 1: tarde, 2: no llegó): ");
                        String estado = scanner.nextLine();

                        codigosAA.add(codigoEstudiante);
                        estados.add(estado);
                    }

                    boolean resultado = controlador.adicionarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal, codigosAA, estados);
                    if (resultado) {
                        System.out.println("Asistencia registrada correctamente.");
                    } else {
                        System.out.println("Error al registrar la asistencia.");
                    }
                    break;
                case "2":
                    System.out.print("Código de la Asignatura: ");
                    codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    semestre = scanner.nextLine();
                    System.out.print("Fecha de la Asistencia (aaaa/mm/dd): ");
                    fecha = scanner.nextLine();
                    System.out.print("Hora de Inicio (hh:mm): ");
                    horaInicio = scanner.nextLine();
                    System.out.print("Hora Final (hh:mm): ");
                    horaFinal = scanner.nextLine();

                    Object asistencia = controlador.consultarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal);
                    if (asistencia != null) {
                        System.out.println("Asistencia encontrada: " + asistencia.toString());
                    } else {
                        System.out.println("Asistencia no encontrada.");
                    }
                    break;
                case "3":
                    System.out.print("Código de la Asignatura: ");
                    codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    semestre = scanner.nextLine();
                    System.out.println("Datos actuales de la asistencia:");
                    System.out.print("Fecha actual (aaaa/mm/dd): ");
                    fecha = scanner.nextLine();
                    System.out.print("Hora de Inicio actual (hh:mm): ");
                    horaInicio = scanner.nextLine();
                    System.out.print("Hora Final actual (hh:mm): ");
                    horaFinal = scanner.nextLine();

                    System.out.println("\nNuevos datos de la asistencia:");
                    System.out.print("Nueva fecha (aaaa/mm/dd): ");
                    String nuevaFecha = scanner.nextLine();
                    System.out.print("Nueva hora de Inicio (hh:mm): ");
                    String nuevaHoraInicio = scanner.nextLine();
                    System.out.print("Nueva hora Final (hh:mm): ");
                    String nuevaHoraFinal = scanner.nextLine();

                    codigosAA = new ArrayList<>();
                    estados = new ArrayList<>();

                    System.out.print("Número de estudiantes: ");
                    numEstudiantes = Integer.parseInt(scanner.nextLine());

                    for (int i = 0; i < numEstudiantes; i++) {
                        System.out.print("Código del estudiante " + (i + 1) + ": ");
                        String codigoEstudiante = scanner.nextLine();
                        System.out.print("Estado (0: A tiempo, 1: tarde, 2: no llegó): ");
                        String estado = scanner.nextLine();

                        codigosAA.add(codigoEstudiante);
                        estados.add(estado);
                    }

                    boolean modificada = controlador.modificarAsistencia(codigo, grupo, semestre,
                            fecha, horaInicio, horaFinal,
                            nuevaFecha, nuevaHoraInicio, nuevaHoraFinal,
                            codigosAA, estados);
                    if (modificada) {
                        System.out.println("Asistencia modificada correctamente.");
                    } else {
                        System.out.println("Error al modificar la asistencia.");
                    }
                    break;
                case "4":
                    System.out.print("Código de la Asignatura: ");
                    codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    semestre = scanner.nextLine();
                    System.out.print("Fecha de la Asistencia (aaaa/mm/dd): ");
                    fecha = scanner.nextLine();
                    System.out.print("Hora de Inicio (hh:mm): ");
                    horaInicio = scanner.nextLine();
                    System.out.print("Hora Final (hh:mm): ");
                    horaFinal = scanner.nextLine();

                    boolean eliminada = controlador.eliminarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal);
                    if (eliminada) {
                        System.out.println("Asistencia eliminada correctamente.");
                    } else {
                        System.out.println("Error al eliminar la asistencia.");
                    }
                    break;
                case "5":
                    break;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
}/*
*1. Consultar departamento--->mostrar nombre del departamento.
*2. Modificar departamento---->Cambiar el nombre del departamento.
*3. Registar estudiantes en el departamento----> nombre, tipo de documento, pedir el numero de documento.
*4. Consultar estudiantes en el departamento----> Buscar Tipo de documento, numero de documento. Muestra el nombre
*5  Modificar estudiante en el departamento----> Busca tipo de documento, numero de documento. Se cambia el nombre, tipo de documento.
*6. Agregar Asignatura----> Nombre, codigo (CAD-1), creditos, sección (numero de grupo)(401M o 402M), semestre(2024-1 2024-2).
*7. Consultar Asignatura---> buscar con el codigo, semestre y sección. Muestra--->el nombre y los creditos
*8. Modificar Asignatura-----> buscar con el codigo, seccion y semestre. Cambiar--->El nombre y creditos.
*9. Registrar estudiante en asiganatura------>Tipo de documento, numero de documento, semestre, codigo, sección.
-----Dos arreglos de tipo string, tipo de documento, numero de documento----------------
*10. Consultar estudiantes en asignatura-----> buscar semestre, seccion, codigo. Devolver los tipos de documento y el documento.
*11. Crear lista de asistencia vacia-----> Asigantura: Semestre, sección, codigo, Fecha, hora de inicio. Estado de que ninguno asistio. Lista tipos, numero, hora, fecha.
*12. Llenar asistencia-------> Buscar por  asignatura, hora, fecha. devolver los dos arrglos tipo y numero de documento, cambiar el estado.
*13. Modificar asistencia------>Buscar codigo, semestre, grupo,
*14. Consulaar asistencia------>Buecar codigo, semestre, grupo,
*15. Salir
 /

package Vista;

import Controlador.ElControlador;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElControlador controlador = new ElControlador();
        String opcion = "";

        while (!opcion.equals("15")) {
            System.out.println("\n***** SISTEMA DE GESTIÓN ACADÉMICA *****");
            System.out.println("1. Consultar departamento");
            System.out.println("2. Modificar departamento");
            System.out.println("3. Registrar estudiante en departamento");
            System.out.println("4. Consultar estudiante en departamento");
            System.out.println("5. Modificar estudiante en departamento");
            System.out.println("6. Agregar asignatura");
            System.out.println("7. Consultar asignatura");
            System.out.println("8. Modificar asignatura");
            System.out.println("9. Registrar estudiante en asignatura");
            System.out.println("10. Consultar estudiantes en asignatura");
            System.out.println("11. Crear lista de asistencia vacía");
            System.out.println("12. Llenar asistencia");
            System.out.println("13. Modificar asistencia");
            System.out.println("14. Consultar asistencia");
            System.out.println("15. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    System.out.println("------------------------");
                    System.out.println("Nombre departamento: " + controlador.consultarDepartamento());
                    System.out.println("------------------------");
                    break;
                case "2":
                    System.out.println("------------------------");
                    System.out.print("Nuevo nombre: ");
                    controlador.actualizarDepartamento(scanner.nextLine());
                    System.out.println("Departamento creado con exito!!!");
                    System.out.println("------------------------");
                    break;
                case "3":
                    System.out.println("------------------------");
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Tipo documento: ");
                    String tipoDoc = scanner.nextLine();
                    System.out.print("Número documento: ");
                    String numDoc = scanner.nextLine();
                    controlador.registrarEstudiante(nombre, tipoDoc, numDoc);
                    System.out.println("Estudiante registrado exitosamente!!!");
                    System.out.println("------------------------");
                    break;
                case "4":
                    System.out.println("------------------------");
                    System.out.print("Tipo documento: ");
                    tipoDoc = scanner.nextLine();
                    System.out.print("Número documento: ");
                    numDoc = scanner.nextLine();
                    String nombreEst = controlador.consultarEstudiante(tipoDoc, numDoc);
                    System.out.println(nombreEst != null ? "Estudiante: " + nombreEst : "No encontrado");
                    System.out.println("------------------------");
                    break;
                case "5":
                    System.out.println("------------------------");
                    System.out.print("Tipo documento actual: ");
                    String tipoDocActual = scanner.nextLine();
                    System.out.print("Número documento actual: ");
                    String numDocActual = scanner.nextLine();
                    System.out.println("------------------------");
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo tipo documento: ");
                    String nuevoTipoDoc = scanner.nextLine();
                    System.out.print("Nuevo número documento: ");
                    String nuevoNumDoc = scanner.nextLine();
                    controlador.modificarEstudiante(tipoDocActual, numDocActual, nuevoNombre, nuevoTipoDoc, nuevoNumDoc);
                    System.out.println("Estudiante modificado!!!");
                    System.out.println("-------------------------");
                    break;
                case "6":
                    System.out.println("------------------------");
                    System.out.print("Nombre asignatura: ");
                    nombre = scanner.nextLine();
                    System.out.print("Código: ");
                    String codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    String grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    String semestre = scanner.nextLine();
                    System.out.print("Créditos: ");
                    String creditos = scanner.nextLine();
                    controlador.agregarAsignatura(nombre, codigo, grupo, semestre, creditos);
                    System.out.println("Asignatura agregada correctamente!!!");
                    System.out.println("------------------------");
                    break;
                case "7":
                    System.out.println("------------------------");
                    System.out.print("Código: ");
                    codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    semestre = scanner.nextLine();
                    System.out.println("------------------------");
                    String[] datosAsig = controlador.consultarAsignatura(codigo, grupo, semestre);
                    if (datosAsig != null) {
                        System.out.println("Nombre: " + datosAsig[0] + ", Créditos: " + datosAsig[1]);
                        System.out.println("------------------------");
                    } else {
                        System.out.println("Asignatura no encontrada");
                    }
                    break;
                case "8":
                    System.out.println("------------------------");
                    System.out.print("Código: ");
                    codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    semestre = scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Nuevos créditos: ");
                    creditos = scanner.nextLine();
                    controlador.modificarAsignatura(codigo, grupo, semestre, nombre, creditos);
                    System.out.println("Asignatura modificada");
                    System.out.println("------------------------");
                    break;
                case "9":
                    System.out.println("------------------------");
                    System.out.print("Tipo documento: ");
                    tipoDoc = scanner.nextLine();
                    System.out.print("Número documento: ");
                    numDoc = scanner.nextLine();
                    System.out.print("Código asignatura: ");
                    codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    semestre = scanner.nextLine();
                    System.out.println("Estudiante registrado!!!");
                    System.out.println("------------------------");
                    controlador.inscribirEstudianteAsignatura(tipoDoc, numDoc, codigo, grupo, semestre);
                    break;
                case "10":
                    System.out.println("------------------------");
                    System.out.print("Código: ");
                    codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    semestre = scanner.nextLine();
                    ArrayList<String[]> estudiantes = controlador.consultarEstudiantesAsignatura(codigo, grupo, semestre);
                    if (estudiantes != null) {
                        for (String[] est : estudiantes) {
                            System.out.println("----------------------------------------------------");
                            System.out.println("Tipo doc: " + est[0] + ", Número doc: " + est[1]);
                            System.out.println("----------------------------------------------------");
                        }
                    }
                    break;
                case "11":
                    System.out.println("------------------------");
                    System.out.print("Código: ");
                    codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    semestre = scanner.nextLine();
                    System.out.print("Fecha (aaaa/mm/dd): ");
                    String fecha = scanner.nextLine();
                    while (!fecha.matches("\\d{4}/\\d{2}/\\d{2}")) {
                        System.out.println("Formato inválido. Use aaaa/mm/dd");
                        fecha = scanner.nextLine();
                    }
                    System.out.print("Hora inicio (hh:mm): ");
                    String horaInicio = scanner.nextLine();
                    while (!horaInicio.matches("\\d{1,2}:\\d{2}")) {
                        System.out.println("Formato inválido. Use hh:mm");
                        horaInicio = scanner.nextLine();
                    }
                    System.out.print("Hora final (hh:mm): ");
                    String horaFinal = scanner.nextLine();
                    while (!horaFinal.matches("\\d{1,2}:\\d{2}")) {
                        System.out.println("Formato inválido. Use hh:mm");
                        horaFinal = scanner.nextLine();
                    }
                    System.out.println("Lista creada!!!");
                    controlador.crearAsistenciaVacia(codigo, grupo, semestre, fecha, horaInicio, horaFinal);
                    break;
                case "12":
                    System.out.println("------------------------");
                    System.out.print("Código: ");
                    codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    semestre = scanner.nextLine();
                    System.out.print("Fecha (aaaa/mm/dd): ");
                    fecha = scanner.nextLine();
                    while (!fecha.matches("\\d{4}/\\d{2}/\\d{2}")) {
                        System.out.println("Formato inválido. Use aaaa/mm/dd");
                        fecha = scanner.nextLine();
                    }
                    System.out.print("Hora inicio (hh:mm): ");
                    horaInicio = scanner.nextLine();
                    while (!horaInicio.matches("\\d{1,2}:\\d{2}")) {
                        System.out.println("Formato inválido. Use hh:mm");
                        horaInicio = scanner.nextLine();
                    }
                    System.out.print("Hora final (hh:mm): ");
                    horaFinal = scanner.nextLine();
                    while (!horaFinal.matches("\\d{1,2}:\\d{2}")) {
                        System.out.println("Formato inválido. Use hh:mm");
                        horaFinal = scanner.nextLine();
                    }
                    System.out.println("------------------------");

                    ArrayList<String> tiposDocs = new ArrayList<>();
                    ArrayList<String> numsDocs = new ArrayList<>();
                    ArrayList<String> estados = new ArrayList<>();

                    System.out.println("------------------------");
                    System.out.print("Cantidad de estudiantes: ");
                    int cantidad = Integer.parseInt(scanner.nextLine());
                    for (int i = 0; i < cantidad; i++) {
                        System.out.print("Tipo documento " + (i+1) + ": ");
                        tiposDocs.add(scanner.nextLine());
                        System.out.print("Número documento " + (i+1) + ": ");
                        numsDocs.add(scanner.nextLine());
                        System.out.print("Estado (0/1/2) " + (i+1) + ": ");
                        estados.add(scanner.nextLine());
                        System.out.println("------------------------");
                    }
                    controlador.llenarAsistencia(codigo, grupo, semestre, fecha, horaInicio, horaFinal, tiposDocs, numsDocs, estados);
                    break;
                case "13":
                    System.out.println("------------------------");
                    System.out.print("Código: ");
                    codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    semestre = scanner.nextLine();
                    System.out.print("Fecha (aaaa/mm/dd): ");
                    fecha = scanner.nextLine();
                    while (!fecha.matches("\\d{4}/\\d{2}/\\d{2}")) {
                        System.out.println("Formato inválido. Use aaaa/mm/dd");
                        fecha = scanner.nextLine();
                    }
                    System.out.print("Hora inicio (hh:mm): ");
                    horaInicio = scanner.nextLine();
                    while (!horaInicio.matches("\\d{1,2}:\\d{2}")) {
                        System.out.println("Formato inválido. Use hh:mm");
                        horaInicio = scanner.nextLine();
                    }
                    System.out.print("Tipo documento: ");
                    tipoDoc = scanner.nextLine();
                    System.out.print("Número documento: ");
                    numDoc = scanner.nextLine();
                    System.out.println("------------------------");
                    System.out.print("Nuevo estado (0/1/2): ");
                    String estado = scanner.nextLine();
                    System.out.println("Asistencia modificada!!!");
                    System.out.println("------------------------");
                    controlador.modificarAsistencia(codigo, grupo, semestre, fecha, horaInicio, tipoDoc, numDoc, estado);
                    break;
                case "14":
                    System.out.println("------------------------");
                    System.out.print("Código: ");
                    codigo = scanner.nextLine();
                    System.out.print("Grupo: ");
                    grupo = scanner.nextLine();
                    System.out.print("Semestre: ");
                    semestre = scanner.nextLine();
                    System.out.print("Fecha (aaaa/mm/dd): ");
                    fecha = scanner.nextLine();
                    while (!fecha.matches("\\d{4}/\\d{2}/\\d{2}")) {
                        System.out.println("Formato inválido. Use aaaa/mm/dd");
                        fecha = scanner.nextLine();
                    }
                    System.out.print("Hora inicio (hh:mm): ");
                    horaInicio = scanner.nextLine();
                    while (!horaInicio.matches("\\d{1,2}:\\d{2}")) {
                        System.out.println("Formato inválido. Use hh:mm");
                        horaInicio = scanner.nextLine();
                    }
                    System.out.print("Hora Final (hh:mm): ");
                    horaFinal = scanner.nextLine();
                    while (!horaFinal.matches("\\d{1,2}:\\d{2}")) {
                        System.out.println("Formato inválido. Use hh:mm");
                        horaFinal = scanner.nextLine();
                    }
                    String[] llamarNombre = controlador.consultarAsignatura(codigo, grupo, semestre);
                    String nombreAsignatura = llamarNombre != null ? llamarNombre[0] : "Asignatura no encontrada";

                    ArrayList<String[]> listaAsistencia = controlador.consultarAsistencia(
                            codigo, grupo, semestre, fecha, horaInicio);

                    if (listaAsistencia != null && !listaAsistencia.isEmpty()) {
                        System.out.println("\n--- REGISTRO DE ASISTENCIA ---");
                        System.out.println("Asignatura: " +nombreAsignatura+" -Codigo "+ codigo + " - Grupo: " + grupo);
                        System.out.println("Fecha: " + fecha + " Hora de inicio: " + horaInicio+ " Hora final: "+horaFinal+" |");

                        for (String[] reg : listaAsistencia) {
                            String estadoStr = switch(reg[2]) {
                                case "0" -> "Llego a tiempo";
                                case "1" -> "Asistió tarde";
                                case "2" -> "Falto";
                                default -> "Estado desconocido";
                            };
                            System.out.println("--------------------------------");
                            System.out.println(reg[0] + " " + reg[1] + ": " + estadoStr);
                            System.out.println("--------------------------------");
                        }
                    } else {
                        System.out.println("No se encontraron registros de asistencia");
                    }
                    break;
                case "15":
                    System.out.println("Cerrando programa");
                    break;
                default:
                    System.out.println("Opción no válida");
            }
        }
        scanner.close();
    }
}
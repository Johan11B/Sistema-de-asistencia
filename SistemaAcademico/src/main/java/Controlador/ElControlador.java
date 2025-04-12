package Controlador;

import Modelo.Asignatura;
import Modelo.Asistencia;
import Modelo.Departamento;
import Modelo.Estudiante;
import java.util.ArrayList;

public class ElControlador {
    private Departamento departamento = Departamento.singleton();

    public String consultarDepartamento() {
        return departamento.getNombre();
    }

    public boolean actualizarDepartamento(String nuevoNombre) {
        departamento.setNombre(nuevoNombre);
        return true;
    }

    public boolean registrarEstudiante(String nombre, String tipoDoc, String numDoc) {
        return departamento.agregarEstudiante(new Estudiante(nombre, tipoDoc, numDoc));
    }

    public String consultarEstudiante(String tipoDoc, String numDoc) {
        Estudiante e = departamento.buscarEstudiante(tipoDoc, numDoc);
        return e != null ? e.getNombre() : null;
    }

    public boolean modificarEstudiante(String tipoDocActual, String numDocActual,
                                       String nuevoNombre, String nuevoTipoDoc, String nuevoNumDoc) {
        return departamento.modificarEstudiante(tipoDocActual, numDocActual,
                nuevoNombre, nuevoTipoDoc, nuevoNumDoc);
    }

    public boolean agregarAsignatura(String nombre, String codigo, String grupo,
                                     String semestre, String creditos) {
        return departamento.agregarAsignatura(new Asignatura(codigo, grupo, semestre, nombre, creditos));
    }

    public String[] consultarAsignatura(String codigo, String grupo, String semestre) {
        Asignatura a = departamento.buscarAsignatura(codigo, grupo, semestre);
        return a != null ? new String[]{a.getNombre(), String.valueOf(a.getCreditos())} : null;
    }

    public boolean modificarAsignatura(String codigo, String grupo, String semestre,
                                       String nuevoNombre, String nuevosCreditos) {
        return departamento.modificarAsignatura(codigo, grupo, semestre, nuevoNombre, nuevosCreditos);
    }

    public boolean inscribirEstudianteAsignatura(String tipoDoc, String numDoc,
                                                 String codigo, String grupo, String semestre) {
        Asignatura a = departamento.buscarAsignatura(codigo, grupo, semestre);
        Estudiante e = departamento.buscarEstudiante(tipoDoc, numDoc);
        return a != null && e != null && a.inscribirEstudiante(e);
    }

    public ArrayList<String[]> consultarEstudiantesAsignatura(String codigo, String grupo, String semestre) {
        Asignatura a = departamento.buscarAsignatura(codigo, grupo, semestre);
        return a != null ? a.getEstudiantesInscritos() : null;
    }

    public boolean crearAsistenciaVacia(String codigo, String grupo, String semestre,
                                        String fecha, String horaInicio, String horaFinal) {
        Asignatura a = departamento.buscarAsignatura(codigo, grupo, semestre);
        return a != null && a.crearAsistenciaVacia(fecha, horaInicio, horaFinal);
    }

    public boolean llenarAsistencia(String codigo, String grupo, String semestre,
                                    String fecha, String horaInicio, String horaFinal,
                                    ArrayList<String> tiposDocs, ArrayList<String> numsDocs,
                                    ArrayList<String> estados) {
        Asignatura a = departamento.buscarAsignatura(codigo, grupo, semestre);
        if (a != null) {
            for (int i = 0; i < tiposDocs.size(); i++) {
                if (departamento.buscarEstudiante(tiposDocs.get(i), numsDocs.get(i)) == null) {
                    System.out.println("Error: Estudiante no encontrado");
                    return false;
                }
            }
            return a.registrarAsistenciaCompleta(fecha, horaInicio, horaFinal, tiposDocs, numsDocs, estados);
        }
        return false;
    }

    public boolean modificarAsistencia(String codigo, String grupo, String semestre,
                                       String fecha, String horaInicio,
                                       String tipoDoc, String numDoc, String nuevoEstado) {
        Asignatura a = departamento.buscarAsignatura(codigo, grupo, semestre);
        if (a != null) {
            Asistencia asistencia = a.buscarAsistencia(fecha, horaInicio);
            return asistencia != null && asistencia.modificarAsistencia(tipoDoc, numDoc, nuevoEstado);
        }
        return false;
    }

    public ArrayList<String[]> consultarAsistencia(String codigo, String grupo, String semestre,
                                                   String fecha, String horaInicio) {
        Asignatura a = departamento.buscarAsignatura(codigo, grupo, semestre);
        if (a != null) {
            ArrayList<String[]> resultado = a.consultarAsistencia(fecha, horaInicio);
            System.out.println("Resultado consulta: " + (resultado != null ? resultado.size() : ""));
            return resultado;
        }
        System.out.println("No se encontró la asignatura especificada");
        return null;
    }
}
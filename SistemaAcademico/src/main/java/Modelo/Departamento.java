package Modelo;

import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private static Departamento instancia = null;
    private ArrayList<Asignatura> asignaturas = new ArrayList<>();
    private ArrayList<Estudiante> estudiantes = new ArrayList<>();

    private Departamento() {
        nombre = "";
    }

    public static Departamento singleton() {
        if (instancia == null) {
            instancia = new Departamento();
        }
        return instancia;
    }

    // Métodos para departamento
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    // Métodos para estudiantes
    public boolean agregarEstudiante(Estudiante estudiante) {
        if (buscarEstudiante(estudiante.getTipoDocumento(), estudiante.getNumDocumento()) == null) {
            estudiantes.add(estudiante);
            return true;
        }
        return false;
    }

    public Estudiante buscarEstudiante(String tipoDoc, String numDoc) {
        for (Estudiante e : estudiantes) {
            if (e.getTipoDocumento().equalsIgnoreCase(tipoDoc) &&
                    e.getNumDocumento().equalsIgnoreCase(numDoc)) {
                return e;
            }
        }
        return null;
    }

    public boolean modificarEstudiante(String tipoDocActual, String numDocActual,
                                       String nuevoNombre, String nuevoTipoDoc, String nuevoNumDoc) {
        Estudiante estudiante = buscarEstudiante(tipoDocActual, numDocActual);
        if (estudiante != null) {
            estudiante.setNombre(nuevoNombre);
            estudiante.setTipoDocumento(nuevoTipoDoc);
            estudiante.setNumDocumento(nuevoNumDoc);
            return true;
        }
        return false;
    }

    // Métodos para asignaturas
    public boolean agregarAsignatura(Asignatura asignatura) {
        if (buscarAsignatura(asignatura.getCodigo(), asignatura.getGrupo(), asignatura.getSemestre()) == null) {
            asignaturas.add(asignatura);
            return true;
        }
        return false;
    }

    public Asignatura buscarAsignatura(String codigo, String grupo, String semestre) {
        for (Asignatura a : asignaturas) {
            if (a.getCodigo().equalsIgnoreCase(codigo) &&
                    a.getGrupo().equalsIgnoreCase(grupo) &&
                    a.getSemestre().equalsIgnoreCase(semestre)) {
                return a;
            }
        }
        return null;
    }

    public boolean modificarAsignatura(String codigo, String grupo, String semestre,
                                       String nuevoNombre, String nuevosCreditos) {
        Asignatura asignatura = buscarAsignatura(codigo, grupo, semestre);
        if (asignatura != null) {
            asignatura.setNombre(nuevoNombre);
            asignatura.setCreditos(String.valueOf(nuevosCreditos));
            return true;
        }
        return false;
    }

}
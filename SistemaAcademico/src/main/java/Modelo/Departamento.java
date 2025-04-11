package Modelo;

import java.util.ArrayList;

public class Departamento {
    private String nombre;
    private static ArrayList<Asignatura> asignaturas = null;
    private static Departamento instancia = null;
    private static ArrayList<Estudiante> estudiantes = null;

    public Departamento() {
        nombre = "";
        asignaturas = new ArrayList<Asignatura>();
    }

    public static Departamento singleton() {
        if (instancia == null) {
            instancia = new Departamento();
        }
        return instancia;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean agregarAsignatura(String nombre, int creditos, String codigo, String grupo, String semestre) {
        Asignatura asignatura = new Asignatura(codigo, grupo, semestre, nombre, creditos);
        asignaturas.add(asignatura);
        return true;
    }
    public Asignatura consultarAsignatura(String codigo, String grupo, String semestre) {
        for(int vc = 0; vc < asignaturas.size(); vc++) {
            Asignatura copia = asignaturas.get(vc);
            if(copia.getCodigo().equalsIgnoreCase(codigo) &&
                    copia.getGrupo().equalsIgnoreCase(grupo) &&
                    copia.getSemestre().equalsIgnoreCase(semestre)) {
                return copia;
            }
        }
        return null;
    }
    public boolean modificarAsignatura(String codigo, String grupo, String semestre, String nombre, int creditos) {
        Asignatura asignatura = this.consultarAsignatura(codigo, grupo, semestre);
        if(asignatura != null) {
            asignatura.setNombre(nombre);
            asignatura.setCreditos(creditos);
            return true;
        }
        return false;
    }
    public boolean eliminarAsignatura(String codigo, String grupo, String semestre) {
        for(int vc = 0; vc < asignaturas.size(); vc++) {
            Asignatura copia = asignaturas.get(vc);
            if(copia.getCodigo().equalsIgnoreCase(codigo) &&
                    copia.getGrupo().equalsIgnoreCase(grupo) &&
                    copia.getSemestre().equalsIgnoreCase(semestre)) {
                asignaturas.remove(vc);
                return true;
            }
        }
        return false;
    }
    //Agregar estudiante
    public boolean agregarEstudiante(String nombre, String documento, String identificacion) {
        Estudiante estudiante = new Estudiante(nombre, documento, identificacion);
        estudiantes.add(estudiante);
        return true;
    }
    //Consultar estudiante
    public Estudiante consultarEstudiante(String nombre, String documento, String identificacion) {
        for(int vc = 0; vc < estudiantes.size(); vc++) {
            Estudiante copia = estudiantes.get(vc);
            if(copia.getNombre().equalsIgnoreCase(nombre) &&
                    copia.getDocumento().equalsIgnoreCase(documento) &&
                    copia.getIdentificacion().equalsIgnoreCase(identificacion)) {
                return copia;
            }
        }
        return null;
    }
    //Modificar esetudiantes
    public boolean modificarEstudiantes(String nombre, String documento, String identificacion) {
        Estudiante estudiante = this.consultarEstudiante(nombre, documento, identificacion);
        if(estudiante != null) {
            estudiante.setNombre(nombre);
            estudiante.setIdentificacion(identificacion);
            estudiante.setDocumento(documento);
            return true;
        }
        return false;
    }

}
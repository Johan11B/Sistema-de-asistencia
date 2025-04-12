package Modelo;

import java.util.ArrayList;

public class Asignatura {
    private String codigo;
    private String grupo;
    private String semestre;
    private String nombre;
    private String creditos;
    private ArrayList<Estudiante> estudiantesInscritos = new ArrayList<>();
    private ArrayList<Asistencia> asistencias = new ArrayList<>();

    public Asignatura(String codigo, String grupo, String semestre, String nombre, String creditos) {
        this.codigo = codigo;
        this.grupo = grupo;
        this.semestre = semestre;
        this.nombre = nombre;
        this.creditos = creditos;
    }

    public String getCodigo() { return codigo; }
    public String getGrupo() { return grupo; }
    public String getSemestre() { return semestre; }
    public String getNombre() { return nombre; }
    public String getCreditos() { return creditos; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setCreditos(String creditos) { this.creditos = creditos; }

    public boolean inscribirEstudiante(Estudiante estudiante) {
        if (!estaInscrito(estudiante)) {
            estudiantesInscritos.add(estudiante);
            return true;
        }
        return false;
    }

    private boolean estaInscrito(Estudiante estudiante) {
        for (Estudiante e : estudiantesInscritos) {
            if (e.getTipoDocumento().equalsIgnoreCase(estudiante.getTipoDocumento()) &&
                    e.getNumDocumento().equalsIgnoreCase(estudiante.getNumDocumento())) {
                return true;
            }
        }
        return false;
    }

    private boolean estaInscrito(String tipoDoc, String numDoc) {
        for (Estudiante e : estudiantesInscritos) {
            if (e.getTipoDocumento().equalsIgnoreCase(tipoDoc) &&
                    e.getNumDocumento().equalsIgnoreCase(numDoc)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String[]> getEstudiantesInscritos() {
        ArrayList<String[]> lista = new ArrayList<>();
        for (Estudiante e : estudiantesInscritos) {
            lista.add(new String[]{e.getTipoDocumento(), e.getNumDocumento()});
        }
        return lista;
    }

    public boolean crearAsistenciaVacia(String fecha, String horaInicio, String horaFinal) {
        if (buscarAsistencia(fecha, horaInicio) == null) {
            asistencias.add(new Asistencia(fecha, horaInicio, horaFinal));
            return true;
        }
        return false;
    }

    public Asistencia buscarAsistencia(String fecha, String horaInicio) {
        String horaNormalizada = horaInicio.length() == 1 ? "0" + horaInicio + ":00" : horaInicio;

        for (Asistencia a : asistencias) {
            if (a.getFecha().equals(fecha) &&
                    a.getHoraInicio().equals(horaNormalizada)) {
                return a;
            }
        }
        return null;
    }

    public boolean registrarAsistenciaCompleta(String fecha, String horaInicio, String horaFinal,
                                               ArrayList<String> tiposDocs, ArrayList<String> numsDocs,
                                               ArrayList<String> estados) {
        fecha = fecha.trim();
        horaInicio = horaInicio.length() == 1 ? "0" + horaInicio + ":00" : horaInicio;

        Asistencia asistencia = buscarAsistencia(fecha, horaInicio);

        if (asistencia == null) {
            asistencia = new Asistencia(fecha, horaInicio, horaFinal);
            asistencias.add(asistencia);
        }

        asistencia.limpiarRegistros();

        for (int i = 0; i < tiposDocs.size(); i++) {
            if (estaInscrito(tiposDocs.get(i), numsDocs.get(i))) {
                asistencia.registrarAsistencia(tiposDocs.get(i), numsDocs.get(i), estados.get(i));
            }
        }
        return true;
    }

    public ArrayList<String[]> consultarAsistencia(String fecha, String horaInicio) {
        Asistencia a = buscarAsistencia(fecha, horaInicio);
        return a != null ? a.getListaAsistencia() : null;
    }

    @Override
    public String toString() {
        return nombre + " (" + codigo + ") - Grupo: " + grupo + " - Semestre: " + semestre;
    }
}
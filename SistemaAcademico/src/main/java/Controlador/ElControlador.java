package Controlador;
import Modelo.Asistencia;
import Modelo.Departamento;
import Modelo.Asignatura;
import Modelo.Estudiante;
import java.util.ArrayList;

public class ElControlador {

    private Departamento departamento = Departamento.singleton();

    // -------------------- CRUD DEPARTAMENTO --------------------
    public boolean crearDepartamento(String nombre) {
        departamento.setNombre(nombre);
        return true;
    }

    public String consultarDepartamento() {
        return departamento.getNombre();
    }

    public boolean actualizarDepartamento(String nuevoNombre) {
        departamento.setNombre(nuevoNombre);
        return true;
    }

    // -------------------- CRUD ASIGNATURA --------------------
    public boolean agregarAsignatura(String nombre, int creditos, String codigo, String grupo, String semestre){
        return departamento.agregarAsignatura(nombre, creditos, codigo, grupo, semestre);
    }

    public Asignatura consultarAsignatura(String codigo, String grupo, String semestre){
        return departamento.consultarAsignatura(codigo, grupo, semestre);
    }

    public boolean modificarAsignatura(String codigo, String grupo, String semestre, String nombre, int creditos){
        return departamento.modificarAsignatura(codigo, grupo, semestre, nombre, creditos);
    }

    public boolean eliminarAsignatura(String codigo, String grupo, String semestre){
        return departamento.eliminarAsignatura(codigo, grupo, semestre);
    }

    // -------------------- CRUD ASISTENCIA --------------------
    public boolean adicionarAsistencia(String codigo, String grupo, String semestre, String fecha,
                                       String horaInicio, String horaFinal,
                                       ArrayList<String> codigosAA, ArrayList<String> estados){
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);
        return (asignatura != null) && asignatura.adicionarAsistencia(fecha, horaInicio, horaFinal, codigosAA, estados);
    }

    public Asistencia consultarAsistencia(String codigo, String grupo, String semestre,
                                          String fecha, String horaInicio, String horaFinal){
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);
        return (asignatura != null) ? asignatura.consultarAsistencia(fecha, horaInicio, horaFinal) : null;
    }

    public boolean modificarAsistencia(String codigo, String grupo, String semestre,
                                       String fecha, String horaInicio, String horaFinal,
                                       String nuevaFecha, String nuevaHoraInicio, String nuevaHoraFinal,
                                       ArrayList<String> codigos, ArrayList<String> estados){
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);
        return (asignatura != null) && asignatura.modificarAsistencia(fecha, horaInicio, horaFinal,
                nuevaFecha, nuevaHoraInicio, nuevaHoraFinal, codigos, estados);
    }

    public boolean eliminarAsistencia(String codigo, String grupo, String semestre,
                                      String fecha, String horaInicio, String horaFinal){
        Asignatura asignatura = departamento.consultarAsignatura(codigo, grupo, semestre);
        return (asignatura != null) && asignatura.eliminarAsistencia(fecha, horaInicio, horaFinal);
    }
    //------------------CRUD ESTUDIANTE-------------------
    public boolean agregarEstudiante(String nombre, String documento, String identificacion){
        return departamento.agregarEstudiante(nombre, documento, identificacion);
    }
    public Asignatura consultarEstudinate(String nombre, String documento, String semestre){
        return departamento.consultarAsignatura(codigo, grupo, semestre);
    }
}

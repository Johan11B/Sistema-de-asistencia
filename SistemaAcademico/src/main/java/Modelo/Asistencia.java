package Modelo;

import java.util.ArrayList;

public class Asistencia {
    private String fecha;
    private String horaInicio;
    private String horaFinal;
    private ArrayList<String> tiposDocumentos = new ArrayList<>();
    private ArrayList<String> numerosDocumentos = new ArrayList<>();
    private ArrayList<String> estados = new ArrayList<>();

    public Asistencia(String fecha, String horaInicio, String horaFinal) {
        this.fecha = fecha;
        this.horaInicio = horaInicio.length() == 1 ? "0" + horaInicio + ":00" : horaInicio;
        this.horaFinal = horaFinal;
    }

    public void registrarAsistencia(String tipoDoc, String numDoc, String estado) {
        if (!estado.matches("[0-2]")) {
            estado = "2";
        }
        tiposDocumentos.add(tipoDoc);
        numerosDocumentos.add(numDoc);
        estados.add(estado);
    }

    public boolean modificarAsistencia(String tipoDoc, String numDoc, String nuevoEstado) {
        for (int i = 0; i < tiposDocumentos.size(); i++) {
            if (tiposDocumentos.get(i).equalsIgnoreCase(tipoDoc) &&
                    numerosDocumentos.get(i).equalsIgnoreCase(numDoc)) {
                estados.set(i, nuevoEstado);
                return true;
            }
        }
        return false;
    }

    public void limpiarRegistros() {
        tiposDocumentos.clear();
        numerosDocumentos.clear();
        estados.clear();
    }

    public ArrayList<String[]> getListaAsistencia() {
        ArrayList<String[]> lista = new ArrayList<>();
        for (int i = 0; i < tiposDocumentos.size(); i++) {
            lista.add(new String[]{
                    tiposDocumentos.get(i),
                    numerosDocumentos.get(i),
                    estados.get(i)
            });
        }
        return lista;
    }

    public String getFecha() { return fecha; }
    public String getHoraInicio() { return horaInicio; }
    public String getHoraFinal() { return horaFinal; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Asistencia del ").append(fecha)
                .append(" de ").append(horaInicio).append(" a ").append(horaFinal).append("\n");

        for (int i = 0; i < tiposDocumentos.size(); i++) {
            sb.append("- ").append(tiposDocumentos.get(i)).append(":").append(numerosDocumentos.get(i))
                    .append(" -> ").append(estadoToString(estados.get(i))).append("\n");
        }

        return sb.toString();
    }

    private String estadoToString(String estado) {
        switch(estado) {
            case "0": return "A tiempo";
            case "1": return "Tarde";
            case "2": return "No asistió";
            default: return "Desconocido";
        }
    }
}
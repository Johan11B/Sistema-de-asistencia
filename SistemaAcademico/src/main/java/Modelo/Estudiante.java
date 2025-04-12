package Modelo;

public class Estudiante {
    private String nombre;
    private String tipoDocumento;
    private String numDocumento;

    public Estudiante(String nombre, String tipoDocumento, String numDocumento) {
        this.nombre = nombre;
        this.tipoDocumento = tipoDocumento;
        this.numDocumento = numDocumento;
    }

    // Getters y Setters
    public String getNombre() { return nombre; }
    public String getTipoDocumento() { return tipoDocumento; }
    public String getNumDocumento() { return numDocumento; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setTipoDocumento(String tipoDocumento) { this.tipoDocumento = tipoDocumento; }
    public void setNumDocumento(String numDocumento) { this.numDocumento = numDocumento; }

    @Override
    public String toString() {
        return nombre + " (" + tipoDocumento + ": " + numDocumento + ")";
    }
}
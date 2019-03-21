package edu.cecar.controladores;

public final class LineaInvestigacion {

    private String nombre;
    private boolean activa;

    public LineaInvestigacion(String nombre, boolean activa) {
        this.nombre = nombre;
        this.activa = activa;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}

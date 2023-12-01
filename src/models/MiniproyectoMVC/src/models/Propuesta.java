package models;

public class Propuesta {
    private String titulo;
    private String descripcion;

    public Propuesta(String titulo, String descripcion) {
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public Propuesta(String titulo) {
        this.titulo = titulo;
        this.descripcion = "";
    }
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return titulo;
    }
}

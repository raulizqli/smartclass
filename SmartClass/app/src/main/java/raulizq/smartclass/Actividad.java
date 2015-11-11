package raulizq.smartclass;

/**
 * Created by raulizq on 11/11/15.
 */
public class Actividad {
    public int id;
    public String descripcion;
    public String recursos;
    public String contenido;

    public Actividad(){

    }

    public Actividad(int id, String descripcion, String recursos, String contenido) {
        this.id = id;
        this.descripcion = descripcion;
        this.recursos = recursos;
        this.contenido = contenido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }


}

package raulizq.smartclass;

import java.io.Serializable;

/**
 * Created by raulizq on 07/11/15.
 */
public class Alumno implements Serializable{
    public int id;
    public String nombre;
    public int profesor_id;
    public int usuario_id;
    public int grado_id;

    public Alumno(){

    }

    public Alumno (int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public Alumno (int id, String nombre, int usuario_id){
        this(id, nombre);
        this.usuario_id = usuario_id;
    }

    public Alumno (int id, String nombre, int usuario_id, int profesor_id){
        this(id, nombre, usuario_id);
        this.profesor_id = profesor_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getProfesorId() {
        return profesor_id;
    }

    public void setProfesorId(int profesor_id) {
        this.profesor_id = profesor_id;
    }

    public int getUsuarioId() {
        return usuario_id;
    }

    public void setUsuarioId(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public int getGradoId() {
        return grado_id;
    }

    public void setGradoId(int grado_id) {
        this.grado_id = grado_id;
    }
}

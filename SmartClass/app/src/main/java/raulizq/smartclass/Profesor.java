package raulizq.smartclass;

import java.io.Serializable;

/**
 * Created by raulizq on 10/11/15.
 */
public class Profesor implements Serializable {
    public int id;
    public String nombre;
    public int materia_id;
    public int usuario_id;
    public int grado_id;

    public Profesor(){

    }

    public Profesor (int id, String nombre){
        this.id = id;
        this.nombre = nombre;
    }

    public Profesor (int id, String nombre, int usuario_id){
        this(id,nombre);
        this.usuario_id = usuario_id;
    }

    public Profesor (int id, String nombre, int usuario_id, int materia_id){
        this(id, nombre, usuario_id);
        this.materia_id = materia_id;
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

    public int getMateriaId() {
        return materia_id;
    }

    public void setMateriaId(int profesor_id) {
        this.materia_id = profesor_id;
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

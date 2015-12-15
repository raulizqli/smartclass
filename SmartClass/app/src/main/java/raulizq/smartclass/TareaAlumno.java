package raulizq.smartclass;

/**
 * Created by raulizq on 11/11/15.
 */
public class TareaAlumno {
    public int id;
    public Tarea tarea;
    public Alumno alumno;
    public double calificacion;

    public TareaAlumno(){

    }

    public TareaAlumno(int id, Tarea tarea, Alumno alumno){
        this.id = id;
        this.tarea = tarea;
        this.alumno = alumno;
    }

    public Tarea getTarea() {
        return tarea;
    }

    public void setTarea(Tarea tarea) {
        this.tarea = tarea;
    }

    public Alumno getAlumno() {
        return alumno;
    }

    public void setAlumno(Alumno alumno) {
        this.alumno = alumno;
    }

    public double getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(double calificacion) {
        this.calificacion = calificacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

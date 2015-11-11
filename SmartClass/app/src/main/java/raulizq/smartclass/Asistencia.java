package raulizq.smartclass;

import java.util.AbstractSequentialList;
import java.util.Date;

/**
 * Created by raulizq on 11/11/15.
 */
public class Asistencia {
    public int alumno_id;
    public int asistencia_id;
    public Date fecha_asistencia;

    public Asistencia(){

    }

    public Asistencia(int alumno_id, int asistencia_id, Date fecha_asistencia){
        this.fecha_asistencia = fecha_asistencia;
        this.asistencia_id = asistencia_id;
        this.alumno_id = alumno_id;
    }

    public int getAlumno_id() {
        return alumno_id;
    }

    public void setAlumno_id(int alumno_id) {
        this.alumno_id = alumno_id;
    }

    public int getAsistencia_id() {
        return asistencia_id;
    }

    public void setAsistencia_id(int asistencia_id) {
        this.asistencia_id = asistencia_id;
    }

    public Date getFecha_asistencia() {
        return fecha_asistencia;
    }

    public void setFecha_asistencia(Date fecha_asistencia) {
        this.fecha_asistencia = fecha_asistencia;
    }
}

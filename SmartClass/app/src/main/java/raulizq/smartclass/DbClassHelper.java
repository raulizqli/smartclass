package raulizq.smartclass;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by raulizq on 01/11/15.
 */
public class DbClassHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "smartclass";
    public DbClassHelper(Context ctx){
        super(ctx, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREAR_TABLA = "CREATE TABLE tbl_ciclos(id INTEGER PRIMARY KEY,desripcion TEXT,"
                +"acronimo TEXT,fecha_inicio TEXT,activo NUMERIC);";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_permisos(id INTEGER PRIMARY KEY, descripcion TEXT);";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_usuarios(id INTEGER PRIMARY KEY, usuario TEXT, password TEXT,"
                +"permiso_id INTEGER, FOREIGN KEY(permiso_id) REFERENCES tbl_permisos(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_grados(id INTEGER PRIMARY KEY, descripcion TEXT);";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_alumnos(matricula INTEGER PRIMARY KEY, nombre TEXT,"
                +"paterno TEXT, materno TEXT, edad INTEGER,usuario_id INTEGER, grado_id INTEGER, "
                +"FOREIGN KEY(grado_id) REFERENCES tbl_grados(id),"
                +"FOREIGN KEY(usuario_id) REFERENCES tbl_usuarios(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_profesores(num_empleado INTEGER PRIMARY KEY, nombre TEXT,"
                +"paterno TEXT, materno TEXT,materia_id INTEGER, edad INTEGER,usuario_id INTEGER,"
                +" grado_id INTEGER, FOREIGN KEY(grado_id) REFERENCES tbl_grados(id), "
                +"FOREIGN KEY(usuario_id) REFERENCES tbl_usuarios(id),"
                +"FOREIGN KEY(materia_id) REFERENCES tbl_materias(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_padres(id INTEGER PRIMARY KEY, nombre TEXT,"
                +"paterno TEXT, materno TEXT, edad INTEGER, usuario_id INTEGER "
                +"FOREIGN KEY(usuario_id) REFERENCES tbl_usuarios(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_detalle_alumno(id INTEGER PRIMARY KEY, padre_id INTEGER,"
                +"alumno_id INTEGER, FOREIGN KEY(alumno_id) REFERENCES tbl_alumnos(id),"
                +"FOREIGN KEY(padre_id) REFERENCES tbl_padres(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_tipo_materia(id INTEGER PRIMARY KEY, descripcion TEXT, "
                +"obligatoria NUMERIC);";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_salones(id INTEGER PRIMARY KEY, descripcion TEXT,"
                +"acronimo TEXT, capacidad INTEGER, tipo TEXT);";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_grupos(id INTEGER PRIMARY KEY, descripcion TEXT, "
                +"acronimo TEXT);";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_tipo_grupo(id INTEGER PRIMARY KEY, descripcion TEXT, "
                +"acronimo TEXT);";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_horarios(id INTEGER PRIMARY KEY, descripcion TEXT, "
                +"hora_inicio TEXT, hora_fin TEXT, turno TEXT);";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_detalle_grupos(id INTEGER PRIMARY KEY, tipo_grupo_id INTEGER,"
                +" FOREIGN KEY(tipo_grupo_id) REFERENCES tbl_tipo_grupo(id)"
                +" salon_id INTEGER, FOREIGN KEY(salon_id) REFERENCES tbl_salones(id),"
                +" materia_id INTEGER, FOREIGN KEY(materia_id) REFERENCES tbl_materias(id),"
                +" ciclo_id INTEGER, FOREIGN KEY(ciclo_id) REFERENCES tbl_ciclos(id),"
                +" profesor_id INTEGER, FOREIGN KEY(profesor_id) REFERENCES tbl_profesores(id),"
                +" horario_id INTEGER, FOREIGN KEY(horario_id) REFERENCES tbl_horarios(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_grupos_alumnos(id INTEGER PRIMARY KEY, alumno_id INTEGER,"
                +" detalle_grupo_id INTEGER, FOREIGN KEY(alumno_id) REFERENCES tbl_alumnos(id),"
                +"FOREIGN KEY(detalle_grupo_id) REFERENCES tbl_detalle_grupos(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_tareas(id INTEGER PRIMARY KEY, descripcion TEXT, "
                +" contenido TEXT, recurso TEXT, valor_numerico REAL, valor_otro TEXT,"
                +" mataria_id INTEGER, FOREIGN KEY(materia_id) REFERENCES tbl_materias(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_grupos_tareas(id INTEGER PRIMARY KEY, tarea_id INTEGER,"
                +" detalle_grupo_id INTEGER, FOREIGN KEY(tarea_id) REFERENCES tbl_tareas(id),"
                +" FOREIGN KEY(detalle_grupo_id) REFERENCES tbl_detalle_grupos(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_actividades(id INTEGER PRIMARY KEY, descripcion TEXT, "
                +" contenido TEXT, recurso TEXT, valor_numerico REAL, valor_otro TEXT,"
                +" materia_id INTEGER, FOREIGN KEY(materia_id) REFERENCES tbl_materias(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_grupos_actividades(id INTEGER PRIMARY KEY, actividad_id INTEGER,"
                +" detalle_grupo_id INTEGER, FOREIGN KEY(actividad_id) REFERENCES tbl_actividades(id),"
                +" FOREIGN KEY(detalle_grupo_id) REFERENCES tbl_detalle_grupos(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_examenes(id INTEGER PRIMARY KEY, descripcion TEXT, "
                +" contenido TEXT, recurso TEXT, valor_numerico REAL, valor_otro TEXT,"
                +" materia_id INTEGER, FOREIGN KEY(materia_id) REFERENCES tbl_materias(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_grupos_examenes(id INTEGER PRIMARY KEY, examen_id INTEGER,"
                +" detalle_grupo_id INTEGER, FOREIGN KEY(examen_id) REFERENCES tbl_examenes(id),"
                +" FOREIGN KEY(detalle_grupo_id) REFERENCES tbl_detalle_grupos(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_especiales(id INTEGER PRIMARY KEY, descripcion TEXT, "
                +" contenido TEXT, recurso TEXT, valor_numerico REAL, valor_otro TEXT,"
                +" materia_id INTEGER, FOREIGN KEY(materia_id) REFERENCES tbl_materias(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_grupos_especiales(id INTEGER PRIMARY KEY, especial_id INTEGER,"
                +" detalle_grupo_id INTEGER, FOREIGN KEY(especial_id) REFERENCES tbl_especiales(id),"
                +" FOREIGN KEY(detalle_grupo_id) REFERENCES tbl_detalle_grupos(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_tareas_alumnos(id INTEGER PRIMARY KEY, calificacion REAL,"
                +" descripcion TEXT, contenido TEXT, recursos TEXT, grupos_tareas_id INTEGER,"
                +" alumno_id INTEGER, FOREIGN KEY(alumno_id) REFERENCES tbl_alumnos(id),"
                +" FOREIGN KEY(grupos_tareas_id) REFERENCES tbl_grupos_tareas(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_actividades_alumnos(id INTEGER PRIMARY KEY, calificacion REAL,"
                +" descripcion TEXT, contenido TEXT, recursos TEXT, grupos_actividades_id INTEGER,"
                +" alumno_id INTEGER, FOREIGN KEY(alumno_id) REFERENCES tbl_alumnos(id),"
                +" FOREIGN KEY(grupos_actividades_id) REFERENCES tbl_grupos_actividades(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_examenes_alumnos(id INTEGER PRIMARY KEY, calificacion REAL,"
                +" descripcion TEXT, contenido TEXT, recursos TEXT, grupos_examenes_id INTEGER,"
                +" alumno_id INTEGER, FOREIGN KEY(alumno_id) REFERENCES tbl_alumnos(id),"
                +" FOREIGN KEY(grupos_examenes_id) REFERENCES tbl_grupos_examenes(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_especiales_alumnos(id INTEGER PRIMARY KEY, calificacion REAL,"
                +" descripcion TEXT, contenido TEXT, recursos TEXT, grupos_especiales_id INTEGER,"
                +" alumno_id INTEGER, FOREIGN KEY(alumno_id) REFERENCES tbl_alumnos(id),"
                +" FOREIGN KEY(grupos_especiales_id) REFERENCES tbl_grupos_especiales(id));";
        db.execSQL(CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_especiales_alumnos;");
        db.execSQL("DROP TABLE IF EXISTS tbl_examenes_alumnos;");
        db.execSQL("DROP TABLE IF EXISTS tbl_actividades_alumnos;");
        db.execSQL("DROP TABLE IF EXISTS tbl_tareas_alumnos;");
        db.execSQL("DROP TABLE IF EXISTS tbl_grupos_especiales;");
        db.execSQL("DROP TABLE IF EXISTS tbl_grupos_examenes;");
        db.execSQL("DROP TABLE IF EXISTS tbl_grupos_actividades;");
        db.execSQL("DROP TABLE IF EXISTS tbl_grupos_tareas;");
        db.execSQL("DROP TABLE IF EXISTS tbl_especiales;");
        db.execSQL("DROP TABLE IF EXISTS tbl_examenes;");
        db.execSQL("DROP TABLE IF EXISTS tbl_actividades;");
        db.execSQL("DROP TABLE IF EXISTS tbl_tareas;");
        db.execSQL("DROP TABLE IF EXISTS tbl_grupos_alumnos;");
        db.execSQL("DROP TABLE IF EXISTS tbl_detalle_grupos;");
        db.execSQL("DROP TABLE IF EXISTS tbl_horarios;");
        db.execSQL("DROP TABLE IF EXISTS tbl_tipo_grupo;");
        db.execSQL("DROP TABLE IF EXISTS tbl_salones;");
        db.execSQL("DROP TABLE IF EXISTS tbl_grupos;");
        db.execSQL("DROP TABLE IF EXISTS tbl_tipo_materia;");
        db.execSQL("DROP TABLE IF EXISTS tbl_detalle_alumno;");
        db.execSQL("DROP TABLE IF EXISTS tbl_padres;");
        db.execSQL("DROP TABLE IF EXISTS tbl_alumnos;");
        db.execSQL("DROP TABLE IF EXISTS tbl_profesores;");
        db.execSQL("DROP TABLE IF EXISTS tbl_usuarios;");
        db.execSQL("DROP TABLE IF EXISTS tbl_permisos;");
        db.execSQL("DROP TABLE IF EXISTS tbl_ciclos;");
        onCreate(db);
    }
}

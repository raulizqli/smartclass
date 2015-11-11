package raulizq.smartclass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

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
        Log.d("Creating", "Created");
        String CREAR_TABLA = "CREATE TABLE tbl_ciclos(id INTEGER PRIMARY KEY,descripcion TEXT,"
                +"acronimo TEXT,fecha_inicio TEXT, fecha_fin TEXT,activo NUMERIC);";
        db.execSQL(CREAR_TABLA);
        String INSERT = "INSERT INTO tbl_ciclos(id, descripcion, acronimo, fecha_inicio, fecha_fin, activo)"
                +" VALUES(1, 'Julio 2015 - Mayo 2016', 'JUL15-MAY16','2015-07-06', '2015-05-28', 1);";
        db.execSQL(INSERT);
        CREAR_TABLA = "CREATE TABLE tbl_permisos(id INTEGER PRIMARY KEY, descripcion TEXT);";
        db.execSQL(CREAR_TABLA);
        INSERT = "INSERT INTO tbl_permisos(id, descripcion) VALUES(1, 'Maestros');";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_permisos(id, descripcion) VALUES(2, 'Alumnos');";
        db.execSQL(INSERT);
        CREAR_TABLA = "CREATE TABLE tbl_usuarios(id INTEGER PRIMARY KEY, usuario TEXT, password TEXT,"
                +"permiso_id INTEGER, FOREIGN KEY(permiso_id) REFERENCES tbl_permisos(id));";
        db.execSQL(CREAR_TABLA);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(1, 'alumno1@profesor1.com', 'alumno1', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(2, 'alumno2@profesor1.com', 'alumno2', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(3, 'alumno3@profesor1.com', 'alumno3', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(4, 'alumno4@profesor1.com', 'alumno4', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(5, 'alumno5@profesor1.com', 'alumno5', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(6, 'alumno6@profesor1.com', 'alumno6', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(7, 'alumno7@profesor1.com', 'alumno7', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(8, 'alumno8@profesor1.com', 'alumno8', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(9, 'alumno9@profesor1.com', 'alumno9', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(10, 'alumno10@profesor1.com', 'alumno10', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(11, 'alumno11@profesor1.com', 'alumno11', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(12, 'alumno12@profesor1.com', 'alumno12', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(13, 'alumno13@profesor1.com', 'alumno13', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(14, 'alumno14@profesor1.com', 'alumno14', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(15, 'alumno15@profesor1.com', 'alumno15', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(16, 'alumno16@profesor1.com', 'alumno16', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(17, 'profesor1@admin.com', 'profesor1', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(18, 'alumno17@profesor2.com', 'alumno17', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(19, 'alumno18@profesor2.com', 'alumno18', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(20, 'alumno19@profesor2.com', 'alumno19', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(21, 'alumno20@profesor2.com', 'alumno20', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(22, 'alumno21@profesor2.com', 'alumno21', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(23, 'alumno22@profesor2.com', 'alumno22', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(24, 'alumno23@profesor2.com', 'alumno23', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(25, 'alumno24@profesor2.com', 'alumno24', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(26, 'alumno25@profesor2.com', 'alumno25', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(27, 'alumno26@profesor2.com', 'alumno26', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(28, 'alumno27@profesor2.com', 'alumno27', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(29, 'alumno28@profesor2.com', 'alumno28', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(30, 'alumno29@profesor2.com', 'alumno29', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(31, 'alumno30@profesor2.com', 'alumno30', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(32, 'alumno31@profesor2.com', 'alumno31', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(33, 'alumno32@profesor2.com', 'alumno32', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_usuarios(id, usuario, password, permiso_id) VALUES(34, 'profesor2@admin.com', 'profesor2', 1);";
        db.execSQL(INSERT);
        CREAR_TABLA = "CREATE TABLE tbl_grados(id INTEGER PRIMARY KEY, descripcion TEXT);";
        db.execSQL(CREAR_TABLA);
        INSERT = "INSERT INTO tbl_grados(id, descripcion) VALUES(1, 'Primero');";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grados(id, descripcion) VALUES(2, 'Segundo');";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grados(id, descripcion) VALUES(3, 'Tercero');";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grados(id, descripcion) VALUES(4, 'Cuarto');";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grados(id, descripcion) VALUES(5, 'Quinto');";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grados(id, descripcion) VALUES(6, 'Sexto');";
        db.execSQL(INSERT);
        CREAR_TABLA = "CREATE TABLE tbl_alumnos(matricula INTEGER PRIMARY KEY, nombre TEXT,"
                +"paterno TEXT, materno TEXT, edad INTEGER,usuario_id INTEGER, grado_id INTEGER, "
                +"FOREIGN KEY(grado_id) REFERENCES tbl_grados(id),"
                +"FOREIGN KEY(usuario_id) REFERENCES tbl_usuarios(id));";
        db.execSQL(CREAR_TABLA);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(1, 'Fernando', 'Martinez', 'Ruiz', 10, 1, 5);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(2, 'Marisa', 'Cruz', 'Oviedo', 10, 2, 5);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(3, 'Adolfo', 'Juarez', 'Perez', 10, 3, 5);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(4, 'Maria Antonieta', 'Enriquez', 'Acevedo', 10, 4, 5);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(5, 'Jesus Francisco', 'Paniagua', 'Sanchez', 10, 5, 5);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(6, 'Elena', 'Ancira', 'Guadarrama', 10, 6, 5);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(7, 'Barbara Clarissa', 'Perez', 'Gamez', 10, 7, 5);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(8, 'Marisol', 'Ruiz', 'Jimenez', 10, 8, 5);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(9, 'Juan Luis', 'Guerron', 'Fernandez', 10, 9, 5);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(10, 'Meliton', 'Antonino', 'Guemez', 10, 10, 5);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(11, 'Paola', 'Rivas', 'Rivera', 10, 11, 5);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(12, 'Janeth', 'Jimenez', 'Rivas', 10, 12, 5);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(13, 'Fermin', 'Urrea', 'Meneses', 10, 13, 5);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(15, 'Ulises', 'Garza', 'Corona', 10, 15, 5);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(16, 'Esteban Antonio', 'Coronado', 'Costilla', 10, 16, 5);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(17, 'Pedro', 'Perez', 'Juarez', 10, 18, 6);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(18, 'Francisco', 'Fernandez', 'Domingez', 10, 19, 6);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(19, 'Gladis', 'Rodriguez', 'Zertuche', 10, 20, 6);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(20, 'Enrique', 'Ovalle', 'Ortiz', 10, 21, 6);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(21, 'Jimena', 'Carrizales', 'Ramirez', 10, 22, 6);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(22, 'Gustavo', 'Guemez', 'Tamez', 10, 23, 6);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(23, 'Brenda', 'Bezares', 'Romo', 10, 24, 6);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(24, 'Wendy', 'Vazquez', 'Vergara', 10, 25, 6);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(25, 'Valeria', 'Rios', 'Mireles', 10, 26, 6);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(26, 'Rafael', 'Jimenez', 'Lopez', 10, 27, 6);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(27, 'Ramon Antonio', 'Cruz', 'Ruiz', 10, 28, 6);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(28, 'Julian Fernando', 'Bernardez', 'Guillen', 10, 29, 6);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(29, 'Melissa Antonia', 'Acolt', 'Tamez', 10, 30, 6);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(30, 'Silvia', 'Juarez', 'Valenzuela', 10, 31, 6);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(31, 'Gerardo', 'Paredes', 'Dominguez', 10, 32, 6);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_alumnos(matricula, nombre, paterno, materno, edad, usuario_id, grado_id)"
                +"VALUES(32, 'Ricardo Antonio', 'Fernandez', 'Lopez', 10, 33, 6);";
        db.execSQL(INSERT);
        CREAR_TABLA = "CREATE TABLE tbl_materias(id INTEGER PRIMARY KEY, descripcion TEXT, "
                +"obligatoria NUMERIC);";
        db.execSQL(CREAR_TABLA);
        INSERT = "INSERT INTO tbl_materias(id, descripcion, obligatoria) VALUES(1, 'Español', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_materias(id, descripcion, obligatoria) VALUES(2, 'Ciencias Naturales', 1);";
        db.execSQL(INSERT);
        CREAR_TABLA = "CREATE TABLE tbl_profesores(num_empleado INTEGER PRIMARY KEY, nombre TEXT,"
                +"paterno TEXT, materno TEXT,materia_id INTEGER, edad INTEGER,usuario_id INTEGER,"
                +" grado_id INTEGER, FOREIGN KEY(grado_id) REFERENCES tbl_grados(id), "
                +"FOREIGN KEY(usuario_id) REFERENCES tbl_usuarios(id),"
                +"FOREIGN KEY(materia_id) REFERENCES tbl_materias(id));";
        db.execSQL(CREAR_TABLA);
        INSERT = "INSERT INTO tbl_profesores(num_empleado, nombre, paterno, materno, edad, usuario_id, grado_id, materia_id)"
                +"VALUES(1, 'Carlos Antonio', 'Perez', 'Juarez', 30, 17, 5, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_profesores(num_empleado, nombre, paterno, materno, edad, usuario_id, grado_id, materia_id)"
                +"VALUES(2, 'Maria Antonia', 'Fernandez', 'Jimenez', 40, 34, 6, 2);";
        db.execSQL(INSERT);
        CREAR_TABLA = "CREATE TABLE tbl_padres(id INTEGER PRIMARY KEY, nombre TEXT,"
                +"paterno TEXT, materno TEXT, edad INTEGER, usuario_id INTEGER, "
                +"FOREIGN KEY(usuario_id) REFERENCES tbl_usuarios(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_detalle_alumno(id INTEGER PRIMARY KEY, padre_id INTEGER,"
                +"alumno_id INTEGER, FOREIGN KEY(alumno_id) REFERENCES tbl_alumnos(matricula),"
                +"FOREIGN KEY(padre_id) REFERENCES tbl_padres(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_salones(id INTEGER PRIMARY KEY, descripcion TEXT,"
                +"acronimo TEXT, capacidad INTEGER, tipo TEXT);";
        db.execSQL(CREAR_TABLA);
        INSERT = "INSERT INTO tbl_salones(id, descripcion, acronimo, capacidad, tipo) VALUES(1, 'Salon 1', 'SAL1', 16, 'tipo1');";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_salones(id, descripcion, acronimo, capacidad, tipo) VALUES(2, 'Salon 2', 'SAL2', 16, 'tipo2');";
        db.execSQL(INSERT);
        CREAR_TABLA = "CREATE TABLE tbl_grupos(id INTEGER PRIMARY KEY, descripcion TEXT, "
                +"acronimo TEXT);";
        db.execSQL(CREAR_TABLA);
        INSERT = "INSERT INTO tbl_grupos(id, descripcion, acronimo) VALUES(1, 'Grupo 1', 'GR1');";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos(id, descripcion, acronimo) VALUES(2, 'Grupo 2', 'GR2');";
        db.execSQL(INSERT);
        CREAR_TABLA = "CREATE TABLE tbl_tipo_grupo(id INTEGER PRIMARY KEY, descripcion TEXT, "
                +"acronimo TEXT);";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_horarios(id INTEGER PRIMARY KEY, descripcion TEXT, "
                +"hora_inicio TEXT, hora_fin TEXT, turno TEXT);";
        db.execSQL(CREAR_TABLA);
        INSERT = "INSERT INTO tbl_horarios(id, descripcion, hora_inicio, hora_fin, turno)"
                +" VALUES(1,'Horario 1','7:00:00', '8:00:00','Matutino');";
        db.execSQL(INSERT);
        CREAR_TABLA = "CREATE TABLE tbl_detalle_grupos(id INTEGER PRIMARY KEY, grupo_id INTEGER,"
                +" salon_id INTEGER, materia_id INTEGER, ciclo_id INTEGER, profesor_id INTEGER, horario_id INTEGER,"
                +" FOREIGN KEY(grupo_id) REFERENCES tbl_grupos(id),"
                +" FOREIGN KEY(salon_id) REFERENCES tbl_salones(id),"
                +" FOREIGN KEY(materia_id) REFERENCES tbl_materias(id),"
                +" FOREIGN KEY(ciclo_id) REFERENCES tbl_ciclos(id),"
                +" FOREIGN KEY(profesor_id) REFERENCES tbl_profesores(id),"
                +" FOREIGN KEY(horario_id) REFERENCES tbl_horarios(id));";
        db.execSQL(CREAR_TABLA);
        INSERT = "INSERT INTO tbl_detalle_grupos(id, grupo_id, salon_id, materia_id, ciclo_id, profesor_id, horario_id)"
                +" VALUES(1, 1, 1, 1, 1, 1, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_detalle_grupos(id, grupo_id, salon_id, materia_id, ciclo_id, profesor_id, horario_id)"
                +" VALUES(2, 2, 2, 2, 1, 2, 1);";
        db.execSQL(INSERT);
        CREAR_TABLA = "CREATE TABLE tbl_grupos_alumnos(id INTEGER PRIMARY KEY, alumno_id INTEGER,"
                +" detalle_grupo_id INTEGER, FOREIGN KEY(alumno_id) REFERENCES tbl_alumnos(matricula),"
                +"FOREIGN KEY(detalle_grupo_id) REFERENCES tbl_detalle_grupos(id));";
        db.execSQL(CREAR_TABLA);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(1, 1, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(2, 2, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(3, 3, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(4, 4, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(5, 5, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(6, 6, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(7, 7, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(8, 8, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(9, 9, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(10, 10, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(11, 11, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(12, 12, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(13, 13, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(14, 14, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(15, 15, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(16, 16, 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(17, 17, 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(18, 18, 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(19, 19, 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(20, 20, 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(21, 21, 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(22, 22, 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(23, 23, 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(24, 24, 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(25, 25, 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(26, 26, 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(27, 27, 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(28, 28, 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(29, 29, 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(30, 30, 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(31, 31, 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_grupos_alumnos(id, alumno_id, detalle_grupo_id) VALUES(32, 32, 2);";
        db.execSQL(INSERT);
        CREAR_TABLA = "CREATE TABLE tbl_tareas(id INTEGER PRIMARY KEY, descripcion TEXT, "
                +" contenido TEXT, recurso TEXT, valor_numerico REAL, valor_otro TEXT,"
                +" materia_id INTEGER, FOREIGN KEY(materia_id) REFERENCES tbl_materias(id));";
        db.execSQL(CREAR_TABLA);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(1, 'Tarea 1', 'Instrucciones de tarea 1', 'recurso de tarea 1', 20.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(2, 'Tarea 2', 'Instrucciones de tarea 2', 'recurso de tarea 2', 10.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(3, 'Tarea 3', 'Instrucciones de tarea 3', 'recurso de tarea 3', 10.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(4, 'Tarea 4', 'Instrucciones de tarea 4', 'recurso de tarea 4', 10.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(5, 'Tarea 5', 'Instrucciones de tarea 5', 'recurso de tarea 5', 10.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(6, 'Tarea 6', 'Instrucciones de tarea 6', 'recurso de tarea 6', 10.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(7, 'Tarea 7', 'Instrucciones de tarea 7', 'recurso de tarea 7', 5.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(8, 'Tarea 8', 'Instrucciones de tarea 8', 'recurso de tarea 8', 5.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(9, 'Tarea 9', 'Instrucciones de tarea 9', 'recurso de tarea 9', 5.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(10, 'Tarea 10', 'Instrucciones de tarea 10', 'recurso de tarea 10', 5.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(11, 'Tarea 11', 'Instrucciones de tarea 11', 'recurso de tarea 11', 5.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(12, 'Tarea 12', 'Instrucciones de tarea 12', 'recurso de tarea 12', 5.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(13, 'Tarea 13', 'Instrucciones de tarea 13', 'recurso de tarea 13', 5.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(14, 'Tarea 14', 'Instrucciones de tarea 14', 'recurso de tarea 13', 5.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(15, 'Tarea 15', 'Instrucciones de tarea 15', 'recurso de tarea 15', 10.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(16, 'Tarea 16', 'Instrucciones de tarea 16', 'recurso de tarea 16', 10.0, 'A', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(17, 'Tarea 17', 'Instrucciones de tarea 17', 'recurso de tarea 17', 10.0, 'A', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(18, 'Tarea 18', 'Instrucciones de tarea 18', 'recurso de tarea 18', 10.0, 'A', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(19, 'Tarea 19', 'Instrucciones de tarea 19', 'recurso de tarea 19', 10.0, 'A', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(20, 'Tarea 20', 'Instrucciones de tarea 20', 'recurso de tarea 20', 10.0, 'A', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(21, 'Tarea 21', 'Instrucciones de tarea 21', 'recurso de tarea 21', 10.0, 'A', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(22, 'Tarea 22', 'Instrucciones de tarea 22', 'recurso de tarea 22', 10.0, 'A', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_tareas(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(23, 'Tarea 23', 'Instrucciones de tarea 23', 'recurso de tarea 23', 10.0, 'A', 2);";
        db.execSQL(INSERT);

        CREAR_TABLA = "CREATE TABLE tbl_grupos_tareas(id INTEGER PRIMARY KEY, tarea_id INTEGER,"
                +" detalle_grupo_id INTEGER, FOREIGN KEY(tarea_id) REFERENCES tbl_tareas(id),"
                +" FOREIGN KEY(detalle_grupo_id) REFERENCES tbl_detalle_grupos(id));";
        db.execSQL(CREAR_TABLA);

        CREAR_TABLA = "CREATE TABLE tbl_actividades(id INTEGER PRIMARY KEY, descripcion TEXT, "
                +" contenido TEXT, recurso TEXT, valor_numerico REAL, valor_otro TEXT,"
                +" materia_id INTEGER, FOREIGN KEY(materia_id) REFERENCES tbl_materias(id));";
        db.execSQL(CREAR_TABLA);
        INSERT = "INSERT INTO tbl_actividades(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(1, 'Actividad 1', 'Instrucciones de actividad 1', 'Recurso de Actividad 1', 20.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_actividades(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(2, 'Actividad 2', 'Instrucciones de actividad 2', 'Recurso de Actividad 2', 20.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_actividades(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(3, 'Actividad 3', 'Instrucciones de actividad 3', 'Recurso de Actividad 3', 20.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_actividades(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(4, 'Actividad 4', 'Instrucciones de actividad 4', 'Recurso de Actividad 4', 20.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_actividades(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(5, 'Actividad 5', 'Instrucciones de actividad 5', 'Recurso de Actividad 5', 20.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_actividades(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(6, 'Actividad 6', 'Instrucciones de actividad 6', 'Recurso de Actividad 6', 20.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_actividades(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(7, 'Actividad 7', 'Instrucciones de actividad 7', 'Recurso de Actividad 7', 20.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_actividades(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(8, 'Actividad 8', 'Instrucciones de actividad 8', 'Recurso de Actividad 8', 20.0, 'A', 1);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_actividades(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(9, 'Actividad 9', 'Instrucciones de actividad 9', 'Recurso de Actividad 9', 20.0, 'A', 1);";
        db.execSQL(INSERT);

        INSERT = "INSERT INTO tbl_actividades(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(10, 'Actividad 10', 'Instrucciones de actividad 10', 'Recurso de Actividad 10', 20.0, 'A', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_actividades(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(11, 'Actividad 11', 'Instrucciones de actividad 11', 'Recurso de Actividad 11', 20.0, 'A', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_actividades(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(12, 'Actividad 12', 'Instrucciones de actividad 12', 'Recurso de Actividad 12', 20.0, 'A', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_actividades(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(13, 'Actividad 13', 'Instrucciones de actividad 13', 'Recurso de Actividad 13', 20.0, 'A', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_actividades(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(14, 'Actividad 14', 'Instrucciones de actividad 14', 'Recurso de Actividad 14', 20.0, 'A', 2);";
        db.execSQL(INSERT);
        INSERT = "INSERT INTO tbl_actividades(id, descripcion, contenido, recurso, valor_numerico, valor_otro, materia_id)"
                +" VALUES(15, 'Actividad 15', 'Instrucciones de actividad 15', 'Recurso de Actividad 15', 20.0, 'A', 2);";
        db.execSQL(INSERT);

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
                +" alumno_id INTEGER, FOREIGN KEY(alumno_id) REFERENCES tbl_alumnos(matricula),"
                +" FOREIGN KEY(grupos_tareas_id) REFERENCES tbl_grupos_tareas(id));";
        db.execSQL(CREAR_TABLA);

        CREAR_TABLA = "CREATE TABLE tbl_actividades_alumnos(id INTEGER PRIMARY KEY, calificacion REAL,"
                +" descripcion TEXT, contenido TEXT, recursos TEXT, grupos_actividades_id INTEGER,"
                +" alumno_id INTEGER, FOREIGN KEY(alumno_id) REFERENCES tbl_alumnos(matricula),"
                +" FOREIGN KEY(grupos_actividades_id) REFERENCES tbl_grupos_actividades(id));";
        db.execSQL(CREAR_TABLA);

        CREAR_TABLA = "CREATE TABLE tbl_examenes_alumnos(id INTEGER PRIMARY KEY, calificacion REAL,"
                +" descripcion TEXT, contenido TEXT, recursos TEXT, grupos_examenes_id INTEGER,"
                +" alumno_id INTEGER, FOREIGN KEY(alumno_id) REFERENCES tbl_alumnos(matricula),"
                +" FOREIGN KEY(grupos_examenes_id) REFERENCES tbl_grupos_examenes(id));";
        db.execSQL(CREAR_TABLA);

        CREAR_TABLA = "CREATE TABLE tbl_especiales_alumnos(id INTEGER PRIMARY KEY, calificacion REAL,"
                +" descripcion TEXT, contenido TEXT, recursos TEXT, grupos_especiales_id INTEGER,"
                +" alumno_id INTEGER, FOREIGN KEY(alumno_id) REFERENCES tbl_alumnos(matricula),"
                +" FOREIGN KEY(grupos_especiales_id) REFERENCES tbl_grupos_especiales(id));";
        db.execSQL(CREAR_TABLA);
        CREAR_TABLA = "CREATE TABLE tbl_asistencias(id INTEGER PRIMARY KEY, profesor_id INTEGER, fecha_registro TEXT,"
                +" alumno_id INTEGER, FOREIGN KEY(alumno_id) REFERENCES tbl_alumnos(matricula));";
        db.execSQL(CREAR_TABLA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS tbl_asistencias;");
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
        db.execSQL("DROP TABLE IF EXISTS tbl_materias;");
        db.execSQL("DROP TABLE IF EXISTS tbl_alumnos;");
        db.execSQL("DROP TABLE IF EXISTS tbl_profesores;");
        db.execSQL("DROP TABLE IF EXISTS tbl_usuarios;");
        db.execSQL("DROP TABLE IF EXISTS tbl_grados;");
        db.execSQL("DROP TABLE IF EXISTS tbl_permisos;");
        db.execSQL("DROP TABLE IF EXISTS tbl_ciclos;");
        onCreate(db);
    }
    /*
    // Adding new contact
    void addContact(Contact contact) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_NAME, contact.getName()); // Contact Name
        values.put(KEY_PH_NO, contact.getPhoneNumber()); // Contact Phone

        // Inserting Row
        db.insert(TABLE_CONTACTS, null, values);
        db.close(); // Closing database connection
    }

    // Getting single contact
    Contact getContact(int id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_CONTACTS, new String[] { KEY_ID,
                        KEY_NAME, KEY_PH_NO }, KEY_ID + "=?",
                new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();

        Contact contact = new Contact(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1), cursor.getString(2));
        // return contact
        return contact;
    }*/

    // Getting All Contacts
    public List<Usuario> getAllUsers() {
        List<Usuario> contactList = new ArrayList<Usuario>();
        // Select All Query
        String selectQuery = "SELECT id, usuario, password, permiso_id FROM tbl_usuarios;";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Usuario contact = new Usuario(Integer.parseInt(cursor.getString(0))
                        , cursor.getString(1), cursor.getString(2), Integer.parseInt(cursor.getString(3)));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }

    public List<Alumno> getAllAlumnos() {
        List<Alumno> contactList = new ArrayList<Alumno>();
        // Select All Query

        String selectQuery = "SELECT A.alumno_id, A.nombre, D.profesor_id FROM tbl_detalle_grupos AS D" +
                "INNER JOIN(SELECT A.matricula AS alumno_id, (A.nombre || ' ' || A.paterno || ' ' || A.materno) AS nombre" +
                ", G.detalle_grupo_id as grupo_id FROM tbl_alumnos AS A INNER JOIN tbl_grupos_alumnos AS G" +
                "ON G.alumno_id = A.matricula) AS A ON A.grupo_id = D.id;";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Alumno contact = new Alumno(Integer.parseInt(cursor.getString(0))
                        , cursor.getString(1), Integer.parseInt(cursor.getString(2)));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }

    public List<Alumno> getAllAlumnos(Profesor profesor) {
        List<Alumno> contactList = new ArrayList<Alumno>();
        // Select All Query

        String selectQuery = "SELECT A.alumno_id, A.nombre, D.profesor_id FROM tbl_detalle_grupos AS D" +
                " INNER JOIN(SELECT A.matricula AS alumno_id, (A.nombre || ' ' || A.paterno || ' ' || A.materno) AS nombre" +
                ", G.detalle_grupo_id as grupo_id FROM tbl_alumnos AS A INNER JOIN tbl_grupos_alumnos AS G" +
                " ON G.alumno_id = A.matricula) AS A ON A.grupo_id = D.id AND D.profesor_id = "+profesor.getId()+";";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Alumno contact = new Alumno(Integer.parseInt(cursor.getString(0))
                        , cursor.getString(1), Integer.parseInt(cursor.getString(2)));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }

    public Profesor getProfesor(int usuario_id){
        Log.d("Usuario", ""+usuario_id);
        Profesor profesor = new Profesor();
        String selectQuery = "SELECT num_empleado, (nombre || ' ' || paterno || ' ' || materno) AS nombre" +
                ", materia_id FROM tbl_profesores WHERE usuario_id = "+usuario_id+" LIMIT 1;";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Log.d("Profesor", cursor.getString(1));
                profesor = new Profesor(Integer.parseInt(cursor.getString(0))
                        , cursor.getString(1), usuario_id, Integer.parseInt(cursor.getString(2)));
            } while (cursor.moveToNext());
        }
        return profesor;
    }

    public Alumno getAlumno(int usuario_id){
        Alumno alumno = new Alumno();
        String selectQuery = "SELECT matricula, (nombre || ' ' || paterno || ' ' || materno) AS nombre" +
                " FROM tbl_alumnos WHERE usuario_id = "+usuario_id+" LIMIT 1;";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                alumno = new Alumno(Integer.parseInt(cursor.getString(0))
                        , cursor.getString(1));
            } while (cursor.moveToNext());
        }
        return alumno;
    }

    public boolean getAsistencias(Profesor profesor){
        boolean asistencia = false;
        String selectQuery = "SELECT id FROM tbl_asistencias WHERE profesor_id = "+profesor.getId()+" LIMIT 1;";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                asistencia = true;
            } while (cursor.moveToNext());
        }
        return asistencia;
    }

    public void setAsistencias(Profesor profesor, List<Integer> alumnos){
        DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
        Date today = Calendar.getInstance().getTime();
        SQLiteDatabase db = this.getWritableDatabase();
        for (Integer alumno: alumnos) {
            Date date = new Date();
            String query ="INSERT INTO tbl_asistencias(profesor_id, alumno_id, fecha_registro)"
                    +" VALUES("+profesor.getId()+","+alumno.toString()+", '"+df.format(today)+"' );";
            db.execSQL(query);
        }
    }

    public List<Tarea> getUnassignedTareas(Profesor profesor){
        List<Tarea> contactList = new ArrayList<Tarea>();
        // Select All Query

        String selectQuery = "SELECT id, descripcion, contenido, recurso FROM tbl_tareas WHERE id NOT IN(" +
                "SELECT G.tarea_id " +
                " FROM tbl_grupos_tareas AS G" +
                " INNER JOIN(" +
                "   SELECT G.id AS grupo_id " +
                "   FROM tbl_detalle_grupos AS G " +
                "   INNER JOIN tbl_profesores AS P" +
                " ON P.num_empleado = G.profesor_id " +
                "   AND P.num_empleado = "+profesor.getId()+") AS P " +
                " ON P.grupo_id = G.detalle_grupo_id) AND materia_id = "+profesor.getMateriaId()+";";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Tarea contact = new Tarea(Integer.parseInt(cursor.getString(0))
                        , cursor.getString(1), cursor.getString(2), cursor.getString(3));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }

    public List<Actividad> getUnassignedActividades(Profesor profesor){
        List<Actividad> contactList = new ArrayList<Actividad>();
        // Select All Query

        String selectQuery = "SELECT id, descripcion, contenido, recurso FROM tbl_actividades WHERE id NOT IN(" +
                "SELECT G.actividad_id " +
                " FROM tbl_grupos_actividades AS G" +
                " INNER JOIN(" +
                "   SELECT G.id AS grupo_id " +
                "   FROM tbl_detalle_grupos AS G " +
                "   INNER JOIN tbl_profesores AS P" +
                " ON P.num_empleado = G.profesor_id " +
                "   AND P.num_empleado = "+profesor.getId()+") AS P " +
                " ON P.grupo_id = G.detalle_grupo_id) AND materia_id = "+profesor.getMateriaId()+";";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Actividad contact = new Actividad(Integer.parseInt(cursor.getString(0))
                        , cursor.getString(1), cursor.getString(2), cursor.getString(3));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }

    public void setTarea(Profesor profesor, Tarea tarea){
        String rawQuery = "SELECT G.id AS grupo_id " +
            " FROM tbl_detalle_grupos AS G INNER JOIN tbl_profesores AS P" +
                " ON P.num_empleado = G.profesor_id " +
                "   AND P.num_empleado = "+profesor.getId()+" LIMIT 1;";
        SQLiteDatabase db = this.getWritableDatabase();
        int det_id = 0;
        Cursor cursor = db.rawQuery(rawQuery, null);
        if (cursor.moveToFirst()) {
                det_id = Integer.parseInt(cursor.getString(0));
        }
        String query ="INSERT INTO tbl_grupos_tareas(detalle_grupo_id, tarea_id)"
                +" VALUES("+det_id+","+tarea.getId()+");";
        db.execSQL(query);
    }

    public void setActividad(Profesor profesor, Actividad actividad){
        String rawQuery = "SELECT G.id AS grupo_id " +
                " FROM tbl_detalle_grupos AS G INNER JOIN tbl_profesores AS P" +
                " ON P.num_empleado = G.profesor_id " +
                "   AND P.num_empleado = "+profesor.getId()+" LIMIT 1;";
        SQLiteDatabase db = this.getWritableDatabase();
        int det_id = 0;
        Cursor cursor = db.rawQuery(rawQuery, null);
        if (cursor.moveToFirst()) {
            det_id = Integer.parseInt(cursor.getString(0));
        }
        String query ="INSERT INTO tbl_grupos_actividades(detalle_grupo_id, actividad_id)"
                +" VALUES("+det_id+","+actividad.getId()+");";
        db.execSQL(query);
    }

    public List<Tarea> getMyTareas(Alumno alumno){
        List<Tarea> contactList = new ArrayList<Tarea>();
        // Select All Query
        String selectQuery = "SELECT id, descripcion, contenido, recurso FROM tbl_tareas WHERE id IN(" +
                "SELECT G.tarea_id " +
                " FROM tbl_grupos_tareas AS G" +
                " INNER JOIN(" +
                "   SELECT G.detalle_grupo_id AS grupo_id" +
                "   FROM tbl_grupos_alumnos AS G " +
                "   INNER JOIN tbl_alumnos AS A" +
                " ON A.matricula = G.alumno_id " +
                "   AND A.matricula = "+alumno.getId()+") AS A " +
                " ON A.grupo_id = G.detalle_grupo_id AND G.id NOT IN (" +
                "   SELECT grupos_tareas_id FROM tbl_tareas_alumnos " +
                " WHERE alumno_id = "+alumno.getId()+"));";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Tarea contact = new Tarea(Integer.parseInt(cursor.getString(0))
                        , cursor.getString(1), cursor.getString(2), cursor.getString(3));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }

    public List<Actividad> getMyActividades(Alumno alumno){
        List<Actividad> contactList = new ArrayList<Actividad>();
        String selectQuery = "SELECT id, descripcion, contenido, recurso FROM tbl_actividades WHERE id IN(" +
                "SELECT G.actividad_id " +
                " FROM tbl_grupos_actividades AS G" +
                " INNER JOIN(" +
                "   SELECT G.detalle_grupo_id AS grupo_id" +
                "   FROM tbl_grupos_alumnos AS G " +
                "   INNER JOIN tbl_alumnos AS A" +
                " ON A.matricula = G.alumno_id " +
                "   AND A.matricula = "+alumno.getId()+") AS A " +
                " ON A.grupo_id = G.detalle_grupo_id AND G.id NOT IN (" +
                " SELECT actividad_id FROM tbl_actividades_alumnos " +
                "   WHERE alumno_id = "+alumno.getId()+"));";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Actividad contact = new Actividad(Integer.parseInt(cursor.getString(0))
                        , cursor.getString(1), cursor.getString(2), cursor.getString(3));
                contactList.add(contact);
            } while (cursor.moveToNext());
        }
        return contactList;
    }

    public void setActividadAlumno(Alumno alumno, Actividad actividad){
        String rawQuery = "SELECT id FROM tbl_grupos_actividades WHERE actividad_id = "+ actividad.getId() +" LIMIT 1;";
        SQLiteDatabase db = this.getWritableDatabase();
        int det_id = 0;
        Cursor cursor = db.rawQuery(rawQuery, null);
        if (cursor.moveToFirst()) {
            det_id = Integer.parseInt(cursor.getString(0));
        }
        String query ="INSERT INTO tbl_actividades_alumnos(grupos_actividades_id, alumno_id, recursos, calificacion)"
                +" VALUES("+det_id+","+alumno.getId()+", '"+ actividad.getRecursos() +"', -1);";
        db.execSQL(query);
    }

    public void setTareaAlumno(Alumno alumno, Tarea tarea){
        String rawQuery = "SELECT id FROM tbl_grupos_tareas WHERE tarea_id = "+ tarea.getId() +" LIMIT 1;";
        SQLiteDatabase db = this.getWritableDatabase();
        int det_id = 0;
        Cursor cursor = db.rawQuery(rawQuery, null);
        if (cursor.moveToFirst()) {
            det_id = Integer.parseInt(cursor.getString(0));
        }
        String query ="INSERT INTO tbl_tareas_alumnos(grupos_tareas_id, alumno_id, recursos, calificacion)"
                +" VALUES("+det_id+","+alumno.getId()+", '"+ tarea.getRecursos() +"', -1);";
        db.execSQL(query);
    }

    public List<TareaAlumno> getUncheckedTareas(Profesor profesor){
        //List<Alumno> alumnos = this.getAllAlumnos(profesor);
        List<TareaAlumno> tareaAlumnos = new ArrayList<>();
        String selectQuery = "SELECT A.alumno_id, A.nombre, A.tarea_id, T.descripcion " +
                "FROM(SELECT A.alumno_id, A.nombre, T.tarea_id " +
                " FROM (SELECT TA.alumno_id, (A.nombre || ' ' || A.paterno || ' ' || A.materno) as nombre," +
                " TA.grupos_tareas_id" +
                " FROM tbl_tareas_alumnos AS TA " +
                " INNER JOIN tbl_alumnos AS A"+
                " ON grupos_tareas_id NOT IN(" +
                "   SELECT G.id " +
                "   FROM tbl_grupos_tareas AS G" +
                "   INNER JOIN(" +
                "       SELECT G.id AS grupo_id " +
                "       FROM tbl_detalle_grupos AS G " +
                "       INNER JOIN tbl_profesores AS P" +
                "           ON P.num_empleado = G.profesor_id " +
                "           AND P.num_empleado = "+profesor.getId()+") AS P " +
                "   ON P.grupo_id = G.id)" +
                "   AND TA.calificacion = -1 AND A.matricula = TA.alumno_id) AS A " +
                " INNER JOIN tbl_grupos_tareas AS T " +
                " ON T.id = A.grupos_tareas_id) AS A " +
                " INNER JOIN tbl_tareas AS T " +
                " ON T.id = A.tarea_id;";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Alumno contact = new Alumno(Integer.parseInt(cursor.getString(0))
                        , cursor.getString(1));
                Tarea tarea = new Tarea(Integer.parseInt(cursor.getString(2)), cursor.getString(3));
                tareaAlumnos.add(new TareaAlumno(tarea, contact));
            } while (cursor.moveToNext());
        }
        return tareaAlumnos;

    }
}

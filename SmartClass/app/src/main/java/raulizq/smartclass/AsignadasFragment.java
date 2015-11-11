package raulizq.smartclass;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class AsignadasFragment extends Fragment {
    private DbClassHelper db;
    private Alumno alumno;
    private static final int SELECT_PICTURE = 1;
    private Bitmap selImage;
    private Uri selectedImagePath;

    public AsignadasFragment() {
        // Required empty public constructor
    }

    public void setDb(DbClassHelper db){
        this.db = db;
    }
    public void setAlumno(Alumno alumno){ this.alumno = alumno;}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_asignadas, container, false);
        Spinner sp_asignacion = (Spinner) root.findViewById(R.id.sp_asignadas);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(root.getContext(),
                R.array.options_spinner, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_asignacion.setAdapter(adapter);
        sp_asignacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0){
                    LinearLayout linear = (LinearLayout) view.getRootView().findViewById(R.id.tareas);
                    linear.setVisibility(View.INVISIBLE);
                    linear = (LinearLayout) view.getRootView().findViewById(R.id.actividades);
                    linear.setVisibility(View.VISIBLE);
                }else{
                    LinearLayout linear = (LinearLayout) view.getRootView().findViewById(R.id.tareas);
                    linear.setVisibility(View.VISIBLE);
                    linear = (LinearLayout) view.getRootView().findViewById(R.id.actividades);
                    linear.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        final Spinner sp_tareas = (Spinner) root.findViewById(R.id.sp_tareas);
        final Spinner sp_actividades = (Spinner) root.findViewById(R.id.sp_actividades);
        final List<Tarea> tareas = db.getMyTareas(alumno);
        ArrayList<String> iTareas = new ArrayList<String>();
        for (Tarea tarea: tareas){
            iTareas.add(tarea.descripcion);
        }
        final ArrayAdapter<String> aTareas = new ArrayAdapter<String>(this.getContext()
                , android.R.layout.simple_list_item_1, iTareas);
        aTareas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_tareas.setAdapter(aTareas);
        final List<Actividad> actividades = db.getMyActividades(alumno);
        ArrayList<String> iActividades = new ArrayList<String>();
        for (Actividad act: actividades){
            iActividades.add(act.descripcion);
        }
        final ArrayAdapter<String> aActividades = new ArrayAdapter<String>(this.getContext()
                , android.R.layout.simple_list_item_1, iActividades);
        aActividades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_actividades.setAdapter(aActividades);
        Button btn = (Button) root.findViewById(R.id.guardar);
        btn.setEnabled(false);
        LinearLayout linear = (LinearLayout) root.findViewById(R.id.tareas);
        linear.setVisibility(View.INVISIBLE);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LinearLayout linear = (LinearLayout) v.getRootView().findViewById(R.id.tareas);
                if (linear.getVisibility() == View.INVISIBLE) {
                    if (sp_actividades.getSelectedItem() != null) {
                        String myData = sp_actividades.getSelectedItem().toString();
                        int id = aActividades.getPosition(myData);
                        Actividad actividad = actividades.get(id);
                        actividad.setRecursos(selectedImagePath.toString());
                        db.setActividadAlumno(alumno, actividad);
                        actividades.remove(actividad);
                        aActividades.remove(myData);
                        Snackbar.make(v, "Se envio la actividad correctamente", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        Button btn = (Button) v.findViewById(R.id.guardar);
                        btn.setEnabled(false);
                    } else {
                        Snackbar.make(v, "No existe actividad para enviar", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                } else {
                    if (sp_tareas.getSelectedItem() != null) {
                        String myData = sp_tareas.getSelectedItem().toString();
                        int id = aTareas.getPosition(myData);
                        //int id = sp_tareas.getSelectedItemPosition();
                        Tarea tarea = tareas.get(id);
                        tarea.setRecursos(selectedImagePath.toString());
                        db.setTareaAlumno(alumno, tarea);
                        tareas.remove(tarea);
                        aTareas.remove(myData);
                        Snackbar.make(v, "Se envio la tarea correctamente", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                        Button btn = (Button) v.findViewById(R.id.guardar);
                        btn.setEnabled(false);
                    } else {
                        Snackbar.make(v, "No existe tarea para enviar", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }
            }
        });
        Button btn2 = (Button)root.findViewById(R.id.recursos);
        btn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(intent,
                        "Seleccione Imagen"), SELECT_PICTURE);
            }
        });
        return root;
    }

    public void onActivityResult(int requestCode, int resultCode,
                                    Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
        if(resultCode == Activity.RESULT_OK){
            selectedImagePath = imageReturnedIntent.getData();
            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = this.getActivity().getContentResolver().query(
                    selectedImagePath, filePathColumn, null, null, null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String filePath = cursor.getString(columnIndex);
            cursor.close();
            selImage = BitmapFactory.decodeFile(filePath);
            Button btn = (Button) this.getView().findViewById(R.id.guardar);
            btn.setEnabled(true);
        }
    }
}

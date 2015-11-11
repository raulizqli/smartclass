package raulizq.smartclass;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
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
public class AsignacionFragment extends Fragment {
    private DbClassHelper db;
    private Profesor profesor;
    public AsignacionFragment() {
        // Required empty public constructor
    }

    public void setDb(DbClassHelper db){
        this.db = db;
    }
    public void setProfesor(Profesor profesor){ this.profesor = profesor;}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_asignacion, container, false);
        Spinner sp_asignacion = (Spinner) root.findViewById(R.id.sp_asignacion);
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
        final List<Tarea> tareas = db.getUnassignedTareas(profesor);
        ArrayList<String> iTareas = new ArrayList<String>();
        for (Tarea tarea: tareas){
            iTareas.add(tarea.descripcion);
        }
        final ArrayAdapter<String> aTareas = new ArrayAdapter<String>(this.getContext()
                , android.R.layout.simple_list_item_1, iTareas);
        aTareas.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_tareas.setAdapter(aTareas);
        final List<Actividad> actividades = db.getUnassignedActividades(profesor);
        ArrayList<String> iActividades = new ArrayList<String>();
        for (Actividad act: actividades){
            iActividades.add(act.descripcion);
        }
        final ArrayAdapter<String> aActividades = new ArrayAdapter<String>(this.getContext()
                , android.R.layout.simple_list_item_1, iActividades);
        aActividades.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_actividades.setAdapter(aActividades);
        Button btn = (Button) root.findViewById(R.id.guardarAsignacion);
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
                        db.setActividad(profesor, actividad);
                        actividades.remove(actividad);
                        aActividades.remove(myData);
                        Snackbar.make(v, "Se asigno la actividad correctamente", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    } else {
                        Snackbar.make(v, "No existe actividad para asignar", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                } else {
                    if (sp_tareas.getSelectedItem() != null) {
                        String myData = sp_tareas.getSelectedItem().toString();
                        int id = aTareas.getPosition(myData);
                        //int id = sp_tareas.getSelectedItemPosition();
                        Tarea tarea = tareas.get(id);
                        db.setTarea(profesor, tarea);
                        tareas.remove(tarea);
                        aTareas.remove(myData);
                        Snackbar.make(v, "Se asigno la tarea correctamente", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    } else {
                        Snackbar.make(v, "No exixte tarea para asignar", Snackbar.LENGTH_LONG)
                                .setAction("Action", null).show();
                    }
                }
            }
        });

        return root;
    }


}

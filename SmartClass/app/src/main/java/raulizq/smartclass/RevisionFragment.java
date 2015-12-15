package raulizq.smartclass;


import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class RevisionFragment extends Fragment {

    private DbClassHelper db;
    private Profesor profesor;

    public RevisionFragment() {
        // Required empty public constructor
    }

    public void setDb(DbClassHelper db) {
        this.db = db;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_revision, container, false);
        List<TareaAlumno> tarAlu = db.getUncheckedTareas(profesor);
        LinearLayout linear = (LinearLayout) root.findViewById(R.id.revision);
        Context context = root.getContext();
        if (tarAlu.isEmpty()) {
            TextView name = new TextView(context);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                    , ViewGroup.LayoutParams.WRAP_CONTENT);
            name.setLayoutParams(lp);
            String rName = "No existe ninguna revisón pendiente";
            name.setText(rName);
            name.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            linear.addView(name);
            Snackbar.make(root, "No existe ninguna revisón pendiente", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            Toast.makeText(root.getContext(), "No existe ninguna revisón pendiente", Toast.LENGTH_LONG);
        } else {
            for (TareaAlumno al : tarAlu) {
                Random r = new Random();
                TextView name = new TextView(context);
                ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                        , ViewGroup.LayoutParams.WRAP_CONTENT);
                name.setLayoutParams(lp);
                String rName = al.getAlumno().getNombre() +" - " +al.getTarea().getDescripcion();
                name.setText(rName);
                name.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                linear.addView(name);
                SeekBar sek = new SeekBar( context );
                sek.setContentDescription("" + al.getId());
                linear.addView(sek);
            }
            Button send = new Button(context);
            send.setText("Guardar Actividades");
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LinearLayout linear = (LinearLayout) v.getRootView().findViewById(R.id.asistencias);
                    int count = linear.getChildCount();
                    ArrayList<TareaAlumno> ids = new ArrayList<TareaAlumno>();
                    for (int i = 0; i < count; i++) {
                        View view = linear.getChildAt(i);
                        if (view instanceof SeekBar) {
                            SeekBar rg = (SeekBar) view;
                            int value = rg.getProgress();
                            TareaAlumno tarea = new TareaAlumno();
                            tarea.setId(Integer.parseInt(rg.getContentDescription().toString()));
                            tarea.setCalificacion(value);
                            ids.add(tarea);
                        }
                    }
                    db.setRevisionTareas(ids);
                    Snackbar.make(v, "Se guardaron las revisiones correctemente", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    v.setEnabled(false);
                }
            });
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            send.setLayoutParams(lp);
            linear.addView(send);
            Space space = new Space(context);
            lp = new ViewGroup.LayoutParams(130, 130);
            space.setLayoutParams(lp);
            linear.addView(space);
        }
        return root;

    }
}

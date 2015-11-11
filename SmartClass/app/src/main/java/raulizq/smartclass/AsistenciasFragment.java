package raulizq.smartclass;


import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.util.Size;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Random;

public class AsistenciasFragment extends Fragment {

    public String[] names = {"Roberto", "Maria", "Francisco", "Luisa", "Eduardo", "Gloria", "Luis", "Janeth"
            , "Pedro", "Paola", "Antonio", "Vanessa"};
    public String[] lastnames = {"Roberto", "Maria", "Francisco", "Luisa", "Eduardo", "Gloria", "Luis", "Janeth"
            , "Pedro", "Paola", "Antonio", "Vanessa"};
    public String[] lastnames2 = {"Roberto", "Maria", "Francisco", "Luisa", "Eduardo", "Gloria", "Luis", "Janeth"
            , "Pedro", "Paola", "Antonio", "Vanessa"};
    private DbClassHelper db;
    private Profesor profesor;

    public AsistenciasFragment() {
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

        View mView = inflater.inflate(R.layout.fragment_asistencias, container, false);
        LinearLayout linear = (LinearLayout) mView.findViewById(R.id.asistencias);
        Context context = mView.getContext();
        List<Alumno> alumnos = db.getAllAlumnos(this.profesor);
        if(db.getAsistencias(this.profesor)){
            TextView name = new TextView(context);
            ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                    , ViewGroup.LayoutParams.WRAP_CONTENT);
            name.setLayoutParams(lp);
            String rName = "Ya se tomo la asistencia el dia de hoy";
            name.setText(rName);
            name.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
            linear.addView(name);
            Snackbar.make(mView, "Ya se tomo la asistencia", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            Toast.makeText(mView.getContext(), "Ya se tomo la asistencia", Toast.LENGTH_LONG);
        }else {
            for (Alumno al : alumnos) {
                Random r = new Random();
                TextView name = new TextView(context);
                ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT
                        , ViewGroup.LayoutParams.WRAP_CONTENT);
                name.setLayoutParams(lp);
                String rName = al.getNombre();
                name.setText(rName);
                name.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 20);
                linear.addView(name);
                RadioGroup rGroup = new RadioGroup(context);
                rGroup.setContentDescription("" + al.getId());
                lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                rGroup.setLayoutParams(lp);
                linear.addView(rGroup);
                RadioButton yes = new RadioButton(rGroup.getContext());
                yes.setText("Asistencia");
                lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                yes.setLayoutParams(lp);
                yes.setChecked(false);
                RadioButton no = new RadioButton(rGroup.getContext());
                no.setText("Inasistencia");
                lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                no.setLayoutParams(lp);
                no.setChecked(false);
                RadioButton late = new RadioButton(rGroup.getContext());
                late.setText("Tarde");
                lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                late.setLayoutParams(lp);
                late.setChecked(false);
                rGroup.addView(yes);
                rGroup.addView(no);
                rGroup.addView(late);
                yes.setChecked(true);
            }
            Button send = new Button(context);
            send.setText("Guardar");
            send.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    LinearLayout linear = (LinearLayout) v.getRootView().findViewById(R.id.asistencias);
                    int count = linear.getChildCount();
                    ArrayList<Integer> ids = new ArrayList<Integer>();
                    for (int i = 0; i < count; i++) {
                        View view = linear.getChildAt(i);
                        if (view instanceof RadioGroup) {
                            RadioGroup rg = (RadioGroup) view;
                            ids.add(Integer.parseInt(rg.getContentDescription().toString()));
                        }
                    }
                    db.setAsistencias(profesor, ids);
                    Snackbar.make(v, "Se guardo la asistencia", Snackbar.LENGTH_LONG)
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
        return  mView;
    }

}

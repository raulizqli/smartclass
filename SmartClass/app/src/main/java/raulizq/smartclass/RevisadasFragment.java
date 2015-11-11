package raulizq.smartclass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class RevisadasFragment extends Fragment {
    private DbClassHelper db;
    private Alumno alumno;

    public RevisadasFragment() {
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
        return inflater.inflate(R.layout.fragment_revisadas, container, false);
    }


}

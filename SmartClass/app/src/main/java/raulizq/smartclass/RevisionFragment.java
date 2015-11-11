package raulizq.smartclass;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class RevisionFragment extends Fragment {

    private DbClassHelper db;
    private Profesor profesor;
    public RevisionFragment() {
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
        return inflater.inflate(R.layout.fragment_revision, container, false);
    }


}

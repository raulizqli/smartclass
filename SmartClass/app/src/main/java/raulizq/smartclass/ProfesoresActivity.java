package raulizq.smartclass;

import android.app.ActionBar;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;
import java.util.jar.JarEntry;

public class ProfesoresActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;
    private DbClassHelper db;
    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profesores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Asistencia"));
        tabLayout.addTab(tabLayout.newTab().setText("Asignacion"));
        tabLayout.addTab(tabLayout.newTab().setText("Revision"));
        mViewPager = (ViewPager) findViewById(R.id.container);
        db = new DbClassHelper(this);
        Profesor profesor = (Profesor)getIntent().getSerializableExtra("Profesor");
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager()
                , tabLayout.getTabCount(), db, profesor);
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mViewPager.setCurrentItem(1);
                Snackbar.make(view, "Asignar ...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profesores, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentStatePagerAdapter {
        private int tabsNum;
        private DbClassHelper db;
        private Profesor profesor;

        public SectionsPagerAdapter(FragmentManager fm, int count, DbClassHelper db, Profesor profesor) {
            super(fm);
            this.tabsNum = count;
            this.db = db;
            this.profesor = profesor;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    AsistenciasFragment tab = new AsistenciasFragment();
                    tab.setDb(db);
                    tab.setProfesor(profesor);
                    return tab;
                case 1:
                    AsignacionFragment tab2 = new AsignacionFragment();
                    tab2.setDb(db);
                    tab2.setProfesor(profesor);
                    return tab2;
                case 2:
                    RevisionFragment tab3 = new RevisionFragment();
                    tab3.setDb(db);
                    tab3.setProfesor(profesor);
                    return tab3;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return this.tabsNum;
        }
    }
}

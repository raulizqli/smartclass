package raulizq.smartclass;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

public class AlumnosActivity extends AppCompatActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;
    private DbClassHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumnos);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.addTab(tabLayout.newTab().setText("Tareas - Actividades"));
        //tabLayout.addTab(tabLayout.newTab().setText(""));
        tabLayout.addTab(tabLayout.newTab().setText("Revisadas"));
        mViewPager = (ViewPager) findViewById(R.id.container);
        db = new DbClassHelper(this);
        Alumno alumno = (Alumno)getIntent().getSerializableExtra("Alumno");
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager()
                , tabLayout.getTabCount(), db, alumno);
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
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alumnos, menu);
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
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        private int tabsNum;
        private DbClassHelper db;
        private Alumno alumno;

        public SectionsPagerAdapter(FragmentManager fm, int count, DbClassHelper db, Alumno alumno) {
            super(fm);
            this.tabsNum = count;
            this.db = db;
            this.alumno = alumno;
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    AsignadasFragment tab = new AsignadasFragment();
                    tab.setDb(db);
                    tab.setAlumno(alumno);
                    return tab;
                case 1:
                    RevisadasFragment tab2 = new RevisadasFragment();
                    tab2.setDb(db);
                    tab2.setAlumno(alumno);
                    return tab2;
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

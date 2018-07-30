package com.leotorrealba.petagramv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.leotorrealba.petagramv2.adapter.PageAdapter;
import com.leotorrealba.petagramv2.fragment.MainActivityFragment;
import com.leotorrealba.petagramv2.fragment.SecondActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Click", Snackbar.LENGTH_LONG)
                        .setAction("Click", null).show();
            }
        });

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if (toolbar != null){
            setSupportActionBar(toolbar);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menuTop5:
                Intent intent = new Intent(this, DetalleMascota.class);
                this.startActivity(intent);
                return true;
            case R.id.mContact:
                Intent intent2 = new Intent(this, Contact.class);
                this.startActivity(intent2);
                return true;
            case R.id.mAbout:
                Intent intent3 = new Intent(this, About.class);
                this.startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private ArrayList<Fragment> agregarFragments(){

        ArrayList<Fragment> fragments = new ArrayList<>();

        fragments.add(new MainActivityFragment());
        fragments.add(new SecondActivity());

        return fragments;

    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agregarFragments()));
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_dog_house);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_dog);
    }

}

package com.captainhampton.android.lightsout.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.captainhampton.android.lightsout.R;
import com.captainhampton.android.lightsout.fragment.FragmentClassic;
import com.captainhampton.android.lightsout.fragment.FragmentMenu;

public class ActivityMain extends AppCompatActivity implements FragmentMenu.OnFragmentInteractionListener, FragmentClassic.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        Fragment menu = FragmentMenu.newInstance("a", "b");
        // use the public static newInstance method instead of a constructor

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.add(R.id.menu_screen, menu, FragmentMenu.TAG).commit();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(int i) {

    }

    @Override
    public void onStartButtonPressed(/* if there are multiple button options from within the fragment,
     create multiple different methods, or if the logic is simple routing, pass a parameter ex. FragmentMenu.TAG
         implying of the location you are going to or even as simple as an int 1 (for now)*/) {

        Fragment someNewFragment = FragmentClassic.newInstance("a","b");
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.menu_screen, someNewFragment, FragmentClassic.TAG).commit();
    }
}

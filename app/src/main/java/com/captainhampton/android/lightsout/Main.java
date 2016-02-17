package com.captainhampton.android.lightsout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity implements FragmentMenu.OnFragmentInteractionListener{


    Button bClassic, bDeluxe, bHowToPlay, bAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);

        Fragment menu = new FragmentMenu();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();



        ft.add(R.id.menu_screen, menu, FragmentMenu.TAG).commit();

       // setupVariables();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void onClick(View v) {

        if (bClassic.isPressed()) {
            Intent classicIntent = new Intent("android.intent.action.CLASSIC");
            startActivity(classicIntent);
        }

        if (bDeluxe.isPressed()) {
            Intent classicIntent = new Intent("android.intent.action.DELUXE");
            startActivity(classicIntent);
        }

        if (bHowToPlay.isPressed()) {
            Intent classicIntent = new Intent("android.intent.action.HOWTOPLAY");
            startActivity(classicIntent);
        }

        if (bAbout.isPressed()) {
            Intent classicIntent = new Intent("android.intent.action.ABOUT");
            startActivity(classicIntent);
        }

    }

    @Override
    public void onFragmentInteraction(int i) {

    }
}

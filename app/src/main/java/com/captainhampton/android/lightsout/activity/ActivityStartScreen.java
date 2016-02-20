package com.captainhampton.android.lightsout.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.captainhampton.android.lightsout.R;

public class ActivityStartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start_screen);

        findViewById(R.id.fullscreen_content_controls).setVisibility(View.VISIBLE);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        findViewById(R.id.start_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(ActivityStartScreen.this, ActivityMain.class);
                startActivity(i);
            }
        });
    }
}

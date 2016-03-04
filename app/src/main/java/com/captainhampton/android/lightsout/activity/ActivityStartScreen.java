package com.captainhampton.android.lightsout.activity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.captainhampton.android.lightsout.LOUtils;
import com.captainhampton.android.lightsout.R;

public class ActivityStartScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_start_screen);
        LOUtils.applyFont(this, R.id.start_screen_text, LOUtils.FONT_GEAR);

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

package com.captainhampton.android.lightsout;


import android.app.Activity;
import android.graphics.Typeface;
import android.widget.TextView;

public class LOUtils {

    public static final String FONT_GEAR = "gear.ttf";

    public static void applyFont(Activity activity, int id, String fontName) {
        TextView textView = (TextView) activity.findViewById(id);
        if (textView != null) {
            Typeface tf = Typeface.createFromAsset(activity.getAssets(), "fonts/" + fontName);
            textView.setTypeface(tf);
        }
    }
}

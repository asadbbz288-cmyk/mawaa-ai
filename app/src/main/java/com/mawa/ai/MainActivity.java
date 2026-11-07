package com.mawa.ai;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.graphics.Color;
import android.view.Gravity;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        TextView title = new TextView(this);
        title.setText("MAWA AI");
        title.setTextSize(32);
        title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.CENTER);

        title.setBackgroundColor(Color.rgb(25, 20, 55));

        setContentView(title);
    }
}

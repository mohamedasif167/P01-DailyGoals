package com.example.a15017498.p01_dailygoals;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Summary extends AppCompatActivity {

    Button btnClose;
    TextView textview;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        setTitle("Summary");

//        toolbar = (Toolbar) findViewById(R.id.tool)
//        toolbar.setTitle("Summary");
        textview = (TextView) findViewById(R.id.textview);
        btnClose = (Button) findViewById(R.id.btnClose);

        btnClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String ans1 = prefs.getString("ans1","false");
        String ans2 = prefs.getString("ans2","false");
        String ans3 = prefs.getString("ans3","false");
        String ans4 = prefs.getString("ans4","false");

        String qn1 = prefs.getString("qn1","false");
        String qn2 = prefs.getString("qn2","false");
        String qn3 = prefs.getString("qn3","false");
        String qn4 = prefs.getString("qn4","false");


        String message = qn1+" : "+ans1+"\n"+qn2+": "+ans2+"\n"+qn3+": "+ans3+"\n"+qn4+": "+ans4 ;

        textview.setText(message);

    }
}

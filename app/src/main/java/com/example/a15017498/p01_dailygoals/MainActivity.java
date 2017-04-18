package com.example.a15017498.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn1 = (Button) findViewById(R.id.btn1);
        editText = (EditText) findViewById(R.id.editText2);


        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
                SharedPreferences.Editor prefEditor  = prefs.edit();


                TextView qn1 = (TextView) findViewById(R.id.qn1);
                TextView qn2 = (TextView) findViewById(R.id.qn2);
                TextView qn3 = (TextView) findViewById(R.id.qn3);
                TextView qn4 = (TextView) findViewById(R.id.qn4);


                prefEditor.putString("qn1",qn1.getText().toString());
                prefEditor.putString("qn2",qn2.getText().toString());
                prefEditor.putString("qn3",qn3.getText().toString());
                prefEditor.putString("qn4",qn4.getText().toString());

           //This is for the first question

                // Get the RadioGroup object
                RadioGroup rg = (RadioGroup) findViewById(R.id.radiogroup1);
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId = rg.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb = (RadioButton) findViewById(selectedButtonId);
                //Show a Toast that display the text on the selected radio button
                prefEditor.putString("ans1", (String) rb.getText());
               // Toast.makeText(getBaseContext(), rb.getText(),  Toast.LENGTH_LONG).show();

                // Get the RadioGroup object
                RadioGroup rg2 = (RadioGroup) findViewById(R.id.radiogroup2);
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb2 = (RadioButton) findViewById(selectedButtonId2);
                prefEditor.putString("ans2", (String) rb2.getText());
                //Show a Toast that display the text on the selected radio button
               // Toast.makeText(getBaseContext(), rb2.getText(),  Toast.LENGTH_LONG).show();


                // Get the RadioGroup object
                RadioGroup rg3 = (RadioGroup) findViewById(R.id.radiogroup2);
                // Get the Id of the selected radio button in the RadioGroup
                int selectedButtonId3 = rg3.getCheckedRadioButtonId();
                // Get the radio button object from the Id we had gotten above
                RadioButton rb3 = (RadioButton) findViewById(selectedButtonId3);
                prefEditor.putString("ans3", (String) rb3.getText());
                //Show a Toast that display the text on the selected radio button
               // Toast.makeText(getBaseContext(), rb3.getText(),  Toast.LENGTH_LONG).show();


                EditText editText2 = (EditText) findViewById(R.id.editText2);
                prefEditor.putString("ans4",editText2.getText().toString());

                prefEditor.commit();
                Intent intent = new Intent(getBaseContext(),Summary.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        String ans1 = prefs.getString("ans1","false");
        String ans2 = prefs.getString("ans2","false");
        String ans3 = prefs.getString("ans3","false");
        String ans4 = prefs.getString("ans4","false");


        if(ans1.equalsIgnoreCase("Yes")){
            RadioButton rbu1 =(RadioButton)findViewById(R.id.radioButton);
            rbu1.setChecked(true);
        }else{
            RadioButton rbu1 =(RadioButton)findViewById(R.id.radioButton2);
            rbu1.setChecked(true);
        }

         if (ans2.equalsIgnoreCase("Yes")){
            RadioButton rbu1 =(RadioButton)findViewById(R.id.radioButton3);
            rbu1.setChecked(true);
        }else {
            RadioButton rbu1 =(RadioButton)findViewById(R.id.radioButton4);
            rbu1.setChecked(true);
        }
         if (ans3.equalsIgnoreCase("Yes")){
            RadioButton rbu1 =(RadioButton)findViewById(R.id.radioButton5);
            rbu1.setChecked(true);
        }else{
            RadioButton rbu1 =(RadioButton)findViewById(R.id.radioButton6);
            rbu1.setChecked(true);
        }


        editText.setText(ans4);


    }
}

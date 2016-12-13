package com.example.js_cmd.examen1;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView texto;
    private RadioGroup rg1,rg2;
    private CheckBox chk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        texto = (TextView) findViewById(R.id.txt_Main);
        rg1 = (RadioGroup) findViewById(R.id.radioG1);
        chk= (CheckBox) findViewById(R.id.chk1);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (chk.isChecked()){
                    texto.setVisibility(TextView.VISIBLE);
                }else{texto.setVisibility(TextView.INVISIBLE);}
            }
        });

        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = rg1.indexOfChild(findViewById(rg1.getCheckedRadioButtonId()));
                if (index == 0) {
                    texto.setBackgroundColor(Color.BLACK);
                    Toast.makeText(MainActivity.this, "Se ha cambiado a fondo negro", Toast.LENGTH_SHORT);
                } else if (index == 1) {
                    texto.setBackgroundColor(Color.GREEN);
                    Toast.makeText(MainActivity.this, "Se ha cambiado a fondo negro", Toast.LENGTH_SHORT);
                } else if (index == 2) {
                    texto.setBackgroundColor(Color.RED);
                    Toast.makeText(MainActivity.this, "Se ha cambiado a fondo negro", Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(MainActivity.this, "No has escogido ninguno", Toast.LENGTH_SHORT);
                }

            }
        });

        rg2 = (RadioGroup) findViewById(R.id.radioG2);
        rg2.check(0);
        rg2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int index = rg2.indexOfChild(findViewById(rg2.getCheckedRadioButtonId()));
                if (index == 0) {
                    texto.setTextColor(Color.WHITE);
                    Toast.makeText(MainActivity.this, "Se ha cambiado a texto de color negro", Toast.LENGTH_SHORT);
                } else if (index == 1) {
                    texto.setTextColor(Color.YELLOW);
                    Toast.makeText(MainActivity.this, "Se ha cambiado a texto de color negro", Toast.LENGTH_SHORT);
                } else if (index == 2) {
                    texto.setTextColor(Color.BLUE);
                    Toast.makeText(MainActivity.this, "Se ha cambiado a texto de color negro", Toast.LENGTH_SHORT);
                } else {
                    Toast.makeText(MainActivity.this, "No has escogido ninguno", Toast.LENGTH_SHORT);
                }

            }
        });

    }

}

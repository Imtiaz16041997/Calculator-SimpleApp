package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import java.text.DecimalFormat;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnDot,btnPlus,btnMinus,btnDivide,btnMulti,btnAC,btnDel,btnEquals,btnModule;
    TextView inputtext,outputtext;

    private String data;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Button
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        btn7 = findViewById(R.id.btn7);
        btn8 = findViewById(R.id.btn8);
        btn9 = findViewById(R.id.btn9);
        btn0 = findViewById(R.id.btn0);

        //Button Calculation

        btnPlus = findViewById(R.id.btnPlus);
        btnMinus = findViewById(R.id.btnMinus);
        btnDivide = findViewById(R.id.btnDivide);
        btnMulti = findViewById(R.id.btnMulti);

        // Button Operation

        btnDot = findViewById(R.id.btnDot);
        btnAC = findViewById(R.id.btnAC);
        btnDel = findViewById(R.id.btnDel);
        btnEquals = findViewById(R.id.btnEquals);
        btnModule = findViewById(R.id.btnModule);


        //Answer and Question Screen TextView

        inputtext = findViewById(R.id.inputtext);
        outputtext = findViewById(R.id.outputtext);


        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
               data = inputtext.getText().toString();
               inputtext.setText(data +"0");

            }
        });

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                data = inputtext.getText().toString();
                inputtext.setText(data +"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                data = inputtext.getText().toString();
                inputtext.setText(data +"2");
            }
        });


        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                data = inputtext.getText().toString();
                inputtext.setText(data +"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                data = inputtext.getText().toString();
                inputtext.setText(data +"4");
            }
        });


        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                data = inputtext.getText().toString();
                inputtext.setText(data +"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                data = inputtext.getText().toString();
                inputtext.setText(data +"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                data = inputtext.getText().toString();
                inputtext.setText(data +"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                data = inputtext.getText().toString();
                inputtext.setText(data +"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                data = inputtext.getText().toString();
                inputtext.setText(data +"9");
            }
        });

        btnDot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                data = inputtext.getText().toString();
                inputtext.setText(data +".");
            }
        });


        btnAC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                inputtext.setText("");
                outputtext.setText("");

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                inputtext.setText("");
                outputtext.setText("");

            }
        });


        btnPlus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                data = inputtext.getText().toString();
                inputtext.setText(data +"+");

            }
        });


        btnMinus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                data = inputtext.getText().toString();
                inputtext.setText(data +"-");

            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                data = inputtext.getText().toString();
                inputtext.setText(data +"x");

            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                data = inputtext.getText().toString();
                inputtext.setText(data +"÷");

            }
        });


        btnModule.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                data = inputtext.getText().toString();
                inputtext.setText(data + "%");

            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                data = inputtext.getText().toString();
//                Toast.makeText(MainActivity.this,""+data,Toast.LENGTH_LONG).show();
//                Log.d("@","onClick: "+data);

                data=data.replaceFirst("x","*");
                data=data.replaceFirst("%","/100");
                data=data.replaceFirst("÷","/");

//                Context rhino = Context.enter();
//                //when you set the optimization level to -1,
//                // then you switch Rhino into interpreted mode,
//                // which means that it goes down a different path for
//                // executing the code than it does in compiled mode.
//                rhino.setOptimizationLevel(-1);
//
//                String finalResult = "";
//
//                Scriptable scriptable = rhino.initStandardObjects();
//                finalResult=rhino.evaluateString(scriptable,data,"Javascript",1,null).toString();
//
//                outputtext.setText(finalResult);

                Double result = null;

                ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

                try {
                    result = (double)engine.eval(data);

                }
                catch (ScriptException e){

                Toast.makeText(getApplicationContext(),"invalid input",Toast.LENGTH_SHORT).show();

                }

                if(result != null)
                    outputtext.setText(String.valueOf(result.doubleValue()));





            }
        });







    }






}
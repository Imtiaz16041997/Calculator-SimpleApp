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
import java.util.ArrayList;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btnDot,
            btnPlus,btnMinus,btnDivide,btnMulti,
            btnAC,btnDel,btnEquals,btnModule,btnPower,btnbracket,btnPi;
    TextView inputtext,outputtext;

    private String workings = null;
    boolean leftBracket = true;
    String formula = "";
    String tempFormula = "";
    String pi = "3.14159265";

    boolean dot = true;



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
        btnPower = findViewById(R.id.btnPower);
        btnbracket = findViewById(R.id.btnbracket);
        btnPi = findViewById(R.id.btnPi);


        //Answer and Question Screen TextView

        inputtext = findViewById(R.id.inputtext);
        outputtext = findViewById(R.id.outputtext);


        btn0.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();
               inputtext.setText(workings  +"0");

            }
        });

        btn1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();
                inputtext.setText(workings  +"1");
            }
        });

        btn2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();
                inputtext.setText(workings  +"2");
            }
        });


        btn3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();
                inputtext.setText(workings  +"3");
            }
        });

        btn4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();
                inputtext.setText(workings  +"4");
            }
        });


        btn5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();
                inputtext.setText(workings  +"5");
            }
        });

        btn6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();
                inputtext.setText(workings  +"6");
            }
        });

        btn7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();
                inputtext.setText(workings  +"7");
            }
        });

        btn8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();
                inputtext.setText(workings  +"8");
            }
        });

        btn9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();
                inputtext.setText(workings  +"9");
            }
        });


        btnAC.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                inputtext.setText("");
                outputtext.setText("");
                leftBracket = true;
                workings="";
                btnDel.setClickable(true);
                dot=true;

            }
        });

        btnDel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();

                if(!workings.equals("")){
                    workings = workings.substring(0,workings.length()-1);
                    inputtext.setText(workings);
                    dot=true;
                }

            }

        });


        btnPlus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();
                inputtext.setText(workings  +"+");
                dot=true;


            }
        });


        btnMinus.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();
                inputtext.setText(workings  +"-");
                dot=true;
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();
                inputtext.setText(workings  +"x");
                dot=true;
            }
        });

        btnDivide.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();
                inputtext.setText(workings  +"÷");
                dot=true;
            }
        });


        btnModule.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                workings  = inputtext.getText().toString();
                inputtext.setText(workings  + "%");
                dot=true;
            }
        });

        btnEquals.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                workings  = inputtext.getText().toString();
//                Toast.makeText(MainActivity.this,""+data,Toast.LENGTH_LONG).show();
//                Log.d("@","onClick: "+data);

                workings =workings .replaceFirst("x","*");
                workings =workings .replaceFirst("%","/100");
                workings =workings .replaceFirst("÷","/");


                Double result = null;

                ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
                checkForPowerOf();

                try {
                    result = (double)engine.eval(formula);


                }
                catch (ScriptException e){

                Toast.makeText(getApplicationContext(),"invalid input",Toast.LENGTH_SHORT).show();

                }

                if(result != null)
                    outputtext.setText(String.valueOf(result.doubleValue()));


            }
        });


        btnbracket.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

               if(leftBracket){
                   workings  = inputtext.getText().toString();
                   inputtext.setText(workings  + "(");
                   leftBracket = false;
               }else
               {
                   workings  = inputtext.getText().toString();
                   inputtext.setText(workings  + ")");
                   leftBracket = true;
               }



            }
        });

        btnPower.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                workings  = inputtext.getText().toString();
                inputtext.setText(workings  + "^");


            }
        });


        btnPi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                workings  = inputtext.getText().toString();
                inputtext.setText(workings  + "π");




            }
        });


        btnDot.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                    workings  = inputtext.getText().toString();
//                    inputtext.setText(workings + ".");

                if(dot)
                {

                    if(workings == null){
                        workings = "0.";

                    }

                    else
                    {
                        workings = workings + ".";
                    }



                }

                inputtext.setText(workings);
                dot = false;


            }
        });






    }


    private void checkForPowerOf()
    {
        ArrayList<Integer> indexOfPowers = new ArrayList<>();
        for(int i=0; i<workings.length(); i++)
        {
            if(workings.charAt(i) == '^')
                indexOfPowers.add(i);
        }
        
        formula =workings;
        tempFormula = workings;
        
        for(Integer index: indexOfPowers)
        {
            changeFormula(index);
        }

        formula = tempFormula;
        

    }

    private void changeFormula(Integer index)
    {
        String numberLeft = "";
        String numberRight = "";

        for(int i = index + 1; i< workings.length(); i++)
        {
            if(isNumeric(workings.charAt(i)))
                numberRight = numberRight + workings.charAt(i);
            else
                break;
        }

        for(int i = index - 1; i >= 0; i--)
        {
            if(isNumeric(workings.charAt(i)))
                numberLeft = numberLeft + workings.charAt(i);
            else
                break;
        }

        String original = numberLeft + "^" + numberRight;
        String changed = "Math.pow("+numberLeft+","+numberRight+")";
        tempFormula = tempFormula.replace(original,changed);

    }

    private boolean isNumeric(char c)

    {
        if((c <= '9' && c >= '0') || c == '.'){

            return true;
        }

        return false;


    }

}
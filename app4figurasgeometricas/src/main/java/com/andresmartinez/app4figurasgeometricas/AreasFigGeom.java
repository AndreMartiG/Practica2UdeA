package com.andresmartinez.app4figurasgeometricas;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class AreasFigGeom extends Activity {

    int operac = 1;
    double number1, number2, number3, res = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_areas_fig_geom);

        final EditText num1=(EditText) findViewById(R.id.eNum1);
        final EditText num2=(EditText) findViewById(R.id.eNum2);
        final EditText num3=(EditText) findViewById(R.id.eNum3);

        final TextView result=(TextView) findViewById(R.id.tResult);

        Button boton =(Button) findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int temp = 0;

                if (num1.getText().toString().trim().length() != 0) {        //Tamaño del String
                    number1 = Double.parseDouble(num1.getText().toString());

                    if (operac == 1 || operac == 4) number2 = 0;
                    else if (num2.getText().toString().trim().length() != 0)        //Tamaño del String
                        number2 = Double.parseDouble(num2.getText().toString());
                    else {
                        temp = operac;
                        operac = 0;
                    }

                    if (operac == 2){
                        if (num3.getText().toString().trim().length() != 0)
                            number3 = Double.parseDouble(num3.getText().toString());
                        else {
                            temp = operac;
                            operac = 0;
                        }
                    }

                    switch (operac) {
                        case 1:
                            res = Math.pow(number1, 2);         //area de un cuadrado
                            result.setText(Double.toString(res));
                            break;
                        case 2:
                            //Uso de la formula de Herón: Area a partir de sus lados
                            double semip;           //semiperimetro del triangulo
                            semip = (number1 + number2 + number3) / 2;
                            res = Math.sqrt(semip*(semip-number1)*(semip-number2)*(semip-number3));     //area del triangulo
                            result.setText(Double.toString(res));
                            break;
                        case 3:
                            res = number1 * number2;            //area de un rectangulo
                            result.setText(Double.toString(res));
                            break;
                        case 4:
                            res = 2 * Math.PI * number1;        //area de un circulo
                            result.setText(Double.toString(res));
                            break;
                        default:
                            result.setText("No Valido");
                            operac = temp;
                    }
                }
                else result.setText("No Valido");
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        final EditText num2=(EditText) findViewById(R.id.eNum2);
        final EditText num3=(EditText) findViewById(R.id.eNum3);
        final TextView texto1=(TextView) findViewById(R.id.text1);
        final TextView texto2=(TextView) findViewById(R.id.text2);
        final TextView texto3=(TextView) findViewById(R.id.text3);

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioCuad:
                if (checked){
                    texto1.setText(R.string.ladoCuad);
                    texto2.setVisibility(View.INVISIBLE);
                    num2.setVisibility(View.INVISIBLE);
                    texto3.setVisibility(View.INVISIBLE);
                    num3.setVisibility(View.INVISIBLE);
                    operac = 1;}
                break;
            case R.id.radioTriang:
                if (checked){
                    texto1.setText(R.string.lado1triang);
                    texto2.setVisibility(View.VISIBLE);
                    texto2.setText(R.string.lado2triang);
                    num2.setVisibility(View.VISIBLE);
                    texto3.setVisibility(View.VISIBLE);
                    texto3.setText(R.string.lado3triang);
                    num3.setVisibility(View.VISIBLE);
                    operac = 2;}
                break;
            case R.id.radioRect:
                if (checked){
                    texto1.setText(R.string.lado1rect);
                    texto2.setVisibility(View.VISIBLE);
                    texto2.setText(R.string.lado2rect);
                    num2.setVisibility(View.VISIBLE);
                    texto3.setVisibility(View.INVISIBLE);
                    num3.setVisibility(View.INVISIBLE);
                    operac = 3;}
                break;
            case R.id.radioCirc:
                if (checked){
                    texto1.setText(R.string.radiocirc);
                    texto2.setVisibility(View.INVISIBLE);
                    num2.setVisibility(View.INVISIBLE);
                    texto3.setVisibility(View.INVISIBLE);
                    num3.setVisibility(View.INVISIBLE);
                    operac = 4;}
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_areas_fig_geom, menu);
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
}

package com.andresmartinez.app2calculadora;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class Calculadora extends Activity {

    int operac = 1;
    double number1, number2, res = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        final EditText num1=(EditText) findViewById(R.id.eNum1);
        final EditText num2=(EditText) findViewById(R.id.eNum2);

        final TextView result=(TextView) findViewById(R.id.tResult);

        Button boton =(Button) findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int check1 = num1.getText().toString().trim().length();
                int check2 = num2.getText().toString().trim().length();

                if (check1 != 0 && check2 != 0) {
                    number1 = Double.parseDouble(num1.getText().toString());
                    number2 = Double.parseDouble(num2.getText().toString());

                    switch (operac) {
                        case 1:
                            res = number1 + number2;
                            break;
                        case 2:
                            res = number1 - number2;
                            break;
                        case 3:
                            res = number1 * number2;
                            break;
                        case 4:
                            res = number1 / number2;
                            break;
                    }

                    result.setText(Double.toString(res));
                }
                else result.setText("No Valido");
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioSuma:
                if (checked)
                    operac = 1;
                    break;
            case R.id.radioResta:
                if (checked)
                    operac = 2;
                    break;
            case R.id.radioMult:
                if (checked)
                    operac = 3;
                    break;
            case R.id.radioDiv:
                if (checked)
                    operac = 4;
                    break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_calculadora, menu);
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

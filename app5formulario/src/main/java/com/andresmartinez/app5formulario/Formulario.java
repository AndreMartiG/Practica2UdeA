package com.andresmartinez.app5formulario;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;


public class Formulario extends Activity {

    boolean operac = true, hob1 = false, hob2 = false, hob3 = false, hob4 = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario);

        final EditText nombre=(EditText) findViewById(R.id.eNombre);
        final EditText correo=(EditText) findViewById(R.id.eCorreo);
        final EditText telefono= (EditText) findViewById(R.id.eTel);
        final RadioButton fem= (RadioButton) findViewById(R.id.radioFem);
        final RadioButton masc= (RadioButton) findViewById(R.id.radioMasc);
        final Spinner ciudad= (Spinner) findViewById(R.id.eCity);
        final CheckBox pasaTiempo1= (CheckBox) findViewById(R.id.eFutbol);
        final CheckBox pasaTiempo2= (CheckBox) findViewById(R.id.eBalonc);
        final CheckBox pasaTiempo3= (CheckBox) findViewById(R.id.eKarat);
        final CheckBox pasaTiempo4= (CheckBox) findViewById(R.id.eCorrer);
        final DatePicker date= (DatePicker) findViewById(R.id.eFecha);

        final TextView name=(TextView) findViewById(R.id.tNombre);
        final TextView email=(TextView) findViewById(R.id.tCorreo);
        final TextView tel=(TextView) findViewById(R.id.tTel);
        final TextView gener= (TextView) findViewById(R.id.tGenero);
        final TextView city= (TextView) findViewById(R.id.tCity);
        final TextView hobby1= (TextView) findViewById(R.id.tHobby);
        final TextView hobby2= (TextView) findViewById(R.id.tHobby2);
        final TextView hobby3= (TextView) findViewById(R.id.tHobby3);
        final TextView hobby4= (TextView) findViewById(R.id.tHobby4);
        final TextView day= (TextView) findViewById(R.id.tDia);
        final TextView month= (TextView) findViewById(R.id.tMes);
        final TextView year= (TextView) findViewById(R.id.tYear);

        Button boton =(Button) findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText(nombre.getText()); //mostrar nombre
                email.setText(correo.getText());    //mostrar correo
                tel.setText(telefono.getText());    //mostrar telefono

                if(operac) gener.setText(fem.getText());    //mostrar genero
                else gener.setText(masc.getText());

                city.setText(String.valueOf(ciudad.getSelectedItem())); //mostar ciudad

                if(hob1) hobby1.setText(pasaTiempo1.getText());     //mostrar hobbies
                else hobby1.setText(" ");
                if(hob2) hobby2.setText(pasaTiempo2.getText());
                else hobby2.setText(" ");
                if(hob3) hobby3.setText(pasaTiempo3.getText());
                else hobby3.setText(" ");
                if(hob4) hobby4.setText(pasaTiempo4.getText());
                else hobby4.setText(" ");

                day.setText(String.valueOf(date.getDayOfMonth())); //mostar fecha
                month.setText(String.valueOf(date.getMonth()+1));
                year.setText(String.valueOf(date.getYear()));
            }
        });


    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.radioFem:
                if (checked)
                    operac = true;
                break;
            case R.id.radioMasc:
                if (checked)
                    operac = false;
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();

        // Check which checkbox was clicked
        switch(view.getId()) {
            case R.id.eFutbol:
                if (checked) hob1 = true;
                else hob1 = false;
                break;
            case R.id.eBalonc:
                if (checked) hob2 = true;
                else hob2 = false;
                break;
            case R.id.eKarat:
                if (checked) hob3 = true;
                else hob3 = false;
                break;
            case R.id.eCorrer:
                if (checked) hob4 = true;
                else hob4 = false;
                break;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_formulario, menu);
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

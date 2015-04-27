package com.andresmartinez.app3notafinal;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class NotaFinal extends Activity {

    double quiz, exposic, pract, proyec, nota = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nota_final);

        final double pQuiz = 0.15, pExp = 0.1, pPract = 0.4, pProy = 0.35;

        final EditText gQuiz=(EditText) findViewById(R.id.eQuices);
        final EditText gExp=(EditText) findViewById(R.id.eExposic);
        final EditText gPrac= (EditText) findViewById(R.id.ePract);
        final EditText gProy= (EditText) findViewById(R.id.eProy);

        final TextView result=(TextView) findViewById(R.id.tResult);
        Button boton =(Button) findViewById(R.id.button);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                quiz = Double.parseDouble(gQuiz.getText().toString());
                exposic = Double.parseDouble(gExp.getText().toString());
                pract = Double.parseDouble(gPrac.getText().toString());
                proyec = Double.parseDouble(gProy.getText().toString());

                nota = quiz*pQuiz + exposic*pExp + pract*pPract + proyec*pProy;

                result.setText(Double.toString(nota));
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_nota_final, menu);
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

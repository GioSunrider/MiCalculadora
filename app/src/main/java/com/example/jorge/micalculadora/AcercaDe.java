package com.example.jorge.micalculadora;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AcercaDe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        Button botonVolver = (Button) findViewById(R.id.button);

        botonVolver.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent activity1 = new Intent ();
                setResult(Calculadora.RESULT_OK, activity1);
                finish();
            }
        });

    }
}

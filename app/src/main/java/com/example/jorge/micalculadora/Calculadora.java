package com.example.jorge.micalculadora;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Calculadora extends AppCompatActivity {

    final Context context = this;//para la alerta

    private TextView cuentas, operacion;

    private String cuenta, ultimochar, s9, s8, s7, s6, s5, s4, s3,
            s2, s1, s0, ssum, sres ,smult, sdiv, spun, spi, sxy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);

        Button boton_autor = (Button) findViewById(R.id.Acerca_De);

        /**
         * Para algunos tamaños de pantalla no dejaria visible el texteview en
         * pantalla horizontal por eso bloqueamos el vertical
         * */
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //initialization of strings and textView
        cuenta = "";
        cuentas = findViewById(R.id.cuentas);
        cuentas.setText(cuenta);
        operacion = findViewById(R.id.operacion);
        operacion.setText("");

        //initialization of strigs from strings.xml to use them in MainActivity
        s9 = getString(R.string.num_9); s8 = getString(R.string.num_8); s7 = getString(R.string.num_7);
        s6 = getString(R.string.num_6); s5 = getString(R.string.num_5); s4 = getString(R.string.num_4);
        s3 = getString(R.string.num_3); s2 = getString(R.string.num_2); s1 = getString(R.string.num_1);
        s0 = getString(R.string.num_0); ssum = getString(R.string.sum); sres = getString(R.string.res);
        smult = getString(R.string.mult); sdiv = getString(R.string.div); spun = getString(R.string.punto);
        spi = getString(R.string.pi); sxy = getString(R.string.xy);

        //initialization of buttons
        Button suma = findViewById(R.id.suma);
        Button resta = findViewById(R.id.resta);
        Button scientific = findViewById(R.id.scientific);
        Button multiplicacion = findViewById(R.id.multiplicacion);
        Button division = findViewById(R.id.division);
        Button c = findViewById(R.id.c);
        Button ce = findViewById(R.id.ce);
        Button n0 = findViewById(R.id.n_0);
        Button n9 = findViewById(R.id.n_9);
        Button n8 = findViewById(R.id.n_8);
        Button n7 = findViewById(R.id.n_7);
        Button n6 = findViewById(R.id.n_6);
        Button n5 = findViewById(R.id.n_5);
        Button n4 = findViewById(R.id.n_4);
        Button n3 = findViewById(R.id.n_3);
        Button n2 = findViewById(R.id.n_2);
        Button n1 = findViewById(R.id.n_1);
        Button igual = findViewById(R.id.igual);
        Button punto = findViewById(R.id.punto);

        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simbolo_intr(ssum);
            }
        });
        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simbolo_intr(sres);
            }
        });
        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simbolo_intr(smult);
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                simbolo_intr(sdiv);
            }
        });
        punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean punto;
                punto = comprobar_punto();
                if(!punto) {
                    simbolo_intr(spun);
                }
            }
        });
        n0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anadirtexto(s0);
            }
        });
        n1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anadirtexto(s1);
            }
        });
        n2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anadirtexto(s2);
            }
        });
        n3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anadirtexto(s3);
            }
        });
        n4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anadirtexto(s4);
            }
        });
        n5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anadirtexto(s5);
            }
        });
        n6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anadirtexto(s6);
            }
        });
        n7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anadirtexto(s7);
            }
        });
        n8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anadirtexto(s8);
            }
        });
        n9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                anadirtexto(s9);
            }
        });
        ce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminarultimochar();
            }
        });
        c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminartodo();
                operacion.setText("");
            }
        });
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cuenta.equals("")) {
                    ultimochar = "" + cuenta.charAt(cuenta.length() - 1);
                    if ((ultimochar.equals(spun)) || (ultimochar.equals(ssum)) || (ultimochar.equals(sres)) || (ultimochar.equals(smult)) || (ultimochar.equals(sdiv))) {
                    } else {
                        calcular();
                    }
                }
            }
        });
        scientific.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity1 = new Intent(Calculadora.this,CalculadoraCient.class);
                activity1.putExtra("cuenta2", cuenta);
                startActivityForResult(activity1, 0);
            }
        });
        boton_autor.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent activity1 = new Intent(Calculadora.this,AcercaDe.class);
                startActivity(activity1);

            }
        });
    }
    @Override
    public void onActivityResult (int requestCode, int resultCode, Intent resu) {
        if(resu!=null) {
            cuenta=resu.getStringExtra("cuenta");
            cuentas.setText(cuenta);
            operacion.setText("");
        }
    }

    void eliminarultimochar () {
        if(!cuenta.equals("")) {
            cuenta = cuenta.substring(0, cuenta.length() - 1);
            cuentas.setText(cuenta);
        }
    }
    void eliminartodo () {
        cuenta = "";
        cuentas.setText(cuenta);
    }
    void anadirtexto (String texto) {
        cuenta=cuenta+texto;
        cuentas.setText(cuenta);
    }
    void simbolo_intr (String simbolo){
        if(cuenta.equals("")){
            if(simbolo.equals(sres)){
                anadirtexto(simbolo);
            }
        }
        else {
            ultimochar = "" + cuenta.charAt(cuenta.length()-1);
            if(cuenta.length()==1 && ultimochar.equals(sres)) {
            }
            else {
                if ((ultimochar.equals(spun)) || (ultimochar.equals(ssum)) || (ultimochar.equals(sres)) || (ultimochar.equals(smult)) || (ultimochar.equals(sdiv))) {
                    eliminarultimochar();
                }
                anadirtexto(simbolo);
            }
        }
    }
    int get_numero_operandos () {
        if(cuenta.equals("")){
            return 0;
        }

        int x, tamano, numoperandos=1;
        String term;

        tamano=cuenta.length();
        for (x=0; x<tamano; x++) {
            term = ""+cuenta.charAt(x);
            if(x>0&&(term.equals(ssum)||term.equals(sres)||term.equals(smult)||term.equals(sdiv)||term.equals(sxy))) {
                numoperandos++;
            }
        }
        return numoperandos;
    }
    boolean comprobar_punto () {
        int numoperandos;
        boolean punto = false;

        numoperandos  = get_numero_operandos();

        if(numoperandos==0) {
            cuenta="0";
            punto = false;
        }
        else {
            ultimochar = "" + cuenta.charAt(cuenta.length()-1);
            if(ultimochar.equals(ssum) || ultimochar.equals(sres) || ultimochar.equals(smult) || ultimochar.equals(sdiv) || ultimochar.equals(sxy)){
                punto = true;
            }
            else {
                int tamano, x;
                String term;

                tamano = cuenta.length();
                for (x = (tamano - 1); x >= 0; x--) {
                    term = "" + cuenta.charAt(x);
                    if (term.equals(spun)) {
                        punto = true;
                        break;
                    }
                    if (term.equals(ssum) || term.equals(sres) || term.equals(smult) || term.equals(sdiv) || term.equals(sxy)) {
                        punto = false;
                        break;
                    }
                }
            }
        }
        return punto;
    }
    void get_oper (String[] operaciones, double[] operandos){
        String term, operando="";
        int tamano, x, y=0;
        boolean negativo=false;

        tamano=cuenta.length();
        for (x = 0; x < tamano; x++) {
            term = "" + cuenta.charAt(x);
            if(x==0&&term.equals(sres)){
                negativo = true;
            }
            else {
                if (x > 0 && (term.equals(ssum) || term.equals(sres) || term.equals(smult) || term.equals(sdiv)||term.equals(sxy))) {
                    if (operando.equals(spi)) {
                        operandos[y] = Math.PI;
                    }
                    else {
                        operandos[y] = Double.parseDouble(operando);
                        operaciones[y] = term;
                        operando = "";
                    }
                    if (negativo) {
                        operandos[y] = operandos[y] * -1;
                        negativo=false;
                    }
                    y++;
                }
                else {
                    operando = operando + term;
                }
            }
        }
        if (operando.equals(spi)) {
            operandos[y] = Math.PI;
        }
        else {
            operandos[y]=Double.parseDouble(operando);
        }
    }
    @SuppressLint("SetTextI18n")
    void calcular () {
        int numoperandos;
        numoperandos = get_numero_operandos();

        if (numoperandos > 1) {
            String[] operaciones = new String[numoperandos-1];
            double resultado;
            double[] operandos = new double[numoperandos];

            get_oper(operaciones, operandos);

            int x;
            resultado = operandos[0];
            for (x=0; x<(numoperandos-1); x++) {
                if (operaciones[x].equals(ssum))
                {resultado = resultado+operandos[x+1];}
                if ((operaciones[x].equals(sres)))
                {resultado = resultado-operandos[x+1];}
                if(operaciones[x].equals(smult))
                {resultado = resultado*operandos[x+1];}
                if(operaciones[x].equals(sdiv)) {
                    if (operandos[x + 1] == 0) {
                        cuentas.setText("Error");
                        cuenta = "";
                        break;
                    } else {
                        resultado = resultado / operandos[x + 1];
                    }
                }
                if(operaciones[x].equals(sxy)){
                    resultado = Math.pow(resultado, operandos[x+1]);
                }
            }
            if(!cuenta.equals("")) {
                operacion.setText(cuenta+"=");
                cuenta = "";
                resultado = (double)Math.round(resultado * 1000d) / 1000d;
                cuenta = Double.toString(resultado);
                cuentas.setText(cuenta);
            }
        }
    }
}


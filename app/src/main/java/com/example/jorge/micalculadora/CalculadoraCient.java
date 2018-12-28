package com.example.jorge.micalculadora;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class CalculadoraCient extends AppCompatActivity {
    private TextView cuentas2, operacion2;
    private CheckBox rad, deg;

    private String cuenta2, ultimochar, s9, s8, s7, s6, s5, s4, s3,
            s2, s1, s0, spun, ssum, sres, smult, sdiv, spi, ssin, scos, stan, sxy, slog, ssqrt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora_cient);


        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //initialization of strigs from strings.xml to use them in MainActivity
        s9 = getString(R.string.num_9); s8 = getString(R.string.num_8); s7 = getString(R.string.num_7);
        s6 = getString(R.string.num_6); s5 = getString(R.string.num_5); s4 = getString(R.string.num_4);
        s3 = getString(R.string.num_3); s2 = getString(R.string.num_2); s1 = getString(R.string.num_1);
        s0 = getString(R.string.num_0); spun = getString(R.string.punto); ssum = getString(R.string.sum);
        sres = getString(R.string.res); sdiv = getString(R.string.div); smult = getString(R.string.mult);
        spi = getString(R.string.pi); ssin = getString(R.string.sin); scos = getString(R.string.cos);
        stan = getString(R.string.tan); slog = getString(R.string.log); ssqrt = getString(R.string.sqrt);
        sxy = getString(R.string.xy);

        //initialization of buttons
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
        Button pi = findViewById(R.id.pi);
        Button resta = findViewById(R.id.res);
        Button standard = (Button) findViewById(R.id.standard);
        Button sin = findViewById(R.id.sin);
        Button cos = findViewById(R.id.cos);
        Button tan = findViewById(R.id.tan);
        Button log = findViewById(R.id.log);
        Button sqrt = findViewById(R.id.sqrt);
        Button xy = findViewById(R.id.xy);

        cuentas2 = (TextView) findViewById(R.id.cuentas); operacion2 = (TextView) findViewById(R.id.operacion);

        rad = (CheckBox) findViewById(R.id.rad); deg = (CheckBox) findViewById(R.id.deg);

        Intent intento = this.getIntent();
        cuenta2 = intento.getStringExtra("cuenta2");
        cuentas2.setText(cuenta2);

        rad.setChecked(true); deg.setChecked(false);

        punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean punto;
                punto = comprobar_punto();
                if(!punto) {
                    anadirtexto(spun);
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
        pi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cuenta2.equals("")) {
                    anadirtexto(spi);
                }
                else {
                    ultimochar = "" + cuenta2.charAt(cuenta2.length() - 1);
                    if ((ultimochar.equals(spun)) || (ultimochar.equals(ssum)) || (ultimochar.equals(sres)) || (ultimochar.equals(smult)) || (ultimochar.equals(sdiv))) {
                        if(ultimochar.equals(spun)){
                            eliminarultimochar();
                            anadirtexto(smult+spi);
                        }
                        else{
                            anadirtexto(spi);
                        }
                    }
                    else {
                        anadirtexto(smult+spi);
                    }
                }
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
                operacion2.setText("");
            }
        });
        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cuenta2.equals("")){
                    anadirtexto(sres);
                }
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion(ssin);
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion(scos);
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion(stan);
            }
        });
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion(slog);
            }
        });
        sqrt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion(ssqrt);
            }
        });
        xy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cuenta2.equals("")){
                    cuenta2="0";
                    anadirtexto(sxy);
                }
                else {
                    ultimochar = "" + cuenta2.charAt(cuenta2.length() - 1);
                    if (cuenta2.length() == 1 && ultimochar.equals(sres)) {
                    } else {
                        if ((ultimochar.equals(spun)) || (ultimochar.equals(ssum)) || (ultimochar.equals(sres)) || (ultimochar.equals(smult)) || (ultimochar.equals(sdiv))) {
                            eliminarultimochar();
                        }
                        anadirtexto(sxy);
                    }
                }
            }
        });
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cuenta2.equals("")) {
                    ultimochar = "" + cuenta2.charAt(cuenta2.length() - 1);
                    if ((ultimochar.equals(spun)) || (ultimochar.equals(sxy)) || (ultimochar.equals(ssum)) || (ultimochar.equals(sres)) || (ultimochar.equals(smult)) || (ultimochar.equals(sdiv))) {
                        eliminarultimochar();
                    }
                    calcular();
                }
            }
        });
        standard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent activity1 = new Intent ();
                String cuenta = cuenta2;
                activity1.putExtra("cuenta", cuenta);
                setResult(Calculadora.RESULT_OK, activity1);
                finish();
            }
        });
        rad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deg.setChecked(false);
                if(!rad.isChecked() && !deg.isChecked()){
                    deg.setChecked(true);
                }
            }
        });
        deg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rad.setChecked(false);
                if(!rad.isChecked() && !deg.isChecked()){
                    rad.setChecked(true);
                }
            }
        });
    }
    void eliminarultimochar () {
        if(!cuenta2.equals("")) {
            cuenta2 = cuenta2.substring(0, cuenta2.length() - 1);
            cuentas2.setText(cuenta2);
        }
    }
    void eliminartodo () {
        cuenta2 = "";
        cuentas2.setText(cuenta2);
    }
    void anadirtexto (String texto) {
        cuenta2 = cuenta2 + texto;
        cuentas2.setText(cuenta2);
    }
    int get_numero_operandos () {
        if(cuenta2.equals("")){
            return 0;
        }

        int x, tamano, numoperandos=1;
        String term;

        tamano=cuenta2.length();
        for (x=0; x<tamano; x++) {
            term = ""+cuenta2.charAt(x);
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
            cuenta2="0";
            punto = false;
        }
        else {
            ultimochar = "" + cuenta2.charAt(cuenta2.length()-1);
            if(ultimochar.equals(ssum) || ultimochar.equals(sres) || ultimochar.equals(smult) || ultimochar.equals(sdiv) || ultimochar.equals(sxy)){
                punto = true;
            }
            else {
                int tamano, x;
                String term;

                tamano = cuenta2.length();
                for (x = (tamano - 1); x >= 0; x--) {
                    term = "" + cuenta2.charAt(x);
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

        tamano=cuenta2.length();
        for (x = 0; x < tamano; x++) {
            term = "" + cuenta2.charAt(x);
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
        int numoperandos = get_numero_operandos();

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
                        cuentas2.setText("Error");
                        cuenta2 = "";
                        break;
                    } else {
                        resultado = resultado / operandos[x + 1];
                    }
                }
                if(operaciones[x].equals(sxy)){
                    resultado = Math.pow(resultado, operandos[x+1]);
                }
            }
            if(!cuenta2.equals("")) {
                operacion2.setText(cuenta2+"=");
                cuenta2 = "";
                resultado = (double)Math.round(resultado * 1000d) / 1000d;
                cuenta2 = Double.toString(resultado);
                cuentas2.setText(cuenta2);
            }
        }
    }
    @SuppressLint("SetTextI18n")
    void operacion (String funcion) {
        if (cuenta2.equals("")||cuenta2.equals("-")) {
            cuenta2 = "0";
        } else {
            ultimochar = "" + cuenta2.charAt(cuenta2.length() - 1);
            if ((ultimochar.equals(spun)) || (ultimochar.equals(ssum)) || (ultimochar.equals(sres)) || (ultimochar.equals(smult)) || (ultimochar.equals(sdiv))) {
                eliminarultimochar();
            }
        }
        double resultado;
        if (cuenta2.equals("")) {
            cuenta2 = "0";
        } else {
            if (get_numero_operandos() > 1) {
                calcular();
            }
            if (cuenta2.equals(spi)) {
                resultado = Math.PI;
            } else {
                resultado = Double.parseDouble(cuenta2);
            }
            operacion2.setText(funcion+"(" + cuenta2 + ")=");

            if (deg.isChecked()&&(funcion.equals(ssin)||funcion.equals(scos)||funcion.equals(stan))) {
                resultado = Math.toRadians(resultado);
            }
            if(funcion.equals(ssin)||funcion.equals(scos)||funcion.equals(stan)){
                if(funcion.equals(ssin)) {resultado = Math.sin(resultado);}
                if(funcion.equals(scos)) {resultado = Math.cos(resultado);}
                if(funcion.equals(stan)) {resultado = Math.tan(resultado);}
                resultado = (double) Math.round(resultado * 1000d) / 1000d;
                cuenta2 = Double.toString(resultado);
                cuentas2.setText(cuenta2);
            }
            if(resultado<0&&(funcion.equals(slog)||funcion.equals(ssqrt))){
                cuentas2.setText("Error");
                cuenta2 = "";
            } else {
                if(funcion.equals(slog)) {
                    if (resultado == 0) {
                        cuentas2.setText("-∞");
                        cuenta2="";
                    } else {
                        resultado = Math.log10(resultado);
                        resultado = (double) Math.round(resultado * 1000d) / 1000d;
                        cuenta2 = Double.toString(resultado);
                        cuentas2.setText(cuenta2);
                    }
                }
                if(funcion.equals(ssqrt)) {
                    resultado = Math.sqrt(resultado);
                    resultado = (double) Math.round(resultado * 1000d) / 1000d;
                    cuenta2 = Double.toString(resultado);
                    cuentas2.setText(cuenta2);
                }
            }
        }
    }
}
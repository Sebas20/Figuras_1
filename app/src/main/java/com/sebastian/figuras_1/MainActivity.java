package com.sebastian.figuras_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button bCalcular, bSalir;
    private RadioButton rCirculo, rTriangulo, rCubo, rCuadrado;
    private EditText eLado_1, eLado_2;
    private TextView tArea, tPerimetro, tVolumen;
    private int flag = 0;
    private String Error = " Falta Ingresar Datos", NA = " NA";
    private double lado_1, lado_2, altura,base, radio, area, perimetro, volumen, pi = 3.141592653589793,hipo=0;
    private String L_1 = "", L_2 = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bCalcular = (Button) findViewById(R.id.bCalcular);
        bSalir = (Button) findViewById(R.id.bsalir);
        rCirculo = (RadioButton) findViewById(R.id.rCirculo);
        rTriangulo = (RadioButton) findViewById(R.id.rTriangulo);
        rCuadrado = (RadioButton) findViewById(R.id.rCuadrado);
        rCubo = (RadioButton) findViewById(R.id.rCubo);
        eLado_1 = (EditText) findViewById(R.id.eLado_1);
        eLado_2 = (EditText) findViewById(R.id.eLado_2);
        tArea = (TextView) findViewById(R.id.tArea);
        tPerimetro = (TextView) findViewById(R.id.tPerimetro);
        tVolumen = (TextView) findViewById(R.id.tVolumen);

        bSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        bCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (flag == 1) {
                    L_1 = eLado_1.getText().toString();
                        if (L_1.isEmpty()) {
                        tArea.setText(Error);
                        tPerimetro.setText(Error);
                        tVolumen.setText(NA);
                    } else {
                            radio = Double.parseDouble(L_1);
                            area = (pi*radio*radio);
                            area = Math.rint(area*1000)/1000;
                            perimetro = (2*pi*radio);
                            perimetro = Math.rint(perimetro*1000)/1000;
                            tArea.setText(Double.toString(area));
                            tPerimetro.setText(Double.toString(perimetro));
                            tVolumen.setText(NA);
                    }
                }
                if (flag == 2) {

                    L_1 = eLado_1.getText().toString();
                    L_2 = eLado_2.getText().toString();
                    if (L_1.isEmpty() || L_2.isEmpty()) {
                        tArea.setText(Error);
                        tPerimetro.setText(Error);
                        tVolumen.setText(NA);
                    } else {
                        lado_1 = Double.parseDouble(L_1);
                        lado_2 = Double.parseDouble(L_1);
                        altura = Double.parseDouble(L_2);
                        base = Double.parseDouble(L_1);
                        area = (base*altura)/2;
                        area = Math.rint(area*1000)/1000;
                        hipo = Math.sqrt(base*base+altura*altura);
                        hipo = Math.rint(hipo*1000)/1000;
                        perimetro = (base + altura + hipo);
                        perimetro = Math.rint(perimetro*1000)/1000;
                        tArea.setText(Double.toString(area));
                        tPerimetro.setText(Double.toString(perimetro));
                        tVolumen.setText(NA);
                    }
                }

                if (flag == 3) {

                    L_1 = eLado_1.getText().toString();
                    if (L_1.isEmpty()) {
                        tArea.setText(Error);
                        tPerimetro.setText(Error);
                        tVolumen.setText(NA);
                    } else {
                        lado_1 = Double.parseDouble(L_1);
                        area = (lado_1*lado_1);
                        area = Math.rint(area*1000)/1000;
                        perimetro = (4*lado_1);
                        perimetro = Math.rint(perimetro*1000)/1000;
                        tArea.setText(Double.toString(area));
                        tPerimetro.setText(Double.toString(perimetro));
                        tVolumen.setText(NA);
                    }
                }

                if (flag == 4) {

                    L_1 = eLado_1.getText().toString();
                    if (L_1.isEmpty()) {
                        tArea.setText(Error);
                        tPerimetro.setText(Error);
                        tVolumen.setText(Error);
                    } else {
                        lado_1 = Double.parseDouble(L_1);
                        area = (lado_1*lado_1*6);
                        area = Math.rint(area*1000)/1000;
                        perimetro = (4*lado_1);
                        perimetro = Math.rint(perimetro*1000)/1000;
                        volumen = (lado_1*lado_1*lado_1);
                        volumen = Math.rint(volumen*1000)/1000;
                        tArea.setText(Double.toString(area));
                        tPerimetro.setText(NA);
                        tVolumen.setText(Double.toString(volumen));
                    }
                }

            }
        });

        rCirculo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tArea.setText("");
                tPerimetro.setText("");
                tVolumen.setText("");
                eLado_1.setText("");
                eLado_2.setText("");
                eLado_1.setVisibility(View.VISIBLE);
                eLado_1.setHint("Radio");
                eLado_2.setVisibility(View.GONE);
                flag = 1;
            }
        });

        rTriangulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tArea.setText("");
                tPerimetro.setText("");
                tVolumen.setText("");
                eLado_1.setText("");
                eLado_2.setText("");
                eLado_1.setVisibility(View.VISIBLE);
                eLado_1.setHint("Base");
                eLado_2.setVisibility(View.VISIBLE);
                eLado_2.setHint("Altura");
                flag = 2;
            }
        });

        rCuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tArea.setText("");
                tPerimetro.setText("");
                tVolumen.setText("");
                eLado_1.setText("");
                eLado_2.setText("");
                eLado_1.setVisibility(View.VISIBLE);
                eLado_1.setHint("Lado");
                eLado_2.setVisibility(View.GONE);
                flag = 3;
            }
        });
        rCubo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tArea.setText("");
                tPerimetro.setText("");
                tVolumen.setText("");
                eLado_1.setText("");
                eLado_2.setText("");
                eLado_1.setVisibility(View.VISIBLE);
                eLado_1.setHint("Lado");
                eLado_2.setVisibility(View.GONE);
                flag = 4;
            }
        });

    }

}

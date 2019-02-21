package com.example.maanas.juegomenormayor;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.R;
import android.R.*;


import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView tv_enunciado, n_intentos;
    EditText et_numero;
    Button btn_comprobar,btn_reiniciar;
    Context contexto=this;
    Random myRandom=new Random();
    int numero_aleatorio;
    int intento=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_main);
        cargarVistas();
        numero_aleatorio=Aleatorio.obtenerAleatorio();
        jugar();
    }

    private void cargarVistas() {
        tv_enunciado=findViewById(id.tv_enunciado);
        n_intentos=findViewById(id.tv_intentos);
        et_numero=findViewById(id.et_numero);
        btn_comprobar=findViewById(id.btn_comprobar);
        btn_reiniciar=findViewById(id.btn_reiniciar);

    }

    private void jugar() {
        btn_comprobar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n_usuario=et_numero.getText().toString();
                final int numero_usuario=Integer.parseInt(n_usuario);
                if(numero_aleatorio>numero_usuario){
                    Toast notificacion=Toast.makeText(contexto, "El número es mayor que "+numero_usuario,Toast.LENGTH_LONG);
                    notificacion.show();
                    et_numero.setText("");
                }
                else if(numero_aleatorio<numero_usuario){
                    Toast notificacion=Toast.makeText(contexto, "El número es menor que "+numero_usuario,Toast.LENGTH_LONG);
                    notificacion.show();
                    et_numero.setText("");
                }
                else if(numero_aleatorio==numero_usuario){
                    Toast notificacion=Toast.makeText(contexto, "¡Correcto!",Toast.LENGTH_LONG);
                    notificacion.show();
                }
                et_numero.requestFocus();
                intento++;
                n_intentos.setText("Llevas "+intento+" intentos");
            }
        });
        btn_reiniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numero_aleatorio=Aleatorio.obtenerAleatorio();
                jugar();
                et_numero.setText("");
                intento=0;
                n_intentos.setText("");
            }
        });


    }


}

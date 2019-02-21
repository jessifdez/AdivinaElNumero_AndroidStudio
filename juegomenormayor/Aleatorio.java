package com.example.maanas.juegomenormayor;

public class Aleatorio {

    public static int obtenerAleatorio() {
        double d=Math.random();
        //Para que de un numero entre 1-10, sino solo devuelve nº entre 0 y 1
        d=(d*9+1);
        int numero_aleatorio=(int)d;
        return numero_aleatorio;
    }
}

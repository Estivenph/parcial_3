package com.example.parcial_2do_corte;

import java.io.Serializable;

public class Recibir implements Serializable {

    public int cant_1, cant_2, cant_3;


    public Recibir(int cant_1, int cant_2, int cant_3) {
        this.cant_1 = cant_1;
        this.cant_2 = cant_2;
        this.cant_3 = cant_3;


    }
    public Recibir(){

    }
    public int getCant_1() {return cant_1;}
    public void setCant_1(int cant_prod_1) {this.cant_1 = cant_prod_1;}

    public int getCant_2() {return cant_2;}
    public void setCant_2(int cant_prod_2) {this.cant_2 = cant_prod_2;}

    public int getCant_3() {return cant_3;}
    public void setCant_3(int cant_prod_3) {this.cant_3 = cant_prod_3;}
}





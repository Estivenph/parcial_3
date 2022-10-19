package com.example.parcial_2do_corte;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {


    private TextView total_1, total_2, total_3, total, fecha, prod_1, prod_2, prod_3, unitario_1, unitario_2, unitario_3;
    private int precio_p_1, precio_p_2, precio_p_3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        fecha = findViewById(R.id.fecha);
        prod_1 = findViewById(R.id.prod_1);
        prod_2 = findViewById(R.id.prod_2);
        prod_3 = findViewById(R.id.prod_3);
        unitario_1 = findViewById(R.id.unitario_1);
        unitario_2 = findViewById(R.id.unitario_2);
        unitario_3 = findViewById(R.id.unitario_3);
        total_1 = findViewById(R.id.total_1);
        total_2 = findViewById(R.id.total_2);
        total_3 = findViewById(R.id.total_3);
        total = findViewById(R.id.total);
        precio_p_1 = 40000;
        precio_p_2 = 65000;
        precio_p_3 = 85000;


        Bundle sendObj = getIntent().getExtras();
        Recibir prod = null;

        if (sendObj != null) {
            prod = (Recibir) sendObj.getSerializable("recibe");



            fecha.setText(String.valueOf(new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date())));
            unitario_1.setText(String.valueOf(precio_p_1));
            unitario_2.setText(String.valueOf(precio_p_2));
            unitario_3.setText(String.valueOf(precio_p_3));

            prod_1.setText(String.valueOf(prod.getCant_1()));
            prod_2.setText(String.valueOf(prod.getCant_2()));
            prod_3.setText(String.valueOf(prod.getCant_3()));

            total_1.setText(String.valueOf(calcula(precio_p_1, prod.getCant_1())));
            total_2.setText(String.valueOf(calcula(precio_p_2, prod.getCant_2())));
            total_3.setText(String.valueOf(calcula(precio_p_3, prod.getCant_3())));


            total.setText(String.valueOf((calcula(precio_p_1, prod.getCant_1())+(calcula(precio_p_2, prod.getCant_2()))+(calcula(precio_p_3, prod.getCant_3())))));
        }
    }

    public int calcula(int a, int b) {
        if (a == 0 || b == 0)
            return 0;
            else if (b != 1)
                return a + calcula(a, b-1);
        else
            return a;
    }

}




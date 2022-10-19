package com.example.parcial_2do_corte;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public EditText cant1, cant2, cant3;
    public Button btnregistrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cant1 = findViewById(R.id.cant_1);
        cant2 = findViewById(R.id.cant_2);
        cant3 = findViewById(R.id.cant_3);
        btnregistrar = findViewById(R.id.btnregistrar);

        btnregistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validacion()){
                    int cant_reloj = Integer.parseInt(cant1.getText().toString());
                    int cant_tv = Integer.parseInt(cant2.getText().toString());
                    int cant_cel = Integer.parseInt(cant3.getText().toString());

                    Recibir rec = new Recibir(cant_reloj,cant_tv,cant_cel);

                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);

                    Bundle bundle = new Bundle();
                    bundle.putSerializable("recibe", rec);
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });
    }


    public boolean validacion() {

    boolean res = true;
        String entrada_1 = cant1.getText().toString();
        String entrada_2 = cant2.getText().toString();
        String entrada_3 = cant3.getText().toString();

        if(entrada_1.isEmpty()){
            cant1.setError("Diligenciar todos los campos");
            res = false;
        }
        else if(entrada_2.isEmpty()){
            cant2.setError("Diligenciar todos los campos");
            res = false;
        }
        else if(entrada_3.isEmpty()){
            cant3.setError("Diligenciar todos los campos");
            res = false;
        }
        return res;
    }

}

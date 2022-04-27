package com.example.ordinario_dam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pantalla9 extends AppCompatActivity {
    TextView mensaje1;
    Button regresar1;

    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla9);
        mensaje1 = (TextView) findViewById(R.id.mensaje1);
        regresar1 = (Button) findViewById(R.id.regresar1);


        Bundle extras = getIntent().getExtras();
        if(extras!=null){
            String dato1 = extras.getString("Nombre");
            String dato2 = extras.getString("Direccion");
            String dato3 = extras.getString("Pizza");
            String dato4 = extras.getString("Bebida");
            String dato5 = extras.getString("Preciob");
            String dato6 = extras.getString("Preciop");
            double valor1 = Double.parseDouble(dato5);
            double valor2 = Double.parseDouble(dato6);
            double nfinal= valor1 +valor2;


            if(!dato1.equals("")&&!dato2.equals("")&&!dato3.equals("")&&!dato4.equals("")&&!dato5.equals("")&&!dato6.equals("")){
                mensaje1.setText("Estimado "+dato1+" con destino: " +dato2+ " has seleccionado " +dato3+ " y " +dato4+ " el total de la compra es: " +nfinal);

            }
            else
                mensaje1.setText("Los datos que enviaste son incorrectos");

        }
        else {
            mensaje1.setText("No se envio ningun extra en el intent");
            LeerDatos();
        }




        regresar1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pantalla9.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
    private void LeerDatos() {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        String dato1 = preferences.getString("Nombre","No hay dato");
        String dato2 = preferences.getString("Direccion","No hay dato");
        String dato3 = preferences.getString("Pizza","No hay dato");
        String dato4 = preferences.getString("Bebida","No hay dato");
        String dato5 = preferences.getString("Preciob","No hay dato");
        String dato6 = preferences.getString("Preciop","No hay dato");
        double valor1 = Double.parseDouble(dato5);
        double valor2 = Double.parseDouble(dato6);
        double nfinal= valor1 +valor2;



        if(!dato1.equals("")&&!dato2.equals("")&&!dato3.equals("")&&!dato4.equals("")&&!dato5.equals("")&&!dato6.equals(""))
            mensaje1.setText("Estimado "+dato1+" con destino: "+dato2+" has seleccionado " +dato3+" y "+dato4+ "el total de la compra es: " +nfinal);

        else
            mensaje1.setText("Los datos que enviaste son incorrectos nombre: "+dato1+" direccion: "+dato2+ "Pizza: " +dato3+ "Bebida: "+dato4);


    }
}
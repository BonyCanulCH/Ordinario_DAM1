package com.example.ordinario_dam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class pantalla4 extends AppCompatActivity {
    EditText comprarb,preciob;
    Button pagarb;
    Button menupizza;


    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla4);
        menupizza=(Button) findViewById(R.id.menupizza);
        pagarb = (Button) findViewById(R.id.pagarb);
        comprarb = (EditText) findViewById(R.id.comprarb);
        preciob = (EditText) findViewById(R.id.preciob);




        menupizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _comprarb="";
                String _preciob="";
                _comprarb = comprarb.getText().toString();
                _preciob = preciob.getText().toString();
                GuardarDatos(_comprarb,_preciob);
                Intent intent = new Intent(pantalla4.this,pantalla5.class);
                //intent.putExtra("Comprarb",_comprarb);
                //intent.putExtra("Preciob",_preciob);
                startActivity(intent);
            }
        });

        pagarb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _comprarb="";
                String _preciob="";
                _comprarb = comprarb.getText().toString();
                _preciob = preciob.getText().toString();
                GuardarDatos(_comprarb,_preciob);
                Intent intent = new Intent(pantalla4.this,pantalla9.class);
                //intent.putExtra("Comprarb",_comprarb);
                //intent.putExtra("Preciob",_preciob);
                startActivity(intent);
            }
        });
    }
    private void GuardarDatos(String comprarb, String preciob) {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Bebida",comprarb);
        editor.putString("Preciob",preciob);
        editor.commit();
    }
}
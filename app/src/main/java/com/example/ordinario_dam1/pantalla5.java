package com.example.ordinario_dam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class pantalla5 extends AppCompatActivity {
    EditText comprarp, preciop;
    Button pagarp;
    Button menubebida;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla5);
        menubebida=(Button) findViewById(R.id.menubebida);
        pagarp = (Button) findViewById(R.id.pagarp);
        comprarp = (EditText) findViewById(R.id.comprarp);
        preciop = (EditText) findViewById(R.id.preciop);



        menubebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _comprarp="";
                String _preciop="";
                _comprarp = comprarp.getText().toString();
                _preciop = preciop.getText().toString();
                GuardarDatos(_comprarp,_preciop);
                Intent intent = new Intent(pantalla5.this,pantalla9.class);
                //intent.putExtra("Comprarp",_comprarp);
                //intent.putExtra("Preciop",_preciop);
                startActivity(intent);
            }
        });

        pagarp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _comprarp="";
                String _preciop="";
                _comprarp = comprarp.getText().toString();
                _preciop = preciop.getText().toString();
                GuardarDatos(_comprarp,_preciop);
                Intent intent = new Intent(pantalla5.this,pantalla9.class);
                //intent.putExtra("Comprarp",_comprarp);
                //intent.putExtra("Preciop",_preciop);
                startActivity(intent);
            }
        });

    }
    private void GuardarDatos(String comprarp, String preciop) {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Pizza",comprarp);
        editor.putString("Preciop",preciop);
        editor.commit();
    }
}
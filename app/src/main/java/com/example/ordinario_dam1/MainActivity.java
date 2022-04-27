package com.example.ordinario_dam1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText nombre,direccion;
    Button iniciar;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre = (EditText) findViewById(R.id.nombre);
        direccion = (EditText) findViewById(R.id.direccion);
        iniciar = (Button) findViewById(R.id.boton);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String _nombre="";
                String _direccion="";
                _nombre = nombre.getText().toString();
                _direccion = direccion.getText().toString();
                GuardarDatos(_nombre,_direccion);
                Intent intent = new Intent(MainActivity.this,pantalla2.class);
                //intent.putExtra("Nombre",_nombre);
                //intent.putExtra("Direccion",_direccion);
                startActivity(intent);
            }
        });
    }
    private void GuardarDatos(String nombre, String direccion) {
        preferences = getSharedPreferences("credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("Nombre",nombre);
        editor.putString("Direccion",direccion);
        editor.commit();
    }
}
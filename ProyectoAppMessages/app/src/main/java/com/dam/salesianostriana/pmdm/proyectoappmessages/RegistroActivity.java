package com.dam.salesianostriana.pmdm.proyectoappmessages;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dam.salesianostriana.pmdm.proyectoappmessages.notificaciones.GcmRegistrationAsyncTask;

public class RegistroActivity extends AppCompatActivity {
    Button entrar;
    EditText nom_usuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        entrar = (Button) findViewById(R.id.btn_entrar);
        nom_usuario = (EditText) findViewById(R.id.editTextNick);

        SharedPreferences prefs = getSharedPreferences("preferencias", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = prefs.edit();

        if(prefs.getString("clave",null)!= null){
            Intent i = new Intent(RegistroActivity.this, MainActivity.class);
            startActivity(i);
            RegistroActivity.this.finish();
        }

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nick = nom_usuario.getText().toString();
                if(!nick.isEmpty()) {
                    Intent i = new Intent(RegistroActivity.this, MainActivity.class);
                    new GcmRegistrationAsyncTask(RegistroActivity.this).execute(nick);
                    startActivity(i);
                    RegistroActivity.this.finish();
                }
                Toast.makeText(RegistroActivity.this,"Introduzca algún nick",Toast.LENGTH_LONG).show();
            }
        });


    }

}

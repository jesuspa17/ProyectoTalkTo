package com.dam.salesianostriana.pmdm.proyectoappmessages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EnviarMensajeActivity extends AppCompatActivity {

    TextView usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_mensaje);

        usuario = (TextView) findViewById(R.id.txtNombreEnviar);

        Bundle extras = getIntent().getExtras();
        String nombre = "";
        if(extras!=null) {
            nombre = extras.getString("usuario");
        }
        usuario.setText(nombre);
    }
}

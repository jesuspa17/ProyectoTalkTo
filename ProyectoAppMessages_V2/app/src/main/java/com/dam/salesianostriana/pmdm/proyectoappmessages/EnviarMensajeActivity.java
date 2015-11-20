package com.dam.salesianostriana.pmdm.proyectoappmessages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.dam.salesianostriana.pmdm.proyectoappmessages.notificaciones.GcmSendMessageAsyncTask;

public class EnviarMensajeActivity extends AppCompatActivity {

    TextView usuario;
    ImageView enviar_mensaje;
    String nombre;
    EditText mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enviar_mensaje);

        usuario = (TextView) findViewById(R.id.txtNombreEnviar);
        enviar_mensaje = (ImageView) findViewById(R.id.imgEnviarMensaje);
        mensaje = (EditText) findViewById(R.id.editMensaje);

        Bundle extras = getIntent().getExtras();

        if(extras!=null) {
            nombre = extras.getString("usuario");
        }
        usuario.setText(nombre);

        enviar_mensaje.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = mensaje.getText().toString();
                Mensaje mensaje = new Mensaje(nombre,msg);
                Log.i("OBJETO MENSAJE: ", mensaje.getNick_usuario() +"\n"+mensaje.getMsg());
                new GcmSendMessageAsyncTask(EnviarMensajeActivity.this).execute(mensaje);

            }
        });
    }
}

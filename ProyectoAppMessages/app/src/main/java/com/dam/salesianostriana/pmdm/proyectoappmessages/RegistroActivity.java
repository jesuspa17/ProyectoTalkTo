package com.dam.salesianostriana.pmdm.proyectoappmessages;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class RegistroActivity extends AppCompatActivity {
    Button entrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        entrar = (Button) findViewById(R.id.btn_entrar);

        entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistroActivity.this, MainActivity.class);
                startActivity(i);
                RegistroActivity.this.finish();

            }
        });


    }

}

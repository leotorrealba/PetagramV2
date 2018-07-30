package com.leotorrealba.petagramv2;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.leotorrealba.petagramv2.pojo.SimpleMail;

public class Contact extends AppCompatActivity {

    private EditText name;
    private EditText from;
    private EditText msg;
    private Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        if(getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);
        }

        name = (EditText) findViewById(R.id.tietNombre);
        from = (EditText) findViewById(R.id.tietEmail);
        msg = (EditText) findViewById(R.id.tietMensaje);
        enviar = (Button) findViewById(R.id.btnEnviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviarEmail(name.getText().toString(), from.getText().toString(), msg.getText().toString());
                Toast.makeText(getApplicationContext(), "Mensaje enviado Exitosamente",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void enviarEmail(String name, String from, String msg){
        new SimpleMail().sendEmail(name,from,msg);
    }

}

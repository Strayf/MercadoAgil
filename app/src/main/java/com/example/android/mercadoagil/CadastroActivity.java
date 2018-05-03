package com.example.android.mercadoagil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btCadastrar = (Button) findViewById(R.id.buttonRegistrar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mudarTela = new Intent(CadastroActivity.this,LoginActivity.class);
                CadastroActivity.this.startActivity(mudarTela);

            }
        });

    }

}

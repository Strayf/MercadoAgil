package com.example.android.mercadoagil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class CadastroActivity extends AppCompatActivity {

    Button registrar;
    EditText nome;
    EditText email;
    EditText dataNasc;
    RadioGroup sexo;
    EditText username;
    EditText senha;
    EditText confSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        registrar = findViewById(R.id.btnRegistrar);
        nome = findViewById(R.id.txtNome);
        email = findViewById(R.id.txtEmail);
        dataNasc = findViewById(R.id.txtData);
        sexo = findViewById(R.id.radioSexo);
        username = findViewById(R.id.txtUsername);
        senha = findViewById(R.id.txtPassword);
        confSenha = findViewById(R.id.txtConfPassword);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( (nome.getText().toString().isEmpty()) || (email.getText().toString().isEmpty()) ||(dataNasc.getText().toString().isEmpty()) ||(username.getText().toString().isEmpty()) || (senha.getText().toString().isEmpty()) ||(confSenha.getText().toString().isEmpty()) )
                    Toast.makeText(getApplicationContext(),"Preencha todos os campos",Toast.LENGTH_SHORT).show();
                else{
                    Toast.makeText(getApplicationContext(),"Usuário cadastrado com sucesso!",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(getApplicationContext(),LoginActivity.class));
                }
            }
        });
    }

}

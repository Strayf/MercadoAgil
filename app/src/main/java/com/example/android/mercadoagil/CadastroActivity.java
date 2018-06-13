package com.example.android.mercadoagil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.mercadoagil.classes.Cliente;
import com.example.android.mercadoagil.classes.MercadoBD;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Button btCadastrar = (Button) findViewById(R.id.buttonRegistrar);

        btCadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText t1 = findViewById(R.id.campoSenha);
                EditText t2 = findViewById(R.id.campoConfirmarSenha);
                EditText t3 = findViewById(R.id.campoLogin);
                EditText t4 = findViewById(R.id.campoNome);

                String Nome = t4.getText().toString();
                String Login = t3.getText().toString();
                String Senha = t1.getText().toString();
                String ConfirmarSenha = t2.getText().toString();

                if (Nome.isEmpty() || Login.isEmpty() || Senha.isEmpty() || ConfirmarSenha.isEmpty()) {
                    Alert("Todos os campos devem ser preenchidos.");
                    return;
                }

                if (!Senha.equals(ConfirmarSenha)) {
                    Alert("Senha e confirmação devem ser idênticas.");
                    return;
                }

                Cliente cliente = new Cliente(Nome, Login, Senha);
                MercadoBD db = new MercadoBD(getBaseContext());

                db.cadastraCliente(cliente);

                Intent telaLogin = new Intent(CadastroActivity.this,LoginActivity.class);
                CadastroActivity.this.startActivity(telaLogin);

            }
        });

    }

    private void Alert(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}

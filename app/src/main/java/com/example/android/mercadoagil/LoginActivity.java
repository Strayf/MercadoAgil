package com.example.android.mercadoagil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnAcessar = findViewById(R.id.buttonLogin);
        btnAcessar.setOnClickListener(Acessar());

        Button btNovo = findViewById(R.id.buttonCadastro);
        btNovo.setOnClickListener(Cadastrar());

    }

    private void alet(String s) {

        Toast.makeText(this,s , Toast.LENGTH_LONG).show();
    }

    private View.OnClickListener Acessar() {
        return new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validaLogin()) {
                    alet("Sucesso");

                   Intent mudar = new Intent(LoginActivity.this,ListaProdutosActivity.class);
                   LoginActivity.this.startActivity(mudar);
                }
                else alet("Usuario incorreto");
            }
        };
    }
    private View.OnClickListener Cadastrar() {
        return new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent mudarTela = new Intent(LoginActivity.this,CadastroActivity.class);
                LoginActivity.this.startActivity(mudarTela);

            }
        };
    }

    public boolean validaLogin(){

        EditText Login = findViewById(R.id.campoLogin);
        EditText Senha = findViewById(R.id.campoSenha);

        String tLogin = Login.getText().toString();
        String tSenha = Senha.getText().toString();

        if ("abc".equals(tLogin) && "123".equals(tSenha)) {
            return true;
        }
        else {
            return false;
        }
    }


}
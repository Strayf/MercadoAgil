package com.example.android.mercadoagil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity implements AdapterView.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button btnAcessar = findViewById(R.id.buttonLogin);
        //btnAcessar.setOnClickListener();

        if (validaLogin()) {
            Toast.makeText(this, "Login aceito.", Toast.LENGTH_LONG);
        }
    }

    public boolean validaLogin(){
        EditText Login = findViewById(R.id.campoLogin);
        EditText Senha = findViewById(R.id.campoSenha);

        if (Login.toString() == "abc" && Senha.toString() == "123") {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public void onClick(View view) {

    }
}

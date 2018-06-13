package com.example.android.mercadoagil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android.mercadoagil.classes.Cliente;
import com.example.android.mercadoagil.classes.MercadoBD;

public class LoginActivity extends AppCompatActivity {

    private Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ctx = this;

        Button btnAcessar = findViewById(R.id.buttonLogin);
        btnAcessar.setOnClickListener(Acessar());

        Button btNovo = findViewById(R.id.buttonCadastro);
        btNovo.setOnClickListener(Cadastrar());

        EditText campoLogin = findViewById(R.id.campoLogin);
        EditText campoSenha = findViewById(R.id.campoSenha);
        CheckBox checkLembrar = findViewById(R.id.checkLembrar);
        boolean lembrarMarcado = LerLembrar(ctx, "Lembrar");

        if (lembrarMarcado) {
            campoLogin.setText(LerLogin(ctx, "Login"));
            campoSenha.setText(LerLogin(ctx, "Senha"));
            checkLembrar.setChecked(true);
        }
    }

    private void Alert(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }

    private View.OnClickListener Acessar() {
        return new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cliente cliente = validaLogin();

                if (cliente == null) {
                    Alert("Usuário ou senha incorretos.");

                }
                else {
                    Alert("Bem vindo, " + cliente.getNome());

                    Intent telaPosLogin = new Intent(LoginActivity.this,  MainActivity.class);
                    LoginActivity.this.startActivity(telaPosLogin);
                }
            }
        };
    }

    private View.OnClickListener Cadastrar() {
        return new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent telaCadastro = new Intent(LoginActivity.this, CadastroActivity.class);
                LoginActivity.this.startActivity(telaCadastro);

            }
        };
    }

    private Cliente validaLogin(){

        EditText Login = findViewById(R.id.campoLogin);
        EditText Senha = findViewById(R.id.campoSenha);
        CheckBox lembrar = findViewById(R.id.checkLembrar);
        SharedPreferences configuracoes = PreferenceManager.getDefaultSharedPreferences(ctx);

        String tLogin = Login.getText().toString();
        String tSenha = Senha.getText().toString();
        boolean lembrarMarcado = lembrar.isChecked();

        if (lembrarMarcado) {
            GravarLogin(ctx,"Login", tLogin);
            GravarLogin(ctx,"Senha", tSenha);
            GravarLogin(ctx, "Lembrar", true);
        }
        else {
            GravarLogin(ctx, "Lembrar", false);
        }

        MercadoBD db = new MercadoBD(getBaseContext());
        Cliente cliente = db.lerCliente(tLogin, tSenha);

        if (cliente != null) {
            return cliente;
        }

        return null;
    }

    public void GravarLogin(Context context, String campo, String texto) {
        SharedPreferences configuracoes;
        SharedPreferences.Editor editor;

        configuracoes = PreferenceManager.getDefaultSharedPreferences(context);
        editor = configuracoes.edit();
        try {
            editor.putString(campo, texto);
            editor.commit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public void GravarLogin(Context context, String campo, boolean valor) {
        SharedPreferences configuracoes;
        SharedPreferences.Editor editor;

        configuracoes = PreferenceManager.getDefaultSharedPreferences(context);
        editor = configuracoes.edit();
        try {
            editor.putBoolean(campo, valor);
            editor.commit();
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }

    public String LerLogin(Context context, String campo) {
        SharedPreferences configuracoes;
        String texto = "";

        configuracoes = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            texto = configuracoes.getString(campo, "");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return texto;
    }

    public boolean LerLembrar(Context context, String campo) {
        SharedPreferences configuracoes;
        boolean valor = false;

        configuracoes = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            valor = configuracoes.getBoolean(campo, false);
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return valor;
    }

}
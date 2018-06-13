package com.example.android.mercadoagil.classes;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Cliente {

    private String Nome;
    private String Login;
    private String Senha;

    public Cliente(String Nome, String Login, String Senha) {
        this.Nome = Nome;
        this.Login = Login;
        this.Senha = Senha;
    }

    public String getNome() {
        return Nome;
    }

    public String getLogin() {
        return Login;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String Senha) {
        this.Senha = Senha;
    }
}

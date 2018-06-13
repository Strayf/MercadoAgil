package com.example.android.mercadoagil.classes;

import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class Cliente {

    private Integer ID;
    private String Nome;
    private String Login;
    private String Senha;

    public Cliente(Integer ID, String Nome, String Login, String Senha) {
        this.ID = ID;
        this.Nome = Nome;
        this.Login = Login;
        this.Senha = Senha;
    }

    public Integer getID() {
        return ID;
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

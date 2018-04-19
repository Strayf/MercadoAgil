package com.example.android.mercadoagil;

/**
 * Created by android on 18/04/2018.
 */

public class Produto {

    private String Nome;
    private String Descricao;
    private float Preco;

    public Produto(String Nome, String Descricao, float Preco) {
        this.Nome = Nome;
        this.Descricao = Descricao;
        this.Preco = Preco;
    }

    public String getNome() {
        return this.Nome;
    }

    public String getDescricao() {
        return this.Descricao;
    }

    public float getPreco() {
        return this.Preco;
    }
}

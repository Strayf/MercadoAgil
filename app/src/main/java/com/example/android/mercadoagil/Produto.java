package com.example.android.mercadoagil;

import java.util.ArrayList;
import java.util.List;

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
    public static List<Produto> getProdutos(){

        List<Produto> Produtos = new ArrayList<Produto>();

        Produtos.add(new Produto("Arroz","Arroz branco",2)) ;
        Produtos.add(new Produto("Feijão","Feijão fradinho",2)) ;
        Produtos.add(new Produto("Macarrão","Massa italiana",2)) ;

        return Produtos ;
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

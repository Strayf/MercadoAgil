package com.example.android.mercadoagil.classes;

/**
 * Created by android on 18/04/2018.
 */

public class Produto {

    private Integer id;
    private String Nome;
    private String Marca;
    private double Preco;
    private int Quantidade;

    public Produto(String Nome, String Marca, double Preco, Integer id, Integer Quantidade) {

        this.id = id;
        this.Nome = Nome;
        this.Marca = Marca;
        this.Preco = Preco;
        this.Quantidade = Quantidade;
    }

    public String getNome() {
        return this.Nome;
    }

    public String getMarca() {
        return this.Marca;
    }

    public double getPreco() {
        return this.Preco * this.Quantidade;
    }

    public Integer getId() {
        return id;
    }

}

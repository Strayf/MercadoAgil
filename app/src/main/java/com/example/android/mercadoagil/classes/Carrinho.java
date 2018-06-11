package com.example.android.mercadoagil.classes;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private int id_cliente;
    private List<Integer> id_produtos;
    private double total;

    public Carrinho(){

        id_produtos = new ArrayList<>();
    }

    public void setProdutos(Integer id_produto) {
        this.id_produtos.add(id_produto);
    }

    public List<Integer> getId_produtos() {
        return id_produtos;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }
}

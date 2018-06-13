package com.example.android.mercadoagil.classes;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {

    private Cliente cliente;
    private List<Produto> produtos;
    private double total;

    public Carrinho(Cliente cliente){
        this.cliente = cliente;
        produtos = new ArrayList<Produto>();
    }

    public void adicionaProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public void removeProduto(Produto produto) {
        this.produtos.remove(produto);
    }

    public List<Produto> getListaProdutos() {
        return produtos;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public double calculaValorTotal() {
        total = 0;
        for (Produto produto : produtos) {
            total += produto.getPreco();
        }
        return total;
    }
}

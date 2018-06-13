package com.example.android.mercadoagil.classes;

import java.util.Date;

public class Compra {
    private String Situacao;
    private double PrecoTotal;
    private Date DataCompra;

    public Compra(String Situacao, double PrecoTotal, Date DataCompra) {
        this.Situacao = Situacao;
        this.PrecoTotal = PrecoTotal;
        this.DataCompra = DataCompra;
    }

    public String getSituacao() {
        return Situacao;
    }

    public double getPrecoTotal() {
        return PrecoTotal;
    }

    public Date getDataCompra() {
        return DataCompra;
    }
}

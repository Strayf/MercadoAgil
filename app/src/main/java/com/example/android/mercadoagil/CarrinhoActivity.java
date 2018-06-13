package com.example.android.mercadoagil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.mercadoagil.adapter.CarrinhoAdapter;
import com.example.android.mercadoagil.classes.Carrinho;
import com.example.android.mercadoagil.classes.Cliente;
import com.example.android.mercadoagil.classes.Produto;

public class CarrinhoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        Cliente cliente = new Cliente("John", "Batata", "Pure");
        Carrinho carrinho = new Carrinho(cliente);

        ListView listView = (ListView) findViewById(R.id.ListaProdutos);

        Produto produto = new Produto("Batata", "ZOINKS", 3.5, 5);
        carrinho.adicionaProduto(produto);
        carrinho.adicionaProduto(produto);
        carrinho.adicionaProduto(produto);

        listView.setAdapter(new CarrinhoAdapter(this, carrinho));
    }
}

package com.example.android.mercadoagil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.mercadoagil.adapter.ProdutoAdapter;

import java.util.List;

public class ListaProdutosActivity extends AppCompatActivity {

    private List<Produto> Produtos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);
        ListView listView = (ListView) findViewById(R.id.ListaProdutos);
        Produtos = Produto.getProdutos() ;

        listView.setAdapter(new ProdutoAdapter(this, Produtos));
    }
}

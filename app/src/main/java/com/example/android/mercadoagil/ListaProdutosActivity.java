package com.example.android.mercadoagil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.mercadoagil.adapter.ProdutoAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaProdutosActivity extends AppCompatActivity {

    private List<Produto> Produtos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);
        ListView listView = (ListView) findViewById(R.id.ListaProdutos);

        List<Produto> Produtos = new ArrayList<Produto>();

        Produtos.add(new Produto("Arroz","Arroz branco",2)) ;
        Produtos.add(new Produto("Feijão","Feijão fradinho",2)) ;
        Produtos.add(new Produto("Macarrão","Massa italiana",2)) ;

        listView.setAdapter(new ProdutoAdapter(this, Produtos));
    }
}

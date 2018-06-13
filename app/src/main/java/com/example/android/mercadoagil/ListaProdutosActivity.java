package com.example.android.mercadoagil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.mercadoagil.classes.MercadoBD;
import com.example.android.mercadoagil.classes.Produto;
import com.example.android.mercadoagil.adapter.ProdutoAdapter;

import java.util.ArrayList;
import java.util.List;

public class ListaProdutosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);
        ListView listView = (ListView) findViewById(R.id.ListaProdutos);

        List<Produto> Produtos = new ArrayList<Produto>();

        MercadoBD db = new MercadoBD(getBaseContext());

        db.deleteProdutos();
        db.inserirProdutos();
        Produtos = db.listarProdutos();

        listView.setAdapter(new ProdutoAdapter(this, Produtos));
    }
}

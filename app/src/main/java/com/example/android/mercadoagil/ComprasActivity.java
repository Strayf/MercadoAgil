package com.example.android.mercadoagil;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.mercadoagil.adapter.ComprasAdapter;
import com.example.android.mercadoagil.classes.Compra;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ComprasActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compras);

        ListView listView = findViewById(R.id.ListaCompras);

        List<Compra> compras = new ArrayList<>();

        Compra compra = new Compra("Em Andamento", 235.90, new Date());
        compras.add(compra);
        compras.add(compra);
        compras.add(compra);

        listView.setAdapter(new ComprasAdapter(this, compras));
    }
}

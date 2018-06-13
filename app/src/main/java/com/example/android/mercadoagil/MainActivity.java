package com.example.android.mercadoagil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btIniciarCompra = (Button) findViewById(R.id.button);
        Button btCarrinho = (Button) findViewById(R.id.button2);
        Button btStatus = (Button) findViewById(R.id.button3);

        btIniciarCompra.setOnClickListener(abrirSetor());
        btCarrinho.setOnClickListener(abrirCarrinho());
        btStatus.setOnClickListener(abrirStatus());
    }

    private View.OnClickListener abrirStatus() {

        return new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ComprasActivity.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener abrirCarrinho() {
        return new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CarrinhoActivity.class);
                startActivity(intent);
            }
        };
    }

    private View.OnClickListener abrirSetor() {
        return new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SetoresActivity.class);
                startActivity(intent);
            }
        };
    }
}


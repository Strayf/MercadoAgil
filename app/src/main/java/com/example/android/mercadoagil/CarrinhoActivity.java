package com.example.android.mercadoagil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.mercadoagil.adapter.CarrinhoAdapter;
import com.example.android.mercadoagil.classes.Carrinho;
import com.example.android.mercadoagil.classes.Cliente;
import com.example.android.mercadoagil.classes.MercadoBD;
import com.example.android.mercadoagil.classes.Produto;

import java.util.Date;

public class CarrinhoActivity extends AppCompatActivity {

    private Carrinho carrinho;
    private Cliente cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrinho);

        MercadoBD db = new MercadoBD(getBaseContext());

        Button btFinalizar = (Button) findViewById(R.id.btFinalizar);
        btFinalizar.setOnClickListener(finalizarCompras());

        String loginCliente = LerLogin(this, "Login");

        cliente = db.lerCliente(loginCliente);
        carrinho = new Carrinho(cliente);

        ListView listView = (ListView) findViewById(R.id.ListaCarrinho);

        Produto produto = new Produto("Batata", "Fake", 3.5, 5, 3);
        carrinho.adicionaProduto(produto);
        carrinho.adicionaProduto(produto);
        carrinho.adicionaProduto(produto);
        carrinho.adicionaProduto(produto);
        carrinho.adicionaProduto(produto);
        carrinho.adicionaProduto(produto);
        carrinho.adicionaProduto(produto);
        carrinho.adicionaProduto(produto);
        carrinho.adicionaProduto(produto);
        carrinho.adicionaProduto(produto);
        carrinho.adicionaProduto(produto);
        carrinho.adicionaProduto(produto);

        TextView viewPreco = findViewById(R.id.precoTotal);
        double preco = carrinho.calculaValorTotal();

        viewPreco.setText("Preço total: R$ " + preco);

        listView.setAdapter(new CarrinhoAdapter(this, carrinho));
    }

    private View.OnClickListener finalizarCompras() {

        return new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date();

                MercadoBD db = new MercadoBD(getBaseContext());
                db.gravarCompra(carrinho, data);

                Alert("Compra gravada com sucesso.");

                Intent intent = new Intent(CarrinhoActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }

    public String LerLogin(Context context, String campo) {
        SharedPreferences configuracoes;
        String texto = "";

        configuracoes = PreferenceManager.getDefaultSharedPreferences(context);
        try {
            texto = configuracoes.getString(campo, "");
        }
        catch(Exception e) {
            e.printStackTrace();
        }

        return texto;
    }

    private void Alert(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
    }
}

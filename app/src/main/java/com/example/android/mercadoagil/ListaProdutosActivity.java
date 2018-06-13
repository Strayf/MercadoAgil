package com.example.android.mercadoagil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.mercadoagil.classes.Carrinho;
import com.example.android.mercadoagil.classes.Cliente;
import com.example.android.mercadoagil.classes.MercadoBD;
import com.example.android.mercadoagil.classes.Produto;
import com.example.android.mercadoagil.adapter.ProdutoAdapter;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListaProdutosActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private Carrinho carrinho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_produtos);
        ListView listView = (ListView) findViewById(R.id.ListaProdutos);
        String login = LerLogin(this, "Login");

        Button btAdicionar = (Button) findViewById(R.id.btAdicionar);
        btAdicionar.setOnClickListener(adicionarAoCarrinho());

        List<Produto> Produtos = new ArrayList<Produto>();

        MercadoBD db = new MercadoBD(getBaseContext());

        Cliente cliente = db.lerCliente(login);
        carrinho = new Carrinho(cliente);

        db.inserirProdutos();
        Produtos = db.listarProdutos();

        listView.setAdapter(new ProdutoAdapter(this, Produtos));
        listView.setOnItemClickListener(this);
    }

    private View.OnClickListener adicionarAoCarrinho() {

        return new Button.OnClickListener() {
            @Override
            public void onClick(View v) {
                MercadoBD db = new MercadoBD(getBaseContext());
                db.adicionarAoCarrinho(carrinho);

                Alert("Produtos adicionados ao carrinho.");

                Intent intent = new Intent(ListaProdutosActivity.this, MainActivity.class);
                startActivity(intent);
            }
        };
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Produto p = (Produto) adapterView.getAdapter().getItem(i);
        carrinho.adicionaProduto(p);

        Alert("Produto adicionado.");
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    private void Alert(String mensagem) {
        Toast.makeText(this, mensagem, Toast.LENGTH_LONG).show();
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
}

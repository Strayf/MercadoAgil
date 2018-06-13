package com.example.android.mercadoagil;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.android.mercadoagil.adapter.ComprasAdapter;
import com.example.android.mercadoagil.classes.Cliente;
import com.example.android.mercadoagil.classes.Compra;
import com.example.android.mercadoagil.classes.MercadoBD;

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
        String login = LerLogin(this, "Login");

        MercadoBD db = new MercadoBD(getBaseContext());
        Cliente cliente = db.lerCliente(login);
        Integer idCliente = cliente.getID();

        compras = db.listarCompras(idCliente.toString());
        if (compras == null) compras = new ArrayList<Compra>();

        listView.setAdapter(new ComprasAdapter(this, compras));
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

package com.example.android.mercadoagil.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.mercadoagil.R;
import com.example.android.mercadoagil.classes.Carrinho;
import com.example.android.mercadoagil.classes.Produto;

import java.util.List;

public class CarrinhoAdapter extends BaseAdapter {
    private Context context;
    private List<Produto> produtos;

    public CarrinhoAdapter(Context context, Carrinho carrinho) {
        super();
        this.context = context;
        this.produtos = carrinho.getListaProdutos();
    }

    @Override
    public int getCount() {
        return produtos.size();
    }

    @Override
    public Object getItem(int position) {
        return produtos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View view = LayoutInflater.from(context).inflate(R.layout.layout_carrinho, parent, false);

        if (position%2 == 1) {
            view.setBackgroundColor(0xFFA7969F);
        }

        TextView titulo = (TextView) view.findViewById(R.id.nomep_layout);
        TextView descricao = (TextView) view.findViewById(R.id.valorp_layout);
        ImageView img = (ImageView) view.findViewById(R.id.img_layout);

        Produto a = produtos.get(position);
        titulo.setText(a.getNome());
        descricao.setText(a.getMarca());
        img.setImageResource(R.drawable.ic_cutlery);

        return view;
    }
}

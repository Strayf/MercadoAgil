package com.example.android.mercadoagil.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.mercadoagil.Produto;
import com.example.android.mercadoagil.R;

import java.util.List;

public class ProdutoAdapter extends BaseAdapter {
    private Context context;
    private List<Produto> produtos;

    public ProdutoAdapter(Context context, List<Produto> produtos) {
        super();
        this.context = context;
        this.produtos = produtos;
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

        View view = LayoutInflater.from(context).inflate(R.layout.layout_produto,parent , false);

        TextView titulo = (TextView) view.findViewById(R.id.nomep_layout);
        TextView descricao = (TextView) view.findViewById(R.id.valorp_layout);
        ImageView img = (ImageView) view.findViewById(R.id.img_layout);

        Produto a = produtos.get(position);
        titulo.setText(a.getNome());
        descricao.setText(a.getDescricao());
        img.setImageResource(R.drawable.ic_launcher_background);

        return view;
    }
}

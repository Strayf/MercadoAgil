package com.example.android.mercadoagil.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.android.mercadoagil.R;

public class SetorAdapter extends BaseAdapter {

    private Context context;
    private final int[] imagens;

    public SetorAdapter(Context context, int[] imagens){

        this.context = context ;
        this.imagens = imagens ;

    }
    @Override
    public int getCount() {
        return imagens.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.layout_setor,parent,false);
        ImageView image = (ImageView) view.findViewById(R.id.imageGrid);

        image.setImageResource(R.drawable.ic_cutlery);

        return view;
    }
}

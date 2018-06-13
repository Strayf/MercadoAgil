package com.example.android.mercadoagil.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.mercadoagil.R;
import com.example.android.mercadoagil.classes.Compra;
import com.example.android.mercadoagil.classes.Produto;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class ComprasAdapter extends BaseAdapter {
    private Context context;
    private List<Compra> compras;

    public ComprasAdapter(Context context, List<Compra> compras) {
        super();
        this.context = context;
        this.compras = compras;
    }

    @Override
    public int getCount() {
        return compras.size();
    }

    @Override
    public Object getItem(int position) {
        return compras.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        View view = LayoutInflater.from(context).inflate(R.layout.layout_compras, parent, false);

        if (position%2 == 1) {
            view.setBackgroundColor(0xFFA7969F);
        }

        TextView situacao = (TextView) view.findViewById(R.id.situacao_layout);
        TextView preco = (TextView) view.findViewById(R.id.preco_layout);
        TextView data = (TextView) view.findViewById(R.id.data_layout);


        Compra a = compras.get(position);
        Date Data = a.getDataCompra();
        String DataFormatada = "";
        Format formatter;

        formatter = new SimpleDateFormat("dd/MM/yy");
        DataFormatada = formatter.format(Data);
        
        situacao.setText(a.getSituacao());
        preco.setText("R$ " + a.getPrecoTotal());
        data.setText("Data Agendada: " + DataFormatada);

        return view;
    }
}

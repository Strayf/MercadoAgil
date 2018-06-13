package com.example.android.mercadoagil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.android.mercadoagil.adapter.SetorAdapter;

public class SetoresActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState ) {
        super.onCreate(savedInstanceState);

        int[] imagens = {R.drawable.ic_cutlery,
                R.drawable.ic_cutlery,
                R.drawable.ic_cutlery,
                R.drawable.ic_cutlery,
                R.drawable.ic_cutlery,
                R.drawable.ic_cutlery};

        setContentView(R.layout.activity_setores);
        gridView = (GridView) findViewById(R.id.grid1) ;
        gridView.setAdapter(new SetorAdapter(this, imagens));
        gridView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,"Imagem selecionado: " + (position+1), Toast.LENGTH_SHORT).show();
        Intent telaPosSetor = new Intent(SetoresActivity.this, ListaProdutosActivity.class);
        try {
            SetoresActivity.this.startActivity(telaPosSetor);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

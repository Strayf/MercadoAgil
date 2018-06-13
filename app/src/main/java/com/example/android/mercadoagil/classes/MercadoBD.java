package com.example.android.mercadoagil.classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MercadoBD extends SQLiteOpenHelper {

    private static final String TAG = "sql";
    public static final  String NOME_BANCO = "mercado_db.sqlite";
    private static final int VERSAO_BANCO = 1;

    public MercadoBD(Context context) {

        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d(TAG, "Criando tabelas cliente, produto, categoria, compra..");

        db.execSQL("create table if not exists Cliente   (_id integer  primary  key  autoincrement , Nome text, Login text, Senha text);");
        db.execSQL("create table if not exists produto   (_id integer  primary  key  autoincrement , nome text, marca text, categoria String, preco real);");
        db.execSQL("create table if not exists compra    (_id integer  primary  key  autoincrement , data text, hora text,id_cliente integer,id_produto integer,FOREIGN KEY(id_cliente) REFERENCES cliente(_id),FOREIGN KEY(id_produto) REFERENCES produto(_id));");

        Log.d(TAG, "Tabelas criadas com sucesso");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void inserirProdutos(){
        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            values.put("nome", "Sabao");
            values.put("marca", "Omo");
            values.put("categoria", "Limpeza");
            values.put("preco", 5.5);
            db.insert("produto", "", values);
            values.put("nome", "Detergente");
            values.put("marca", "Minuano");
            values.put("categoria", "Limpeza");
            values.put("preco", 0.99);
            db.insert("produto", "", values);
            values.put("nome", "Quijo Prato");
            values.put("marca", "Perdigao");
            values.put("categoria", "Frios");
            values.put("preco", 1.99);
            db.insert("produto", "", values);
            values.put("nome", "Presunto");
            values.put("marca", "Perdigao");
            values.put("categoria", "Frios");
            values.put("preco", 2.10);
            db.insert("produto", "", values);
            values.put("nome", "Refrigerante 2l");
            values.put("marca", "Coca-Cola");
            values.put("categoria", "Bebida");
            values.put("preco", 5.3);
            db.insert("produto", "", values);
            values.put("nome", "Cerveja Lata");
            values.put("marca", "Antartica");
            values.put("categoria", "Bebida");
            values.put("preco", 5.5);
            db.insert("produto", "", values);

        }
        finally {
            db.close();
        }
    }

    public Cliente lerCliente(String login, String senha) {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Cliente> clientes = null;

        try {

            Cursor c = db.rawQuery("SELECT Nome, Login, Senha FROM Cliente WHERE Login = ? AND Senha = ?", new String[] {login, senha});
            if(c.moveToFirst()){
                clientes = new ArrayList<Cliente>();
                do {
                    String Nome = c.getString(c.getColumnIndex("Nome"));
                    String Login = c.getString(c.getColumnIndex("Login"));
                    String Senha = c.getString(c.getColumnIndex("Senha"));
                    Cliente cliente = new Cliente(Nome, Login, Senha);
                    clientes.add(cliente);

                } while(c.moveToNext());
            }

            if (clientes == null || clientes.isEmpty()) {
                return null;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            db.close();
        }

        return clientes.get(0);
    }

    public void cadastraCliente(Cliente cliente) {

        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();

            values.put("Nome", cliente.getNome());
            values.put("Login", cliente.getLogin());
            values.put("Senha", cliente.getSenha());

            db.insert("Cliente", "", values);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            db.close();
        }
    }

    public String saveCompra(Carrinho carrinho,String data,String hora){

        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            List<Integer> id_produtos = carrinho.getId_produtos();

            for (Integer id_produto : id_produtos) {

                values.put("data", data);
                values.put("hora",hora);
                values.put("id_clinte", carrinho.getId_cliente());
                values.put("id_produto", id_produto);
                db.insert("compra", "", values);

            }

            return "Compra concluida com sucesso";

        }
        finally {

            db.close();

        }

    }
    public List<Produto> listarProdutos(){
        SQLiteDatabase db = getReadableDatabase();
        List<Produto> produtos = null;
        try {
            //Cursor c = db.query("produto", null, null, null, null, null, null);
            //rawQuery("SELECT id, name FROM people WHERE name = ? AND id = ?", new String[] {"David", "2"});
            Cursor c = db.rawQuery("select * from produto", null);
            if(c.moveToFirst()){
                produtos = new ArrayList<Produto>();
                do {

                    String  nome = c.getString(c.getColumnIndex("nome"));
                    String  marca = c.getString(c.getColumnIndex("marca"));
                    Double  preco = c.getDouble(c.getColumnIndex("preco"));
                    Integer id = c.getInt(c.getColumnIndex("_id"));

                    Produto produto = new Produto(nome, marca, preco, id);
                    produtos.add(produto);

                }while(c.moveToNext());
            }
        }
        finally {
            db.close();
        }
        return produtos;
    }
    public void deleteProdutos(){
        SQLiteDatabase db = getWritableDatabase();
        try{
            db.delete("produto", null, null);
        }
        finally {
            db.close();
        }
    }
}

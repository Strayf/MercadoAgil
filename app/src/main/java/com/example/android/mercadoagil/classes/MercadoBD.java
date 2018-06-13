package com.example.android.mercadoagil.classes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MercadoBD extends SQLiteOpenHelper {

    private static final String TAG = "sql";
    public static final  String NOME_BANCO = "mercado_db.sqlite";
    private static final int VERSAO_BANCO = 2;

    public MercadoBD(Context context) {

        super(context, NOME_BANCO, null, VERSAO_BANCO);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        Log.d(TAG, "Inicializando tabelas do banco.");

        db.execSQL("CREATE TABLE IF NOT EXISTS Cliente  (_id integer PRIMARY KEY AUTOINCREMENT, Nome text, Login text, Senha text)");
        db.execSQL("CREATE TABLE IF NOT EXISTS Produto  (_id integer PRIMARY KEY AUTOINCREMENT, Nome text, Marca text, Categoria String, Preco real)");
        db.execSQL("CREATE TABLE IF NOT EXISTS Carrinho (_id integer PRIMARY KEY AUTOINCREMENT, Quantidade integer, id_cliente integer, id_produto integer, FOREIGN KEY(id_cliente) REFERENCES Cliente(_id), FOREIGN KEY(id_produto) REFERENCES Produto(_id))");
        db.execSQL("CREATE TABLE IF NOT EXISTS Compra   (_id integer PRIMARY KEY AUTOINCREMENT, Data text, Situacao text, Preco real, id_cliente integer, FOREIGN KEY(id_cliente) REFERENCES cliente(_id))");

        Log.d(TAG, "Tabelas criadas com sucesso.");
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

    public Cliente lerCliente(String login) {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Cliente> clientes = null;

        try {

            Cursor c = db.rawQuery("SELECT Nome, Login, Senha, _id FROM Cliente WHERE Login = ?", new String[] {login});
            if(c.moveToFirst()){
                clientes = new ArrayList<Cliente>();
                do {
                    String Nome = c.getString(c.getColumnIndex("Nome"));
                    String Login = c.getString(c.getColumnIndex("Login"));
                    String Senha = c.getString(c.getColumnIndex("Senha"));
                    Integer ID = c.getInt(c.getColumnIndex("_id"));
                    Cliente cliente = new Cliente(ID, Nome, Login, Senha);
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

    public Cliente lerCliente(String login, String senha) {
        SQLiteDatabase db = getReadableDatabase();
        ArrayList<Cliente> clientes = null;

        try {

            Cursor c = db.rawQuery("SELECT Nome, Login, Senha, _id FROM Cliente WHERE Login = ? AND Senha = ?", new String[] {login, senha});
            if(c.moveToFirst()){
                clientes = new ArrayList<Cliente>();
                do {
                    String Nome = c.getString(c.getColumnIndex("Nome"));
                    String Login = c.getString(c.getColumnIndex("Login"));
                    String Senha = c.getString(c.getColumnIndex("Senha"));
                    Integer ID = c.getInt(c.getColumnIndex("_id"));
                    Cliente cliente = new Cliente(ID, Nome, Login, Senha);
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

    public void gravarCompra(Carrinho carrinho, Date data){

        Format formatter;
        formatter = new SimpleDateFormat("dd/MM/yy");
        String DataFormatada = formatter.format(data);

        SQLiteDatabase db = getWritableDatabase();
        try {
            ContentValues values = new ContentValues();
            values.put("Situacao", "Em Andamento");
            values.put("Preco", carrinho.calculaValorTotal());
            values.put("Data", DataFormatada);
            values.put("id_cliente", carrinho.getCliente().getID());

            db.insert("Compra", "", values);
            db.delete("Carrinho", null, null);
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            db.close();
        }
    }

    public List<Compra> listarCompras(String id_cliente) {
        SQLiteDatabase db = getReadableDatabase();
        List<Compra> compras = null;
        try {
            Cursor c = db.rawQuery("SELECT Data, Situacao, Preco FROM Compra WHERE id_cliente = ?", new String[] {id_cliente});
            if(c.moveToFirst()){
                compras = new ArrayList<Compra>();

                do {
                    String DataString = c.getString(c.getColumnIndex("Data"));
                    String Situacao = c.getString(c.getColumnIndex("Situacao"));
                    Double Preco = c.getDouble(c.getColumnIndex("Preco"));

                    SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date Data = originalFormat.parse(DataString);

                    Compra compra = new Compra(Situacao, Preco, Data);
                    compras.add(compra);

                } while(c.moveToNext());
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            db.close();
        }
        return compras;
    }

    public List<Produto> listarProdutos(){
        SQLiteDatabase db = getReadableDatabase();
        List<Produto> produtos = null;
        try {
            Cursor c = db.rawQuery("SELECT Nome, Marca, Preco, _id FROM Produto", null);
            if(c.moveToFirst()){
                produtos = new ArrayList<Produto>();
                do {

                    String  Nome = c.getString(c.getColumnIndex("Nome"));
                    String  Marca = c.getString(c.getColumnIndex("Marca"));
                    Double  Preco = c.getDouble(c.getColumnIndex("Preco"));
                    Integer id = c.getInt(c.getColumnIndex("_id"));

                    Produto produto = new Produto(Nome, Marca, Preco, id, 1);
                    produtos.add(produto);

                } while(c.moveToNext());
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            db.close();
        }
        return produtos;
    }

    public void deleteProdutos(){
        SQLiteDatabase db = getWritableDatabase();
        try{
            db.delete("Produto", null, null);
        }
        finally {
            db.close();
        }
    }
}

package com.example.yann.easeychef;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class ReceitaDAO {

    private SQLiteDatabase bancoDeDados;


    public ReceitaDAO(Context context) {
        this.bancoDeDados = (new BancoDeDados(context)).getWritableDatabase();
    }


    public ArrayList<Receita> getReceitas() {
        ArrayList<Receita> receitas = new ArrayList<>();

    String sqlQuery = "SELECT * FROM receita ";

    Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

    while(cursor.moveToNext()) {
         Receita r  = new Receita();

         r.setIdReceita(cursor.getInt(0));
         r.setNome(cursor.getString(1));
         r.setIngredientes(cursor.getString(2));
         r.setDescricao(cursor.getString(3));
         r.setModoPreparo(cursor.getString(4));
         r.setTempoPreparo(cursor.getInt(5));

         receitas.add(r);

    }
        cursor.close();
        return receitas;
    }

    public ArrayList<Receita> getReceitasByCategorias(String categoria) {
        ArrayList<Receita> receitas = new ArrayList<>();

        String sqlQuery = "SELECT * FROM receita " +
                "WHERE receita.categoria = '"+categoria+"'";

        Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

        while(cursor.moveToNext()) {
            Receita r  = new Receita();

            r.setIdReceita(cursor.getInt(0));
            r.setNome(cursor.getString(1));
            r.setIngredientes(cursor.getString(2));
            r.setDescricao(cursor.getString(3));
            r.setModoPreparo(cursor.getString(4));
            r.setTempoPreparo(cursor.getInt(5));

            receitas.add(r);

        }
        cursor.close();
        return receitas;
    }


    public int getReceitasTotal() {
        String sqlQuery = "SELECT COUNT(*) FROM receita ";

        Cursor cursor = this.bancoDeDados.rawQuery(sqlQuery, null);

        int result = 0;
        if(cursor.moveToNext()){
            result = cursor.getInt(0);
        }
        return result;
    }


    public boolean addReceita(Receita receita){
        try {
            String sqlCmd = "INSERT INTO receita(nome, ingredientes, descricao, modo_preparo, tempo_preparo, categoria)" +
                    " VALUES ('" +
                    receita.getNome()+ "'," + " '" +receita.getIngredientes() + "'," + " '" +receita.getDescricao() + "', '" +
                    receita.getModoPreparo() + "', " + receita.getTempoPreparo() + ", '"+receita.getCategoria()+"')";
            this.bancoDeDados.execSQL(sqlCmd);
            return true;
        }
        catch (SQLException e) {
            Log.e("EasyChefBD", e.getMessage());
            return false;
        }

    }

}

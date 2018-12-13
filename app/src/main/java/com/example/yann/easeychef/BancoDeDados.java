package com.example.yann.easeychef;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BancoDeDados extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 4;

    public static final String DATABASE_NAME = "easychef.db";

    private static final String SQL_CREATE_TABLES = "CREATE TABLE receita(" +
            " id  INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,   nome  VARCHAR(100) NOT NULL,"  +
            " ingredientes  TEXT NOT NULL,    descricao  TEXT NOT NULL," +
            " modo_preparo  TEXT NOT NULL,    tempo_preparo  INT(11) NOT NULL,"+
            " teor_calorico  INT(11) DEFAULT NULL,    avaliacao  INT(5) DEFAULT NULL, categoria  VARCHAR,"+
            " observacoes  TEXT)";
    private static final String SQL_POPULATE_TABLES = "INSERT INTO receita(nome, ingredientes, descricao, modo_preparo, tempo_preparo, categoria) " +
            "VALUES ('Camarao', 'Camaroes', 'Muito bacana', 'Fritar Camaroes', 20, 'Entradas'), ('Arroz', '1kg de Arroz - Alho', 'Muito Bom', 'Cozinhar o Arroz', 30, 'Salgados')";


    private static final String SQL_DELETE_TABLES = "DROP TABLE IF EXISTS receita";


    public BancoDeDados(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLES);
        db.execSQL(SQL_POPULATE_TABLES);
    }


    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_TABLES);
        onCreate(db);
    }
}
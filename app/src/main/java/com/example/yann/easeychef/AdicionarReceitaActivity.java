package com.example.yann.easeychef;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AdicionarReceitaActivity extends AppCompatActivity {

    private Button salvarReceita;

    private EditText editNome;
    private EditText editDescricao;
    private EditText editIngredientes;
    private EditText editModoPreparo;
    private EditText editTempoPreparo;
    private Spinner spinnerCategorias;

    private String[] items = new String[] {
            "Entradas", "Carnes", "Aves", "Salgados", "Doces", "Vegetariano"
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_receita);

        salvarReceita = findViewById(R.id.buttonSalvar);


        spinnerCategorias = findViewById(R.id.spinnerCategorias);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);

        spinnerCategorias.setAdapter(adapter);

        editNome = findViewById(R.id.editTextNomeReceita);
        editDescricao = findViewById(R.id.editTextDescricao);
        editIngredientes = findViewById(R.id.editTextIngredientes);
        editModoPreparo = findViewById(R.id.editTextModoPreparo);
        editTempoPreparo = findViewById(R.id.editTextTempoPreparo);

        final ReceitaDAO receitaDAO = new ReceitaDAO(this);

        salvarReceita.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        if(!(editNome.getText().toString().equals("") || editDescricao.getText().toString().equals("") || editIngredientes.getText().toString().equals("") ||
                                editIngredientes.getText().toString().equals("") || editModoPreparo.getText().toString().equals("")
                                || editTempoPreparo.getText().toString().equals("") )){
                        Receita r = new Receita(editNome.getText().toString(),editIngredientes.getText().toString(),
                                editDescricao.getText().toString(),editModoPreparo.getText().toString(),"","",
                                Integer.parseInt(editTempoPreparo.getText().toString()),0,0);

                        r.setCategoria(spinnerCategorias.getSelectedItem().toString());

                        boolean resp = receitaDAO.addReceita(r);
                            if (resp) {
                                Toast.makeText(getApplicationContext(),"Receita Criada",Toast.LENGTH_LONG).show();
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Erro ", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Preencha os Campos Obrigatorios", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
        );
    }
}

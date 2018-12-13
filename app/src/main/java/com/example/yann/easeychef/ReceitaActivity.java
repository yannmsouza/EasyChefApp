package com.example.yann.easeychef;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ReceitaActivity extends AppCompatActivity {


    private Button voltarBttn;

    private TextView textNome;
    private TextView textDescricao;
    private TextView textIngredientes;
    private TextView textModoPreparo;
    private TextView textTempoPreparo;
    private TextView textTeorCal;
    private TextView textAvaliacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receita);

        textNome = findViewById(R.id.textViewNome);
        textDescricao = findViewById(R.id.textViewDescricao);
        textIngredientes = findViewById(R.id.textViewIngredientes);
        textModoPreparo = findViewById(R.id.textViewModoPreparo);
        textTempoPreparo = findViewById(R.id.textViewTempoPreparo);
        textTeorCal = findViewById(R.id.textViewTeor);
        textAvaliacao = findViewById(R.id.textViewAvaliacao);

        Bundle dados = getIntent().getExtras();

        Receita receita = (Receita) dados.getSerializable("receita");


        textNome.setText(receita.getNome());
        textDescricao.setText(receita.getDescricao());
        textIngredientes.setText(receita.getIngredientes());
        textModoPreparo.setText(receita.getModoPreparo());

        textTeorCal.setText(Integer.toString(receita.getTeorCal()));

        textTempoPreparo.setText(Integer.toString(receita.getTempoPreparo()));

        textAvaliacao.setText(Integer.toString(receita.getAvaliacao()));




        voltarBttn = findViewById(R.id.buttonVoltar);


        voltarBttn.setOnClickListener(

                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );



    }
}

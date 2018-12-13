package com.example.yann.easeychef;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;


public class HomeActivity extends AppCompatActivity {


    private ListView listReceitas;

    private FloatingActionButton addReceitaBttn;

    private ArrayList<Receita> receitas;

    private TextView mensagem;


    private TextView relatorio;

    private String[] listCategorias = new String[] {
            "Entradas", "Carnes", "Aves", "Salgados", "Doces", "Vegetariano"
    };





    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;

    {
        mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.navigation_home:
                        showReceitas();
                        return true;
                    case R.id.navigation_categorias:
                        showCategorias();
                        return true;
                    case R.id.navigation_relatorios:
                        showRelatorios();
                        return true;
                }
                return false;
            }
        };
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        ReceitaDAO receitaDAO = new ReceitaDAO(this);

        receitas = receitaDAO.getReceitas();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);


        listReceitas = findViewById(R.id.listReceitas);

        relatorio = findViewById(R.id.textViewRelatorio);
        relatorio.setVisibility(View.INVISIBLE);

        //Criar Adaptador da Lista

        listReceitas.setVisibility(View.VISIBLE);


        ArrayAdapter<Receita> adapter = new ArrayAdapter<Receita>(getApplicationContext(),R.layout.item_receita_list,R.id.text1, receitas);

        listReceitas.setAdapter(adapter);


        //Criar Adaptador da Lista

        clickReceita();
        setMensagem();


        addReceitaBttn = findViewById(R.id.addReceita);
        addReceitaBttn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getApplicationContext(), AdicionarReceitaActivity.class);
                        startActivity(intent);
                    }
                }
        );

        }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {

        super.onResume();

        ReceitaDAO receitaDAO = new ReceitaDAO(this);

        receitas = receitaDAO.getReceitas();

        listReceitas = findViewById(R.id.listReceitas);

        //Criar Adaptador da Lista

        relatorio = findViewById(R.id.textViewRelatorio);
        relatorio.setVisibility(View.INVISIBLE);


        ArrayAdapter<Receita> adapter = new ArrayAdapter<Receita>(getApplicationContext(),R.layout.item_receita_list,R.id.text1, receitas);

        listReceitas.setAdapter(adapter);
        clickReceita();
        setMensagem();


    }


    protected void showReceitas(){


        relatorio = findViewById(R.id.textViewRelatorio);
        relatorio.setVisibility(View.INVISIBLE);

        ReceitaDAO receitaDAO = new ReceitaDAO(this);

        receitas = receitaDAO.getReceitas();

        listReceitas = findViewById(R.id.listReceitas);

        listReceitas.setVisibility(View.VISIBLE);

        //Criar Adaptador da Lista

        ArrayAdapter<Receita> adapter = new ArrayAdapter<Receita>(getApplicationContext(),R.layout.item_receita_list,R.id.text1, receitas);

        listReceitas.setAdapter(adapter);

        clickReceita();
        setMensagem();

    }

    protected void showCategorias(){

        final ReceitaDAO receitaDAO = new ReceitaDAO(this);

        listReceitas = findViewById(R.id.listReceitas);

        listReceitas.setVisibility(View.VISIBLE);

        relatorio = findViewById(R.id.textViewRelatorio);
        relatorio.setVisibility(View.INVISIBLE);


        //Criar Adaptador da Lista

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.item_receita_list,R.id.text1, listCategorias);

        listReceitas.setAdapter(adapter);

        listReceitas.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        receitas = receitaDAO.getReceitasByCategorias(listCategorias[position]);

                        ArrayAdapter<Receita> adapter = new ArrayAdapter<Receita>(getApplicationContext(),R.layout.item_receita_list,R.id.text1, receitas);

                        listReceitas.setAdapter(adapter);


                        clickReceita();
                        setMensagem();

                    }
                }
        );
    }


    protected void clickReceita(){
        listReceitas.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(getApplicationContext(), ReceitaActivity.class);

                        intent.putExtra("receita", (Receita) listReceitas.getItemAtPosition(position));

                        startActivity(intent);
                    }
                }
        );
    }

    protected void setMensagem(){

        mensagem = findViewById(R.id.textViewMensagem);

        if(receitas.size() == 0){
            mensagem.setText("Nenhuma Receita");
            mensagem.setVisibility(View.VISIBLE);
        } else {
            mensagem.setVisibility(View.INVISIBLE);
        }
    }

    protected void showRelatorios(){

        mensagem = findViewById(R.id.textViewMensagem);

        listReceitas = findViewById(R.id.listReceitas);

        listReceitas.setVisibility(View.INVISIBLE);

        ReceitaDAO receitaDAO = new ReceitaDAO(this);

        int result = receitaDAO.getReceitasTotal();

        relatorio = findViewById(R.id.textViewRelatorio);
        relatorio.setVisibility(View.VISIBLE);

        relatorio.setText("Total Receitas: "+ result);

    }



}

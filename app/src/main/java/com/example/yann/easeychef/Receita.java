package com.example.yann.easeychef;


import java.io.Serializable;

public class Receita implements Serializable {

    private int idReceita;
    private String nome;
    private String ingredientes;
    private String descricao;
    private String modoPreparo;
    private String observacoes;
    private String categoria;
    private int tempoPreparo;
    private int teorCal;
    private int avaliacao;
    private int idUsuario;
    private int idCategoria;


    Receita(){
    }

    Receita(int id, String nome, String ingredientes, String descricao, String modoPreparo, String observacoes,
            String categoria, int tempoP, int teorCal, int avalicao) {
        setIdReceita(id);
        setNome(nome);
        setIngredientes(ingredientes);
        setDescricao(descricao);
        setModoPreparo(modoPreparo);
        setObservacoes(observacoes);
        if (categoria != null) {
            setCategoria(categoria);
        }
        setTempoPreparo(tempoP);
        setTeorCal(teorCal);
        setAvaliacao(avalicao);
    }

    Receita(String nome, String ingredientes, String descricao, String modoPreparo, String observacoes,
            String categoria, int tempoP, int teorCal, int avalicao) {
        setNome(nome);
        setIngredientes(ingredientes);
        setDescricao(descricao);
        setModoPreparo(modoPreparo);
        setObservacoes(observacoes);
        if (categoria != null) {
            setCategoria(categoria);
        }
        setTempoPreparo(tempoP);
        setTeorCal(teorCal);
        setAvaliacao(avalicao);
    }

    Receita(int id, String nome, String ingredientes, String descricao, String modoPreparo, int tempoP) {
        setIdReceita(id);
        setNome(nome);
        setIngredientes(ingredientes);
        setDescricao(descricao);
        setModoPreparo(modoPreparo);

        setTempoPreparo(tempoP);
    }

    public int getIdReceita() {
        return idReceita;
    }

    public void setIdReceita(int idReceita) {
        this.idReceita = idReceita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getModoPreparo() {
        return modoPreparo;
    }

    public void setModoPreparo(String modoPreparo) {
        this.modoPreparo = modoPreparo;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public int getTempoPreparo() {
        return tempoPreparo;
    }

    public void setTempoPreparo(int tempoPreparo) {
        this.tempoPreparo = tempoPreparo;
    }

    public int getTeorCal() {
        return teorCal;
    }

    public void setTeorCal(int teorCal) {
        this.teorCal = teorCal;
    }

    public int getAvaliacao() {
        return avaliacao;
    }

    public void setAvaliacao(int avaliacao) {
        this.avaliacao = avaliacao;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }


    public String toString() {
        String s = getIdReceita() + " | "+ getNome() + ", "+ getDescricao() + ", "+ getIngredientes() + ", "+
                 getTempoPreparo() + "min, "+ getTeorCal()
                + ", "+  getCategoria() + ", "+ getAvaliacao();
        s = s.replaceAll("null", "");
        s = s.replaceAll("0", "");
        s = s.replaceAll(", ,", "");
        s = s.replaceAll(",,", "");
        s = s.replaceAll(" ,", "");

        return s;
    }

}

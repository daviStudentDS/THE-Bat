package com.example.apptheb;

public class Personagem {
    private int _id;
    private String nome;
    private String nomeReal;
    private String primeiroQuadrinho;

    public Personagem(String nome, String nomeReal, String primeiroQuadrinho){
        this.nome = nome;
        this.nomeReal = nomeReal;
        this.primeiroQuadrinho = primeiroQuadrinho;
    }

    public Personagem(int id, String nome, String nomeReal, String primeiroQuadrinho){
        this._id = id;
        this.nome = nome;
        this.nomeReal = nomeReal;
        this.primeiroQuadrinho = primeiroQuadrinho;
    }

    // GETs E SETs

    public int getID(){ return this._id; }

    public void setNome(String newNome){
        this.nome = newNome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNomeReal(String newNomeReal){ this.nomeReal = newNomeReal; }

    public String getNomeReal(){
        return this.nomeReal;
    }

    public void setPrimeiroQuadrinho(String newPrimeiroQuadrinho){
        this.primeiroQuadrinho = newPrimeiroQuadrinho;
    }

    public String getPrimeiroQuadrinho(){
        return this.primeiroQuadrinho;
    }

}

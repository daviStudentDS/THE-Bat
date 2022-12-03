package com.example.apptheb;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

public class Personagem implements Serializable {
    private int _id;
    private String alterEgo;
    private String nome;
    private String primeiroQuadrinho;
    private boolean isHeroi;

    public Personagem(){
        this._id = -1;
        this.nome = "";
        this.alterEgo = "";
        this.primeiroQuadrinho = "";
        this.isHeroi = false;
    }

    public Personagem(String nome, String nomeReal, String primeiroQuadrinho, boolean isHeroi){
        this.alterEgo = nome;
        this.nome = nomeReal;
        this.primeiroQuadrinho = primeiroQuadrinho;
        this.isHeroi = isHeroi;
    }

    public Personagem(int id, String nome, String nomeReal, String primeiroQuadrinho, boolean isHeroi){
        this._id = id;
        this.alterEgo = nome;
        this.nome = nomeReal;
        this.primeiroQuadrinho = primeiroQuadrinho;
        this.isHeroi = isHeroi;
    }

    // GETs E SETs

    public int getID(){ return this._id; }

    public void setID(int id){this._id = id;}

    public void setAlterEgo(String newNome){
        this.alterEgo = newNome;
    }

    public String getAlterEgo(){
        return this.alterEgo;
    }

    public void setNome(String newNomeReal){ this.nome = newNomeReal; }

    public String getNome(){
        return this.nome;
    }

    public void setHeroi(boolean isHeroi){ this.isHeroi = isHeroi; }

    public boolean getHeroi(){
        return this.isHeroi;
    }

    public void setPrimeiroQuadrinho(String newPrimeiroQuadrinho){
        this.primeiroQuadrinho = newPrimeiroQuadrinho;
    }

    public String getPrimeiroQuadrinho(){
        return this.primeiroQuadrinho;
    }

    public JSONObject getJsonObject(){
        JSONObject obj = new JSONObject();
        try {
            obj.put("id", this._id);
            obj.put("nome", this.nome);
            obj.put("alter_ego", this.alterEgo);
            obj.put("primeiro_quadrinho", this.primeiroQuadrinho);
            obj.put("is_heroi", this.isHeroi);
        }
        catch (JSONException e){
        }
        return obj;

    }
}

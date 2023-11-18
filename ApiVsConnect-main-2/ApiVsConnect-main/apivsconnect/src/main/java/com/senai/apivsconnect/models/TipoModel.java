package com.senai.apivsconnect.models;

public enum TipoModel {
    ADMIN("admin"),
    DESENVOLVEDOR("dev"),
    CLIENTE("cliente");

    private String tipo;

    TipoModel(String tipoRecebido){
        this.tipo = tipoRecebido;
    }

    public String getRole(){
        return tipo;
    }
}

package com.senai.apivsconnect.models;

public enum TipoModel {
    ADMIN("admin"),
    DESENVOLVEDOR("dev"),
    CLIENTE("cliente");

    private String tipo;

    TipoModel(String tipo) {
        this.tipo = tipo;
    }
    public String getRole() {
        return tipo;
    }
}

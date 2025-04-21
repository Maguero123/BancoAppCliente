package com.banco.app.Model;

public class Usuario {
    private String username;
    private String password;
    private Cliente cliente;

    public Usuario(String username, String password, Cliente cliente) {
        this.username = username;
        this.password = password;
        this.cliente = cliente;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public Cliente getCliente() {
        return cliente;
    }
}

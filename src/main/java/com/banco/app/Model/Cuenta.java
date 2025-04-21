package com.banco.app.Model;

import java.util.ArrayList;
import java.util.List;

public class Cuenta {
    private String cbu;
    private Cliente cliente;
    private String tipo;
    private double saldo;
    private List<Movimiento> movimientos = new ArrayList<>();

    public Cuenta(String cbu, Cliente cliente, String tipo, double saldo) {
        this.cbu = cbu;
        this.cliente = cliente;
        this.tipo = tipo;
        this.saldo = saldo;
    }

    public String getCbu() {
        return cbu;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getTipo() {
        return tipo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double monto) {
        this.saldo += monto;
    }

    public boolean extraer(double monto) {
        if (monto > saldo) return false;
        saldo -= monto;
        return true;
    }

    public void agregarMovimiento(Movimiento movimiento) {
        movimientos.add(movimiento);
    }

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    @Override
    public String toString() {
        return tipo + " - " + cbu;
    }
}

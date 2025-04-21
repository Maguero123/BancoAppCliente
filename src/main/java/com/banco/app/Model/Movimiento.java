package com.banco.app.Model;

import java.time.LocalDateTime;

public class Movimiento {
    private Cuenta cuenta;
    private String tipo;
    private double monto;
    private String descripcion;
    private LocalDateTime fechaHora;

    public Movimiento(Cuenta cuenta, String tipo, double monto, String descripcion) {
        this.cuenta = cuenta;
        this.tipo = tipo;
        this.monto = monto;
        this.descripcion = descripcion;
        this.fechaHora = LocalDateTime.now();
    }

    public Cuenta getCuenta() {
        return cuenta;
    }

    public String getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    @Override
    public String toString() {
        return fechaHora + " - " + tipo + ": $" + monto + " (" + descripcion + ")";
    }
}

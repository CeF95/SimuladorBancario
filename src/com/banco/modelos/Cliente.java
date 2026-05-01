package com.banco.modelos;

public class Cliente {
    public String nombre;
    public String dpi;

    public Cliente(String nombre, String dpi) {
        this.nombre = nombre;
        this.dpi = dpi;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + "[DPI: " + dpi + "]";
    }
}
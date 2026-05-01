package com.banco.modelos;

public class Cliente {
    public Integer id;
    public String nombre;
    public String servicio;

    public Cliente(Integer id, String nombre, String servicio) {
        this.id = id;
        this.nombre = nombre;
        this.servicio = servicio;
    }

    @Override
    public String toString() {
        return "Cliente: " + nombre + "[Servicio: " + servicio + ", ID: " + id + "]";
    }
}
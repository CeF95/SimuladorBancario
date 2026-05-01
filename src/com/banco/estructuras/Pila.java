package com.banco.estructuras;

import com.banco.modelos.Cliente;
import com.banco.modelos.Nodo;

public class Pila {
    private Nodo tope;

    public void apilar(Cliente c) {
        Nodo nuevo = new Nodo(c);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public Cliente verTope() {
        return (tope != null) ? tope.cliente : null;
    }

    public void mostrar() {
        Nodo temp = tope;
        if (temp == null) 
            System.out.println("La pila está vacía.");
        while (temp != null) {
            System.out.println(temp.cliente);
            temp = temp.siguiente;
        }
    }
}

package com.banco.estructuras;

import com.banco.modelos.Cliente;
import com.banco.modelos.Nodo;

public class Cola {
    private Nodo frente, finalCola;

    public void encolar(Cliente c) {
        Nodo nuevo = new Nodo(c);
        if (frente == null) {
            frente = nuevo;
        } else {
            finalCola.siguiente = nuevo;
        }
        finalCola = nuevo;
    }

    public Cliente desencolar() {
        if (frente == null) return null;
        Cliente c = frente.cliente;
        frente = frente.siguiente;
        if (frente == null) finalCola = null;
        return c;
    }
        
    public void mostrar() {
        Nodo temp = frente;
        if (temp == null) 
            System.out.println("La cola está vacía.");
        while (temp != null) {
            System.out.println(temp.cliente);
            temp = temp.siguiente;
        }
    }

    public boolean estaVacia() {
        return frente == null;
    }
}

package com.banco.principal;

import com.banco.estructuras.Cola;
import com.banco.estructuras.Pila;
import com.banco.modelos.Cliente;
import java.util.Scanner;
import java.io.*;

public class SimuladorBancario {
    private static Cola colaClientes = new Cola();
    private static Pila historialAtencion = new Pila();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        do {
            System.out.println("\n--- SIMULADOR DE COLA BANCARIA ---");
            System.out.println("1. Cargar clientes desde archivo");
            System.out.println("2. Agregar cliente manualmente");
            System.out.println("3. Atender cliente (desencolar y aplicar)");
            System.out.println("4. Mostrar cola de clientes");
            System.out.println("5. Mostrar historial de atención");
            System.out.println("6. Consultar ultimo atendido (tope de pila)");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            scanner.nextLine(); 


    }
    
}

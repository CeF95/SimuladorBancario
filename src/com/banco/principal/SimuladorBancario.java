package com.banco.principal;

import com.banco.estructuras.Cola;
import com.banco.estructuras.Pila;
import com.banco.modelos.Cliente;
import java.util.Scanner;
import java.io.*;

public class SimuladorBancario {
    private static Cola colaClientes = new Cola();
    private static Pila historialAtencion = new Pila();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int opcion;
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
            opcion = sc.nextInt();
            sc.nextLine(); 

            switch (opcion) {
                case 1:
                    cargarClientesDesdeArchivo();
                    break;
                case 2:
                    agregarClienteManualmente();
                    break;
                case 3:
                    atenderCliente();
                    break;
                case 4:
                    System.out.println("\n--- COLA DE CLIENTES ---");
                    colaClientes.mostrar();
                    break;
                case 5:
                    System.out.println("\n--- HISTORIAL DE ATENCIÓN ---");
                    historialAtencion.mostrar();
                    break;
                case 6:
                    Cliente ultimoAtendido = historialAtencion.verTope();
                    if (ultimoAtendido != null) {
                        System.out.println("Último cliente atendido: " + ultimoAtendido);
                    } else {
                        System.out.println("No se ha atendido a ningún cliente aún.");
                    }
                    break;
                case 0:
                    System.out.println("Saliendo del simulador...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");   
            }
        } while (opcion != 0);
    }

    private static void cargarClientesDesdeArchivo() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/clientes.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                   colaClientes.encolar(new Cliente(datos[0].trim(), datos[1].trim()));
                }
            }
            System.out.println("Clientes cargados exitosamente desde el archivo.");
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
    
    private static void agregarClienteManualmente() {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = sc.nextLine();
        System.out.print("Ingrese el DPI del cliente: ");
        String dpi = sc.nextLine();
        Cliente nuevoCliente = new Cliente(nombre, dpi);
        colaClientes.encolar(nuevoCliente);
        System.out.println("Cliente agregado a la cola.");

        try (PrintWriter pw = new PrintWriter(new FileWriter("data/manuales.txt", true))) {
            pw.println(nombre + "," + dpi);
            System.out.println("Cliente encolado y registrado en manuales.txt");
        } catch (IOException e) {
            System.out.println("No se pudo escribir en el archivo de manuales, pero el cliente está en cola: " + e.getMessage());
        }
    }

    private static void atenderCliente() {
        if (colaClientes.estaVacia()) {
            System.out.println("No hay clientes en la cola para atender.");
            return;
        }
        Cliente clienteAtendido = colaClientes.desencolar();
        historialAtencion.apilar(clienteAtendido);
        System.out.println("Cliente atendido: " + clienteAtendido);
    }
}


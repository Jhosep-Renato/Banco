package main;

import domain.Cliente;
import domain.Operacion;
import domain.TipoOperacion;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dni, password;
        Operacion op;
        TipoOperacion operacion = null;

        Cliente cliente1 = new Cliente("123", "Jhosep", "jhosep123");
        Cliente cliente2 = new Cliente("456", "Kiyotaka", "kei123");

        ArrayList<Cliente> clientes = new ArrayList<>();
        clientes.add(cliente1);
        clientes.add(cliente2);

        System.out.print("Ingrese el dni: ");
        dni = sc.next();

        System.out.print("\nIngrese el password: ");
        password = sc.next();

        for (Cliente cliente : clientes) {
            if (dni.equalsIgnoreCase(cliente.getDni()) && password.equalsIgnoreCase(cliente.getPassword())) {
                while (operacion != TipoOperacion.SALIR) {
                    System.out.println("[1]Deposito");
                    System.out.println("[2]Retiro");
                    System.out.println("[3]Consulta de saldo");
                    System.out.println("[4]Salir");
                    operacion = TipoOperacion.values()[sc.nextInt() - 1];

                    switch (operacion) {
                        case DEPOSITO:
                            System.out.print("Ingrese el monto: ");
                            double monto = sc.nextDouble();
                            op = new Operacion(cliente.getDni(), operacion, monto);
                            op.deposito(cliente);
                            break;

                        case RETIRO:
                            System.out.print("Ingrese el monto: ");
                            monto = sc.nextDouble();
                            op = new Operacion(cliente.getDni(), operacion, monto);
                            op.retiro(cliente);
                            break;

                        case CONSULTA_SALDO:
                            System.out.println(cliente);
                            break;

                        case SALIR:
                            break;

                        default:
                            System.out.println("Ingrese la opcion correcta");
                    }
                }
            }
        }
    }
}

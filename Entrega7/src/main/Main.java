package main;

import java.util.Scanner;

import ejercicio1.Ejercicio1;
import ejercicio2.Ejercicio2;
import ejercicioBarcos.Ejercicio3;
import ejercicioBarcos.Ejercicio4;


public class Main {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		int opcion;
		Ejercicio1 ejercicio1 = new Ejercicio1();
		Ejercicio2 ejercicio2 = new Ejercicio2();
		Ejercicio3 ejercicio3 = new Ejercicio3();
		Ejercicio4 ejercicio4 = new Ejercicio4();

		do {
			System.out.println("\nElija una de las opciones: ");
			menu();
			opcion = teclado.nextInt();
			switch (opcion) {
			case 1:
				ejercicio1.juegoDados();
				break;
			case 2:
				ejercicio2.cymClientes(teclado);
				break;
			case 3:
				ejercicio3.juegoBarcos3();
				break;
			case 4:
				ejercicio4.juegoBarcos4();
				break;
			case 5:
				System.out.println("Adiós.");
				break;
			default:
				System.out.println("La opción elegida no existe.");
			} 
		}
		while (opcion != 5);	
	}

    private static void menu() {
        System.out.println("1 - Los dados.");
        System.out.println("2 - Los clientes.");
        System.out.println("3 - Micro guerra de barcos (versión 3).");
        System.out.println("4 - Micro guerra de barcos (versión 4).");
        System.out.println("5 - Salir.");
    }

}

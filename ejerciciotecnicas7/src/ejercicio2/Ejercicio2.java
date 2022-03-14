package ejercicio2;

import java.util.Scanner;

public class Ejercicio2 extends GestorClientes{

	public void cymClientes (Scanner teclado) {
		GestorClientes gc = new GestorClientes();
		Scanner teclado2 = new Scanner(System.in);
		int opcion;
		do {
			System.out.println("\n-- Menú --\n");
			menu();
			opcion = teclado2.nextInt();
			switch (opcion) {
			case 1:
				gc.mostrarClientes();
				break;
			case 2:
				gc.crearCliente(teclado2);
				break;
			case 3:
				System.out.println("Adiós.");
				break;
			default:
				System.out.println("La opción elegida no existe.");
			} 
		}
		while (opcion != 3);	
	}

	private static void menu() {
		System.out.println("1 - Mostrar Clientes");
		System.out.println("2 - Crear un cliente");
		System.out.println("3 - Salir");
	}

}

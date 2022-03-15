package ejercicioBarcos;

import java.util.Scanner;

public class Ejercicio3 extends Cuadricula {

	public void juegoBarcos3() {

		Scanner teclado = new Scanner(System.in);
		int opcion;
		Cuadricula tablero = new Cuadricula();
		boolean juego;

		do {
			System.out.println("\nElija una de las opciones: ");
			menu();
			opcion = teclado.nextInt();
			switch (opcion) {
			case 1:
				tablero.mostrarreglas();
				System.out.println("\n*** En nuestro caso solo habrá un submarino ***");
				break;
			case 2:
				tablero.mostartablero();
				break;
			case 3:
				tablero.mostartablero();
				tablero.depositarBarco(teclado);
				do {
					juego = tablero.disparar(teclado);
					if(juego != true) {
						System.out.println("¡Has fallado, vuelve a intentarlo!");
						tablero.mostartablero();
					}else {
						System.out.println("¡Has hundido el barco!");
						tablero.mostartablero();
					}
				}while(juego != true);
				break;
			case 4:
				System.out.println("Adiós.");
				break;
			default:
				System.out.println("La opción elegida no existe.");
			} 
		}
		while (opcion != 4);	
	}

	private static void menu() {
		System.out.println("1 - Ver las reglas");
		System.out.println("2 - Ver el tablero");
		System.out.println("3 - Jugar a hundir la flota");
		System.out.println("4 - Salir.");
	}

}
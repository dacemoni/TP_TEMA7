import java.util.Scanner;

public class Ejercicio3 extends Cuadricula {

	public void juegoBarcos3() {

		Scanner teclado = new Scanner(System.in);
		int opcion;
		rellenarreglas();
		rellenar();
		rellenartablero();
		
		do {
			System.out.println("\nElija una de las opciones: ");
			menu();
			opcion = teclado.nextInt();
			switch (opcion) {
			case 1:
				mostrarreglas();
				System.out.println("\n*** En nuestro caso solo habrá un submarino ***");
				break;
			case 2:
				mostartablero();
				break;
			case 3:
				disparar(teclado);
				break;
			case 4:
				mostartablero();
				depositarBarco(teclado);
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
		/*
		do {
			try {
				System.out.println("Escoja una fila: ");
				filaSeleccionada = teclado.nextLong();
				System.out.println("Escoja una columna: ");
				columnaSeleccionada = teclado.nextInt() - 1;
				try {
					acierto = tablero.disparar(filaSeleccionada, columnaSeleccionada);
				} catch (IndexOutOfBoundsException e) {
					System.out.println("No se puede seleccionar esa casilla.");
				}
				if (acierto) {
					System.out.println("¡Has acertado!");
					tablero.visualizacion();
				} else {
					System.out.println("Inténtelo de nuevo.");
				}
			} catch (InputMismatchException e) {
				System.out.println("Introduzca caracteres numéricos.");
				teclado.nextLine();
			}
		} while (!acierto);
	}
		 */
	
    private static void menu() {
        System.out.println("1 - Ver las reglas");
        System.out.println("2 - Ver el tablero");
        System.out.println("3 - Jugar a hundir la flota");
        System.out.println("4 - Poner el barco donde quieras");
        System.out.println("5 - Salir.");
    }

}
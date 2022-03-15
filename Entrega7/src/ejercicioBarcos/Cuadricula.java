package ejercicioBarcos;

import java.util.ArrayList;
import java.util.Scanner;

public class Cuadricula {

    private String[][] tablero = new String[11][11];
	private String[] reglas= new String[11];
	public static ArrayList<String> posFinalBarco = new ArrayList<String>();
	public static String user;
	public static int posx;
	public static int posy;

    public Cuadricula() {
    	rellenar();
    	rellenartablero();
    	rellenarreglas();
    }

    public void rellenar(){
    	char caracter = (char)42;
    	for(int i = 0; i < 11; i++){
			for(int o = 0; o < 11; o++){
				tablero[i][o] = Character.toString(caracter);
			}
		}
	}

	public void rellenartablero(){
		int letras = 65;
		int num = 49;
		char numeros = (char)49;
		char letra = (char)65;
		for(int i = 1; i < 11; i++){
			tablero[0][i] = Character.toString(numeros);
			num = num+1;
			numeros = (char)num;
		}
		for(int i = 1; i < 11; i++){
			tablero[i][0] = Character.toString(letra);
			letras = letras+1;
			letra = (char)letras;
		}
		tablero[0][10] = "10";
	}
    
    public void depositarBarco(Scanner teclado) {
		System.out.println("Dime posición para el barco (ejemplo: a2 o B7)");
		teclado.nextLine();
		user = teclado.nextLine();
		posx=letraanum(user);
		posy = Integer.parseInt(user.substring(1));
		if (posx == 0 || posy > 10 ){
			System.out.println("Tienes que introducir una posición válida");
		}
		posFinalBarco.add(user);
    }

    public boolean disparar(Scanner teclado) {
    	System.out.println("Dime posición para hacer un disparo (ejemplo: a2 o D7)");
    	user = teclado.nextLine();
    	posx=letraanum(user);
    	posy = Integer.parseInt(user.substring(1));
    	if (posx == 0 || posy > 10 ){
    		System.out.println("Tienes que introducir una posición válida");
    	}
    	if(user.equals(posFinalBarco.get(0))) {
    		tablero[posx][posy] = "X";
    		return true;
    	}
    	else {
    		tablero[posx][posy] = "~";
    		return false;
    	}
    }

	public static int letraanum(String user){
		if("A".equals(user.substring(0,1)) || "a".equals(user.substring(0,1))){
			return 1;
		}else if("B".equals(user.substring(0,1)) || "b".equals(user.substring(0,1))){
			return 2;
		}else if("C".equals(user.substring(0,1)) || "c".equals(user.substring(0,1))){
			return 3;
		}else if("D".equals(user.substring(0,1)) || "d".equals(user.substring(0,1))){
			return 4;
		}else if("E".equals(user.substring(0,1)) || "e".equals(user.substring(0,1))){
			return 5;
		}else if("F".equals(user.substring(0,1)) || "f".equals(user.substring(0,1))){
			return 6;
		}else if("G".equals(user.substring(0,1)) || "g".equals(user.substring(0,1))){
			return 7;
		}else if("H".equals(user.substring(0,1)) || "h".equals(user.substring(0,1))){
			return 8;
		}else if("I".equals(user.substring(0,1)) || "i".equals(user.substring(0,1))){
			return 9;
		}else if("J".equals(user.substring(0,1)) || "j".equals(user.substring(0,1))){
			return 10;
		}else{
			return 0;
		}
	}

	public void rellenarreglas(){
		reglas[0] = "\nReglas Básicas de la batalla\n";
		reglas[1] = "El objetivo del juego es adivinar donde estan los barcos de tu oponente";
		reglas[2] = "Cuando se te indique que digas una posición, tienes que decir una letra y un numero";
		reglas[3] = "\nSimbología:\n";
		reglas[4] = "* - Cuadro oculto: no se sabe lo que hay, esa posicion no la has dicho";
		reglas[5] = "~ - Esto es agua, has fallado y ahí no hay barco";
		reglas[6] = "+ - Tocado: has dado a un barco, pero no le has hundido";
		reglas[7] = "X - Hundido: cuando hayas tocado por completo al barco, este pasará a estar hundido";
		reglas[8] = "\nFLOTA ENEMIGA:\n";
		reglas[9] = "Un Portaaviones(Ocupa 4 espacios), Dos Acorazados(3 posiciones cada uno)";
		reglas[10] = "Tres Buques(2 posiciones cada uno) y Cuatro Submarinos(1 posicion cada uno)";
	}

	public void mostartablero(){
		System.out.println("\n");
		for(int i = 0; i < 11; i++){
			for(int o = 0; o < 11; o++){
				System.out.print(tablero[i][o] + "    ");
			}
			System.out.println("\n");
		}
	}

	public void mostrarreglas() {
		rellenarreglas();
		for(int i = 0; i < 11; i++){
			System.out.println("\t" + reglas[i]);
		}
	}

}
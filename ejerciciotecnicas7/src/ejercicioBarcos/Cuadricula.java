package ejercicioBarcos;

import java.util.ArrayList;
import java.util.Scanner;

public class Cuadricula {

	ArrayList<Barco> barcos= new ArrayList<Barco>();
	Scanner teclado = new Scanner(System.in);
	public String[][] tablero= new String[11][11];
	public static String[] reglas= new String[11];
	public static ArrayList<String> ocupadas=new ArrayList<String>();
	public static ArrayList<String> repetidas=new ArrayList<String>();
	public static ArrayList<String> posfinal=new ArrayList<String>();
	public static String user;
	public static int posx;
	public static int posy;
	public int intentos = 0;

	public void depositarBarco(Scanner teclado) {
		System.out.println("Dime posicion primero letra y despues numero");
		user = teclado.nextLine();
		posx=letraanum(user);
		posy = Integer.parseInt(user.substring(1));
		String posxy = posx + "," + posy;
		System.out.println(posxy);
		if (posx == 0 || posy > 10 ){
			System.out.println("Tienes que irntroducir una posición válida" + posx + posy);
		}
	}

	public void disparar(Scanner teclado) {
		do{
			System.out.println("Dime posicion primero letra y despues numero");
			user = teclado.nextLine();
			posx=letraanum(user);
			posy = Integer.parseInt(user.substring(1));
			String posxy = posx + "," + posy;
			System.out.println(posxy);
			if (posx == 0 || posy > 10 ){
				System.out.println("Tienes que irntroducir una posición válida" + posx + posy);
			}else{
				boolean comprobacion=false;
				for(int i = 0; i < barcos.size(); i++){
					String barcopos = barcos.get(i).getPosicion();
					if(barcopos.contains(posxy) == true){
						tablero[posx][posy] = "+";
						System.out.println("Bien has dado a un barco");
						comprobacion = true;
						barcos.get(i).tocado(posx, posy);
						if(barcos.get(i).posiciones() == barcos.get(i).getTamano()){
							System.out.println("HUNDIDOOOOO!!");
							System.out.println("Has hundido un "+barcos.get(i).getNombre());
							for(int o = 0; o < barcos.get(i).posicionesx.size(); o++){
								tablero[barcos.get(i).posicionesx.get(o)][barcos.get(i).posicionesy.get(o)] = "X";
							}
							barcos.remove(i);
						}
					}
				}
				if(comprobacion == false){
					System.out.println("Agua");
					tablero[posx][posy] = Character.toString((char)126);
				}
			}
			mostartablero();
			intentos++;
			if(barcos.size() == 0){
				break;
			}
		}while(intentos != 25);
	}

	public void creacionBarcos(Scanner teclado) {
		Scanner teclado1 = new Scanner(System.in);
		int opcion;
		rellenarreglas();
		rellenar();
		rellenartablero();

		do {
			System.out.println("\nElija una de las opciones: ");
			menu2();
			opcion = teclado1.nextInt();
			switch (opcion) {
			case 1:		
				do {
					System.out.println("\n¿Qué tipo de barco quieres crear? ");
					menu3();
					opcion = teclado1.nextInt();
					switch (opcion) {
					case 1:
						for (int i=5;i<9;i++){
							genenarbarcos(1);
							Barco barc=new Barco(1,"Submarino",posfinal.get(i));
							barcos.add(barc);
						}
						break;
					case 2:
						for (int i=2;i<5;i++){
							genenarbarcos(2);
							Barco barc=new Barco(2,"Buque",posfinal.get(i));
							barcos.add(barc);
						}
						break;
					case 3:
						for (int i=0;i<2;i++){
							genenarbarcos(3);
							Barco barc=new Barco(3,"Acorazado",posfinal.get(i));
							barcos.add(barc);
						}
						break;
					case 4:
						genenarbarcos(4);
						Barco barc=new Barco(4,"Portaavion",posfinal.get(9));
						barcos.add(barc);
						break;
					case 5:
						break;
					default:
						System.out.println("La opción elegida no existe.");
					} 
				}
				while (opcion != 5);

				break;
			case 2:
				for (int i=0;i<2;i++){
					genenarbarcos(3);
					Barco barc=new Barco(3,"Acorazado",posfinal.get(i));
					barcos.add(barc);
				}
				for (int i=2;i<5;i++){
					genenarbarcos(2);
					Barco barc=new Barco(2,"Buque",posfinal.get(i));
					barcos.add(barc);
				}
				for (int i=5;i<9;i++){
					genenarbarcos(1);
					Barco barc=new Barco(1,"Submarino",posfinal.get(i));
					barcos.add(barc);
				}
				genenarbarcos(4);
				Barco barc=new Barco(4,"Portaavion",posfinal.get(9));
				barcos.add(barc);
				break;
			case 3:
				break;
			default:
				System.out.println("La opción elegida no existe.");
			} 
		}
		while (opcion != 5);
	}

	private static void menu2() {
		System.out.println("1 - Personalizado (jugarás solo con los tipos de barcos que elijas)");
		System.out.println("2 - Normal (todos los barcos del juego normal)");
		System.out.println("3 - Salir.");
	}
	
	private static void menu3() {
		System.out.println("1 - Submarino");
		System.out.println("2 - Buque");
		System.out.println("3 - Acorazado");
		System.out.println("4 - Portaavion");
		System.out.println("5 - Salir.");
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
		for(int i = 0; i < 11; i++){
			System.out.println("\t" + reglas[i]);
		}
	}

	public static void genenarbarcos(int logitud){
		int x = (int) (Math.random()*10+1);
		int y = (int) (Math.random()*10+1);
		int orientacion = (int) (Math.random()*2+1);
		String orientado = "";
		if(x < 5 && y < 5){
			if(orientacion == 1){
				orientado = "derecha";
			}else{
				orientado = "abajo";
			}
		}else if(x > 5 && y > 5){
			if(orientacion == 1){
				orientado = "izquierda";
			}else{
				orientado = "arriba";
			}
		}else if(x > 5 && y < 5){
			orientado="arriba";
		}else if(x < 5 && y > 5){
			orientado = "abajo";
		}else{
			if(orientacion == 1){
				orientado = "izquierda";
			}else{
				orientado = "arriba";
			}
		}
		generarposiciones(x,y,orientado,logitud);
	}

	public static void generarposiciones(int x, int y, String orientado, int longitud){
		String posicionesfinal = "";
		String posfallidas = "";
		int conterr = 0;
		if(orientado == "derecha"){
			for(int o = y; o < y+longitud; o++){
				if(comprobar(x,o) == true){
					conterr = 1;
					repetidas.add(Integer.toString(x) + "," + Integer.toString(o));
				}else{
					ocupadas.add(Integer.toString(x) + "," + Integer.toString(o));
					posicionesfinal = posicionesfinal+Integer.toString(x) + "," + Integer.toString(o) + " ";
				}
			}
		}
		if(orientado == "izquierda"){
			for(int o = y; o > y-longitud; o--){
				if(comprobar(x,o) == true){
					conterr = 1;
					repetidas.add(Integer.toString(x) + "," + Integer.toString(o));
				}else{
					ocupadas.add(Integer.toString(x) + "," + Integer.toString(o));
					posicionesfinal = posicionesfinal + Integer.toString(x) + "," + Integer.toString(o)+" ";  
				}
			}
		}
		if(orientado == "abajo"){
			for(int o = x; o < x+longitud; o++){
				if(comprobar(o,x) == true){
					conterr = 1;
					repetidas.add(Integer.toString(x) + "," + Integer.toString(o));
				}else{
					ocupadas.add(" " + Integer.toString(o) + "," + Integer.toString(x));
					posicionesfinal = posicionesfinal + Integer.toString(o) + "," + Integer.toString(x) + " ";
				}
			}
		}
		if(orientado == "arriba"){
			for(int o = x; o > x-longitud; o--){
				if(comprobar(o,x) == true){
					conterr = 1;
					repetidas.add(Integer.toString(x) + "," + Integer.toString(o));
				}else{
					ocupadas.add(Integer.toString(o) + ","+Integer.toString(x));
					posicionesfinal = posicionesfinal + Integer.toString(o) + "," + Integer.toString(x) + " "; 
				}
			}
		}
		if (conterr == 1){
			genenarbarcos(longitud);
		}else{
			posfinal.add(posicionesfinal);
		}
	}

	public static boolean comprobar(int x,int o){
		String pos = Integer.toString(x) + "," + Integer.toString(o);
		String pos2 = Integer.toString(x) + "," + Integer.toString(o) + ",";
		String pos3 = " " + Integer.toString(x) + "," + Integer.toString(o) + ",";
		String pos4 = " " + Integer.toString(x) + "," + Integer.toString(o);
		if(ocupadas.contains(pos) == true || ocupadas.contains(pos2) == true || ocupadas.contains(pos3) == true || ocupadas.contains(pos4) == true){
			return true;
		}else{
			return false;
		}
	}

}
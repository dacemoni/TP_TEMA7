package ejercicio1;

public class Ejercicio1 extends Dado{

	public void juegoDados() {
		int suma = 0;
		Dado d6 = new Dado();
		Dado d10 = new Dado(10);
		Dado d12 = new Dado(12);
		do {
			d6.lanzarDado();
			d10.lanzarDado();
			d12.lanzarDado();
			suma = d6.getUltima() + d10.getUltima() + d12.getUltima();
			System.out.println("La suma es: " + suma + "\n");
		} while (suma < 20);
		System.out.println("Acabó el juego.");
	}

}


package principal;

import algoritmos.Algoritmos;
import arbolBinario.*;
import tad.TADVector;

public class Main {
	public static void main(String[] args) {
		long inicio = System.nanoTime();

		ArbolAVL<Persona> arbol = new ArbolAVL<>("Arbol Taller AVL");
		String[] nombres = { "Peter", "Donald", "Hugo", "Paco", "Luis", "Gohan", "Goku", "Piccolo", "Satan", "Krilin" };
		TADVector<Persona> p = new TADVector<>(10, "Vector");

		for (int i = 0; i < nombres.length; i++) {
			p.insertarElemento(new Persona(nombres[i], Algoritmos.cedulaAleatorio(), Algoritmos.aleatorio(18, 50)), i);
			arbol.insertar(p.leerElemento(i));
		}
		System.out.println("\n");

		arbol.info();

		int index = p.buscarElemento2(new Persona("Gohan", "", 0));
		Persona pBuscar = p.leerElemento(index);

		arbol.buscarNodo(pBuscar);

		long fin = System.nanoTime();
		System.out.println("Tiempo Total Ejecucion: " + (fin - inicio) + " [ns]");
	}

}

package principal;

import algoritmos.Algoritmos;
import arbolBinario.*;
import tad.TADVector;

public class Main {
	public static void main(String[] args) {
		Long inicio = System.nanoTime();
		ArbolBB<Persona> abb = new ArbolBB<>("miABB");
		ArbolAVL<Persona> avl = new ArbolAVL<>("Arbol Taller AVL");
		TADVector<Persona> p = new TADVector<>(10, "Vector");
		Persona goku = new Persona("goku", "1234567890", 47);

		String[] nombres = { "Peter", "Donald", "Hugo", "Paco", "Luis", "Gohan", goku.getNombre(), "Piccolo", "Satan" };

		/*
		 * for (int i = 0; i < nombres.length -1 ; i++) {
		 * p.insertarElemento(new Persona(nombres[i], Algoritmos.cedulaAleatorio(),
		 * Algoritmos.aleatorio(18, 50)), i);
		 * arbol.insertar(p.leerElemento(i));
		 * }
		 */

		System.out.println("------Informacion Del Arbol ABB------");
		abb.insertar(new Persona(nombres[0], Algoritmos.cedulaAleatorio(), 30));
		abb.insertar(new Persona(nombres[1], Algoritmos.cedulaAleatorio(), 50));
		abb.insertar(new Persona(nombres[2], Algoritmos.cedulaAleatorio(), 12));
		abb.insertar(new Persona(nombres[3], Algoritmos.cedulaAleatorio(), 11));
		abb.insertar(new Persona(nombres[4], Algoritmos.cedulaAleatorio(), 28));
		abb.insertar(new Persona(nombres[5], Algoritmos.cedulaAleatorio(), 99));

		abb.insertar(goku);
		abb.insertar(new Persona(nombres[7], Algoritmos.cedulaAleatorio(), 65));
		abb.insertar(new Persona(nombres[8], Algoritmos.cedulaAleatorio(), 37));
		abb.info();

		System.out.println("\n");

		// p.insertarElemento(pK); // inserto el ultimo al vector
		// arbol.insertar(pK);

		// muestra la informacion de todo el arbol
		// arbol.info();

		System.out.println("------Informacion Del Arbol AVL------");
		avl.insertar(new Persona(nombres[0], Algoritmos.cedulaAleatorio(), 30));
		avl.insertar(new Persona(nombres[1], Algoritmos.cedulaAleatorio(), 50));
		avl.insertar(new Persona(nombres[2], Algoritmos.cedulaAleatorio(), 12));
		avl.insertar(new Persona(nombres[3], Algoritmos.cedulaAleatorio(), 11));
		avl.insertar(new Persona(nombres[4], Algoritmos.cedulaAleatorio(), 28));
		avl.insertar(new Persona(nombres[5], Algoritmos.cedulaAleatorio(), 99));

		avl.insertar(goku);
		avl.insertar(new Persona(nombres[7], Algoritmos.cedulaAleatorio(), 65));
		avl.insertar(new Persona(nombres[8], Algoritmos.cedulaAleatorio(), 37));
		avl.info();

		rellenarVector(avl, p);

		long inicioBuscar = System.nanoTime();
		int index = 5;
		Persona pBuscar = p.leerElemento(index);
		System.out.println("\nBuscar Nodo Con Dato: " + pBuscar.getNombre());
		System.out.println(avl.buscar(pBuscar));
		long finalBuscar = System.nanoTime();

		long inicioBuscarNoExistente = System.nanoTime();
		System.out.println("\nBuscar Nodo No Existente");
		Persona persona = new Persona("Rogert", "084324564", 24);
		System.out.println(avl.buscar(persona));
		long finalBuscarNoExistente = System.nanoTime();

		System.out.println("\n    ELIMINAR LA RAIZ DEL AVL      \n");
		avl.eliminar(avl.getRaiz().getClave());

		System.out.println("Tiempo De Busqueda De Nodo Existente: " + (finalBuscar - inicioBuscar) + "[Ns]");
		System.out.println("Tiempo De Busqueda De Nodo No Existente: "
				+ (finalBuscarNoExistente - inicioBuscarNoExistente) + "[Ns]");

		long fin = System.nanoTime();
		System.out.println("\nTiempo Total Ejecucion Del Programa: " + (fin - inicio) + " [ns]");
	}

	public static void rellenarVector(ArbolAVL<Persona> arbol, TADVector<Persona> vector) {
		rellenarVectorR(arbol.getRaiz(), vector);
	}

	private static void rellenarVectorR(NodoArbol<Persona> arbol, TADVector<Persona> vector) {
		if (arbol != null) {
			vector.insertarElemento(arbol.getClave());
			rellenarVectorR(arbol.getIz(), vector);
			rellenarVectorR(arbol.getDe(), vector);
		}
	}

}

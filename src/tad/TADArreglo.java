package tad;

import java.util.ArrayList;

public class TADArreglo<T extends Comparable<T>> {
	private ArrayList<T> vector;
	private int longitud;
	private String nombre;
	
	/**
	 * @param vector
	 * @param longitud
	 */
	public TADArreglo(int longitud, String nombre) {
		this.nombre = nombre;
		this.vector = new ArrayList<T>(longitud);
		this.longitud = longitud;
		for(int pos=0; pos<longitud; ++pos)
			vector.add(null);
	}
	
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @return the longitud
	 */
	public int getLongitud() {
		return longitud;
	}
	
	public boolean ingresarElemento(int pos, T dato) {
		boolean resul=false;
		
		if(pos>=0 && pos<longitud && leerElemento(pos)==null) {
			vector.set(pos, dato);
			resul = true;
		}
		return resul;
	}
	
	public boolean ingresarElemento(T dato) {
		boolean resul=false;
		int pos=0;
		
		while(pos<longitud && !resul) {
			if(leerElemento(pos) == null) {
				resul = ingresarElemento(pos, dato);
			}
			else {
				++pos;
			}
		}		
		return resul;
	}
	
	public T leerElemento(int pos) {
		if(pos>=0 && pos<longitud)
			return vector.get(pos);
		else
			return null;
	}
	
	public void imprimirVector() {
		for(T elem : vector) {
			if(elem != null)
				System.out.println(elem);
		}
	}
	
	public void imprimirVectorCompleto() {
		for(int pos=0; pos<longitud; ++pos) {
			System.out.println(pos + ": " + leerElemento(pos));
		}
	}
	
	public int buscarElemento(T dato) {
		int resul = -1;
		
		for(int pos=0; pos<longitud; ++pos) {
			if(dato != null && dato.equals(leerElemento(pos))) {
				resul = pos;
				pos = this.longitud;
			}
		}
		return resul;
	}
	
	public boolean modificarElemento(int pos, T dato) {
		boolean resul=false;
		
		if(pos>=0 && pos<longitud && leerElemento(pos)!=null) {
			vector.set(pos, dato);
			resul = true;
		}
		return resul;
	}
	
	public boolean modificarElemento2(T dato, T datoNuevo) {
		int pos = buscarElemento(dato);
		
		if(pos != -1)
			return modificarElemento(pos, datoNuevo);
		else
			return false;
	}
	
	public boolean eliminarElemento(int pos) {
		return modificarElemento(pos, null);

	}
	
	public boolean eliminarElemento(T dato) {
		return modificarElemento2(dato, null);
	}
	
	
}

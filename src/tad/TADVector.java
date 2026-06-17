package tad;

import java.util.Arrays;

public class TADVector<T> {
	private T[] vector;
	private int longitud;
	private String nombre;
	
	@SuppressWarnings("unchecked")
	public TADVector(int longitud, String nombre) {
		super();
		this.longitud = longitud;
		this.nombre = nombre;
		vector =  (T[]) new Object[longitud];
	}
	
	@Override
	public String toString() {
		return "TADVector [vector=" + Arrays.toString(vector) + ", longitud=" + longitud + ", nombre=" + nombre + "]";
	}


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getLongitud() {
		return longitud;
	}
	
	public void imprimirVector() {
		for(int i=0; i<=vector.length-1; ++i) {
			System.out.println(i+": "+vector[i]);
		}
	}
	
	public void imprimirVector2() {
		for(int i=0; i<=vector.length-1; ++i) {
			if(vector[i]!=null)
				System.out.println(vector[i]);
		}
	}
	
	public boolean insertarElemento(T dato) {
		boolean resul = false;
		for(int pos=0; pos<vector.length; ++pos) {
			if(vector[pos] == null) {
				vector[pos] = dato;
				resul = true;
				pos = vector.length;
			}
		}
		return resul;
	}
	
	public boolean insertarElemento(T dato, int pos) {
		boolean resul = false;
		
		if(pos>=0 && pos<vector.length && vector[pos] == null) {
			vector[pos] = dato;
			resul = true;
		}
		
		return resul;		
	}
	
	public boolean modificarElemento(T datoNuevo, int pos) {
		boolean resul = false;
		
		if(pos>=0 && pos<vector.length && vector[pos] != null) {
			vector[pos] = datoNuevo;
			resul = true;
		}
		
		return resul;
	}
	
	public boolean modificarElemento2(T datoNuevo, T dato) {
		boolean resul = false;
		
		for(int pos=0; pos<vector.length; ++pos) {		
			if(vector[pos].equals(dato)) {
				vector[pos] = datoNuevo;
				resul = true;
				pos = vector.length;
			}
		}
		
		return resul;
	}
	
	public boolean eliminarElemento(int pos) {
		return modificarElemento(null, pos);
	}
		
	public boolean buscarElemento(T dato) {
		boolean resul = false;
		for(int pos=0; pos<vector.length; ++pos) {	
			if(vector[pos].equals(dato)) {
				resul = true;
				pos = vector.length;
			}
		}
		return resul;
	}
	
	/**
	 * Devuelve el elemento almacenado en la posición pos del vector
	 * @param pos Posición del elemento en el vector. Debe ser posición válida.
	 * @return El elemento almacenado en la posición pos del vector
	 */
	public T leerElemento(int pos) {
		if(pos>=0 && pos<vector.length)
			return vector[pos];
		else
			return null;

	}
	
	/**
	 * Devuelve la posición de un elemento (dato) en el vector
	 * @param dato Elemento a buscar en el vector
	 * @return La posición del elemento en el vector o -1 si el elemento no existe
	 */
	public int buscarElemento2(T dato) {
		int resul = -1;
		for(int pos=0; pos<vector.length; ++pos) {
			if(vector[pos]!=null && vector[pos].equals(dato)) {
				resul = pos;
				pos=vector.length;
			}
		}
			
		return resul;
	}
}

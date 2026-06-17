package principal;

public class Persona implements Comparable<Persona> {
    private String nombre;
    private String cedula;
    private int edad;

    public Persona(String nombre, String cedula, int edad) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public String getCedula() {
        return cedula;
    }

    @Override
    public int compareTo(Persona p) {
        if (this.edad < p.edad) {
            return -1; // retorna -1 cuando la edad actual es menor que la otra
        }

        if (this.edad > p.edad) {
            return 1; // retorna 1 cuando la edad actual es mayor que la otra
        }

        // con Strings utilizamos compareTo propio para las condicionales y comparar

        if (this.cedula.compareTo(p.cedula) < 0) {
            return -1; // la cedula va antes
        }

        if (this.cedula.compareTo(p.cedula) > 0) {
            return 1; // la cedula va despues
        }

        return 0; // retorna 0 cuando los dos son iguales osea la misma persona
    }

}

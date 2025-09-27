//==== Clase Nodo para el Árbol Binario ====//

public class Nodo<E> {
    int nombre;    // Nombre del nodo
    E dato;     // Dato del nodo
    Nodo<E> hijoIzquierdo;     // Apuntador al hijo izquierdo
    Nodo<E> hijoDerecho;       // Apuntador al hijo derecho

    public Nodo(int nombre, E dato) { // Constructor
        this.dato = dato;
        this.nombre = nombre;
        this.hijoIzquierdo = null; // Se inicializan como nulos
        this.hijoDerecho = null;
    }
    // Mostrar 
    @Override
    public String toString() {
        return nombre + " - su dato es: " + dato; // Muestra el contenido del nodo
    }
}

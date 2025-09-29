public class MiHashTable<K, V> { // ALMACENA SOCIOS

    private static class Nodo<K, V> {
        K clave;
        V valor;
        Nodo<K, V> siguiente;
        Nodo(K clave, V valor) {
            this.clave = clave;
            this.valor = valor;
        }
    }

    private Nodo<K, V>[] tablaHash;
    private int capacidad;
    private int tamaño;

    // CONSTRUCTOR
    @SuppressWarnings("unchecked")
    public MiHashTable(int capacidadInicial) {
        capacidad = capacidadInicial;
        tablaHash = new Nodo[capacidad]; // Inicializa el arreglo con el tamaño dado
        tamaño = 0;
    }
    public MiHashTable() { // Constructor por defecto
        capacidad = 10; // Capacidad inicial por defecto
        tablaHash = new Nodo[capacidad];
        tamaño = 0;
    }

    private int funcionHash(K clave) { // Obtiene el índice para la HashTable
        int hash = clave.hashCode();
        return Math.abs(hash) % capacidad; // Asegura que el índice sea positivo
    }
    public void put(K clave, V valor) { // Agrega o actualiza un par clave-valor
        int indice = funcionHash(clave);
        Nodo<K, V> actual = tablaHash[indice];

        while (actual != null) {
            if (actual.clave.equals(clave)) {
                actual.valor = valor;
                return;
            }
            actual = actual.siguiente;
        }
        Nodo<K, V> nuevo = new Nodo<>(clave, valor);
        nuevo.siguiente = tablaHash[indice];
        tablaHash[indice] = nuevo;
        tamaño++;
    }
    public V getValue(K clave) { // Obtiene el valor asociado a la clave
        int indice = funcionHash(clave);
        Nodo<K, V> actual = tablaHash[indice];

        while (actual != null) {
            if (actual.clave.equals(clave)) {
                return actual.valor;
            }
            actual = actual.siguiente;
        }
        return null; // No encontrado
    }
    public K getKey(V valor) { // Obtiene la clave asociada a un valor
        for (int i = 0; i < 10; i++) { // Recorre toda la tabla Hash
            Nodo<K, V> actual = tablaHash[i];
            while (actual != null) {
                if (actual.valor.equals(valor)) { // Verifica si el primer elemento de la lista coincide
                    return actual.clave;
                }
                actual = actual.siguiente; // Recorre la lista
            }
        }
        return null; // No encontrado
    }
    public void remove(K clave) { // Elimina un elemento por su clave
        int indice = funcionHash(clave);
        Nodo<K, V> actual = tablaHash[indice];
        Nodo<K, V> anterior = null;

        while (actual != null) {
            if (actual.clave.equals(clave)) {
                if (anterior == null) {
                    tablaHash[indice] = actual.siguiente;
                } else {
                    anterior.siguiente = actual.siguiente;
                }
                tamaño--;
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }
    }
    public boolean containsKey(K clave) {       // Verifica si una clave existe en la tabla
        return getValue(clave) != null;
    }
    public boolean containsValue(V valor) {     // Verifica si un valor existe en la tabla
        return getKey(valor) != null;
    }
    public int size() { return tamaño; }               // Devuelve el número de elementos en la tabla
    public boolean isEmpty() { return tamaño == 0; }   // Verifica si la tabla está vacía
    public void display() { // Muestra el contenido de la tabla Hash
        for (int i = 0; i < capacidad; i++) {
            Nodo<K, V> actual = tablaHash[i];
            if (actual != null) {
                System.out.print("Índice " + i + ": ");
                while (actual != null) {
                    System.out.print("[" + actual.clave + ": " + actual.valor + "] -> ");
                    actual = actual.siguiente;
                }
                System.out.println("null");
            }
        }
    }
    public Integer[] keySet() { // Devuelve un arreglo con todas las claves (asumiendo que K es Integer)
        Integer[] claves = new Integer[tamaño];
        int index = 0;
        for (int i = 0; i < capacidad; i++) {
            Nodo<K, V> actual = tablaHash[i];
            while (actual != null) {
                claves[index++] = (Integer) actual.clave; // Cast a Integer
                actual = actual.siguiente;
            }
        }
        return claves;
    }
}
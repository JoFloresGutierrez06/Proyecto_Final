public class OrdenamientoBusqueda {
    
    // METODOS DE ORDENAMIENTO
    public static void selectionSort(Long[] arreglo, int contISBNs) {   //MÉTODO DE ORDENAMIENTO POR SELECCIÓN

        for (int i = 0; i < contISBNs - 1; i++) {
            for (int j = i + 1; j < contISBNs; j++) {
                if (arreglo[i] > arreglo[j]) {
                    Long temp = arreglo[i];
                    arreglo[i] = arreglo[j];
                    arreglo[j] = temp;
                } 
            }
        }
    }
    public static void bubbleSort(Long[] arreglo, int contISBNs) {      // MÉTODO DE ORDENAMIENTO BURBUJA

        for(int i = 0; i < (contISBNs -1); i++) { // Recorre todos los elementos del arreglo
            for(int j = 0; j < (contISBNs -1 -i); j++) {
                if(arreglo[j] > arreglo[j+1]) { // Si el elemento actual es mayor al siguiente, se intercambian
                    Long temp = arreglo[j]; // Intercambio
                    arreglo[j] = arreglo[j + 1];
                    arreglo[j + 1] = temp; 
                } 
            }
        }
    }

    /********************************************** 
        Nota: Para usar la búsqueda binaria es necesari tener el arreglo ordenado.
        Por eso se invocan los métodos de ordenamiento antes de llamar un método de búsqueda.
    **********************************************/

    // MÉTODOS DE BÚSQUEDA
    public static int busquedaSecuencial(Long[] arreglo, Long valorBuscado, int contISBNs) { // BÚSQUEDA SECUENCIAL
        // Está bien sencillo y bonito este método, pero no es eficiente para arreglos grandes
        for (int i = 0; i < contISBNs; i++) {
            if (arreglo[i] == valorBuscado.longValue()) {
                return i;   // Devuelve el índice donde se encontró el valor
            }
        }
        return -1; // Retorna -1 si no se encontró el valor
    }
    public static int busquedaBinaria(int[] arreglo, int valorBuscado) { // BÚSQUEDA BINARIA
        // Necesitamos que el arreglo esté ordenado, así que usamos un método de ordenamiento antes de usarlo.
        // Arrays.sort(arreglo); // Se puede usar el método Arrays para ordenar el arreglo, pero ese no es el chiste del ejercicio.

        int inicio = 0;                 // Indica el inicio
        int fin = arreglo.length - 1;   // Indica el final

        while (inicio <= fin) {             // Mientras no se llegue al final
            int medio = (inicio + fin) / 2; // Señala la mitad del arreglo

            if (arreglo[medio] == valorBuscado) { // El valor está en la mitad
                return medio; 

            } else if (arreglo[medio] < valorBuscado) {
                inicio = medio + 1; // Buscar en la mitad derecha

            } else {
                fin = medio - 1; // Buscar en la mitad izquierda
            }
        }
        return -1; // Retorna -1 si no se encontró el valor
    }
    public static int busquedaBinariaDYV(Long[] arreglo, Long valorBuscado, int inicio, int fin) { // BÚSQUEDA BINARIA DIVIDE Y VENCERÁS
        // Necesitamos que el arreglo esté ordenado, así que usamos un bubble sort antes de usarlo.

        if (inicio > fin) {
            return -1; // Caso base: no se encontró el valor
        }

        int medio = (inicio + fin) / 2; // Señala la mitad del arreglo

        if (arreglo[medio] == valorBuscado.longValue()) {
            return medio; // El valor está en la mitad

        } else if (arreglo[medio] < valorBuscado) {
            return busquedaBinariaDYV(arreglo, valorBuscado, medio + 1, fin); // Buscar en la mitad derecha

        } else {
            return busquedaBinariaDYV(arreglo, valorBuscado, inicio, medio - 1); // Buscar en la mitad izquierda
        }
    }
}
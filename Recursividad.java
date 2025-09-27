public class Recursividad {

    public static long generarISBN(int contador, String isbn) { // GENERAR ISBN DE 13 DÍGITOS CON RECURSIVIDAD
        if (contador == 13) {
            return Long.parseLong(isbn); // Regresa el ISBN generado, convertido de nuevo a número
        }
        isbn += (int)(Math.random() * 10); // Agrega un dígito aleatorio al ISBN
        return generarISBN(contador + 1, isbn); // Llama recursivamente incrementando el contador
    }
    public static void insertarISBN(Long[] arreglo, int contISBNs) { // Insertar el ISBN generado en el arreglo
        int cont = 0;                                   // Contador para los 13 dígitos del ISBN
        String isbnAux = "";                            // String para ir guardando el ISBN
        long nuevoISBN = generarISBN(cont, isbnAux);    // Genera un nuevo ISBN
        arreglo[contISBNs] = nuevoISBN;           // Inserta el nuevo ISBN en la posición indicada por el contador
        System.out.println("ISBN generado: " + nuevoISBN + " en la posición " + contISBNs);                        // Incrementa el contador para la próxima inserción
    }

}

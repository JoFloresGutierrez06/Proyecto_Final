// ===== Clase principal - Sistema de Gestión Editorial =====//

import java.util.*; // Importamos librerías

public class Main {

    // MENÚS SECUNDARIOS
    public static void menuMonticulo(int seleccion, Objeto[] monticulo) {       // Método para el menú de montículo
        Scanner input = new Scanner(System.in); 
        boolean ciclo = true;
        while (ciclo) {
            System.out.println("\n === 'AGENDAR EVENTO' ===");
            System.out.print("1) Agregar evento a la cola " +           // enqueue
                            "\n2) Mostrar evento actual " +             // front
                            "\n3) Completar evento actual" +            // dequeue
                            "\n4) Mostrar todos los eventos en cola" +  // display
                            "\n5) Volver \n=> ");
            seleccion = input.nextInt();
            input.nextLine(); // limpiar buffer

            switch(seleccion) {
                case 1: // AGREGAR EVENTO (ENQUEUE)
                    System.out.println("Nombre evento: ");
                    String dato = input.nextLine();
                    System.out.println("Prioridad del evento (1 en delante): ");
                    int prioridad = input.nextInt();
                    input.nextLine(); // Limpiar buffer
                    Monticulo.enqueue(new Objeto(dato, prioridad), monticulo); //Crea el objeto, añade los datos y lo agrega al arreglo
                    break;
                case 2: // MOSTRAR EVENTO ACTUAL (FRONT)
                    Monticulo.front(monticulo);
                    break;
                case 3: // COMPLETAR EVENTO ACTUAL (DEQUEUE)
                    Monticulo.dequeue(monticulo);
                    break;
                case 4: // MOSTRAR TODOS LOS EVENTOS EN COLA (DISPLAY)
                    Monticulo.display(monticulo);
                    break;
                case 5: // VOLVER
                    ciclo = false;
                    break;
                default: // VALIDACIÓN DE DATO
                    System.out.println("Opción inválida.");
            } 
        }  
    }
    public static void menuPila(int seleccion, Pila pila) {                     // Método para el menú de pila
        Scanner input = new Scanner(System.in);
        boolean ciclo = true;
        while(ciclo) {
            System.out.println("\n === 'HISTORIAL DE EVENTOS' ===");
            System.out.print("1) Agregar evento al historial " +        // push
                            "\n2) Mostrar evento más reciente " +       // peek
                            "\n3) Borrar evento más reciente" +         // pop
                            "\n4) Mostrar historial de eventos" +       // display
                            "\n5) Volver \n=> ");
            seleccion = input.nextInt();
            input.nextLine(); // limpiar buffer

            switch(seleccion) {
                case 1: // AREGAR EVENTO AL HISTORIAL (PUSH)
                    System.out.print("Ingrese el nombre del evento => ");
                    String dato = input.nextLine();
                    pila.push(dato);
                    break;
                case 2: // MOSTRAR EVENTO MÁS RECIENTE (PEEK)
                    System.out.println("Evento más reciente: " + pila.peek());
                    break;
                case 3: // BORRAR EVENTO MÁS RECIENTE (POP)
                    System.out.println(pila.pop());
                    break;
                case 4: // MOSTRAR HISTORIAL DE EVENTOS (DISPLAY)
                    System.out.println("Historial de eventos:");
                    pila.display();
                    System.out.println();
                    break;
                case 5: // VOLVER
                    ciclo = false;
                    break;
                default: // VALIDAR DATO
                    System.out.println("Opción inválida.");
            }
        }
    }
    public static void menuListaEnlazada(int seleccion, ListaEnlazada<String> listaEnlazada) { // Método para el menú de lista enlazada
        Scanner input = new Scanner(System.in);
        boolean ciclo = true;
        while (ciclo) {
            System.out.println("\n === 'PROPUESTAS DE PROYECTO' ===");
            System.out.print("1) Agregar propuesta " +                  // insert
                            "\n2) Buscar propuesta " +                  // find
                            "\n3) Borrar propuesta" +                   // delete
                            "\n4) Mostrar propuestas" +                 // display
                            "\n5) Volver \n=> ");
            seleccion = input.nextInt();
            input.nextLine(); // limpiar buffer

            switch(seleccion) {
                case 1: // AGREGAR PROPUESTA (insert)
                    System.out.print("Nombre de la propuesta => ");
                    listaEnlazada.insert(input.nextLine());
                    break;
                case 2: // BUSCAR PROPUESTA (find)
                    System.out.print("Nombre de la propuesta a buscar: ");
                    String dato = input.nextLine();

                    if (listaEnlazada.find(dato)) { // Si está el dato es true
                        System.out.println("Propuesta existente. ");
                    } else {
                        System.out.println("No se encuentra la propuesta. ");
                    }
                    break;
                case 3: // BORRAR PROPUESTA (delete)
                    System.out.print("Propuesta a eliminar: ");
                    String datoEliminar = input.nextLine();

                    if(listaEnlazada.delete(datoEliminar)) { // Sí encontró el dato y lo elimina
                        System.out.println("Propuesta eliminada.");
                    } else {
                        System.out.println("Propuesta no encontrada."); // No encontró el dato
                    } 
                    break;
                case 4: // MOSTRAR PROPUESTAS (DISPLAY)
                    System.out.println("Propuestas:");
                    listaEnlazada.display();
                    break;
                case 5: // VOLVER
                    ciclo = false;
                    break;
                default: // VALIDACIÓN DE DATO
                    System.out.println("Opción inválida.");
            }
        }   
    }
    public static void menuArbolBinario(int seleccion, ArbolBinario arbolito) { // Método para el menú de árbol binario
        Scanner input = new Scanner(System.in);
        boolean ciclo = true;
        while (ciclo) {
            System.out.println("\n ==== GESTIÓN DE EMPLEADOS ====");
            System.out.print("1) Agregar empleado \n" +     // insertar
                            "2) Eliminar empleado \n" +     // eliminar
                            "3) Buscar empleado \n" +       // buscar
                            "4) Mostrar empleados \n" +     // mostrar
                            "5) Volver \n" + 
                            "=> ");
            seleccion = input.nextInt();
            input.nextLine(); // Limpiar buffer

            switch(seleccion) {
                case 1: // INSERTAR ELEMENTO
                    System.out.print("Ingrese ID del empleado => ");
                    int id = input.nextInt();
                    input.nextLine(); // Limpiar buffer
                    System.out.println("Ingrese el nombre del empleado: ");
                    String nombre = input.nextLine();
                    arbolito.insertar(id, nombre);
                    break;
                case 2: // ELIMINAR ELEMENTO
                    if (arbolito.estaVacio()) { // Si el árbol está vacío
                        System.out.println("No hay registros existentes.");
                    } else {
                        System.out.print("Ingrese ID del empleado a eliminar => ");
                        id = input.nextInt();
                        input.nextLine(); // Limpiar buffer
                        if (arbolito.eliminar(id)) { // true o false
                            System.out.println("Registro dado de baja exitosamente! ");
                        } else {
                            System.out.println("No fue posible eliminar el registro.");
                        }
                    }
                    break;
                case 3: // BUSCAR ELEMENTO
                    if (arbolito.estaVacio()) { // Si el árbol está vacío
                        System.out.println("No hay registros existentes.");
                    } else {
                        System.out.print("Ingrese ID del empleado a buscar => ");
                        id = input.nextInt();
                        input.nextLine(); // Limpiar buffer
                        if (arbolito.buscar(id)) { // true o false
                            System.out.println("Registro existente. ");
                        } else {
                            System.out.println("Registro no encontrado.");
                        }
                    }
                    break;
                case 4: // MOSTAR ÁRBOL
                    if (arbolito.estaVacio()) { // Si el árbol está vacío
                        System.out.println("No hay registros existentes.");
                    } else {
                        System.out.println("\n ==== Mostrar árbol ====");
                        System.out.print("1) Preorden \n" +
                                            "2) InOrden \n" +
                                            "3) PosOrden \n" +
                                            "4) Volver \n" + 
                                            "=> ");
                        int seleccion2 = input.nextInt();
                        input.nextLine(); // Limpiar buffer
                        switch (seleccion2) {
                            case 1: // PREORDEN
                                arbolito.preorden();
                                break;
                            case 2: // INORDEN
                                arbolito.inorden();
                                break;
                            case 3: // POSORDEN
                                arbolito.posorden();
                                break;
                            case 4: // VOLVER
                                break;
                            default:
                                System.out.println("Opción inválida.");
                        }
                    }  
                    break;
                case 5: // VOLVER
                    ciclo = false;
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        }   
    }
    public static void menuRecursividadOrdenamientoBusqueda(int seleccion, int contISBNs, Long[] isbns) {   // Método para el menú de métodos de ordenamiento/búsqued
        Scanner input = new Scanner(System.in);
        boolean ciclo = true;
        while(ciclo) {
            System.out.println("\n === 'CATÁLOGO OBRAS TERMINADAS' ===");
            System.out.print("1) Generar ISBN " +                       // Recursividad
                            "\n2) Mostrar ISBN registrados " +          // Mostrar arreglo de ISBNs
                            "\n3) Ordenar registros (menor a mayor) " + // Ordenamiento por selección
                            "\n4) Búsqueda secuencial de ISBN " +       // Búsqueda secuencial
                            "\n5) Búsqueda binaria de ISBN " +          // Búsqueda binaria
                            "\n6) Volver \n=> ");
            seleccion = input.nextInt();
            input.nextLine(); // limpiar buffer

            switch(seleccion) {
                case 1: // RECURSIVIDAD
                    System.out.println("\n === 'GENERAR ISBN' ===");
                    if (contISBNs >= isbns.length) { // Si ya se llenó el arreglo
                        System.out.println("No es posible generar más ISBNs.");
                        break;
                    } else {
                        Recursividad.insertarISBN(isbns, contISBNs); // Llama al método para insertar el ISBN en el arreglo y mostrarlo
                        contISBNs++; // Incrementa el contador de ISBNs almacenados
                    }
                    break;
                case 2: // MOSTRAR ARREGLO DE ISBNs
                    System.out.println("\n === 'ISBN REGISTRADOS' ==="); 
                    if (contISBNs == 0) {
                        System.out.println("No hay registros para mostrar.");
                        break;
                    }
                    mostrarArreglo(isbns);
                    break;
                case 3: // ORDENAMIENTO POR SELECCIÓN
                    System.out.println("\n === 'ORDENAR REGISTROS (MENOR A MAYOR)' ===");
                    if (contISBNs == 0) {
                        System.out.println("No hay registros para ordenar.");
                        break;
                    }
                    OrdenamientoBusqueda.selectionSort(isbns, contISBNs); // Llama al método de ordenamiento por selección
                    System.out.println("Registros ordenados: ");
                    mostrarArreglo(isbns);
                    break;
                case 4: // BÚSQUEDA SECUENCIAL
                    System.out.println("\n === 'BÚSQUEDA SECUENCIAL' ===");
                    if (contISBNs == 0) {
                        System.out.println("No hay registros para buscar.");
                        break;
                    }
                    System.out.print("Ingrese el ISBN a buscar => ");
                    Long isbnBuscado = input.nextLong();
                    input.nextLine(); // Limpiar buffer
                    int resultado = OrdenamientoBusqueda.busquedaSecuencial(isbns, isbnBuscado, contISBNs); // Llama al método de búsqueda secuencial
                    if (resultado != -1) { // El método regresa el índice donde se encuentra el elemento
                        System.out.println("ISBN encontrado en la posición: " + resultado);
                    } else { // O un -1 si no se encontró
                        System.out.println("ISBN no encontrado.");
                    }
                    break;
                case 5: // BÚSQUEDA BINARIA
                    System.out.println("\n === 'BÚSQUEDA BINARIA' ===");
                    if (contISBNs == 0) {
                        System.out.println("No hay registros para buscar.");
                        break;
                    }
                    System.out.print("Ingrese el ISBN a buscar => ");
                    isbnBuscado = input.nextLong();
                    input.nextLine(); // Limpiar buffer
                    OrdenamientoBusqueda.bubbleSort(isbns, contISBNs); // Ordena el arreglo antes de buscar
                    resultado = OrdenamientoBusqueda.busquedaBinariaDYV(isbns, isbnBuscado, 0, contISBNs - 1);
                    if (resultado != -1) { // El método regresa el índice donde se encuentra el elemento
                        System.out.println("ISBN encontrado en la posición: " + resultado);
                    } else { // O un -1 si no se encontró
                        System.out.println("ISBN no encontrado.");
                    }
                    break;
                case 6: // VOLVER
                    ciclo = false;
                    break;
                default: // VALIDAR DATO
                    System.out.println("Opción inválida.");
            }
        }
    }
    public static void menuHashTablesHashMap(int seleccion, MiHashTable<Integer, String> tablaHash, HashMap<Integer, String> hashMap) { // Método para el menú de tablas hash y HashMap
        Scanner input = new Scanner(System.in);
        boolean ciclo = true;
        while(ciclo) {
                System.out.println("\n === 'CATÁLOGO GENERAL' ==="); // ==========
            System.out.print("1) Socios \n" +           // Tabla Hash
                            "2) Obras \n" +            // HashMap   
                            "3) Volver \n" +
                            "=> ");
            seleccion = input.nextInt();
            input.nextLine(); // limpiar buffer

            switch(seleccion) {
                case 1: // TABLA HASH - SOCIOS
                    System.out.println("\n === 'SOCIOS' ===");
                    System.out.print("1) Agregar socio " +            // insert
                                    "\n2) Buscar socio " +            // find
                                    "\n3) Borrar socio " +            // delete
                                    "\n4) Mostrar socios " +          // display
                                    "\n5) Volver \n=> ");
                    seleccion = input.nextInt();
                    input.nextLine(); // limpiar buffer

                    switch(seleccion) {
                        case 1: // AGREGAR SOCIO (INSERT)
                            System.out.print("ID del socio => ");
                            int idSocio = input.nextInt();
                            input.nextLine(); // limpiar buffer
                            System.out.print("Nombre del socio => ");
                            String nombreSocio = input.nextLine();
                            tablaHash.put(idSocio, nombreSocio); // La nueva tabla hash
                            System.out.println("Socio agregado.");
                            break;
                        case 2: // BUSCAR SOCIO (FIND)
                            if (tablaHash.isEmpty()) { // Si la tabla está vacía
                                System.out.println("No hay registros existentes.");
                                break;
                            }
                            System.out.print("ID del socio a buscar => ");
                            idSocio = input.nextInt();
                            input.nextLine(); // limpiar buffer
                            if (tablaHash.containsKey(idSocio)) { // Si está el dato es true
                                System.out.println("Socio existente: " + tablaHash.getValue(idSocio));
                                //System.out.println("Socio existente: " + tablaHash.get(idSocio)); // Tabla Hash importada
                            } else {
                                System.out.println("No se encuentra el socio. ");
                            }
                            break;
                        case 3: // BORRAR SOCIO (DELETE)
                            if (tablaHash.isEmpty()) { // Si la tabla está vacía
                                System.out.println("No hay registros existentes.");
                                break;
                            }
                            System.out.print("ID del socio a eliminar => ");
                            idSocio = input.nextInt();
                            input.nextLine(); // limpiar buffer
                            if (tablaHash.containsKey(idSocio)) { // Si está el dato es true
                                tablaHash.remove(idSocio);
                                System.out.println("Socio eliminado.");
                            } else {
                                System.out.println("No se encuentra el socio. ");
                            }
                            break;
                        case 4: // MOSTRAR SOCIOS (DISPLAY)
                            if (tablaHash.isEmpty()) { // Si la tabla está vacía
                                System.out.println("No hay registros existentes.");
                                break;
                            }
                            System.out.println("Socios registrados:");
                            for (Integer key : tablaHash.keySet()) {
                                System.out.println("ID: " + key + " - Nombre: " + tablaHash.getValue(key));
                                //System.out.println("ID: " + key + " - Nombre: " + tablaHash.get(key));
                            }
                            break;
                        case 5: // VOLVER
                            break;
                        default: // VALIDAR DATO
                            System.out.println("Opción inválida.");
                    }
                    break;
                case 2: // HASHMAP - OBRAS
                    System.out.println("\n === 'OBRAS' ===");
                    System.out.print("1) Agregar obra " +           // insert
                                        "\n2) Buscar obra " +          // find
                                        "\n3) Borrar obra " +          // delete
                                        "\n4) Mostrar obras " +        // display
                                        "\n5) Volver \n=> ");
                    seleccion = input.nextInt();
                    input.nextLine(); // limpiar buffer

                    switch (seleccion) {
                        case 1: // AGREGAR OBRA
                            System.out.print("\n¿Es una obra terminada o en proceso? \n(1)Terminada \n(2)En proceso \n=> ");
                            int estadoObra = input.nextInt();
                            input.nextLine(); // limpiar buffer
                            if (estadoObra == 1) { // TERMINADA

                                System.out.print("ISBN de la obra => ");
                                int idObra = input.nextInt();
                                input.nextLine(); // limpiar buffer
                                System.out.print("Nombre de la obra => ");
                                String nombreObra = input.nextLine();
                                hashMap.put(idObra, nombreObra);
                                System.out.println("Obra agregada.");

                            } else if (estadoObra == 2) { // EN PROCESO, SIN ISBN
                                System.out.print("Nombre de la obra => ");
                                String nombreObra = input.nextLine();
                                hashMap.put(null, nombreObra); // Se usa null como key temporal
                                System.out.println("Obra agregada.");
                            } else {
                                System.out.println("Opción inválida.");
                                break;
                            }
                            break;
                        case 2: // BUSCAR OBRA
                            if (hashMap.isEmpty()) { // Si la tabla está vacía
                                System.out.println("No hay registros existentes.");
                                break;
                            }
                            System.out.println("Nombre de la obra a buscar: ");
                            String nombreObra = input.nextLine();
                            if (hashMap.containsValue(nombreObra)) { // Busca por el valor
                                System.out.println("Obra existente: " + nombreObra);
                            } else {
                                System.out.println("No se encuentra la obra.");
                            }
                            break;
                        case 3: // BORRAR OBRA
                            if (hashMap.isEmpty()) { // Si la tabla está vacía
                                System.out.println("No hay registros existentes.");
                                break;
                            }
                            System.out.println("Nombre de la obra a eliminar: ");
                            nombreObra = input.nextLine();
                            if (hashMap.containsValue(nombreObra)) {
                                hashMap.values().remove(nombreObra);
                                System.out.println("Obra eliminada.");
                            } else {
                                System.out.println("No se encuentra la obra.");
                            }
                            break;
                        case 4: // MOSTRAR OBRAS
                            if (hashMap.isEmpty()) { // Si la tabla está vacía
                                System.out.println("No hay registros existentes.");
                                break;
                            }
                            System.out.println("Obras registradas:");
                            for (String obra : hashMap.values()) {
                                System.out.println("Nombre: " + obra);
                            }
                            break;
                        case 5: // VOLVER
                            break;
                        default: // VALIDAR DATO
                            System.out.println("Opción inválida.");
                    }
                    break;
                case 3: // VOLVER
                    ciclo = false;
                    break;
                default: // VALIDAR DATO
                    System.out.println("Opción inválida.");
            }
        }
        
    }

    // MÉTODOS AUXILIARES GENERALES
    public static <E> void mostrarArreglo(E[] arreglo) {        // Método para mostrar arreglos. no imprime null
        for (E elemento : arreglo) {
            if (elemento != null) {
                System.out.print(elemento + " ");
            }
        }
        System.out.println(); // Salto de línea al final
    }
    public static <E> void swap(E[] arreglo, int a, int b) {    //Intercambiar elementos en el arreglo
        E temp = arreglo[a];   // Guardar la referencia al objeto en una variable temporal
        arreglo[a] = arreglo[b];   //Mover al padre al lugar del objeto
        arreglo[b] = temp;     //Mover al objeto al lugar del padre
    }
    public static <E> int getIndex(E objeto, E[] arreglo) {     //Obtener un index del arreglo
        for (int i = 1; i < arreglo.length; i++) {
            if (arreglo[i].equals(objeto)) {     //Comparar si es el mismo objeto en memoria con ==, sino reemplazar con .equals()
                return i; // devuelve el índice
            }
        }
        return -1; //Dará error porque -1 está fuera del rango
    }
    public static <E> int getSize(E[] arreglo) {                // Obtener el num. de elementos reales del arreglo
        int tamano = 0;
        for (E elemento: arreglo) { // Recorre todos los elementos del arreglo
            if (elemento != null) { //Si no está vacío el espacio lo cuentas
                tamano += 1; // Contador que cuenta los elementos reales
            } 
        }
        return tamano;
    }
    

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);                         // Creamos el scanner para leer las entradas
        Objeto[] monticulo = new Objeto[100];                           // Declarar montículo. Le ponemos tamaño grande
        Pila pila = new Pila(100);                             // Creamos una pila
        ListaEnlazada<String> listaEnlazada = new ListaEnlazada<>();    // Creamos una lista enlazada
        ArbolBinario arbolito = new ArbolBinario();                     // Creamos un árbol binario
        //Hashtable<Integer, String> tablaHash = new Hashtable<>();        // Creamos una tabla hash
        MiHashTable<Integer, String> socios = new MiHashTable<>();  // Creamos una tabla hash personalizada
        HashMap<Integer, String> hashMap = new HashMap<>();              // Creamos un HashMap 
        Long isbns[] = new Long[50];                                    // Arreglo de ISBNs
        boolean ciclo = true;
        int contISBNs = 0; //ContISBNs cuenta los ISBNs almacenados en el arreglo

        // MENÚ PRINCIPAL
        while(ciclo) {
            System.out.println("\n ==== SISTEMA DE GESTIÓN EDITORIAL ====");
            System.out.print("1) Agendar evento                 (Montículo)" +                          // Montículo
                            "\n2) Historial de eventos          (Pila)" +                               // Pila
                            "\n3) Propuestas de proyecto        (Lista enlazada)" +                     // Lista enlazada
                            "\n4) Gestión de empleados          (Árbol binario)" +                      // Árbol binario
                            "\n5) Catálogo de obras terminadas  (Recursividad, DYV, Ordenamiento/Búsqueda)" + // Recursividad, DYV, Métodos de ordenamiento/búsqueda
                            "\n6) Catálogo general              (Tablas Hash y HashMap)" +              // Tablas Hash y HashMap
                            "\n7) Ver colaboraciones            (Grafos)" +                             // Grafos
                            "\n8) Salir \n=> "); 
            int seleccion = input.nextInt();
            input.nextLine(); // limpiar buffer

            switch(seleccion) { //MENÚS SENCUNDARIOS
            
                case 1: //MONTÍCULO
                    menuMonticulo(seleccion, monticulo);
                    break;
                case 2: // PILA
                    menuPila(seleccion, pila);   
                    break;
                case 3: // LISTA ENLAZADA
                    menuListaEnlazada(seleccion, listaEnlazada);
                    break;
                case 4: // ÁRBOL BINARIO
                    menuArbolBinario(seleccion, arbolito);
                    break;
                case 5: // RECURSIVIDAD, DIVIDE Y VENCERÁS Y MÉTODOS DE ORDENAMIENTO/BÚSQUEDA
                    menuRecursividadOrdenamientoBusqueda(seleccion, contISBNs, isbns);
                    break;
                case 6: // TABLAS HASH Y HASHMAP
                    menuHashTablesHashMap(seleccion, socios, hashMap);
                    break;
                case 7: // GRAFOS
                    System.out.println("\n === 'GRAFOS' ===");
                    break;
                case 8: // SALIR
                    System.out.println("Saliendo... Hasta pronto!");
                    ciclo = false;
                    break;
                default: // VALIDAR DATO
                    System.out.println("Opción no válida.");
            }
        }
    }
}
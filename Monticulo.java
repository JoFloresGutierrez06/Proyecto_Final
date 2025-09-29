//==== Clase para gestionar la Cola Priorizada (MONTÍCULO) ====//

public class Monticulo {
    
    // MÉTODOS ESTÁTICOS DEL MONTÍCULO
    public static void enqueue(Objeto objeto, Objeto[] arreglo) { //Agregar elemento al arreglo

        if (Main.getSize(arreglo) == 0) {    //Si la lista está vacía agregarlo en la posición 1 
            arreglo[1] = objeto;    //Agregarlo al arreglo
            objeto.setHijoIzquierdo(2); //2 - 2*n
            objeto.setHijoDerecho(3); //3 - 2*n +1
            objeto.setPadre(0);//No tiene padre aún

        } else {    //No es el primer elemento
            
            arreglo[Main.getSize(arreglo) + 1] = objeto; //Agregarlo primeramente
            //Asignar a sus hijos
            objeto.setHijoIzquierdo(Main.getIndex(objeto, arreglo)*2); //2*n
            objeto.setHijoDerecho((Main.getIndex(objeto, arreglo)*2) +1); //2*n +1
            objeto.setPadre(Main.getIndex(objeto, arreglo)/2);  //Asignarle padre

            while(true) {
                if (objeto.getPrioridad() < arreglo[objeto.getPadre()].getPrioridad()) { //Si es menor la prioridad del nuevo
                    int index_inicial_objeto = Main.getIndex(objeto, arreglo);   //Guarda la posición inicial del objeto antes de cambiar
                    Main.swap(arreglo, Main.getIndex(objeto, arreglo), objeto.getPadre()); //Cambia lugar con el padre en el arreglo
                    
                    //Si quedó en la posición 1 del arreglo no se modifica su padre
                    if (Main.getIndex(objeto, arreglo) == 1) {
                    } else {    //Si no es el 1, reasignarle padre
                        objeto.setPadre(Main.getIndex(objeto, arreglo)/2);
                    }

                    //Actualiza a sus hijos
                    objeto.setHijoIzquierdo(Main.getIndex(objeto, arreglo)*2); //2*n
                    objeto.setHijoDerecho((Main.getIndex(objeto, arreglo)*2) +1); //2*n +1

                    //Actualizar datos del padre anterior, que se movió al lugar inicial del objeto
                    arreglo[index_inicial_objeto].setPadre(index_inicial_objeto/2); //actualizarle el padre al padre
                    arreglo[index_inicial_objeto].setHijoIzquierdo(index_inicial_objeto*2); //Actualizar hijo izquierdo del padre
                    arreglo[index_inicial_objeto].setHijoDerecho((index_inicial_objeto*2) +1); //Actualizar hijo derecho del padre
                
                } else { //Si el objeto no es menor que su padre no se mueve
                    break;
                }
                
            }     
        }
        System.out.println("Registro exitoso!");
    }
    public static void dequeue(Objeto[] arreglo) { //Eliminar el primer elemento del arreglo

        if (Main.getSize(arreglo) == 0) { //El arreglo está vacío
            System.out.println("No hay eventos registrados.");
        } else { 
            Objeto eliminado = arreglo[1]; //Guardar en una variable el objeto eliminado
            //Recorrer los elementos un lugar en el arreglo
            for (int i = 1; i < Main.getSize(arreglo); i++) { //De 1 a 'tamaño del arreglo' -1
                arreglo[i] = arreglo[i+1];
            }
            arreglo[Main.getSize(arreglo)] = null; //Se actualiza el último espacio para que sea null
            System.out.println("Evento completado: " + eliminado.getDato());
        }
        
    }
    public static void front(Objeto[] arreglo) { //Mostrar el primer elemento

        if (Main.getSize(arreglo)== 0) { //Si el arreglo está vacío
            System.out.println("No hay eventos registrados."); 
        } else {
            System.out.println("Evento: " + arreglo[1].getDato() + " Prioridad: " + arreglo[1].getPrioridad());
        }
    }
    public static void display(Objeto[] arreglo) {
        if (Main.getSize(arreglo) == 0) { //Si el arreglo está vacío
            System.out.println("Aún no hay eventos.");
        } else { //Recorrer cada elemento
            System.out.println(" <= Actual | En espera =>");
            for (Objeto elemento: arreglo) {
                if (elemento != null) { //Si no está vacío el espacio lo muestra
                    System.out.print(elemento.getDato() + "(" + elemento.getPrioridad() + ") "); //Muestra el dato y su prioridad entre paréntesis
                } 
            }
            System.out.println();
        }
    }
}

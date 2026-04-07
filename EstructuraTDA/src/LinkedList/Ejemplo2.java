/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

/**
 *
 * @author Iosef Canchán
 */
public class Ejemplo2 {
    public static void main(String[] args) {
        ListaManual2 lista = new ListaManual2();
        System.out.println("1. Prueba de insercion");
        lista.insetar("hola");
        lista.insetar("saludo");
        lista.insetar("adios");
        lista.insetar("despedida");
        lista.insetar("hi");
        lista.mostrar();
        System.out.println("-------------------------");
        
        System.out.println("2. Eliminar desde la cabeza (inicio)");
        System.out.println("Eliminando hola...");
        lista.eliminar("hola");
        lista.mostrar();
        System.out.println("-------------------------");
        
        System.out.println("3. Eliminar en el medio");
        System.out.println("Eliminando adios...");
        lista.eliminar("adios");
        lista.mostrar();
        System.out.println("-------------------------");
        
        System.out.println("4. Eliminar el ultimo (cola)");
        System.out.println("Eliminando hi...");
        lista.eliminar("hi");
        lista.mostrar();
        System.out.println("-------------------------");
        
        System.out.println("5. Eliminar elemnto que no existe");
        System.out.println("Intentando eliminar el Bye...");
        lista.eliminar("Bye");
        lista.mostrar();
        System.out.println("-------------------------");
        
        System.out.println("Prubas finalizas con exito");
    }
}

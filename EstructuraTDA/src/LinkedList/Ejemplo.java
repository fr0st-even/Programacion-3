/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

/**
 *
 * @author Iosef Canchán
 */
public class Ejemplo {
    
    public static void main(String[] args) {
        ListaManual lista = new ListaManual();
        
        System.out.println("1. Prueba de insercion");
        lista.insetar(10);
        lista.insetar(20);
        lista.insetar(30);
        lista.insetar(40);
        lista.insetar(50);
        lista.mostrar();
        System.out.println("-------------------------");
        
        System.out.println("2. Eliminar desde la cabeza (inicio)");
        System.out.println("Eliminando el10...");
        lista.eliminar(10);
        lista.mostrar();
        System.out.println("-------------------------");
        
        System.out.println("3. Eliminar en el medio");
        System.out.println("Eliminando el 30...");
        lista.eliminar(30);
        lista.mostrar();
        System.out.println("-------------------------");
        
        System.out.println("4. Eliminar el ultimo (cola)");
        System.out.println("Eliminando el 50...");
        lista.eliminar(50);
        lista.mostrar();
        System.out.println("-------------------------");
        
        System.out.println("5. Eliminar elemnto que no existe");
        System.out.println("Intentando eliminar el 99...");
        lista.eliminar(99);
        lista.mostrar();
        System.out.println("-------------------------");
        
        System.out.println("Prubas finalizas con exito");
    }
}

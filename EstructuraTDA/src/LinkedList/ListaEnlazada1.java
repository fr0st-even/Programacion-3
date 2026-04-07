/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;
import java.util.LinkedList;
/**
 *
 * @author Iosef Canchán
 */
public class ListaEnlazada1 {
    public static void main(String[] args) {
        LinkedList<Integer> lista = new LinkedList<>();
        
        lista.add(10);
        lista.addFirst(5);
        lista.add(2, 15);
        
        System.out.println("Contenido de la lista: " +lista);
        
        lista.removeFirst();
        System.out.println("Lista despues de eliminar el primer elemento: " +lista);
        
        lista.removeLast();
        System.out.println("Lista despues de eliminar el ultimo elemento: " +lista);
    }
}

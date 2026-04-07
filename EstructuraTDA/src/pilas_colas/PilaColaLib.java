/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas_colas;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

/**
 *
 * @author Iosef Canchán
 */
public class PilaColaLib {
    
    public static void main(String[] args) {
        //Pila
        //definimos una variable pila utilizando la liberia Stack y el tipo de datos Integer porque son numeros
        //si quisieramos tener tipos de datos de caracter usamos String
        Stack<Integer>pila = new Stack<>();
        System.out.println("Ejemplo pila: ");
        pila.push(10); //apilamos con push
        pila.push(20); //apilamos con push
        pila.push(30); //apilamos con push
        System.out.println("Pop pila: " +pila.pop()); //desapilamos el ultimo en entrar primero en salir. Retorna el ultimo valor y lo saca de la pila 
        System.out.println("Pop pila: " +pila.pop());
        System.out.println("Pop pila: " +pila.pop());//desapilamos el ultimo en entrar primero en salir. Retorna el ultimo valor y lo saca de la pila
    
        //Cola
        //en el caso de la cola usamos la libreria Queue, se crea el objeto cola que almacenara Integers
        System.out.println("Ejemplo cola: ");
        Queue<Integer> cola = new LinkedList<>();
        cola.add(1);
        cola.add(2);
        cola.add(3);
        System.out.println("Dequeue cola: " + cola.poll());
    }
    
}

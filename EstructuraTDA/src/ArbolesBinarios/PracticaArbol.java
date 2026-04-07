/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolesBinarios;

/**
 *
 * @author Iosef Canchán
 */
public class PracticaArbol {
    public static void main(String[] args) {
        /*
        ArbolBinario arbol = new ArbolBinario();
        arbol.insertar(50);
        arbol.insertar(30);
        arbol.insertar(70);
        arbol.insertar(20);
        arbol.insertar(40);
        
        System.out.println("Recorrido Pre-Orden (Izquierda a Derecha)");
        arbol.preOrden(arbol.raiz);
        
        System.out.println("Recorrido In-Orden (Ordenado)");
        arbol.inOrden(arbol.raiz);
        
        System.out.println("Recorrido Post-Orden (Raiz a Ultimo)");
        arbol.postOrden(arbol.raiz);           
        */
        ArbolBinario arbol = new ArbolBinario();
        arbol.insertar("Hola");
        arbol.insertar("Hi");
        arbol.insertar("Adios");
        arbol.insertar("Bye");
        arbol.insertar("Saludos");
        
        System.out.println("Recorrido Pre-Orden (Izquierda a Derecha)");
        arbol.preOrden(arbol.raiz);
        
        System.out.println("Recorrido In-Orden (Ordenado)");
        arbol.inOrden(arbol.raiz);
        
        System.out.println("Recorrido Post-Orden (Raiz a Ultimo)");
        arbol.postOrden(arbol.raiz);           
    }
}

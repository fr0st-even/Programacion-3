/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolavl;

/**
 *
 * @author Iosef Canchán
 */
public class MainAVL {
    public static void main(String[] args) {
        ArbolAVL arbol = new ArbolAVL();
        
        System.out.println("Insertando 10,20,30...");
        arbol.insertar(10);
        arbol.insertar(20);
        arbol.insertar(30); //Aqui ocurrira una rotacion a la izquierda
        //arbol.mostrarArbol();
        
    }
}

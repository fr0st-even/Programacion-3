/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolavl;

/**
 *
 * @author Iosef Canchán
 */
public class Nodo {
    int valor, altura;
    Nodo izquierdo, derecho;
    
    Nodo(int d){
        valor = d;
        altura = 1; //Un nodo nuevo comienza con altura 1
    }
}

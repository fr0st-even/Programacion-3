/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

/**
 *
 * @author Iosef Canchán
 */
public class ListaManual2 {
    Nodo2 cabeza;
        
        public void insetar (String caracter){
            Nodo2 nuevoNodo = new Nodo2(caracter);
            
            if(cabeza == null){
                cabeza = nuevoNodo;
            }
            else{
                Nodo2 temporal = cabeza;
                while(temporal.siguiente != null){
                    temporal = temporal.siguiente;
                }
                temporal .siguiente = nuevoNodo;
            }
        }
        
        public void eliminar(String caracter){
            if (cabeza == null)return;
            //Caso 1: El valor esta en la cabeza (el primer nodo)
            if (cabeza.caracter.equals(caracter)){
                cabeza = cabeza.siguiente;
                return;
            }         
            //Caso 2: El valor esta en medio o al final
            Nodo2 actual = cabeza;
            while(actual.siguiente != null && actual.siguiente.caracter.equals(caracter)){
                actual = actual.siguiente;
            }
            if (actual.siguiente != null){
                actual.siguiente = actual.siguiente.siguiente;
            }
        }
        
        public void mostrar(){
            Nodo2 temporal = cabeza;
            System.out.println("List: ");
            
            while(temporal != null){
                System.out.println(temporal.caracter +" -> ");
                temporal = temporal.siguiente;
            }
            System.out.println("null");
        }
    
}

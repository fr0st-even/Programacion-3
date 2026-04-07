/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package LinkedList;

/**
 *
 * @author Iosef Canchán
 */
    public class ListaManual{
        Nodo cabeza;
        
        public void insetar (int dato){
            Nodo nuevoNodo = new Nodo(dato);
            
            if(cabeza == null){
                cabeza = nuevoNodo;
            }
            else{
                Nodo temporal = cabeza;
                while(temporal.siguiente != null){
                    temporal = temporal.siguiente;
                }
                temporal .siguiente = nuevoNodo;
            }
        }
        
        public void eliminar(int valor){
            if (cabeza == null)return;
            //Caso 1: El valor esta en la cabeza (el primer nodo)
            if (cabeza.dato == valor){
                cabeza = cabeza.siguiente;
                return;
            }         
            //Caso 2: El valor esta en medio o al final
            Nodo actual = cabeza;
            while(actual.siguiente != null && actual.siguiente.dato != valor){
                actual = actual.siguiente;
            }
            if (actual.siguiente != null){
                actual.siguiente = actual.siguiente.siguiente;
            }
        }
        
        public void mostrar(){
            Nodo temporal = cabeza;
            System.out.println("List: ");
            
            while(temporal != null){
                System.out.println(temporal.dato +" -> ");
                temporal = temporal.siguiente;
            }
            System.out.println("null");
        }
    }  

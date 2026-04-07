/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pilas_colas;

/**
 *
 * @author Iosef Canchán
 */
public class PilaCola {
    static class Pila{
        
        int[] datos = new int[3];
     
        int tope = -1;
        
        public void push(int valor){
            if(tope<datos.length-1){
                tope++;
                datos[tope] = valor;
            }
            else{
                System.out.println("Pila vacia");
            }
        }
        
        public int pop(){
            if (tope>=0){
                return datos[tope--];
            }
            else{
                System.out.println("Pila vacia");
                return -1;
            }
        }
    }
    
    static class Cola{
        int[] datos = new int[5];
        
        int inicio =0;
        int fin =0;        
        
        void enqueue(int valor){
            if(fin<datos.length){
                datos[fin++] = valor;
            }
            else{
                System.out.println("Cola llena");
            }
        }
        
        int dequeue(){
            if (inicio < fin){
                return datos[inicio++];
            }
            else{
                System.out.println("Cola vacia");
                return -1;
            }
        }
    }
    
    public static void main(String[] args) {
        
        Pila pila = new Pila();
        pila.push(10);
        pila.push(20);
        pila.push(30);
        System.out.println("Pop pila: " + pila.pop());
        
        Cola cola = new Cola();
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        System.out.println("Dequeue cola: " + cola.dequeue());
    }
}

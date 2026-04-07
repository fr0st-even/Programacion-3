/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Hash;
import java.util.LinkedList;

/**
 *
 * @author Iosef Canchán
 */
public class MiTablaHash {
    private LinkedList<Entry>[] tabla;
    
    private int tamanio;
    
    class Entry{
        String llave;
        String valor;

        public Entry(String llave, String valor) {
            this.llave = llave;
            this.valor = valor;
        }
    }
    
    public MiTablaHash(int tamanio){
        this.tamanio = tamanio;
        
        tabla = new LinkedList[tamanio];
        for (int i = 0; i<tamanio;i++){
            tabla[i] = new LinkedList<>();
        }
    }
    
    private int hash(String llave){
        int hash = llave.hashCode();
        hash = Math.abs(hash);
        return hash % tamanio;
    }
    
    public void insertar (String llave, String valor){
        int indice = hash(llave);
        
        tabla[indice].add(new Entry(llave, valor));
    }
    
    public String buscar(String llave){
        int indice = hash(llave);
        for (Entry e: tabla [indice]){
            if (e.llave.equals(llave)){
                return e.valor;
            }
        }
        return null;
    }
    
    public void mostrarTabla(){
        for (int i = 0; i < tamanio; i++){
            System.out.println("Indice " + i + " : ");
            for (Entry e : tabla[i]){
                System.out.println("[" + e.llave + " -> " + e.valor + "] ");
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        MiTablaHash tabla = new MiTablaHash(5);
        
        System.out.println("=== INSERTANDO DATOS ===");
        
        tabla.insertar("Juan","Ingeniero");
        tabla.insertar("Maria", "Doctora");
        tabla.insertar("Pedro","Arquitecto");
        tabla.insertar("Ana","Abogada");
        tabla.insertar("Luis","Profesor");
        
        System.out.println("\n=== MOSTRANDO TABLA ===");
        tabla.mostrarTabla();
        
        System.out.println("\n=== BUSCANDO DATOS ===");
        
        System.out.println("Juan -> " + tabla.buscar("Juan"));
        System.out.println("Ana -> " + tabla.buscar("Ana"));
        
        String resultado = tabla.buscar("Carlos");
        
        if(resultado == null){
            System.out.println("Carlos -> No encontrado"); 
        }
    }
}



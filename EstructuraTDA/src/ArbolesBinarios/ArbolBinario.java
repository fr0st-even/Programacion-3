/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolesBinarios;

/**
 *
 * @author Iosef Canchán
 */
public class ArbolBinario {
    /*
    Nodo raiz;
    public ArbolBinario() {raiz = null;}
    
    void insertar (int valor){raiz = insertarRecursivo (raiz, valor);}
    
    private Nodo insertarRecursivo(Nodo actual, int valor){
        if (actual == null) return new Nodo(valor);
        if (valor < actual.valor)
            actual.izquierdo = insertarRecursivo(actual.izquierdo, valor);
        else if (valor > actual.valor)
            actual.derecho = insertarRecursivo(actual.derecho, valor);
        return actual;
    }
    
    private int encontrarMinimo (Nodo raiz){
        int min = raiz.valor;
        while (raiz.izquierdo != null);{
            min = raiz.izquierdo.valor;
            raiz = raiz.izquierdo;
        }  
        return min;
    }
    
    void inOrden (Nodo nodo){
        if (nodo != null){
            inOrden(nodo.izquierdo);
            System.out.println(nodo.valor +"");
            inOrden(nodo.derecho);
        }
    }
    
    void preOrden (Nodo nodo){
        if (nodo != null){
            System.out.println(nodo.valor +"");
            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }
    
    void postOrden(Nodo nodo){
        if (nodo != null){
            postOrden(nodo.izquierdo);
            postOrden(nodo.derecho);
            System.out.println(nodo.valor +"");
        }
    }
    */
    
    Nodo raiz;
    public ArbolBinario() {raiz = null;}
    
    void insertar (String valor){raiz = insertarRecursivo (raiz, valor);}
    
    private Nodo insertarRecursivo(Nodo actual, String valor){
        if (actual == null) return new Nodo(valor);
        if (valor.compareTo(actual.valor)<0)
            actual.izquierdo = insertarRecursivo(actual.izquierdo, valor);
        else if (valor.compareTo(actual.valor)>0)
            actual.derecho = insertarRecursivo(actual.derecho, valor);
        return actual;
    }
    
    private String encontrarMinimo (Nodo raiz){
        String min = raiz.valor;
        while (raiz.izquierdo != null);{
            min = raiz.izquierdo.valor;
            raiz = raiz.izquierdo;
        }  
        return min;
    }
    
    void inOrden (Nodo nodo){
        if (nodo != null){
            inOrden(nodo.izquierdo);
            System.out.println(nodo.valor +"");
            inOrden(nodo.derecho);
        }
    }
    
    void preOrden (Nodo nodo){
        if (nodo != null){
            System.out.println(nodo.valor +"");
            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }
    
    void postOrden(Nodo nodo){
        if (nodo != null){
            postOrden(nodo.izquierdo);
            postOrden(nodo.derecho);
            System.out.println(nodo.valor +"");
        }
    }
}

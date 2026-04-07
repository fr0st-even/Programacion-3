/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ArbolSimple;

/**
 *
 * @author Iosef Canchán
 */


public class ArbolBinario {

    Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    // -------- INSERTAR --------
    boolean insertar(int valor) {
        if (buscarNivel(valor) != -1) {
            return false; // valor duplicado
        }
        raiz = insertarRecursivo(raiz, valor);
        return true;
    }
 
    private Nodo insertarRecursivo(Nodo actual, int valor) {
        if (actual == null) return new Nodo(valor);
        if (valor < actual.valor)
            actual.izquierdo = insertarRecursivo(actual.izquierdo, valor);
        else if (valor > actual.valor)
            actual.derecho = insertarRecursivo(actual.derecho, valor);
        return actual;
    }
 
    // -------- ALTURA --------
    int altura() {
        return alturaRecursivo(raiz);
    }
 
    private int alturaRecursivo(Nodo nodo) {
        if (nodo == null) return -1;
        int altIzq = alturaRecursivo(nodo.izquierdo);
        int altDer = alturaRecursivo(nodo.derecho);
        return 1 + Math.max(altIzq, altDer);
    }

    // -------- ELIMINAR --------
    void eliminar(int valor) {
        raiz = eliminarRecursivo(raiz, valor);
    }

    private Nodo eliminarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            System.out.println("El valor " + valor + " no existe en el arbol.");
            return null;
        }
        if (valor < actual.valor) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = eliminarRecursivo(actual.derecho, valor);
        } else {
            // Nodo encontrado - tres casos
            if (actual.izquierdo == null) return actual.derecho;
            if (actual.derecho == null)   return actual.izquierdo;
            // Tiene dos hijos: buscar el minimo del lado derecho
            int minValor = encontrarMinimo(actual.derecho);
            actual.valor = minValor;
            actual.derecho = eliminarRecursivo(actual.derecho, minValor);
        }
        return actual;
    }

    private int encontrarMinimo(Nodo nodo) {
        int min = nodo.valor;
        while (nodo.izquierdo != null) {
            min = nodo.izquierdo.valor;
            nodo = nodo.izquierdo;
        }
        return min;
    }

    // -------- BUSCAR --------
    // Retorna el nivel donde esta el valor (-1 si no existe)
    int buscarNivel(int valor) {
        return buscarRecursivo(raiz, valor, 0);
    }

    void buscar(int valor) {
        int nivel = buscarRecursivo(raiz, valor, 0);
        if (nivel == -1) {
            System.out.println("El valor " + valor + " NO se encontro en el arbol.");
        } else {
            System.out.println("El valor " + valor + " se encuentra en el nivel: " + nivel);
        }
    }

    private int buscarRecursivo(Nodo actual, int valor, int nivel) {
        if (actual == null) return -1;
        if (actual.valor == valor) return nivel;
        if (valor < actual.valor)
            return buscarRecursivo(actual.izquierdo, valor, nivel + 1);
        else
            return buscarRecursivo(actual.derecho, valor, nivel + 1);
    }

    // -------- RECORRIDOS --------
    void inOrden(Nodo nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.println(nodo.valor);
            inOrden(nodo.derecho);
        }
    }

    void preOrden(Nodo nodo) {
        if (nodo != null) {
            System.out.println(nodo.valor);
            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }

    void postOrden(Nodo nodo) {
        if (nodo != null) {
            postOrden(nodo.izquierdo);
            postOrden(nodo.derecho);
            System.out.println(nodo.valor);
        }
    }
}

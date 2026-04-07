/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolavl;

/**
 *
 * @author Iosef Canchán
 */
public class ArbolAVL {
    Nodo raiz;
    
    // -- Metodo Altura --
    // Obtener la altura de un nodo de forma segura
    private int obtenerAltura(Nodo n){
        return (n == null) ? 0: n.altura;
    }
    
    // Calcular el factor de Equilibrio del Arbol AVL
    private int obtenerFE(Nodo n){
        return (n == null) ? 0 : obtenerAltura(n.izquierdo) - obtenerAltura(n.derecho);
    }
    
    // -- ROTACIONES --
    // Donde 'c' es el nodo con FE = 2, 'b' es su hijo izquierdo y 'a' el nieto.
    private Nodo rotarDerecha(Nodo c){
        // 1. 'b' se convierte en la nueva raiz del subarbol
        Nodo b = c.izquierdo;
        
        //2. Guardamos el subarbol derecho de 'b' (podria llamarse T2)
        Nodo T2 = b.derecho;
        
        //3. Realizamos la rotacion: 'c' pasa a ser hijo derecho de 'b'
        b.derecho = c;
        
        //4. El antiguo subarbol T2 se reubica como hijo izquierdo de 'c'
        c.izquierdo = T2;
        
        //5. Actualizar alturas: Primero el que bajo (c) y luego el que subio (b)
        c.altura = Math.max(obtenerAltura(c.izquierdo), obtenerAltura(c.derecho));
        c.altura = Math.max(obtenerAltura(b.izquierdo), obtenerAltura(b.derecho));
        
        return b;
    }
    
    //Basado en tu imagen "Rotacion simple a la izquierda (RI)"
    // Donde 'a' es el nodo con FE = -2, 'b' es su hijo derecho y 'c' el nieto
    private Nodo rotarIzquierda(Nodo a){
        //1. 'b' se  convierte en la nueva raiz del subarbol
        Nodo b = a.derecho;
        
        //2. Guardamos el subarbol izquierdo de 'b' para no perderlo
        Nodo T2 = b.izquierdo;
        
        // 3. Realizamos la rotacion: 'a' pasa a ser hijo izquierdo de 'b'
        b.izquierdo = a;
        
        //4. El subarbol T2 se reubica como hijo derecho de 'a'
        a.derecho = T2;
        
        //5. Actualizar las alturas: Primero el que bajo (a) y luego el que subio (b)
        a.altura = Math.max(obtenerAltura(a.izquierdo),obtenerAltura(a.derecho)) + 1;
        b.altura = Math.max(obtenerAltura(b.izquierdo),obtenerAltura(b.derecho)) + 1;
        
        return b;
    }
    
    public void insertar(int valor){
        raiz = insertarRecursivo(raiz, valor);
    }
    
    private Nodo insertarRecursivo(Nodo nodo, int valor){
        if (nodo == null){
            return new Nodo(valor);
        }
        if (valor < nodo.valor){
            nodo.izquierdo = insertarRecursivo(nodo.izquierdo, valor);
        } 
        else if (valor > nodo.valor){
            nodo.derecho = insertarRecursivo(nodo.derecho, valor);
        }
        else{
            return nodo; //No diplicados
        }
      
        //2. Actualizar altura
        nodo.altura = 1 + Math.max(obtenerAltura(nodo.izquierdo),obtenerAltura(nodo.derecho));
        
        //3.Obtener FE
        int fe = obtenerFE(nodo);
    
        // -- CASOS DE BALANCEO --
        // Caso Izquierda - Izquierda (Usa Rotacion Simple a la Derecha - RD)
        // El nodo desbalanceado actua como 'c' en tu diagrama
        if (fe > 1 && valor < nodo.izquierdo.valor){
            return rotarDerecha(nodo);
        }   
        // Caso Derecha- Derecha (Usa Rotacion Simple a la Izquierda - RI)
        // El nodo desbalanceado actua como 'a' en tu diagrama
        if(fe <-1 && valor > nodo.derecho.valor){
            return rotarIzquierda(nodo);
        }
        // Caso Izquierda-Derecha (Doble Rotacion)
        if (fe > 1 && valor > nodo.izquierdo.valor){
            // Primero: RI sobre el hijo izquierdo
            nodo.izquierdo = rotarIzquierda(nodo.izquierdo);
            // Seguimos: RD sobre el nodo actual
            return rotarDerecha(nodo);
        }
        return null;
    }

        // -- RECORRIDOS --
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
        
    
    
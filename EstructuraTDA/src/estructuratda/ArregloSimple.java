/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuratda;

/**
 *
 * @author Iosef Canchán
 */
public class ArregloSimple {
    public static void main(String[] args){
        //Declaracion e inicializacion del arreglo
        int[] calificaciones = {70,85,90,60,75};
        
        //Recorrer el arreglo
        for (int i = 0; i < calificaciones.length; i++ ){
            System.out.println("Posicion"+i+ "valor: " +calificaciones[i]);
        }
    }
}

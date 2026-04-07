/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuratda;

/**
 *
 * @author Iosef Canchán
 */
public class Arreglo {
    public static void main(String[] args){
  
        int[] calificaciones = {70,85,90,60,75};
        
        int suma = 0;
        int mayor = calificaciones[0];
        int menor = calificaciones [0];
        //Recorrer el arreglo
        for (int i = 0; i < calificaciones.length; i++ ){
            
            suma += calificaciones[i];
            
            if (calificaciones[i] > mayor ){
                mayor = calificaciones[i];
            }
            
            if (calificaciones[i] < menor ){
                menor = calificaciones[i];
            }
            System.out.println("Posicion: "+i+" valor: " +calificaciones[i]);
        }
        
        //Calculo de promedio
        double promedio = (double)suma/calificaciones.length;
        
        System.out.println("Promedio: "+promedio);
        System.out.println("Mayor calificacion: "+mayor);
        System.out.println("Menor calificacion: "+menor);
    }
       
}

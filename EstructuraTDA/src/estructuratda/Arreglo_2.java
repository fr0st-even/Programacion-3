/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package estructuratda;
import java.util.Scanner;
/**
 *
 * @author Iosef Canchán
 */
public class Arreglo_2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        
        //Tamano del arreglo
        int n = 5;
        int[] calificaciones = new int[n];
        for (int i = 0; i < n; i++){
            System.out.println("Ingrese la calificacion " + (i+1) + " : ");
            calificaciones[i] = sc.nextInt();
        }
        
        System.out.println("Validaciones");
        for (int i = 0; i <n; i++){
            if (calificaciones[i]<61){
                System.out.println("Calificacion " + (i + 1) + " (" + calificaciones[i] + "): Reprobado");
            }
            else{
                System.out.println("Calificacio"
                        + "n " + (i + 1) + " (" + calificaciones[i] + "): Aprobado");
            }
        }
        sc.close();
    }
}

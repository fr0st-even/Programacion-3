/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package torres_de_Hanoi;
import java.util.Scanner;
/**
 *
 * @author Iosef Canchán
 */
public class TorresDeHanoi {
    public static void main(String[] args) {
        Scanner teclado = new Scanner (System.in);
        int numero;
        System.out.println("Introduce el numero de discos: ");
        numero = teclado.nextInt();
        Hanoi(numero, 1, 2, 3);
    }
    
    public static void Hanoi(int numeroDiscos, int torreA, int torreB, int torreC) {
        if (numeroDiscos == 1){
            System.out.println("Mover disco de " + torreA + " a " + torreC);
        }
        else{
            Hanoi(numeroDiscos - 1, torreA, torreC, torreB);
            System.out.println("Mover disco de " + torreA + " a " + torreC);
            Hanoi(numeroDiscos - 1, torreB, torreA, torreC);
        }
    }
}

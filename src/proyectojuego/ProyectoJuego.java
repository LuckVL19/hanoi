/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectojuego;
import java.util.Scanner;

/**
 *
 * @author eliel
 */
public class ProyectoJuego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        hanoi juego = new hanoi();
        
        hanoi.torre torreA = juego.new torre();
        hanoi.torre torreB = juego.new torre();
        hanoi.torre torreC = juego.new torre();
        
        
        int[] numeros = new int[8];
        for (int i = 0; i < 8; i++) {
            numeros[i] = i + 1;
        }

        for (int i = 0; i < numeros.length; i++) {
            int randomIndex = (int) (Math.random() * numeros.length);
            int num = numeros[i];
            numeros[i] = numeros[randomIndex];
            numeros[randomIndex] = num;
        }

        for (int numero : numeros) {
            torreA.agregar(juego.new disco(numero));
        }
        
        Scanner sc = new Scanner(System.in);
        boolean enCurso = true;
        
        
        while (enCurso) {
            System.out.println("estado actual de las torres:");
            System.out.print("torre A: ");
            torreA.mostrar();
            System.out.print("torre B: ");
            torreB.mostrar();
            System.out.print("torre C: ");
            torreC.mostrar();

            System.out.println("seleccione la torre de origen (A, B, C): ");
            String origen = sc.nextLine().toUpperCase();
            System.out.println("seleccione la torre de destino (A, B, C): ");
            String destino = sc.nextLine().toUpperCase();

            hanoi.torre torreOrigen = null;
            hanoi.torre torreDestino = null;

            switch (origen) {
                case "A": torreOrigen = torreA; break;
                case "B": torreOrigen = torreB; break;
                case "C": torreOrigen = torreC; break;
                default: System.out.println("torre de origen invalida."); continue;
            }

            switch (destino) {
                case "A": torreDestino = torreA; break;
                case "B": torreDestino = torreB; break;
                case "C": torreDestino = torreC; break;
                default: System.out.println("torre de destino invalida."); continue;
            }

            if (torreOrigen != null && torreDestino != null) {
                hanoi.disco discoMover = torreOrigen.verPrimerDisco();
                hanoi.disco discoDestino = torreDestino.verPrimerDisco();

                if (discoMover == null) {
                    System.out.println("no hay discos en la torre de origen.");
                } else if (discoDestino == null || discoMover.size() < discoDestino.size()) {
                    torreDestino.agregar(torreOrigen.quitar());
                    System.out.println("movimiento realizado.");
                } else {
                    System.out.println("movimiento invalido: no puedes colocar un disco mas grande sobre uno mas pequeño.");
                }
            }

            if (torreA.torreEstaOrdenada(torreA) || torreB.torreEstaOrdenada(torreB) || torreC.torreEstaOrdenada(torreC)) {
                System.out.println("¡Felicidades! Has completado el juego.");
                enCurso = false;
            }      
        }
    }    
}

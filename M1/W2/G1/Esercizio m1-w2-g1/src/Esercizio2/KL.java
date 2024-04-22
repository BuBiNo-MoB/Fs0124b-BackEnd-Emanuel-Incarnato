package Esercizio2;

import java.util.Scanner;

public class KL {

    //metodo per calcolare il consumo KM/L
    public static double calcoloConsumo (double kmPercorsi, double litriConsumati){
        return kmPercorsi / litriConsumati;
    }

    public static void main (String[] args){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Inserisci i KM:");
        double kmPercorsi = scanner.nextDouble();

        System.out.println("Inserisci i Litri consumati :");
        double litriConsumati = scanner.nextDouble();

        double consumoKm = calcoloConsumo(kmPercorsi, litriConsumati);

        System.out.println("Consumo km/litro: " + consumoKm);

        scanner.close();
    }
}

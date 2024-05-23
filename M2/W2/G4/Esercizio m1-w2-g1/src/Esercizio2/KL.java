package Esercizio2;

import java.util.Scanner;

public class KL {

    // metodo per calcolare il consumo KM/L
    public static double calcoloConsumo(double kmPercorsi, double litriConsumati) {
        if (litriConsumati == 0) {
            throw new IllegalArgumentException("Impossibile dividere per zero. Inserire un valore diverso da zero per i litri consumati.");
        }
        return kmPercorsi / litriConsumati;
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            System.out.println("Inserisci i KM:");
            double kmPercorsi = scanner.nextDouble();

            System.out.println("Inserisci i Litri consumati :");
            double litriConsumati = scanner.nextDouble();

            double consumoKm = calcoloConsumo(kmPercorsi, litriConsumati);
            System.out.println("Consumo km/litro: " + consumoKm);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}

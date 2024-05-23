package Esercizio1;

import java.util.Random;
import java.util.Scanner;

public class Main {


    static int[] number = new int[5];

    //metodo per stampare l'array con i numeri casuali
    public static void stampaArray(int[] array) {
        for (int numero : array) {
            System.out.print(numero + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) {

        for( int i = 0 ; i< number.length; i++){
            number[i] = new Random().nextInt(10)+1;
        }

        System.out.println("Numeri casuali generati:");
        stampaArray(number);

        int numeroInserito;
        int posizione;

        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Inserisci un numero (0 per terminare): ");
            numeroInserito = scanner.nextInt();

            if (numeroInserito != 0) {
                System.out.println("Inserisci la posizione: ");
                posizione = scanner.nextInt();

                if (posizione >= 0 && posizione < number.length) {
                    number[posizione] = numeroInserito;
                    System.out.println("Stato dell'array dopo l'inserimento:");
                    stampaArray(number);
                } else {
                    System.out.println("Posizione non valida. Inserisci un numero compreso tra 0 e " + (number.length - 1));
                }
            }
        } while (numeroInserito != 0);

        System.out.println("Programma terminato.");
        scanner.close();
    }
}
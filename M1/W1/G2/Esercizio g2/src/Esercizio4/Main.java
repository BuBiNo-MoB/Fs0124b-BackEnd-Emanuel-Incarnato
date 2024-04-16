package Esercizio4;
import java.util.Scanner;


public class Main {public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Inserisci un numero intero:");
    int numero = scanner.nextInt();

    System.out.println("Conto alla rovescia a partire da " + numero + ":");
    for (int i = numero; i >= 0; i--) {
        System.out.println(i);
    }
}
}
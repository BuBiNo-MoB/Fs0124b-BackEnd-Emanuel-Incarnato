package Programma;

import java.util.Scanner;
import Player.Audio;
import Player.Image;
import Player.video;

public class mediaPlayer {

    public static void main(String[] args) {
        // Crea un oggetto Scanner per leggere l'input dell'utente da console
        Scanner scanner = new Scanner(System.in);

        // Mostra un messaggio di benvenuto
        System.out.println("Benvenuto nel Media Player!");

        // Mostra le opzioni per il tipo di media da riprodurre
        System.out.println("Scegli il tipo di media da riprodurre:");
        System.out.println("1. Audio");
        System.out.println("2. Immagine");
        System.out.println("3. Video");

        // Legge l'input dell'utente per la scelta del tipo di media
        int sceltaMedia = scanner.nextInt();
        scanner.nextLine(); // Consuma il carattere di nuova linea

        // Esegue un'operazione diversa in base alla scelta dell'utente
        switch (sceltaMedia) {
            case 1:
                // Se l'utente ha scelto "Audio"
                // Richiede all'utente di inserire il titolo, il volume e la durata dell'audio
                System.out.println("Inserisci il titolo dell'audio:");
                String titoloAudio = scanner.nextLine();
                System.out.println("Inserisci il volume:");
                int volumeAudio = scanner.nextInt();
                System.out.println("Inserisci la durata:");
                int durataAudio = scanner.nextInt();

                // Crea un oggetto Audio con i valori inseriti e lo esegue
                Audio audio = new Audio(titoloAudio, volumeAudio, durataAudio);
                audio.esegui();
                break;
            case 2:
                // Se l'utente ha scelto "Immagine"
                // Richiede all'utente di inserire il titolo e la luminosità dell'immagine
                System.out.println("Inserisci il titolo dell'immagine:");
                String titoloImmagine = scanner.nextLine();
                System.out.println("Inserisci la luminosità:");
                int luminositaImmagine = scanner.nextInt();

                // Crea un oggetto Image con i valori inseriti e lo esegue
                Image immagine = new Image(titoloImmagine, luminositaImmagine);
                immagine.esegui();
                break;
            case 3:
                // Se l'utente ha scelto "Video"
                // Richiede all'utente di inserire il titolo, il volume, la durata e la luminosità del video
                System.out.println("Inserisci il titolo del video:");
                String titoloVideo = scanner.nextLine();
                System.out.println("Inserisci il volume:");
                int volumeVideo = scanner.nextInt();
                System.out.println("Inserisci la durata:");
                int durataVideo = scanner.nextInt();
                System.out.println("Inserisci la luminosità:");
                int luminositaVideo = scanner.nextInt();

                // Crea un oggetto Video con i valori inseriti e lo esegue
                video video = new video(titoloVideo, volumeVideo, durataVideo, luminositaVideo);
                video.esegui();
                break;
            default:
                // Se l'utente ha scelto un'opzione non valida
                System.out.println("Scelta non valida.");
        }

        // Chiude lo scanner per liberare le risorse
        scanner.close();
    }
}

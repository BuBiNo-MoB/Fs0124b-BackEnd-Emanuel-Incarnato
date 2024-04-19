package Player;

public class Audio extends media implements riproduzione {

    // Dichiarazione degli attributi della classe
    private int volume;
    private int durata;
    private static final int minimo = 0;
    private static final int massimo = 0;


    // Costruttore della classe Audio
    public Audio(String titolo, int volume, int durata) {

        super(titolo);
        this.volume = switchSegno(volume);
        setVolume(volume);
        this.durata = switchSegno(durata);

    }

    // Metodo per ottenere il valore assoluto di un numero
    public int switchSegno(int valore){
        if(valore < 0) valore = -valore;
        return valore;
    }


    // Metodo per impostare il volume dell'audio
    private void setVolume(int volume) {
        if (volume >= minimo && volume <= massimo) {
            this.volume = volume;
        } else {
            System.out.println("Il volume deve essere compreso tra " + minimo + " e " + massimo);
        }
    }


    @Override
    public void play() {
        String livelloVolume = "";

        for (int i=0; i<volume; i++) {
            livelloVolume += "!";
        };
        for (int i=0; i<durata; i++){
            System.out.println(titolo + ": " + livelloVolume);
        }

    }


    @Override
    public void alzaVolume()  {
        if (volume < 10) {
            volume++;
            System.out.println("Volume alzato a " + volume);
        } else {
            System.out.println("Volume già al massimo");
        }
    }



    @Override
    public void abbassaVolume() {
        if (volume > 0) {
            volume--;
            System.out.println("Volume abbassato a " + volume);
        } else {
            System.out.println("Volume già al minimo");
        }
    }


    @Override
    public void esegui() {
        play();
    }

    @Override
    public void aumentaLuminosita() {

    }

    @Override
    public void diminuisciLuminosita() {

    }
}

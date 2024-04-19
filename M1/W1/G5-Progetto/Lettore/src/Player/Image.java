package Player;

public class Image extends media implements visualizzazione {

    // Dichiarazione degli attributi della classe
    private int luminosità;
    private static final int minimol = 1;
    private static final int massimol = 5;

    // Costruttore della classe Image
    public Image(String titolo, int luminosità) {
        super(titolo);
        this.luminosità = switchSegno(luminosità);
        setLight(luminosità);
    }

    public int switchSegno(int valore){
        if(valore < 0) valore = -valore;
        return valore;
    }

    // Metodo privato per impostare la luminosità dell'immagine
    private void setLight(int luminosità) {
        if (luminosità >= minimol && luminosità <= massimol) {
            this.luminosità = luminosità;
        } else {
            System.out.println("La luminosità deve essere compresa tra " + minimol + " e " + massimol);
        }
    }

    // Metodo per mostrare l'immagine con la luminosità corrispondente
    public void show() {
        String livelloLuminosità = "";

        for (int i=0; i<luminosità; i++) {
            livelloLuminosità += "*";
        }
        System.out.println(titolo + ": " + livelloLuminosità);
    }

    @Override
    public void esegui() {
        show();

    }

    @Override
    public void aumentaLuminosita() {
        if (luminosità < 5) {
            luminosità++;
            System.out.println("Luminosità alzata a " + luminosità);
        } else {
            System.out.println("Luminosità al massimo");
        }

    }

    @Override
    public void diminuisciLuminosita() {
        {

            if (luminosità > 1) {
                luminosità--;
                System.out.println("Luminosità abbassata a " + luminosità);
            } else {
                System.out.println("Luminosità già al minimo");
            }
        }
    }
}
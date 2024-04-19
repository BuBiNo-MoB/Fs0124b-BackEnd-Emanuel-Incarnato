package Player;

public abstract class media {
    protected String titolo;

    public media(String titolo) {
        this.titolo = titolo;
    }

    public abstract void esegui();
    public abstract void aumentaLuminosita();
    public abstract void diminuisciLuminosita();
}

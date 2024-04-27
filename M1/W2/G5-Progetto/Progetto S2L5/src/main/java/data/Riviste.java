package data;

// La classe Riviste estende la classe Catalogo e rappresenta una rivista nel catalogo.
// Oltre alle informazioni di base ereditate dalla classe Catalogo, contiene anche informazioni specifiche della rivista, come la periodicità.

public class Riviste extends Catalogo {
    private Periodicità periodicità; // Periodicità della rivista

    // Costruttore della classe Riviste che chiama il costruttore della classe Catalogo
    public Riviste(String titolo, int annoPubblicazione, int numeroPagine, Periodicità periodicità) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.periodicità = periodicità;
    }

    // Metodi getter e setter per la periodicità

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    // Metodo toString per rappresentare l'oggetto Riviste sotto forma di stringa

    @Override
    public String toString() {
        return super.toString() + "Riviste{" +
                "periodicità=" + periodicità +
                '}';
    }
}

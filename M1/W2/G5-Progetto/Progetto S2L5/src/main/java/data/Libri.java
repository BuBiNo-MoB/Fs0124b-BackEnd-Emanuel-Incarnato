package data;

// La classe Libri estende la classe Catalogo e rappresenta un libro nel catalogo.
// Oltre alle informazioni di base ereditate dalla classe Catalogo, contiene anche informazioni specifiche del libro, come autore e genere.

public class Libri extends Catalogo {
    private String autore; // Autore del libro
    private String genere; // Genere del libro

    // Costruttore della classe Libri che chiama il costruttore della classe Catalogo
    public Libri(String titolo, int annoPubblicazione, int numeroPagine, String autore, String genere) {
        super(titolo, annoPubblicazione, numeroPagine);
        this.autore = autore;
        this.genere = genere;
    }

    // Metodi getter e setter per autore e genere

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public String getGenere() {
        return genere;
    }

    public void setGenere(String genere) {
        this.genere = genere;
    }

    // Metodo toString per rappresentare l'oggetto Libri sotto forma di stringa

    @Override
    public String toString() {
        return super.toString() + "Libri{" +
                "autore='" + autore + '\'' +
                ", genere='" + genere + '\'' +
                '}';
    }
}

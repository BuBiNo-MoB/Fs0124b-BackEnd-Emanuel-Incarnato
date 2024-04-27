package data;

// La classe Catalogo è una classe astratta che rappresenta un elemento generico di un catalogo.
// Contiene informazioni di base come ISBN, titolo, anno di pubblicazione e numero di pagine.

public abstract class Catalogo {
    // Variabile statica per generare automaticamente il prossimo ISBN
    private static Integer nextISBN = 1;

    private Integer ISBN; // Numero di identificazione univoco
    private String titolo; // Titolo dell'elemento
    private Integer annoPubblicazione; // Anno di pubblicazione
    private int numeroPagine; // Numero di pagine dell'elemento

    // Costruttore della classe Catalogo
    public Catalogo(String titolo, Integer annoPubblicazione, int numeroPagine) {
        this.ISBN = nextISBN;
        nextISBN++;
        this.titolo = titolo;
        this.annoPubblicazione = annoPubblicazione;
        this.numeroPagine = numeroPagine;
    }

    // Metodi getter e setter per i campi della classe

    public static int getNextISBN() {
        return nextISBN;
    }

    public static void setNextISBN(Integer nextISBN) {
        Catalogo.nextISBN = nextISBN;
    }

    public Integer getISBN() {
        return ISBN;
    }

    public void setISBN(Integer ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public Integer getAnnoPubblicazione() {
        return annoPubblicazione;
    }

    public void setAnno(Integer annoPubblicazione) {
        this.annoPubblicazione = annoPubblicazione;
    }

    public int getNumeroPagine() {
        return numeroPagine;
    }

    public void setNumeroPagine(int numeroPagine) {
        this.numeroPagine = numeroPagine;
    }

    // Metodo toString per rappresentare l'oggetto sotto forma di stringa

    @Override
    public String toString() {
        return "Catalogo{" +
                "ISBN=" + ISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPubblicazione=" + annoPubblicazione +
                ", numeroPagine=" + numeroPagine +
                '}';
    }
}

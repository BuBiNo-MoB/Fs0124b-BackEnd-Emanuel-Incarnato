package Esercizio1;

public class Rettangolo {
    private double altezza;
    private double larghezza;

    public Rettangolo(double altezza, double larghezza) {
        this.altezza = altezza;
        this.larghezza = larghezza;
    }

    public double calcolaPerimetro() {
        return 2 * (altezza + larghezza);
    }

    public double calcolaArea() {
        return altezza * larghezza;
    }

    public void stampaRettangolo() {
        System.out.println("Altezza: " + altezza);
        System.out.println("Larghezza: " + larghezza);
        System.out.println("Perimetro: " + calcolaPerimetro());
        System.out.println("Area: " + calcolaArea());
    }

    public static void sommaDueRettangoli(Rettangolo r1, Rettangolo r2) {
        double areaTotale = r1.calcolaArea() + r2.calcolaArea();
        double perimetroTotale = r1.calcolaPerimetro() + r2.calcolaPerimetro();

        System.out.println("Somma delle aree: " + areaTotale);
        System.out.println("Somma dei perimetri: " + perimetroTotale);
    }

    public static void main(String[] args) {
        Rettangolo rettangolo1 = new Rettangolo(5.0, 3.0);
        Rettangolo rettangolo2 = new Rettangolo(7.0, 4.0);

        rettangolo1.stampaRettangolo();
        rettangolo2.stampaRettangolo();

        sommaDueRettangoli(rettangolo1, rettangolo2);
    }
}

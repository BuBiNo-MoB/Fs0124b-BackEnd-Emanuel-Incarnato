package data;

import jakarta.persistence.Entity;

@Entity
public class Riviste extends Catalogo {
    private Periodicità periodicità;


    public Riviste(String titolo, Integer annoPubblicazione, Integer numeroPagine) {
        super( titolo, annoPubblicazione, numeroPagine);
    }
    public Riviste(){

    }

    public Periodicità getPeriodicità() {
        return periodicità;
    }

    public void setPeriodicità(Periodicità periodicità) {
        this.periodicità = periodicità;
    }

    @Override
    public String toString() {
        return "Riviste{" +
                "periodicità=" + periodicità +
                '}';
    }
}

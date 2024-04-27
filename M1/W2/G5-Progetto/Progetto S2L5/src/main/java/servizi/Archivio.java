package servizi;

import data.Catalogo;

import java.util.Optional;

// L'interfaccia Archivio definisce le operazioni consentite su un archivio di elementi del catalogo.
// Le operazioni includono l'aggiunta di un elemento, la rimozione di un elemento per ISBN, la ricerca di un elemento per ISBN o anno di pubblicazione,
// e la ricerca di elementi per autore.

public interface Archivio {
    // Metodo per aggiungere un elemento all'archivio
    void add(Catalogo c);

    // Metodo per rimuovere un elemento dall'archivio dato il suo ISBN
    void deleteISBN(Integer ISBN);

    // Metodo per ottenere un elemento dall'archivio dato il suo ISBN
    Optional<Catalogo> getByISBN(Integer ISBN);

    // Metodo per ottenere un elemento dall'archivio dato l'anno di pubblicazione
    Optional<Catalogo> getAnno(Integer anno);

    // Metodo per ottenere gli elementi dell'archivio di un determinato autore
    void getAutore(String autore);
}

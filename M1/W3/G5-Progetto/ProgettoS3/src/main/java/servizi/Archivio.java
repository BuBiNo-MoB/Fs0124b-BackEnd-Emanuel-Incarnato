package servizi;
import java.util.List;
import java.util.Optional;
import data.Catalogo;
import data.Prestito;

public interface Archivio {
    // Metodo per salvare i cataloghi nel file CSV
    void save(Catalogo cat);

    void add(Catalogo c);
    void deleteISBN(Integer ISBN);

    List<Catalogo> getByTitolo(String titolo);

    List<Catalogo> getElementiInPrestito(Integer numeroTessera);

    List<Prestito> getPrestitiScadutiNonRestituiti();

    Optional<Catalogo> getISBN (Integer ISBN);

    List<Catalogo> getByAutore(String autore);

    List<Catalogo> getAnno(Integer anno);
    void getAutore(String autore);

}

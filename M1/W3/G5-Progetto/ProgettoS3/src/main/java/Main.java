import data.Libri;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import servizi.FileArchivio;


public class Main {
    Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {

        var FileArchivio = new FileArchivio();
        Libri libri1 = new Libri("Bubino va in campagna",1990,6969,"Emanuel","trash");
        Libri libri2 = new Libri("Il signore degli anelli", 1954, 340, "J.R.R. Tolkien", "fantasy");
        Libri libri3 = new Libri("Harry Potter e la pietra filosofale", 1997, 1560, "J.K. Rowling", "fantasy");
        Libri libri4 = new Libri("1984", 1949, 650, "George Orwell", "dystopian");
        Libri libri5 = new Libri("Il piccolo principe", 1943, 150, "Antoine de Saint-Exupéry", "fable");

        //FileArchivio.save(libri1);
        //FileArchivio.save(libri4);
        //FileArchivio.save(libri5);
        //FileArchivio.deleteISBN(2);
        //FileArchivio.deleteISBN(3);
        System.out.println(FileArchivio.getByAutore("George Orwell"));
    }
}
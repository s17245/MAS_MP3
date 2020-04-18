import java.util.UUID;

public class Scenariusz extends Zapis {

    //private static final long serialVersionUID = 7053246124576210409L;
    String nazwa;
    String klucz = UUID.randomUUID().toString();
    Paragraf start;
    String data;

    public Scenariusz(String nazwa, String klucz,  Paragraf pierwszyParagraf, String data) {
        this.nazwa = nazwa;
        this.klucz = klucz;
        this.start = pierwszyParagraf;
        this.data = data;
        System.out.println("Scenariusz " + nazwa + " uruchomiony: " + data);
    }

    /*
     pseudonim autora;
     listaParagrafów;
     liczbaParagrafów
     liczbaZnaków;
    czyPrzeczytany;
    */

}

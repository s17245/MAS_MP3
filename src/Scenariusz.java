/*
s17245
 */

import java.util.UUID;

public class Scenariusz extends Zapis {

    //private static final long serialVersionUID = 7053246124576210409L;
    private String nazwa;
    ///private String klucz = UUID.randomUUID().toString();
    private String klucz;
    private Paragraf start;
    private String data;

    public Scenariusz(){}

    public Scenariusz (String nazwa, String klucz,  Paragraf pierwszyParagraf, String data) {

        this.nazwa = nazwa;
        this.klucz = klucz;
        this.start = pierwszyParagraf;
        this.data = data;
        System.out.println("Scenariusz " + nazwa + " uruchomiony: " + data);

        if(nazwa.equals("") || klucz.equals("") || pierwszyParagraf==null){
            System.out.println("podano niewłaściwe dane");
        }

    }

    /*
     pseudonim autora;
     listaParagrafów;
     liczbaParagrafów
     liczbaZnaków;
    czyPrzeczytany;
    */


    public String toString() {

        return    this.nazwa + " " + this.data;

    }

}

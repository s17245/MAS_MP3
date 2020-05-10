/*
s17245
 */

public class Paragraf extends Zapis {

    private static int licznik;
    //private static final long serialVersionUID = 7058247124576220209L;
    private Paragraf paragraf;

    private String nazwa;
    private String text;
    //String kluczRodzic = UUID.randomUUID().toString();
    private String kluczRodzic;
    //String kluczDzieckoLewe = UUID.randomUUID().toString();
    //String kluczDzieckoPrawe = UUID.randomUUID().toString();
    private Paragraf paragrafLewy;
    private Paragraf paragrafPrawy;
    private Paragraf góra;
    private Paragraf dół;


    // pierwszy
    public Paragraf(String nazwa, String kluczRodzic, String text, Paragraf dziecko) {

        this.nazwa = nazwa;
        this.kluczRodzic = kluczRodzic;
        this.text = text;
        this.paragraf = dziecko;
        System.out.println(text);
        licznik++;
    }

    // ostatni
    public Paragraf(String nazwa, Paragraf paragraf, String text) {

        this.nazwa = nazwa;
        this.paragraf = paragraf;
        this.text = text;
        System.out.println(text);
        licznik++;

    }

    //pośredni paragraf
    public Paragraf(String nazwa, Paragraf góra, Paragraf dół, String text) {

        this.nazwa  =   nazwa;
        //this.kluczRodzic  =   kluczRodzic;
        //this.kluczDzieckoLewe = kluczDzieckoLewe;
        this.góra = góra;
        this.dół = dół;
        this.text = text;
        System.out.println(text);
        licznik++;

    }

    // Y paragraf
    public Paragraf(String nazwa, Paragraf góra, Paragraf dzieckoLewe, Paragraf dzieckoPrawe, String text) {

        this.nazwa  =   nazwa;
        this.góra   =   góra;
        this.paragrafLewy = dzieckoLewe;
        this.paragrafPrawy = dzieckoPrawe;
        this.text   =   text;
        //this.kluczRodzic  =   kluczRodzic;
        //this.kluczDzieckoLewe = kluczDzieckoLewe;
        //this.kluczDzieckoPrawe = kluczDzieckoPrawe;
        System.out.println(text);
        licznik++;

    }

    public static int policzParagrafy() {

        return licznik;
    }

    public String toString() {

        return    nazwa + " " + text;

    }

}

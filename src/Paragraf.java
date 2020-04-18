public class Paragraf extends Zapis {

    //private static final long serialVersionUID = 7058247124576220209L;
    private Paragraf paragraf;

    String nazwa;
    String text;
    //String kluczRodzic = UUID.randomUUID().toString();
    String kluczRodzic;
    //String kluczDzieckoLewe = UUID.randomUUID().toString();
    //String kluczDzieckoPrawe = UUID.randomUUID().toString();
    Paragraf paragrafLewy;
    Paragraf paragrafPrawy;
    Paragraf góra;
    Paragraf dół;
    private static int licznik;


    public Paragraf() {

    }


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
        this.text   =   text;
        this.góra   =   góra;
        this.paragrafLewy = dzieckoLewe;
        this.paragrafPrawy = dzieckoPrawe;
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

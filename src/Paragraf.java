/*
s17245
 */

import java.util.List;

public class Paragraf extends Zapis {


    private Paragraf paragraf;
    private static int licznik;
    public String nazwa;
    private String text;
    private List<Mechanizm> mechanizm;
    private Scenariusz scenariusz;
    public int LiczbaKońcowa;


    // pierwszy
    public Paragraf(String nazwa, String text, int LiczbaKońcowa) {

        //this.mechanizm = mechanizm;List<Mechanizm> mechanizm
        this.nazwa = nazwa;
        this.text = text;
        this.LiczbaKońcowa = LiczbaKońcowa;

        //System.out.println(text);
        licznik++;
    }

    public void ustawScenariusz(Scenariusz scenariusz) {
        this.scenariusz = scenariusz;

    }


    public static int policzParagrafy() {

        return licznik;
    }


    public int usuńLicznik(int licznik) {
        Paragraf.licznik = licznik;
        licznik = 0;
        return licznik;
    }

    public void dodajMechanizm() {
    }

    @Override
    public String toString() {

        return "paragraf: " + nazwa + " tekst: " + text;

    }

    public int dajLiczbeKońcową(){
        return LiczbaKońcowa;

    }

    public String dajOpis() {
        return text;
    }
}

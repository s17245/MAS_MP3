/*
s17245
 */

import java.util.List;

public class Paragraf extends Zapis {

    /**
     * atrybuty zostały zmodyfikowane na potrzby mvp
     */

    private Paragraf paragraf;
    private static int licznik;
    public String nazwa;
    private String text;
    private List<Mechanizm> mechanizm;
    private Scenariusz scenariusz;
    public int LiczbaKońcowa;


    /**
     *
     * @param nazwa nazwa paragrafu
     * @param text tekst paragrafu
     * @param LiczbaKońcowa liczba końcowa paragrafu, determinująca czy jest ostatni czy nie
     * @throws Exception zostanie podniesiony wyjątek jeśli długość tekstu przekroczy 1800
     */
    public Paragraf(String nazwa, String text, int LiczbaKońcowa) throws Exception {

        //this.mechanizm = mechanizm;List<Mechanizm> mechanizm
        this.nazwa = nazwa;
        this.text = text;
        this.LiczbaKońcowa = LiczbaKońcowa;

        if(text.length()>1800){
            throw new Exception("tekst jest za długi");
        }
        //System.out.println(text);
        licznik++;
    }

    /**
     * przypisuje scenariusz do paragrafu
     * @param scenariusz scenariusz do którego przypisujemy paragraf
     */
    public void ustawScenariusz(Scenariusz scenariusz) {
        this.scenariusz = scenariusz;

    }

    /**
     * liczy ile paragrafów zostało użytych
     * @return liczba paragrafów
     */
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

    /**
     * zwraca liczbę końcową
     * @return liczba końcowa paragrafu
     */
    public int dajLiczbeKońcową(){
        return LiczbaKońcowa;

    }

    /**
     * zwraca tekst paragrafu
     *
     * @return tekst paragrafu
     */
    public String dajOpis() {
        return text;
    }
}

/*
s17245
 */

import java.util.ArrayList;

public class Scenariusz extends Zapis {


    public String nazwa;
    private final String autor;
    private final String ocena;
    private Gielda gielda; //asocjacja 1..* - licznośc 1
    public ArrayList<Paragraf> listaParagrafów = new ArrayList<>();

    public Scenariusz(String nazwa, String autor, String ocena) {

        // this.gielda = gielda;
        this.nazwa = nazwa;
        this.autor = autor;
        this.ocena = ocena;

        /**
         * sprawdzenie czy nazwa została podana
         */
        if (nazwa.equals("")) {
            System.out.println("podano niewłaściwe dane");
        }
    }

//setter

    /**
     * ustawia giełdę na wybaraną
     *
     * @param gielda
     */
    public void ustawGielde(Gielda gielda) {
        this.gielda = gielda;

    }
//getter

    /**
     * zwraca giełdę
     *
     * @param gielda wybrana giełda
     * @return zwrócona giełda
     */
    public Gielda pobierzGielde(Gielda gielda) {

        return gielda;
    }

    /**
     * zwraca autora scenariusza
     *
     * @return autor scenariusza
     */
    public String getAutor() {
        return autor;
    }

    /**
     * zwraca nazwę scenariusza
     *
     * @return nazwa scenariusza
     */
    public String getNazwa() {
        return nazwa;
    }

    /**
     * zwraca ocenę scenariusza
     *
     * @return ocena scenariusza
     */
    public String getOcena() {
        return ocena;
    }

    /**
     * dodaje paragraf do scenariusza, kompozycja - liczność 1..*
     *
     * @param p
     * @throws Exception
     */
    public void dodajParagraf(Paragraf p) throws Exception {

        if (!listaParagrafów.contains(p)) {
            this.listaParagrafów.add(p);
            p.ustawScenariusz(this);

        } else {
            throw new Exception("paragraf już istnieje");
        }
    }

    @Override
    public String toString() {
        String text = "Gielda: " + nazwa + "\n";
        return text;
    }
}

/*
s17245
 */

import java.util.ArrayList;

public class Scenariusz extends Zapis {


    public String nazwa;
    private String text;
    private String autor;
    private String ocena;
    private Gielda gielda; //asocjacja 1..* - licznośc 1
    public ArrayList<Paragraf> listaParagrafów = new ArrayList<>();

    public Scenariusz (String nazwa, String autor, String ocena) {

        // this.gielda = gielda;
        this.nazwa = nazwa;
        this.autor=autor;
        this.ocena=ocena;

        if(nazwa.equals("")){
            System.out.println("podano niewłaściwe dane");
        }
    }

//setter
    public void ustawGielde(Gielda gielda) {
        this.gielda = gielda;

    }
//getter
    public Gielda pobierzGielde(Gielda gielda){

        return gielda;
    }

    public String getAutor() {
        return autor;
    }
    public String getNazwa() {
        return nazwa;
    }
    public String getOcena() {
        return ocena;
    }

    public void dodajParagraf(Paragraf p) throws Exception {

        if (!listaParagrafów.contains(p)) {
            this.listaParagrafów.add(p);
            p.ustawScenariusz(this);

        }else{
            throw new Exception("paragraf już istnieje");
        }
    }

    @Override
    public String toString(){
        String text = "Gielda: " + nazwa + "\n";
        return text ;
    }


}

/*
s17245
 */

import java.util.ArrayList;
import java.util.List;

public class Gracz extends Zapis {


    //private static final long serialVersionUID = 7098247124574220209L;
    protected String imie;
    protected String nazwisko;
    protected String email;
    private String at = "@";
    protected static String nick;
    protected static String hasło;
    protected int idRola;
    protected String[] rolaName = new String[]{"Gracz", "Autor", "Developer"};
    protected String RODO;


    private List<SprawdźPesel> sprawdźPeselMap = new ArrayList<>();

    public Gracz(String imie, String nazwisko, String email, String nick, String hasło,int idRola, String RODO) throws Exception {

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.at = at;
        this.nick = nick;
        this.hasło = hasło;
        this.idRola = idRola;
        this.RODO = RODO;

        if (idRola < 0 && idRola > 2) {
            throw new Exception("wybrano niewłaściwy id roli");
        }

        if (!email.contains(at)) {
            throw new Exception("w adresie zabrakło @ ");
        }

        if (nick==null) {
            this.nick = "brak nick'a";
        }
    }


    public String toString() {

        return dajRole(idRola) + ", " + imie + " " + nazwisko + " , email: " + email + ", Nick: " + nick + ", zgoda udzielona: " + sprawdźRodo(RODO);

    }

    public String dajRole(int i) {

        return this.rolaName[i];

    }

    public static String dajNick() {
        return nick;

    }

    public static String dajHasło(){
        return hasło;

    }

    public boolean sprawdźRodo(String RODO) {

        if (this.RODO.equals("tak")) {
            return true;
        } else {
            return false;
        }
    }

    void otworzZapisanaGre() {

    }

    void zapiszGre() {

    }

    public void dodajPesel(SprawdźPesel sprawdźPesel) {
        if(!sprawdźPeselMap.contains(sprawdźPesel)){
            sprawdźPeselMap.add(sprawdźPesel);
            sprawdźPesel.dodajPeselDoGracza(this);
        }
        System.out.println("pesel "+ sprawdźPeselMap);
    }
}

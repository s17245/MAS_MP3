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
    protected String nick;
    protected String hasło;
    protected int idRola;
    protected String[] rolaName = new String[]{"Gracz", "Autor", "Developer"};
    protected String RODO;
    public int zapisanyParagraf = 0;


    private final List<SprawdźPesel> sprawdźPeselMap = new ArrayList<>();

    /**
     * @param imie     imie
     * @param nazwisko nazwisko
     * @param email    email
     * @param nick
     * @param hasło
     * @param idRola
     * @param RODO
     * @param zapis
     * @throws Exception
     */
    public Gracz(String imie, String nazwisko, String email, String nick, String hasło, int idRola, String RODO, int zapis) throws Exception {

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.at = at;
        this.nick = nick;
        this.hasło = hasło;
        this.idRola = idRola;
        this.RODO = RODO;
        this.zapisanyParagraf = zapis;

        if (idRola < 0 && idRola > 2) {
            throw new Exception("wybrano niewłaściwy id roli");
        }

        /**
         * sprawdzenie czy w adresie zawarto "@"
         */
        if (!email.contains(at)) {
            throw new Exception("w adresie zabrakło @ ");
        }
        /**
         * sprawdzenie czy podano nick
         */
        if (nick == null) {
            this.nick = "brak nick'a";
        }
    }


    public String toString() {

        return dajRole(idRola) + ", " + imie + " " + nazwisko + " , email: "
                + email + ", Nick: " + nick + ",hasło: " + hasło
                + ", zgoda udzielona: " + sprawdźRodo(RODO);

    }

    /**
     * zwraca role gracza
     *
     * @param i numer indeksu roli gracza
     * @return
     */
    public String dajRole(int i) {
        return this.rolaName[i];
    }

    /**
     * zwraca nick gracza
     *
     * @return
     */
    public String dajNick() {
        return nick;
    }

    /**
     * zwraca hasło gracza
     *
     * @return
     */
    public String dajHasło() {
        return hasło;
    }

    /**
     * sprawdza czy zgoda RODO została udzielona czy nie
     *
     * @param RODO podana przez użytkownika zgoda: "tak" lub "nie"
     * @return
     */
    public boolean sprawdźRodo(String RODO) {

        return this.RODO.equals("tak");
    }

    void otworzZapisanaGre() {
    }

    void zapiszGre() {
    }

    /**
     * dodaje pesel do gracza poprzez asocjacje kwalifikowana gracz-pesel
     *
     * @param sprawdźPesel obiekt z nr pesel
     */
    public void dodajPesel(SprawdźPesel sprawdźPesel) {
        if (!sprawdźPeselMap.contains(sprawdźPesel)) {
            sprawdźPeselMap.add(sprawdźPesel);
            sprawdźPesel.dodajPeselDoGracza(this);
        }
        System.out.println("pesel " + sprawdźPeselMap);
    }
}

public class Gracz extends Zapis {

    //private static final long serialVersionUID = 7098247124574220209L;
    public String imie;
    public String nazwisko;
    public String email;
    private String at = "@";
    public String nick;  //   #dej optional
    public int idRola;
    private String[] rolaName = new String[]{"Gracz", "Autor", "Developer"};
    public String RODO;

    public Gracz(String imie, String nazwisko, String email, String nick, int idRola, String RODO) throws Exception {

        this.imie = imie;
        this.nazwisko = nazwisko;
        this.email = email;
        this.at = at;
        this.nick = nick;
        this.idRola = idRola;
        this.RODO = RODO;

        if (idRola < 0 && idRola > 2) {
            throw new Exception("wybrano niewłaściwy id roli");
        }

        if (!email.contains(at)) {
            throw new Exception("w adresie zabrakło @ ");
        }

        if (nick.contains("")) {
            this.nick = "brak nick'a";
        }
    }

    public String toString() {

        return dajRole(idRola) + " " + imie + " " + nazwisko + " email: " + email + " Nick: " + nick + " zgoda udzielona: " + sprawdźRodo(RODO);

    }

    public Gracz() {
    }

    public String dajRole(int i) {

        return this.rolaName[i];

    }

    public String dajNick() {
        return this.nick;

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

}

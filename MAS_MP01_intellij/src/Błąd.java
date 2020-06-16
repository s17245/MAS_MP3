import java.io.Serializable;

public class Błąd extends ZapisPlus implements Serializable {

    protected String nazwa;
    private String data;
    private String opis;

    private Błąd(String nazwa, String opis, String data) {

        this.nazwa = nazwa;
        this.opis = opis;

    }

    /**
     * zgłasza błąd
     * @param nazwa nazwa błędu
     * @param opis opis błędu
     * @param nowaData data błędu
     * @return
     */
    protected static Błąd zgłośBłąd(String nazwa, String opis, String nowaData) {

        Błąd błąd = new Błąd(nazwa, opis, nowaData);

        return błąd;

    }

    public String pobierzCzas() {
        return data;
    }

    @Override
    public String toString() {
        return "błąd: " + nazwa;

    }
}

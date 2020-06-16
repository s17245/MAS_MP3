import java.io.Serializable;

public class Mechanizm extends ZapisPlus implements Serializable {

    /**
     * na potrzeby mvp mechanizmy nie zostały użyte, w planach multimedia, np. dźwięki, efekty graficzne etc
     */

    private static int licznik;
    public String nazwa;


    public Mechanizm(String nazwa) {

        this.nazwa = nazwa;
        licznik++;
    }

    public static int policzMechanizmy() {

        return licznik;
    }

    @Override
    public String toString() {

        return "mechanizm: " + nazwa;// + " liczba " + licznik;

    }

    /**
     * zgłasza błąd
     *
     * @param nazwa nazwa błędu
     * @param opis  krótki opis błędu
     * @param data  data utworzenia błędu
     * @throws Exception wyjątek podniesiony w razie niepowodzenia
     */
    public void zgłośBłąd(String nazwa, String opis, String data) throws Exception {

        if (this != null) {

            Błąd błąd = Błąd.zgłośBłąd(nazwa, opis, data);

            this.addPart(błąd.nazwa, this.nazwa, błąd.pobierzCzas(), błąd);

        } else {

            System.out.println("nie istenieje błąd");

        }

    }

}

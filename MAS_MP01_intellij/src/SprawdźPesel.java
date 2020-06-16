import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SprawdźPesel extends Zapis {

    protected String nazwa;
    protected String pesel;

    private final Map<String, Gracz> peselMap = new TreeMap<>();

    /**
     * Sprawdza poprawność identyfikatora pesel
     *
     * @param nazwa identyfikator nr pesel
     * @param pesel nr pesel
     * @throws Exception wyjątek kiedy pesel będzie miał niewłaściwą długość, lub nie zawierał cyfry
     */
    public SprawdźPesel(String nazwa, String pesel) throws Exception {

        this.pesel = pesel;
        this.nazwa = nazwa;
        Pattern pattern = Pattern.compile("[0-9]{11}");
        Matcher matcher = pattern.matcher(pesel);

        if (pesel.length() != 11 && !matcher.find()) {
            throw new Exception("pesel jest niewłaściwy");
        }
        //na potrzeby projektu,nie będę walidował prawdziwych nr pesel
    }

    /**
     * dodaje pesel do gracza poprzez asocjacje kwalifikowana gracz-pesel
     *
     * @param gracz użytwkownik któremu zostanie przypisany pesel
     */
    public void dodajPeselDoGracza(Gracz gracz) {

        if (!peselMap.containsKey(gracz.nick)) {
            peselMap.put(gracz.nick, gracz);
            gracz.dodajPesel(this);

        }
    }

    /**
     * odnajduje pesel wybranego gracza
     *
     * @param nick "nick" użytkownika
     * @return metoda zwraca Gracza
     * @throws Exception kiedy znaleziono "nicka", wyjątek zostaje podniesiony
     */
    public Gracz znajdźPeselGracza(String nick) throws Exception {

        if (!peselMap.containsKey(nick)) {
            throw new Exception("nie ma takiego nicka: " + nick);
        }
        return peselMap.get(nick);
    }

    @Override
    public String toString() {

        return "pesel: " + pesel;
    }
}

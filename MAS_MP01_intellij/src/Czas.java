import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Czas {

    String data = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
    String czas = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());

    /**
     * zwraca date i godzinę jako String do łatwiejszego wyświetlania
     *
     * @return
     */
    public String pobierzCzas() {
        return data + " " + czas;

    }

    /**
     * zwraca godzinę
     * @return
     */
    public String dajGodzine() {
        return czas;

    }

    /**
     * zwraca date
     * @return
     */
    public String dajDate() {
        return data;

    }


    @Override
    public String toString() {
        return "Czas{" +
                "data='" + data + '\'' +
                ", czas='" + czas + '\'' +
                '}';
    }
}

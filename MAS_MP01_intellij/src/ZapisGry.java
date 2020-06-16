public class ZapisGry {

    /**
     * użyto Object+ i Object++ do zapisywania danych
     */

    public Czas data;
    public Czas czas;
    public Gracz g;
    public Paragraf p;


    /**
     * zwraca date i godzinę jako String do łatwiejszego wyświetlania
     *
     * @return
     */
    public String pobierzCzas() {
        return data + " " + czas;

    }
}

public class IlośćWystąpień extends ZapisPlus {

    private final int licznik;
    protected String nazwa = "ilośćWystąpień";

    /**
     * ilość wystąpień mechanizmu podczas przełączania paragrafów
     *
     * @param licznik ilość wystąpień mechanizmu
     */
    private IlośćWystąpień(int licznik) {
        super();
        this.licznik = licznik;

    }

    /**
     * dodaje mechanizm do paragrafu - asocjacja z atrybutem przy użyciu object++
     *
     * @param paragraf  paragraf
     * @param mechanizm mechanizm
     * @param licznik   licznik wystąpień
     * @throws Exception wyjątek podniesiony w razie niepowodzenia
     */
    public static void dodajMechanizmDoParagrafu(Paragraf paragraf, Mechanizm mechanizm, int licznik) throws Exception {

        if (paragraf != null && mechanizm != null) {
            for (int i = 0; licznik <= Mechanizm.policzMechanizmy(); i++) {

                IlośćWystąpień ilośćWystąpień = new IlośćWystąpień(licznik);
                ilośćWystąpień.addLink(mechanizm.nazwa, ilośćWystąpień.nazwa, mechanizm);
                ilośćWystąpień.addLink(paragraf.nazwa, ilośćWystąpień.nazwa, paragraf);
                //licznik--;
            }
            //paragraf.usuńLicznik(licznik);
        } else {
            throw new Exception("nie udało się dodać mechanizmu do paragrafu");
        }
    }

//    public String showMechanizmParagraf(){
//
//    }

    @Override
    public String toString() {
        return "użyto" + licznik + "mechanizmów";
    }
}

public class ElementyGiełdy extends Zapis{

    private String nazwa;
    private String autor;
    private String ocena;

    public ElementyGiełdy (String nazwa, String autor, String ocena){

        super();
        this.nazwa = nazwa;
        this.autor = autor;
        this.ocena = ocena;
    }

    public String getNazwa() {
        return nazwa;
    }
    public String getOcena(){
        return ocena;
    }
    public String getAutor() {
        return autor;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setOcena(String ocena) {
        this.ocena = ocena;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }





    @Override
    public String toString() {
        return "ElementyGiełdy{" +
                "nazwa='" + nazwa + '\'' +
                ", autor='" + autor + '\'' +
                ", ocena='" + ocena + '\'' +
                '}';
    }
}

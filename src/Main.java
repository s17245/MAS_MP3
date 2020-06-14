/*
s17245
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {

    protected static String plikZapisu = "C:\\Users\\Lucek\\MP1\\MP1.bin";

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("C_welcomeScreen.fxml"));
        primaryStage.setTitle("Fantasolo");
        primaryStage.setScene(new Scene(root, 500, 350));
        primaryStage.show();
    }
//    MainGUI gui = new MainGUI();

    public static void main(String[] args) throws Exception {



        //System.out.println(System.getProperty("user.home"));
        //utworzGraczy();
        //utworzScenariusz();
        //System.out.println("liczba paragrafów: " + Paragraf.policzParagrafy());
//serializacja
      File plik = new File(plikZapisu);

        if (plik.exists()) {
            //odczyt
            ObjectInputStream strumieńOdczytu = new ObjectInputStream(new FileInputStream(plik));
            Zapis.czytajZapis(strumieńOdczytu);
            //Zapis.pokażZapis(Gracz.class);
            Zapis.pokażZapis(Paragraf.class);

            strumieńOdczytu.close();
            System.out.println("\n" + "zapis istnieje, odczytuję");

            //plik.delete();
            //System.out.println("\n" + "zapis istnieje, odczytuję i usuwam");

        } else {
            // zapis
        // MP1
            //utworzGraczy();
            //utworzScenariusz();
        // MP2
            //asocjacja z atrybutem, z ojb++
            //utworzParagrafMechanizm();

            //asocjacja 1..* przez referencje
            utworzGieldeScenariusz();

            //asocjacja Kompozycja, addpart z obj++ i private błąd
            utworzMachanizmBłąd();

            //asocjacja kwalifikowana, TreeMap
            utworzGraczPesel();


            //Serializacja /*
            //System.out.println("liczba paragrafów: " + Paragraf.policzParagrafy());
            ObjectOutputStream strumieńZapisu = new ObjectOutputStream(new FileOutputStream(plik));
            Zapis.zrobZapis(strumieńZapisu);
            strumieńZapisu.close();
            System.out.println("\n" + "zapis nie istnieje, zapisuję");
            }

        //GUI
        launch(args);
    }

    //asocjacja kwalifikowana
    private static void utworzGraczPesel() throws Exception {
        Gracz gracz1 = new Gracz("Grzegorz","Brzęczyszczykiewicz","greg@greg.com", "greg", "123",0 ,"tak");
        SprawdźPesel p1 = new SprawdźPesel("greg","87654312345");
        p1.dodajPeselDoGracza(gracz1);
        //System.out.println("\n" + p1);
        System.out.println(p1.znajdźPeselGracza("greg"));

    }
    //asocjacja Kompozycja, addpart z obj++ i private błąd
    private static void utworzMachanizmBłąd() throws Exception {
        Mechanizm mechanizm = new Mechanizm( "Błąd audio" +"\n");
        mechanizm.zgłośBłąd("nie działa","nie słysze","15-07-2020");
        System.out.println(mechanizm);
    }
    //asocjacja 1..* przez referencje
    public static void utworzGieldeScenariusz() throws Exception {

        Gielda gielda = new Gielda("Bajki dla dzieci",5);
        Scenariusz sc1 = new Scenariusz("pierwszy scenariusz", "Kowalsky","3");
        Scenariusz sc2 = new Scenariusz("drugi scenariusz", "MarianoItaliano","4");

        Paragraf p1 = new Paragraf("sc1Pierwszy", "Witaj, lewo B, prawo A ",2);
        Paragraf p2 = new Paragraf("sc1Drugi", "Prawo , prawo - A",1);
        Paragraf p3 = new Paragraf("sc1Trzeci", "Lewo -  Koniec ",0);
        Paragraf p4 = new Paragraf("sc1Czwarty", "Lewo - Koniec ",0);
        Paragraf p5 = new Paragraf("sc1Piąty", "Lewo - Koniec ",0);

        sc1.dodajParagraf(p1);
        sc1.dodajParagraf(p2);
        sc1.dodajParagraf(p3);
        sc1.dodajParagraf(p4);
        sc1.dodajParagraf(p5);

        gielda.dodajScenariusz(sc1);
        System.out.println(gielda);

        System.out.println("scenariusz utoworzono: " + sc1);

    }
    //asocjacja z atrybutem, z ojb++
    public static void utworzParagrafMechanizm() throws Exception {

        Paragraf paragraf = new Paragraf("pierwszy","ala ma kotaaaa",2);
        Mechanizm mechanizm = new Mechanizm("audio");

        //System.out.println("liczba mechanizmów: " + mechanizm.policzMechanizmy());

    //IlośćWystąpień ilośćWystąpień = new IlośćWystąpień(5);  //nie moge dostać się do prywatnego konstruktora

        IlośćWystąpień.dodajMechanizmDoParagrafu(paragraf, mechanizm, 2);
        //System.out.println();
        System.out.println(paragraf);
        System.out.println(mechanizm + "\n");
    }



    /*


####################################################################################
*/
//    public static void utworzGraczy() throws Exception {
//
//        List<Gracz> lista = new ArrayList<>();
//        lista.add(new Gracz("Maciek", "Skrzek", "s17245@pja.pl", "lucek", "123",1, "tak"));
//        lista.add(new Gracz("Grzegorz", "Brzęczyszczykiewicz", "fdsf@fa.pl", "Greg", "123",2, "tak"));
//        lista.add(new Gracz("Kokos", "Kokosowy", "kokos@kokos.pl", "koks", "123",0, "nie"));
//        lista.add(new Gracz("fantom", "Jarek", "panda3@kokos.pl", "", "123",0, "nie"));
//
//        //Gracz a1 = new Autor("a1", "na1", "a1@na1.pl", "autor1", 1, "tak");
//
//        for (Gracz g : lista) {
//            System.out.println(g);
//        }
//    }

//    public static void utworzScenariusz() {
//
//        Paragraf m1 = null, m2 = null, m3 = null, m4 = null;
//        String data = String.valueOf(new Data());
//
//        Paragraf start = new Paragraf("wstęp", "test1", "Drogie dzieci", m1, null);
//        m1 = new Paragraf("n1", start, m2, m3, "ala ma kota");
//        m2 = new Paragraf("n2", m1, "i kot ma ale");
//        m3 = new Paragraf("n3", m1, m4, "albo i nie");
//        m4 = new Paragraf("n4", m3, "KONIEC");
//        Scenariusz sc = new Scenariusz("scn 1", "test1", start, data, null);
//
//    }



//    public static void pokażDate() {
//        //Data d = new Data();
//        String data = String.valueOf(new Data());
//        System.out.println(data);
//    }


            /*



MP1
• Ekstensja                         # utworzGraczy()
• Ekst. - trwałość                  # Zapis
• Atr. złożony                      # Data - godzina
• Atr. opcjonalny                   # nick w graczu
• Atr. powt                         # rolaName w graczu
• Atr. klasowy                      # at = "@" w gracz
• Atr. pochodny, wyliczany          # liczba Paragrafów
• Met. klasowa                      # zrób zapis w Zapis, a np. konstruktor w graczu?
• Przesłonięcie,                    # paragraf
• przeciążenie                      # toString() w graczu
####################################################################################
         */


}

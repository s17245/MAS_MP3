import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static javafx.fxml.FXMLLoader.load;

public class ControllerScenariusz {

    private ArrayList<Paragraf> listaPrf = new ArrayList<>();
    private int licznik = 0;
    public static String nrStrony = "0";

    @FXML
    private javafx.scene.control.Button exitBtn;
    @FXML
    private javafx.scene.control.Button zapiszBtn;
    @FXML
    private javafx.scene.control.Button zatwierdźBtn;
    @FXML
    private javafx.scene.control.Button wystawOceneBtn;
    @FXML
    private TextArea poleTekstowe;
    @FXML
    private TextField poleWyboru;
    @FXML
    private Label nazwaUżytkownika;


    @FXML
    public void nacisnijExit(ActionEvent e) {
        System.out.println("wychodze");
        Platform.exit();

    }

    @FXML
    public void nacisnijZatwierdź(ActionEvent e) {

        nrStrony = poleWyboru.getText().toString();

        poleTekstowe.setText(listaPrf.get(Integer.parseInt(nrStrony)).dajOpis());

        System.out.println("liczba końcowa to: " + listaPrf.get(Integer.parseInt(nrStrony)).dajLiczbeKońcową());
        
        
        if ( java.util.Objects.equals( listaPrf.get(Integer.parseInt(nrStrony)).dajLiczbeKońcową(), 0) ) {
            wystawOceneBtn.setVisible(true);
        } else {
            System.out.println("to nie ostatnia strona");
        }
    }

    @FXML
    public void naciśnijOcena(ActionEvent e) throws IOException {

        Parent root = load(getClass().getResource("C_ekranKońcowy.fxml"));
        Scene scene = new Scene(root, 500, 350);
        Stage scenarioStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scenarioStage.setScene(scene);
        scenarioStage.show();

    }

    @FXML
    public void nacisnijZapisz(ActionEvent e) {

        System.out.println("zapisz");
    }

    public void initialize(){

        nazwaUżytkownika.setText(ControllerEkranPowitalny.dajUżytkownika());
        wystawOceneBtn.setVisible(false);
        listaPrf.addAll(Paragraf.dajZapis(Paragraf.class));

        poleTekstowe.setText(listaPrf.get(Integer.parseInt(nrStrony)).dajOpis());
        System.out.println("poka liczbę końcową " + listaPrf.get(Integer.parseInt(nrStrony)).dajLiczbeKońcową());

    }

    public static boolean sprawdźCzyNumer (String s) {

        if (s.length() == 0 || s == null) {
            return false;
        }
        return s.chars().allMatch(Character::isDigit);

    }


}

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
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

import static javafx.fxml.FXMLLoader.load;

public class ControllerScenariusz {

    private ArrayList<Paragraf> listaPrf = new ArrayList<>();
    private int licznik = 0;

    @FXML
    private javafx.scene.control.Button exitBtn;
    @FXML
    private javafx.scene.control.Button aBtn;
    @FXML
    private javafx.scene.control.Button bBtn;
    @FXML
    private javafx.scene.control.Button zapiszBtn;
    @FXML
    private TextArea poleTekstowe;

    @FXML
    private Label nazwaUżytkownika;


    @FXML
    public void nacisnijExit(ActionEvent e) {
        System.out.println("wychodze");
        Platform.exit();


    }

    @FXML
    public void nacisnijA(ActionEvent e) throws IOException {

        System.out.println("a "+licznik);

        poleTekstowe.setText(listaPrf.get(licznik).dajOpis());
        System.out.println("poka liczbe koncowa, A " + listaPrf.get(licznik).dajLiczbeKońcową());

        if ( listaPrf.get(licznik).dajLiczbeKońcową()==0 || licznik < listaPrf.size() ) {

            Parent root = load(getClass().getResource("C_ekranKońcowy.fxml"));
            Scene scene = new Scene(root, 500, 350);
            Stage scenarioStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scenarioStage.setScene(scene);
            scenarioStage.show();

        } else if (listaPrf.get(licznik).dajLiczbeKońcową()==1 || licznik < listaPrf.size()){
            bBtn.setVisible(false);
        }else if (listaPrf.get(licznik).dajLiczbeKońcową()==2 || licznik < listaPrf.size()){
            licznik++;
        }else{
            System.out.println("############smthNotOk##############");
        }
    }

    @FXML
    public void nacisnijB(ActionEvent e) throws IOException {


        System.out.println("b "+licznik);

        poleTekstowe.setText(listaPrf.get(licznik).dajOpis());
        System.out.println("poka liczbe koncowa b: "+listaPrf.get(licznik).dajLiczbeKońcową());

        if ( listaPrf.get(licznik).dajLiczbeKońcową()==0 || licznik < listaPrf.size() ) {

            Parent root = load(getClass().getResource("C_gielda.fxml"));
            Scene scene = new Scene(root, 500, 350);
            Stage scenarioStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scenarioStage.setScene(scene);
            scenarioStage.show();

        } else {
            licznik += 2;
        }
    }

    @FXML
    public void nacisnijZapisz(ActionEvent e) {

        System.out.println("zapisz");
    }

    public void initialize(){

        nazwaUżytkownika.setText(ControllerEkranPowitalny.dajUżytkownika());
        listaPrf.addAll(Paragraf.dajZapis(Paragraf.class));
        System.out.println(listaPrf.size());

        poleTekstowe.setText(listaPrf.get(licznik).dajOpis());
        System.out.println("poka liczbę końcową " + listaPrf.get(licznik).dajLiczbeKońcową());

    }

    public void akcjaPrzycisku(){


    }

}

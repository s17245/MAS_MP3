import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class ControllerEkranPowitalny {

    private ArrayList<Gracz> listaGraczy = new ArrayList<>();
    private ArrayList<String> listaNicków = new ArrayList<>();
    private ArrayList<String> listaPswd = new ArrayList<>();
    protected static String użytkownik;
    private static String pswd;

    @FXML
    private javafx.scene.control.Button exitBtn;
    @FXML
    private javafx.scene.control.Button loginBtn;
    @FXML
    private javafx.scene.control.Label msgLabel;
    @FXML
    private javafx.scene.control.PasswordField pswdText;
    @FXML
    private javafx.scene.control.TextField userText;


    @FXML
    public void pressExit(ActionEvent e) {
        System.out.println("wychodze");
        Platform.exit();
    }

    @FXML
    public void initialize() {

        listaGraczy.addAll(Gracz.dajZapis(Gracz.class));

        for ( Gracz g: listaGraczy){
            listaNicków.add(g.dajNick());
            listaPswd.add(g.dajHasło());
        }
    }


    @FXML
    public void pressLogin(ActionEvent e) throws Exception {

        //listaGraczy.addAll(Gracz.dajZapis(Gracz.class));
        użytkownik = userText.getText().toString();
        pswd = pswdText.getText().toString();

        System.out.println("*******user*********" + użytkownik);
        System.out.println("*******pswd*********" + pswd);

        if ( listaNicków.contains(użytkownik) && listaPswd.contains(pswd) ) {

            //java.util.Objects.equals( listaPrf.get(Integer.parseInt(nrStrony)).dajLiczbeKońcową()
            Parent root = FXMLLoader.load(getClass().getResource("C_gielda.fxml"));
            Scene scene = new Scene(root, 500, 350);
            Stage scenarioStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scenarioStage.setScene(scene);
            scenarioStage.show();

            System.out.println("login pass");

            msgLabel.setText("login i hasło poprawne, udzielam dostępu");
        } else {
            msgLabel.setText("login i hasło niepoprawne");
        }



//        for (Gracz g : listaGraczy){
//            System.out.println("przed pętlą" + g.dajNick());
//            if ( g.dajNick() == użytkownik && g.dajHasło().equals(pswd)){
//                System.out.println(" w ifie" + g.dajNick());
//
//            }else{
//                msgLabel.setText("błędny login i hasło");
//            }
//        }

//        for (Scenariusz s : listaScn) {
//            if (s.getNazwa() == wybranyScn) {
//                nazwaAutor.setText("autor: " + s.getAutor());
//                nazwaOcena.setText("ocena: " + s.getOcena());
//            }
//        }

        //Gracz.dajNick().equals(userText.getText().toString()) &&
//            Gracz.dajHasło().equals(pswdText.getText().toString())
        //listaGraczy.contains(użytkownik) && listaGraczy.contains(pswd)






//        }else {
//
//        }
    }

    public static String dajUżytkownika() {

        return użytkownik;
    }
}

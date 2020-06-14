import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class ControllerEkranPowitalny {

    @FXML private javafx.scene.control.Button exitBtn;
    @FXML private javafx.scene.control.Button loginBtn;
    @FXML private javafx.scene.control.Label msgLabel;
    @FXML private javafx.scene.control.PasswordField pswdText;
    @FXML private javafx.scene.control.TextField userText;

    public static String użytkownik;

    @FXML
    public void pressExit(ActionEvent e) {
        System.out.println("wychodze");
        Platform.exit();
    }



    @FXML
    public void pressLogin(ActionEvent e) throws Exception {
        System.out.println("login");
        użytkownik = userText.getText().toString();
        System.out.println("*******user*********" + użytkownik);
        //listaGraczy.addAll(Gracz.pokażZapis(Gracz.class));
        if( 1==1//Gracz.dajNick().equals(userText.getText().toString()) &&
//            Gracz.dajHasło().equals(pswdText.getText().toString())
           ) {

            System.out.println("login pass");

            msgLabel.setText("login i hasło poprawne, udzielam dostępu");



            Parent root = FXMLLoader.load(getClass().getResource("C_gielda.fxml"));
            Scene scene = new Scene(root, 500, 350);
            Stage scenarioStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
            scenarioStage.setScene(scene);
            scenarioStage.show();



        }else {
            msgLabel.setText("błędny login i hasło");
        }
    }

    public static String dajUżytkownika(){
        return użytkownik;
    }

}

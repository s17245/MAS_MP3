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

    private final ArrayList<Gracz> listaGraczy = new ArrayList<>();
    private final ArrayList<String> listaNicków = new ArrayList<>();
    private final ArrayList<String> listaPswd = new ArrayList<>();
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

    /**
     * przycisk wyjścia
     *
     * @param e
     */
    @FXML
    public void pressExit(ActionEvent e) {
        System.out.println("wychodze");
        Platform.exit();
    }

    /**
     * załadoanie zapisu z ekstensji i dodanie zapisanych danych graczy
     */
    @FXML
    public void initialize() {

        listaGraczy.addAll(Gracz.dajZapis(Gracz.class));

        for (Gracz g : listaGraczy) {
            listaNicków.add(g.dajNick());
            listaPswd.add(g.dajHasło());
        }
    }

    /**
     * Po wpisaniu właściwego użytkownika i hasła okno zmienia się w giełdę - bibliotekę scenariuszy
     *
     * @param e
     * @throws Exception
     */
    @FXML
    public void pressLogin(ActionEvent e) throws Exception {

        //listaGraczy.addAll(Gracz.dajZapis(Gracz.class));
        użytkownik = userText.getText();
        pswd = pswdText.getText();

        System.out.println("*******user*********" + użytkownik);
        System.out.println("*******pswd*********" + pswd);

        for (Gracz g : listaGraczy) {
            if (g.dajNick().equals(użytkownik) && g.dajHasło().equals(pswd)) {
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
        }
    }

    /**
     * zwraca użytkwonika który się zalogował, do przekazania do następnych okien
     *
     * @return
     */

    public static String dajUżytkownika() {

        return użytkownik;
    }
}

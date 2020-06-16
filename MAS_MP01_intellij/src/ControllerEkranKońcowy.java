import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

import java.io.IOException;

public class ControllerEkranKońcowy {

    @FXML
    private javafx.scene.control.Button exitBtn;
    @FXML
    private Label nazwaUżytkownika;
    @FXML
    private RadioButton r1;
    @FXML
    private RadioButton r2;
    @FXML
    private RadioButton r3;
    @FXML
    private RadioButton r4;
    @FXML
    private RadioButton r5;

    private final ToggleGroup grupa = new ToggleGroup();

    /**
     * przycisk zamknięcia programu
     *
     * @param e
     */
    @FXML
    public void pressExit(ActionEvent e) {
        System.out.println("wychodze");
        Platform.exit();
    }

    /**
     * pokazanie nazwy użytkownika i zgrupowanie radiobuttonów
     */
    public void initialize() {
        nazwaUżytkownika.setText(ControllerEkranPowitalny.dajUżytkownika());
        r1.setToggleGroup(grupa);
        r2.setToggleGroup(grupa);
        r3.setToggleGroup(grupa);
        r4.setToggleGroup(grupa);
        r5.setToggleGroup(grupa);
        r5.setSelected(true);
    }

    /**
     * po naciśnięciu zapisz ocenę ekran wraca do giełdy - bilbioteki scenariuszy
     *
     * @param e
     * @throws IOException
     */
    @FXML
    public void pressZapiszOcenę(ActionEvent e) throws IOException {

        Parent root = FXMLLoader.load(getClass().getResource("C_gielda.fxml"));
        Scene scene = new Scene(root, 500, 350);
        Stage scenarioStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scenarioStage.setScene(scene);
        scenarioStage.show();
    }

}

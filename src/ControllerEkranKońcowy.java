import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class ControllerEkranKońcowy {

    @FXML
    private javafx.scene.control.Button exitBtn;
    @FXML
    private Label nazwaUżytkownika;


    @FXML
    public void pressExit(ActionEvent e) {
        System.out.println("wychodze");
        Platform.exit();
        //Stage stage = (Stage) exitBtn.getScene().getWindow();
       // stage.close();
    }

    public void initialize(){
        nazwaUżytkownika.setText(ControllerEkranPowitalny.dajUżytkownika());

    }

}

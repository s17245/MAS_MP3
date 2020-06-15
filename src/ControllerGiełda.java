import javafx.application.Platform;
import javafx.beans.value.ObservableListValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import jdk.nashorn.internal.objects.annotations.SpecializedFunction;

import java.io.IOException;
import java.util.ArrayList;

public class ControllerGiełda {

    private ArrayList<Scenariusz> listaScn = new ArrayList<>();
    public static String output;

    @FXML
    private javafx.scene.control.Button exitBtn;
    @FXML
    private javafx.scene.control.Button grajBtn;
    @FXML
    private ComboBox scnCombobox;
    @FXML
    private Label nazwaLabel;
    @FXML
    private Label nazwaAutor;
    @FXML
    private Label nazwaOcena;
    @FXML
    private Label nazwaUżytkownika;

//    @FXML
//    private TableView<Scenariusz> tabelka;

    @FXML
    public void nacisnijGraj(ActionEvent e) throws IOException {
        System.out.println("przygoda się rozpoczyna");

        output = scnCombobox.getSelectionModel().getSelectedItem().toString();
        System.out.println(output);


        //nazwaAutor.setText(scnCombobox.getSelectionModel().getClass().getAutor);

//        for (Scenariusz s : listaScn) {
//            if (s.getNazwa() == output) {
//                nazwaAutor.setText("autor: " + s.getAutor());
//                nazwaOcena.setText("ocena: " + s.getOcena());
//            }
//        }
//        nazwaLabel.setText("scenariusz: " + output);
//        if (!listaScn.isEmpty()){
//            System.out.println("%(#)*&#(*$%");
//        }


        //listaScn.get(0);
        Parent root = FXMLLoader.load(getClass().getResource("C_Scenariusz.fxml"));
        Scene scene = new Scene(root, 500, 350);
        Stage scenarioStage = (Stage) ((Node) e.getSource()).getScene().getWindow();
        scenarioStage.setScene(scene);
        scenarioStage.show();
    }
    @FXML
    public void nacisnijExit (ActionEvent e) {
        System.out.println("wychodze");
        Platform.exit();

    }

    public void naciśnijWięcej (ActionEvent e) {

        String wybranyScn = scnCombobox.getSelectionModel().getSelectedItem().toString();
        System.out.println(wybranyScn);

        for (Scenariusz s : listaScn) {
            if (s.getNazwa() == wybranyScn) {
                nazwaAutor.setText("autor: " + s.getAutor());
                nazwaOcena.setText("ocena: " + s.getOcena());
            }
        }
        nazwaLabel.setText("nazwa scenariusza: " + wybranyScn);

    }


    @FXML
    public void initialize() throws ClassNotFoundException {

        nazwaUżytkownika.setText(ControllerEkranPowitalny.dajUżytkownika());

        nazwaLabel.setText("");
        nazwaAutor.setText("");
        nazwaOcena.setText("");


        listaScn.addAll(Scenariusz.dajZapis(Scenariusz.class));

//        System.out.println("##### autor " + listaScn.get(0).getAutor());
//        System.out.println("#####  nazwa " + listaScn.get(0).getNazwa());
//        System.out.println("##### ocena " + listaScn.get(0).getOcena());

        String s1 = listaScn.get(0).getNazwa();
        String s2 = listaScn.get(1).getNazwa();

        ObservableList <String> scnComboboxList = FXCollections.observableArrayList(s1,s2);

        scnCombobox.setValue("naciśnij i wybierz");
        scnCombobox.setItems(scnComboboxList);

    }

    public static String dajScn(){
        return output;
    }
}

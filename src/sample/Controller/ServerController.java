package sample.Controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import sample.App.Server;

import java.net.UnknownHostException;
import java.util.ArrayList;

/**
 * Created by Alastor on 01.10.2016.
 */
public class ServerController {
    private Server server = new Server();

    public Button buttonActivMode;
    public Button buttonFinishMode;
    private ObservableList<String> massages;
    private ArrayList<String> buffmassage = new ArrayList<>();
    private String Name;
    public TextField addMassage;
    public Button addName;
    public TextField placeName;
    public ListView<String> oldMasseges;
    public ToggleButton modeServer;


    public void setName(MouseEvent mouseEvent) {
        Name = placeName.getText();
        System.out.println(placeName.getText());
    }

    public void InputMassage(KeyEvent keyEvent) {

        if(keyEvent.getCode() == KeyCode.ENTER)
        {
            buffmassage.add(Name + ": "+ addMassage.getText());
            System.out.println(addMassage.getText());
            massages = FXCollections.observableArrayList(buffmassage);
            oldMasseges.setItems(massages);
            addMassage.setText("");

        }

    }


    public void ActivMode(MouseEvent mouseEvent) {

        System.out.println("Сервер включен");

    }

    public void FinishMode(MouseEvent mouseEvent) {

        System.out.println("Сервер включен(нет)");
    }
}

package bsuir.KochergaMargarita.sourceFiles;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    public Button guessButton;
    public Button newButton;
    public Label label;
    public TextField numberTextField;

    int number = -1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        number = Logic.newRandomNumber(100);
    }

    public void onGuessButtonClicked(ActionEvent actionEvent) {
        label.setText(Logic.checkNumber(numberTextField.getText(), number));
    }

    public void onNewButtonClicked(ActionEvent actionEvent) {
        number = Logic.newRandomNumber(100);
        label.setText("Новое число сгенерировано!");
    }

}



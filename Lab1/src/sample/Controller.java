package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;


import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    public Button guessButton;
    public Button newButton;
    public Label label;
    public TextField numberTextField;

    Random rand = new Random();
    int number = -1;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        number = rand.nextInt(1000);
        System.out.println(number);
    }

    public void onGuessButtonClicked(ActionEvent actionEvent) {
        if (number == -1) {
            label.setText("Нажмите на кнопку \"Новое\"");
        }
        else if (!numberTextField.getText().matches("\\d+")) {
            label.setText("Пожалуйста, введите число.");
        }
        else if (Integer.parseInt(numberTextField.getText()) > number) {
            label.setText("Ваше число больше загаданного.");
        }
        else if (Integer.parseInt(numberTextField.getText()) < number) {
            label.setText("Ваше число меньше загаданного.");
        }
        else if (Integer.parseInt(numberTextField.getText()) == number) {
            label.setText("Поздравляю! Вы угадали число!\nЧтобы сгенерировать новое число,\n нажмите \"Новое\"");
        }

    }

    public void onNewButtonClicked(ActionEvent actionEvent) {
        number = rand.nextInt(1000);
        System.out.println(number);
        label.setText("Новое число сгенерировано!");
    }

}



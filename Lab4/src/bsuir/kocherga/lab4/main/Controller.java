package bsuir.kocherga.lab4.main;

import bsuir.kocherga.lab4.AllData;
import bsuir.kocherga.lab4.elevator.Elevator;
import bsuir.kocherga.lab4.person.Person;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {


    public TableView<Object> personTable;
    public TextField currentFloorTextField;
    public TextField destinationFloorTextField;
    public Button createPersonButton;
    public Label elevatorFloorLabel;
    public TextArea logTextArea;
    public Elevator elevator;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //  Table initialization
        TableColumn<Object, Object> personColumn = new TableColumn<>("Person");
        TableColumn<Object, Object> currentFloorColumn = new TableColumn<>("Current floor");
        TableColumn<Object, Object> destinationFloorColumn = new TableColumn<>("Destination floor");
        personTable.getColumns().addAll(personColumn, currentFloorColumn, destinationFloorColumn);

        personColumn.prefWidthProperty().bind(personTable.widthProperty().multiply(0.3));
        personColumn.setResizable(false);
        personColumn.setCellValueFactory(
                new PropertyValueFactory<>("personName"));

        currentFloorColumn.prefWidthProperty().bind(personTable.widthProperty().multiply(0.3));
        currentFloorColumn.setResizable(false);
        currentFloorColumn.setCellValueFactory(
                new PropertyValueFactory<>("currentFloor"));

        destinationFloorColumn.prefWidthProperty().bind(personTable.widthProperty().multiply(0.4));
        destinationFloorColumn.setResizable(false);
        destinationFloorColumn.setCellValueFactory(
                new PropertyValueFactory<>("destinationFloor"));


        //  Elevator initialization
        elevator = new Elevator(this);
        elevator.start();
        logTextArea.appendText("Elevator created and is ready to go!\n");


    }

    public void onCreatePersonButtonClicked(ActionEvent actionEvent) {
        if (AllData.upList.size() + AllData.downList.size() == 20 ) {
            logTextArea.appendText("You can't create more than 20 people at the same time.\n" +
                    "Please wait until someone is at his destination floor.\n");
            return;
        }
        if (!currentFloorTextField.getText().matches("\\d+") ||
                Integer.parseInt(currentFloorTextField.getText()) == 0) {
            logTextArea.appendText("Please, enter correct current floor number.\n");
            return;
        }
        if (!destinationFloorTextField.getText().matches("\\d+") ||
                Integer.parseInt(destinationFloorTextField.getText()) == 0) {
            logTextArea.appendText("Please, enter correct destination floor number.\n");
            return;
        }
        if(currentFloorTextField.getText().equals(destinationFloorTextField.getText())) {
            logTextArea.appendText("He is already at the destination floor.\n");
            return;
        }
        if(Integer.parseInt(currentFloorTextField.getText()) > AllData.maxFloor ||
                Integer.parseInt(destinationFloorTextField.getText()) > AllData.maxFloor) {
            logTextArea.appendText("There are only 10 floors in the building.\n");
        }
        else {
            int personNumber = AllData.downList.size() + AllData.upList.size() + elevator.getPassengers().size() + 1;
            Person newPerson = new Person("Person" + personNumber, Integer.parseInt(destinationFloorTextField.getText()),
                    Integer.parseInt(currentFloorTextField.getText()));

            if(newPerson.getDestinationFloor() > newPerson.getCurrentFloor()) {
                AllData.upList.add(newPerson);
            }
            else {
                AllData.downList.add(newPerson);
            }
            logTextArea.appendText("Person" + personNumber + " has been created!\n");
            personTable.getItems().add(newPerson);
        }

    }

    public void changeLogTextArea(String string) {
        Platform.runLater(() -> logTextArea.appendText(string));
    }

    public void changeElevatorFloor(Integer floor) {
        Platform.runLater(() ->  elevatorFloorLabel.setText(floor.toString()));
    }

    public void changePersonTable(Person person) {
        Platform.runLater(() -> personTable.getItems().remove(person));
    }



}

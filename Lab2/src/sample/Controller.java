package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller implements Initializable {
    public Button createWriterButton;
    public Button writeBookButton;
    public Button createReaderButton;
    public Button readBookButton;
    public Button giveFeedbackButton;
    public ComboBox writersBox;
    public ComboBox booksBox;
    public ComboBox readersBox;
    public TextField writerNameField;
    public TextField bookNameField;
    public TextField readerNameField;
    public TextField bookPagesField;
    public Label actionsLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void onCreateWriterButtonClicked(ActionEvent actionEvent) {
        if (writerNameField.getText().equals("")) {
            actionsLabel.setText("Please, enter writer's name.");
        }
        else {
            Writer newWriter = new Writer(writerNameField.getText());
            Writer.writersList.add(newWriter);
            writersBox.getItems().add(newWriter.getName());
            actionsLabel.setText("Writer " + newWriter.getName() + " created!");
        }
    }


    public void onWriteBookButtonClicked(ActionEvent actionEvent) {
        if (!bookPagesField.getText().matches("\\d+")) {
            actionsLabel.setText("Please, enter correct number of pages.");
            return;
        }
        if (bookNameField.getText().equals("")) {
            actionsLabel.setText("Please, enter book's name.");
            return;
        }
        else if (writersBox.getSelectionModel().getSelectedIndex() > -1) {
            Writer writer = Writer.writersList.get(writersBox.getSelectionModel().getSelectedIndex());
            Book book = writer.writeBook(bookNameField.getText(), Integer.parseInt(bookPagesField.getText()));
            booksBox.getItems().add(book.getName());
            actionsLabel.setText("The book \"" + book.getName() + "\" with " + book.getPagesCount()
                    + " pages created by " + writer.getName() + "!");
        }
        else {
            actionsLabel.setText("Writer is not selected!");
        }
    }

    public void onCreateReaderButtonClicked(ActionEvent actionEvent) {
        if (readerNameField.getText().equals("")) {
            actionsLabel.setText("Please, enter reader's name.");
        }
        else {
            Reader newReader = new Reader(readerNameField.getText());
            Reader.readersList.add(newReader);
            readersBox.getItems().add(newReader.getName());
            actionsLabel.setText("Reader " + newReader.getName() + " created!");
        }
    }

    public void onReadBookButtonClicked(ActionEvent actionEvent) {
        if (booksBox.getSelectionModel().getSelectedIndex() > -1 && readersBox.getSelectionModel().getSelectedIndex() > -1) {
            Book book = Book.booksList.get(booksBox.getSelectionModel().getSelectedIndex());
            Reader reader = Reader.readersList.get(readersBox.getSelectionModel().getSelectedIndex());
            reader.readBook(book);
            actionsLabel.setText("The book \"" + book.getName() + "\" is read by " + reader.getName() + "!");
        }
        else {
            actionsLabel.setText("Reader or book is not selected!");
        }
    }

    public void onGiveFeedbackButtonClicked(ActionEvent actionEvent) {
        if (booksBox.getSelectionModel().getSelectedIndex() > -1 && readersBox.getSelectionModel().getSelectedIndex() > -1) {
            Book book = Book.booksList.get(booksBox.getSelectionModel().getSelectedIndex());
            Reader reader = Reader.readersList.get(readersBox.getSelectionModel().getSelectedIndex());
            reader.giveFeedback(book);
            actionsLabel.setText(reader.getName() + " gave cool feedback on book \"" + book.getName() + "\"!");
        }
        else {
            actionsLabel.setText("Reader or book is not selected!");
        }
    }
}

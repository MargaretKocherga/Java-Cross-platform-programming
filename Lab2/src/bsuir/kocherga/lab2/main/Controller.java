package bsuir.kocherga.lab2.main;

import bsuir.kocherga.lab2.AllData;
import bsuir.kocherga.lab2.book.Book;
import bsuir.kocherga.lab2.person.Critic;
import bsuir.kocherga.lab2.person.Reader;
import bsuir.kocherga.lab2.person.Writer;
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
    public Button createCriticButton;
    public Button createReviewButton;
    public ComboBox writersBox;
    public ComboBox booksBox;
    public ComboBox readersBox;
    public ComboBox genreBox;
    public TextField writerNameField;
    public TextField bookNameField;
    public TextField readerNameField;
    public TextField bookPagesField;
    public Label actionsLabel;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        genreBox.getItems().add("Novel");
        genreBox.getItems().add("Story");
    }


    public void onCreateWriterButtonClicked(ActionEvent actionEvent) {
        if (writerNameField.getText().equals("")) {
            actionsLabel.setText("Please, enter writer's name.");
        }
        else {
            Writer newWriter = new Writer(writerNameField.getText());
            AllData.writersList.add(newWriter);
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
        else if (writersBox.getSelectionModel().getSelectedIndex() > -1 && genreBox.getSelectionModel().getSelectedIndex() > -1) {

            Writer writer = AllData.writersList.get(writersBox.getSelectionModel().getSelectedIndex());
            String genre = (String)genreBox.getSelectionModel().getSelectedItem();
            if (genre.equals("Novel")) {
                AllData.booksList.add(writer.writeNovel(bookNameField.getText(), Integer.parseInt(bookPagesField.getText())));
            }
            else if (genre.equals("Story")) {
                AllData.booksList.add(writer.writeNovel(bookNameField.getText(), Integer.parseInt(bookPagesField.getText())));
            }
            booksBox.getItems().add(AllData.booksList.get(AllData.booksList.size() - 1).getName());
            actionsLabel.setText(genre + " \"" + AllData.booksList.get(AllData.booksList.size() - 1).getName() +
                    "\" with " + AllData.booksList.get(AllData.booksList.size() - 1).getPagesCount() +
                    " pages created by " + writer.getName() + "!");
        }
        else {
            actionsLabel.setText("Writer or genre is not selected!");
        }
    }

    public void onCreateReaderButtonClicked(ActionEvent actionEvent) {
        if (readerNameField.getText().equals("")) {
            actionsLabel.setText("Please, enter reader's name.");
        }
        else {
            Reader newReader = new Reader(readerNameField.getText());
            AllData.readersList.add(newReader);
            readersBox.getItems().add(newReader.getName());
            actionsLabel.setText("Reader " + newReader.getName() + " created!");
        }
    }

    public void onReadBookButtonClicked(ActionEvent actionEvent) {
        if (booksBox.getSelectionModel().getSelectedIndex() > -1 && readersBox.getSelectionModel().getSelectedIndex() > -1) {
            Book book = AllData.booksList.get(booksBox.getSelectionModel().getSelectedIndex());
            Reader reader = AllData.readersList.get(readersBox.getSelectionModel().getSelectedIndex());
            reader.readBook(book);
            actionsLabel.setText("The book \"" + book.getName() + "\" is read by " + reader.getName() + "!");
        }
        else {
            actionsLabel.setText("Reader or book is not selected!");
        }
    }

    public void onGiveFeedbackButtonClicked(ActionEvent actionEvent) {
        if (booksBox.getSelectionModel().getSelectedIndex() > -1 && readersBox.getSelectionModel().getSelectedIndex() > -1) {
            Book book = AllData.booksList.get(booksBox.getSelectionModel().getSelectedIndex());
            Reader reader = AllData.readersList.get(readersBox.getSelectionModel().getSelectedIndex());
            reader.giveFeedback(book);
            actionsLabel.setText(reader.getName() + " gave cool feedback on book \"" + book.getName() + "\"!");
        }
        else {
            actionsLabel.setText("Reader or book is not selected!");
        }
    }

    public void onCreateCriticButtonClicked(ActionEvent actionEvent) {
        if (readerNameField.getText().equals("")) {
            actionsLabel.setText("Please, enter critic's name.");
        }
        else {
            Critic newCritic = new Critic(readerNameField.getText() + " (critic)");
            AllData.readersList.add(newCritic);
            readersBox.getItems().add(newCritic.getName());
            actionsLabel.setText("Reader " + newCritic.getName() + " created!");
        }
    }

    public void onCreateReviewButtonClicked(ActionEvent actionEvent) {
        if (!bookPagesField.getText().matches("\\d+")) {
            actionsLabel.setText("Please, enter correct number of pages.");
            return;
        }
        if (bookNameField.getText().equals("")) {
            actionsLabel.setText("Please, enter review's name.");
            return;
        }
        if (booksBox.getSelectionModel().getSelectedIndex() > -1 && readersBox.getSelectionModel().getSelectedIndex() > -1) {
            Book book = AllData.booksList.get(booksBox.getSelectionModel().getSelectedIndex());
            System.out.println(AllData.readersList.get(readersBox.getSelectionModel().getSelectedIndex()).getClass().getName());
            if(!AllData.readersList.get(readersBox.getSelectionModel().getSelectedIndex()).getClass().getName().equals("bsuir.kocherga.lab2.person.Critic")) {
                actionsLabel.setText("Selected reader is not a critic.");
                return;
            }
            Critic critic = (Critic) AllData.readersList.get(readersBox.getSelectionModel().getSelectedIndex());
            AllData.booksList.add(critic.writeReview(bookNameField.getText(), Integer.parseInt(bookPagesField.getText()), book));
            booksBox.getItems().add(AllData.booksList.get(AllData.booksList.size() - 1).getName());
            actionsLabel.setText("Review \"" + bookNameField.getText() + "\" with " + bookPagesField.getText() +
                    " pages on book " + book.getName() + " created!");
        }
        else {
            actionsLabel.setText("Critic or book is not selected!");
        }
    }


}

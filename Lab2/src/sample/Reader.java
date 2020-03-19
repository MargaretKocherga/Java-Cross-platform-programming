package sample;

import java.util.ArrayList;
import java.util.List;

public class Reader extends Person{

    static protected List<Reader> readersList = new ArrayList<Reader>();;

    public Reader(String name) {
        super(name);
        System.out.println("Reader" + name + " created!");
    }

    public void readBook(Book book) {
        System.out.println("The book \"" + book.getName() + "\" is read!");
    }

    public void giveFeedback(Book book) {
        System.out.println(this.getName() + " gave cool feedback on book \"" + book.getName() + "\"!");
    }
}

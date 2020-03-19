package sample;

import java.util.List;
import java.util.ArrayList;


public class Writer extends Person {

    static protected List<Writer> writersList = new ArrayList<Writer>();

    public Writer(String name) {
        super(name);
        System.out.println("Writer " + name + " created!");
    }

    public Writer(Writer obj) {
        super(obj);
    }

    public Book writeBook(String name, Integer pagesCount) {
        Book newBook = new Book(this.getName(), name, pagesCount);
        Book.booksList.add(newBook);
        return newBook;
    }
}

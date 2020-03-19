package sample;

import java.util.ArrayList;
import java.util.List;

public class Book {
    private String name;
    private String author;
    private Integer pagesCount;
    static protected List<Book> booksList = new ArrayList<Book>();;

    public Book (String author, String name, Integer pagesCount) {
        this.author = author;
        this.name = name + " (" + author + ")";
        this.pagesCount = pagesCount;
        System.out.println("The book \"" + name + "\" with " + pagesCount + " pages created!");
    }

    public String getName() {
        return name;
    }

    public Integer getPagesCount() {
        return pagesCount;
    }
}

package bsuir.kocherga.lab2.person;

import bsuir.kocherga.lab2.book.Book;

public class Reader extends Person {
    protected Boolean isCritic = false;

    public Reader() {
        super();
    }

    public Reader(String name) {
        super(name);
        System.out.println("Reader " + name + " created!");
    }

    public Boolean getIsCritic() {
        return isCritic;
    }

    public void readBook(Book book) {
        System.out.println("The book \"" + book.getName() + "\" is read!");
    }

    public void giveFeedback(Book book) {
        System.out.println(this.getName() + " gave cool feedback on book \"" + book.getName() + "\"!");
    }
}

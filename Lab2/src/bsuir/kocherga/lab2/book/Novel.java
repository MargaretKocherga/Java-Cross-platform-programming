package bsuir.kocherga.lab2.book;

public class Novel extends Book {
    public Novel() {
        super();
    }

    public Novel(String author, String name, Integer pagesCount) {
        super(author, name, pagesCount);
        System.out.println("Novel \"" + name + "\" with " + pagesCount + " pages created!");
    }
}

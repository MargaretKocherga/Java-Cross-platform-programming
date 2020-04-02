package bsuir.kocherga.lab2.book;

public abstract class Book {
    private String name;
    private String author;
    private Integer pagesCount;

    public Book() {
        name = "";
        author = "";
        pagesCount = 0;
    }

    public Book (String author, String name, Integer pagesCount) {
        this.author = author;
        this.name = name + " (" + author + ")";
        this.pagesCount = pagesCount;
    }

    public String getName() {
        return name;
    }

    public Integer getPagesCount() {
        return pagesCount;
    }
}

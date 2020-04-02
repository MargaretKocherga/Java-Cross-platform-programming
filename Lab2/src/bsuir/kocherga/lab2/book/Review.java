package bsuir.kocherga.lab2.book;

public class Review extends Book {
    public Review() {
        super();
    }

    public Review(String author, String name, Integer pagesCount, Book book) {
        super(author, name, pagesCount);
        System.out.println("Review \"" + name + "\" with " + pagesCount + " pages on book " +
                book.getName() + " created!");
    }
}

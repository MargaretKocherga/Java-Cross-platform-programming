package bsuir.kocherga.lab2.book;

public class Story extends Book {
    public Story() {
        super();
    }

    public Story(String author, String name, Integer pagesCount) {
        super(author, name, pagesCount);
        System.out.println("Story \"" + name + "\" with " + pagesCount + " pages created!");
    }

}

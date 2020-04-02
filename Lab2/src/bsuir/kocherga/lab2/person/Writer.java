package bsuir.kocherga.lab2.person;

import bsuir.kocherga.lab2.book.Book;
import bsuir.kocherga.lab2.book.Novel;
import bsuir.kocherga.lab2.book.Story;


public class Writer extends Person {

    public Writer() {
        super();
    }

    public Writer(String name) {
        super(name);
        System.out.println("Writer " + name + " created!");
    }

    public Writer(Writer obj) {
        super(obj);
    }

    public Novel writeNovel(String name, Integer pagesCount) {
        Novel newNovel = new Novel(this.getName(), name, pagesCount);
        return newNovel;
    }

    public Story writeStory(String name, Integer pagesCount) {
        Story newStory = new Story(this.getName(), name, pagesCount);
        return newStory;
    }
}

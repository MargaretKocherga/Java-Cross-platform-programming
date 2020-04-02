package bsuir.kocherga.lab2.person;

import bsuir.kocherga.lab2.book.Book;
import bsuir.kocherga.lab2.book.Review;

public class Critic extends Reader {
    public Critic() {
        super();
        isCritic = true;
    }

    public Critic(String name) {
        super(name);
        isCritic = true;
        System.out.println("It is a Critic!");
    }

    public Review writeReview(String name, Integer pagesCount, Book book) {
        Review review = new Review(this.getName(), name, pagesCount, book);
        return review;
    }
}

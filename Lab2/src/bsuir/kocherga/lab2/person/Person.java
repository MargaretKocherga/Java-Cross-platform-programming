package bsuir.kocherga.lab2.person;

public abstract class Person {
    private String name;

    public Person() {
        name = "";
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(Person obj) {
        this.name = obj.getName();
    }

    public String getName() {
        return name;
    }
}

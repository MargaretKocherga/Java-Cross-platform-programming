package sample;

public abstract class Person {
    private String name;

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

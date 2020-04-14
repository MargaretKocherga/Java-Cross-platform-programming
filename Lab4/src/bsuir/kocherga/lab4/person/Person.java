package bsuir.kocherga.lab4.person;

public class Person implements Runnable{
    private short destinationFloor;
    private short currentFloor;

    public Person() {}
    public Person(short destinationFloor, short currentFloor) {
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
    }

    @Override
    public void run() {

    }
}

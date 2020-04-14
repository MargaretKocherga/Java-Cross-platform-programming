package bsuir.kocherga.lab4.person;

import bsuir.kocherga.lab4.main.Controller;

public class Person extends Thread {
    private String personName;
    private Integer destinationFloor;
    private Integer currentFloor;

    public Person() {
        personName = "";
        destinationFloor = 0;
        currentFloor = 0;
    }
    public Person(String personName, Integer destinationFloor, Integer currentFloor) {
        this.personName = personName;
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
        System.out.println(personName + " has been created!");
    }

    @Override
    public void run() {
        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public Integer getDestinationFloor() {
        return destinationFloor;
    }

    public Integer getCurrentFloor() {
        return currentFloor;
    }

    public String getPersonName() {
        return personName;
    }

    public void setCurrentFloor(Integer floor) {
        this.currentFloor = floor;
    }

    public void wakeUp() {
        try {
            System.out.println("Thread " + this + " is waking up...");
            synchronized (this) {
                notify();
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

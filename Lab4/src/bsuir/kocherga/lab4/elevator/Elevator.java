package bsuir.kocherga.lab4.elevator;

import bsuir.kocherga.lab4.AllData;
import bsuir.kocherga.lab4.main.Controller;
import bsuir.kocherga.lab4.person.Person;

import java.util.ArrayList;
import java.util.List;

public class Elevator extends Thread{
    private Integer currentFloor;
    private List<Person> passengers;
    private boolean isGoingUp;
    private final Controller controller;

    public Elevator(Controller controller) {
        currentFloor = 1;
        passengers = new ArrayList<Person>();
        isGoingUp = true;
        this.controller = controller;
    }


    @Override
    public void run() {

        System.out.println("Elevator created and is ready to go!");
        controller.changeElevatorFloor(currentFloor);
        while(true) {
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (!AllData.upList.isEmpty() || !AllData.downList.isEmpty() || !passengers.isEmpty()) {
                if(currentFloor == 1)
                    isGoingUp = true;
                if (currentFloor == AllData.maxFloor)
                    isGoingUp = false;

                if (isGoingUp && currentFloor <= AllData.maxFloor) {
                    goUp();
                }
                if (!isGoingUp && currentFloor >= 1) {
                    goDown();
                }
            }
        }
    }


    private void goUp() {
        while(!AllData.upList.isEmpty() || !AllData.downList.isEmpty() || !passengers.isEmpty()) {

            if(!passengers.isEmpty()) {
                for(int i = 0; i < passengers.size(); i++) {
                    if(passengers.get(i).getDestinationFloor().equals(currentFloor)) {
                        System.out.println(passengers.get(i).getPersonName() +
                                " is leaving lift on floor " + currentFloor + ".");
                        controller.changeLogTextArea(passengers.get(i).getPersonName() +
                                    " is leaving lift on floor " + currentFloor + ".\n");
                        passengers.get(i).wakeUp();
                        controller.changePersonTable(passengers.get(i));
                        passengers.remove(i);
                        i--;
                    }
                }
            }

            if(!AllData.upList.isEmpty() && !currentFloor.equals(AllData.maxFloor)) {
                for(int i = 0; i < AllData.upList.size(); i++) {
                    if(AllData.upList.get(i).getCurrentFloor().equals(currentFloor)) {
                        System.out.println("Taking in " + AllData.upList.get(i).getPersonName() +
                                " at floor " + currentFloor);
                        controller.changeLogTextArea("Taking in " + AllData.upList.get(i).getPersonName() +
                                    " at floor " + currentFloor + "\n");
                        if(passengers.size() < 5) {
                            passengers.add(AllData.upList.get(i));
                            AllData.upList.remove(i);
                            i--;
                        }
                    }
                }
            }

            try {
                synchronized (this) {
                    wait(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


            if(currentFloor.equals(AllData.maxFloor))
                break;
            if(currentFloor < AllData.maxFloor && (!AllData.upList.isEmpty() || !passengers.isEmpty() || !AllData.downList.isEmpty())) {
                currentFloor++;
                controller.changeElevatorFloor(currentFloor);
            }
        }
    }

    private void goDown() {
        while(!AllData.upList.isEmpty() || !AllData.downList.isEmpty() || !passengers.isEmpty()) {

            if(!passengers.isEmpty()) {
                for(int i = 0; i < passengers.size(); i++) {
                    if(passengers.get(i).getDestinationFloor().equals(currentFloor)) {
                        System.out.println(passengers.get(i).getPersonName() + " is leaving lift.");
                        controller.changeLogTextArea(passengers.get(i).getPersonName() + " is leaving lift.\n");
                        passengers.get(i).wakeUp();
                        controller.changePersonTable(passengers.get(i));
                        passengers.remove(i);
                        i--;
                    }
                }
            }

            if(!AllData.downList.isEmpty() && currentFloor != 1) {
                for(int i = 0; i < AllData.downList.size(); i++) {
                    if(AllData.downList.get(i).getCurrentFloor().equals(currentFloor)) {
                        System.out.println("Taking in " + AllData.downList.get(i).getPersonName() +
                                " at floor " + currentFloor);
                        controller.changeLogTextArea("Taking in " + AllData.downList.get(i).getPersonName() +
                                    " at floor " + currentFloor + "\n");
                        if(passengers.size() < 5) {
                            passengers.add(AllData.downList.get(i));
                            AllData.downList.remove(i);
                            i--;
                        }
                    }
                }
            }

            try {
                synchronized (this) {
                    wait(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            if(currentFloor == 1)
                break;
            if(currentFloor > 1 && (!AllData.downList.isEmpty() || !passengers.isEmpty() || !AllData.upList.isEmpty())) {
                currentFloor--;
                controller.changeElevatorFloor(currentFloor);
            }
        }
    }


    public List<Person> getPassengers() {
        return passengers;
    }
}

package sample;

import java.util.Random;

public class Logic {

    static int newRandomNumber(int border) {
        int number = 0;
        Random rand = new Random();
        number = rand.nextInt(border);
        System.out.println(number);
        return number;
    }

}

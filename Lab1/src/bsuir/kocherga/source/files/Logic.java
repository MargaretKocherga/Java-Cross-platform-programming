package bsuir.kocherga.source.files;

import java.util.Random;

public class Logic{

    static public int newRandomNumber(int border) {
        int number = 0;
        Random rand = new Random();
        number = rand.nextInt(border);
        System.out.println(number);
        return number;
    }

    static public String checkNumber(String text, int number) {
        if (number == -1) {
            return "Нажмите на кнопку \"Новое\"";
        } else if (!text.matches("\\d+")) {
            return "Пожалуйста, введите\n положительное число.";
        } else if (Integer.parseInt(text) > number) {
            return "Ваше число больше загаданного.";
        } else if (Integer.parseInt(text) < number) {
            return "Ваше число меньше загаданного.";
        } else {
            return "Поздравляю! Вы угадали число!\n" +
                    "Чтобы сгенерировать новое число,\n нажмите \"Новое\"";
        }
    }

}

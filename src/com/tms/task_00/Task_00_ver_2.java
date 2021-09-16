package com.tms.task_00;

import java.util.ArrayList;
import java.util.Collections;

public class Task_00_ver_2 {
    public static void main(String[] args) {
        ArrayList<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numberList.add((int) (Math.random() * 97 + 2));
        }
        System.out.println("Размер коллекции - " + numberList.size());
        System.out.println(numberList);
        Collections.sort(numberList);
        System.out.println("Минимальное значение в коллекции - " + Collections.min(numberList));
        System.out.println("Два максимальных значения в коллекции - "
                + numberList.get(numberList.size() - 2)
                + " / " + numberList.get(numberList.size() - 1));

    }
}

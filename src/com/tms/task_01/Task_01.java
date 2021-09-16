package com.tms.task_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Task_01 {
    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            String myRandomFingerPrintString = null;

            ArrayList<String> myList = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                System.out.println("Введите строку...");
                myRandomFingerPrintString = scanner.next();
                myList.add(myRandomFingerPrintString);
            }

            System.out.println("Размер коллекции " + myList.size());

            System.out.println("Коллекция после ввода - " + myList);

            for (int i = 0; i < myList.size(); i++) {
                String tempString = myList.get(i);
                tempString = tempString.replaceAll("\\+",
                        "+++");
                myList.set(i, tempString);
            }
            System.out.println("Коллекция после замены символов - " + myList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


package com.tms.task_03;

import java.util.HashMap;

public class Test {
    public static void main(String[] args) {
        HashMap<String, String> myTestHashMap = new HashMap<>();
        myTestHashMap.put("1", "Alex");
        myTestHashMap.put("2", "Andrey");

        //Устанавливаем значения переменных
        String myName = "ORIGINAL";
        Integer number = 223;
        ImmutableClass immutableClass = new ImmutableClass(number, myName, myTestHashMap);

        //Проверяем копию. Была скопирована ссылка или само значение поля
        System.out.println(myName.equals(immutableClass.getName()));
        System.out.println(number.equals(immutableClass.getNumber()));

        // Выводим поля объекта класса в консоль
        System.out.println("\nmyName = " + immutableClass.getName());
        System.out.println("number = " + immutableClass.getNumber());
        System.out.println("myTestMap = " + immutableClass.getTestMap());

        //Изменяем локально значения переменных
        myName = "changed";
        number = 33;
        myTestHashMap.put("3", "Vova");

        // Выводим поля объекта класса в консоль
        System.out.println("\nmyName после изменения = " + immutableClass.getName());
        System.out.println("number после изменения = " + immutableClass.getNumber());
        System.out.println("myTestMap после изменения = " + immutableClass.getTestMap());

    }
}

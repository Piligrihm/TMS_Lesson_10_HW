package com.tms.task_03;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Чтобы сделать класс неизменяемым нужно:
 * Объявить класс final
 * Сделать все поля приватными
 * В классе не должно быть сеттеров
 * Сделать все поля final
 * Инициализация всех полей должна производиться в конструкторе, который выполняет глубокое копирование объекта
 * В геттерах нужно выполнять клонирование объекта и возвращать его копию, ане фактическую ссылку на объект
 *
 *
 * Чтобы убедится в необходимости глубокого копирования нужно закомментировать конструктор "с глубоким копирование"
 * и раскомментировать конструктор "с поверхностным копированием"
 */

public final class ImmutableClass {
    private final String name;
    private final int number;
    private final HashMap<String, String> testMap;


    public ImmutableClass(int number, String name, HashMap<String, String> testMap) {
        System.out.println("Глубокое копирование во время инициализации объекта");
        this.number = number;
        this.name = name;
        HashMap<String, String> tempMap = new HashMap<String, String>();
        String key;
        Iterator<String> it = testMap.keySet().iterator();
        while (it.hasNext()) {
            key = it.next();
            tempMap.put(key, testMap.get(key));
        }
        this.testMap = tempMap;
    }

//    public ImmutableClass(int number, String name, HashMap<String, String> testMap) {
//        System.out.println("Поверхностное копирование во время инициализации объекта");
//        this.number = number;
//        this.name = name;
//        this.testMap = testMap;
//    }

    public HashMap<String, String> getTestMap() {

        return (HashMap<String, String>) testMap.clone();
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }
}

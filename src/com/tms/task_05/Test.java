package com.tms.task_05;

import com.tms.task_05.custom_collection.CustomCollection;
import com.tms.task_05.test_class.Animal;
import com.tms.task_05.test_class.Car;
import com.tms.task_05.test_class.Human;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        //Создаем объект класса c дженериком, который принимает массив целочисленных значений длиной 4 ячейки(элемента)
        CustomCollection<Object> container = new CustomCollection<>(Object[].class, 4);
        Human human1 = new Human();
        Human human2 = new Human();
        Human human3 = new Human();
        Animal lion = new Animal();
        Animal tiger = new Animal();
        Animal elefant = new Animal();
        Car iveco = new Car();
        Car ford = new Car();
        Car maz = new Car();

        // Наполняем значениями
        container.add(human1);
        container.add(lion);
        container.add(human2);
        container.add(iveco);
        container.add(tiger);
        container.add(maz);
        container.add(elefant);
        container.add(new Object());
        container.add(ford);

        //Выводим в консоль индекс последнего добавленного элемента
        container.printLastIndex();
        container.add(human3);
        container.printLastIndex();
        container.add(null);
        container.printLastIndex();

        //Получаем предварительно сохраненный объект и выводим в консоль
        System.out.println(container.get(0));
        System.out.println(container.get(1));
        System.out.println(container.get(25));

        System.out.println("[" + container.get(5) + "]");

        //Получаем коллекцию и выводим в консоль в виде строки
        System.out.println(Arrays.toString(container.getItems()));

        //Удаляем элемент по заданному индексу
        container.delete(2);

        //Удаляем элемент по заданному значению
        container.delete((Integer) 255);

        System.out.println(Arrays.toString(container.getItems()));

        // очищаем всю коллекцию
        container.clear();
        System.out.println(Arrays.toString(container.getItems()));


    }
}

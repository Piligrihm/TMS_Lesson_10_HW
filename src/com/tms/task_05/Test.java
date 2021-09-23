package com.tms.task_05;

import com.tms.task_05.custom_collection.CustomCollection;
import com.tms.task_05.test_class.Animal;
import com.tms.task_05.test_class.Car;
import com.tms.task_05.test_class.Human;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {

        //Создаем объект класса c дженериком, который принимает массив целочисленных значений длиной 4 ячейки(элемента)
        CustomCollection<Object> container = new CustomCollection<>(5);
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
        container.addItem(human1);
        container.addItem(lion);
        container.addItem(human2);
        container.addItem(iveco);
        container.addItem(tiger);
        container.addItem(maz);
        container.addItem(elefant);
        container.addItem(new Object());
        container.addItem(ford);

        //Выводим в консоль индекс последнего добавленного элемента
        container.printLastIndex();
        container.addItem(human3);
        container.printLastIndex();
        container.addItem(null);
        container.printLastIndex();

        //Получаем предварительно сохраненный объект и выводим в консоль
        System.out.println(container.getObject(0));
        System.out.println(container.getObject(1));
        System.out.println(container.getObject(25));

        System.out.println("[" + container.getObject(5) + "]");

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

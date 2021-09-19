package com.tms.task_04.garage;

import com.tms.task_04.car.Car;

import java.util.HashMap;
import java.util.Map;


public class Garage {
    private final int parkingPlace = 20;
    private int freeParkingPlace = parkingPlace;
    private int count = 1;
    HashMap<Car, Integer> garage = new HashMap<>();


    public Garage() {
    }

    /**
     * Метод имитирует парковку авто в гараже
     *
     * @param car - принимаемый на вход объект
     */
    public void park(Car car) {
        garage.put(car, garage.getOrDefault(car, 0) + 1);
        freeParkingPlace--;
        System.out.println("Автомобиль заехал. Кол-во свободных мест - " + freeParkingPlace + "/" + parkingPlace);
    }

    /**
     * Метод имитирует выезд авто из гаража
     *
     * @param car - объект принимаемый на вход
     */
    public void movementOutOfGarage(Car car) {
        if (garage.size() == 0) {
            System.out.println("В гараже пусто!");
        } else {
            if (garage.containsKey(car) && garage.get(car) > 1) {
                int valuesCopy = garage.get(car);
                --valuesCopy;
                garage.put(car, valuesCopy);
                freeParkingPlace++;
                System.out.println("Автомобиль " + car + " покинул гараж.Кол - во свободных мест - " + freeParkingPlace + " / " + parkingPlace);
            } else if (garage.containsKey(car) && garage.get(car) == 1) {
                garage.remove(car);

            } else {
                System.out.println("К сожалению в гараже нет таких авто" + "\n");
            }
        }

    }

    /**
     * Метод выводит в консоль кол-во одинаковых авто данного вида, находящихся в гараже
     *
     * @param car
     */
    public void numberOfThisKindCar(Car car) throws NullPointerException {

        try {
            if (garage.get(car).hashCode() != 0) {
                System.out.println("Кол-во одинаковых " + car + " сейчас в гараже - " + garage.get(car) + "\n");
            }

        } catch (NullPointerException e) {
            System.out.println("В гараже нет таких авто");
        }
    }

    /**
     * Метод выводит в консоль перечень всех стоящих в гараже авто
     */
    public void showGarage() {
        for (Map.Entry<Car, Integer> entry : garage.entrySet()) {
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
    }

    @Override
    public String toString() {
        return "Garage{" +
                "parkingPlace=" + parkingPlace +
                ", freePlace=" +
                ", count=" + count +
                ", garage=" + garage +
                '}';
    }
}

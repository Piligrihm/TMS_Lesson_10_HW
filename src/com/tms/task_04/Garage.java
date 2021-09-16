package com.tms.task_04;

import java.util.HashMap;
import java.util.Map;

public class Garage {
    private int parkingPlace;

    private int count = 1;

    Map<Car, Integer> garage = new HashMap<>();

    public void park(Car car) {
        parkingPlace++;
        if (garage.keySet().equals(car)){
            count++;
        }
        garage.put(car, count);





    }

    public void movementOutOfGarage(Car car) {
        parkingPlace--;
        count--;
        garage.remove(car, count);
    }

    public void numberofThisKindCar() {

    }

    public void printMap() {
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

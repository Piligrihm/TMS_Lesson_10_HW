package com.tms.task_04.car;

public class Camper extends Car{
    public Camper(String make, String model, int year, String color, String fuelType, String gearBox) {
        super(make, model, year, color, fuelType, gearBox);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

package com.tms.task_04.car;


public abstract class Car {
    public String make;
    public String model;
    public int year;
    public String color;
    public String fuelType;
    public String gearBox;


    public Car(String make, String model, int year, String color, String fuelType, String gearBox) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.color = color;
        this.fuelType = fuelType;
        this.gearBox = gearBox;
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

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getColor() {
        return color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getGearBox() {
        return gearBox;
    }
}

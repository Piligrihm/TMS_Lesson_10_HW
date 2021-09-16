package com.tms.task_04;


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
}

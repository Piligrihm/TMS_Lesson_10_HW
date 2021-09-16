package com.tms.task_04;

import java.util.Date;

public class Van extends Car{

    public Van(String make, String model, int year, String color, String fuelType, String gearBox) {
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

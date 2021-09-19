package com.tms.task_04;

import com.tms.task_04.car.Bus;
import com.tms.task_04.car.Car;
import com.tms.task_04.car.Truck;
import com.tms.task_04.car.Van;
import com.tms.task_04.garage.Garage;

public class Test {
    public static void main(String[] args) {
        Garage garage = new Garage();
        Car car1 = new Bus("MAZ", "5331", 2009, "white", "diesel", "manual");
        Car car2 = new Bus("MAZ", "5331", 2009, "white", "diesel", "manual");
        Car car3 = new Bus("MAZ", "5331", 2009, "white", "diesel", "manual");
        Car car4 = new Bus("MAZ", "5331", 2009, "white", "diesel", "manual");
        Car car5 = new Van("VW","transporter", 2000, "white", "diesel", "automatic" );
        Car car6 = new Van("VW","transporter", 2000, "red", "benzin", "manual" );
        Car car7 = new Van("MB","Sprinter", 2004, "black / white", "diesel", "automatic" );
        Car car8 = new Truck("Iveco", "Daily", 2007, "green", "diesel", "manual");


        garage.park(car1);
        garage.park(car2);
        garage.park(car3);
        garage.park(car3);
        garage.park(car3);
        garage.park(car4);
        garage.park(car5);
        garage.park(car6);
        garage.park(car7);
        garage.park(car8);
        garage.park(car1);
        garage.park(car1);
        garage.park(car2);

        garage.showGarage();
        System.out.println();

        garage.numberOfThisKindCar(car3);

        garage.movementOutOfGarage(car3);
        garage.numberOfThisKindCar(car3);
        garage.movementOutOfGarage(car3);
        garage.numberOfThisKindCar(car3);
        garage.movementOutOfGarage(car3);
        garage.numberOfThisKindCar(car3);
        garage.numberOfThisKindCar(car8);
        garage.numberOfThisKindCar(car2);


    }
}

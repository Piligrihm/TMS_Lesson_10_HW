package com.tms.task_04;

public class Test {
    public static void main(String[] args) {
        Garage garage = new Garage();
        Bus busMaz = new Bus("MAZ","5331",2009,"white", "diesel", "manual");
        Bus busMaz1 = new Bus("MAZ","5331",2009,"white", "diesel", "manual");
        Bus busMaz2 = new Bus("MAZ","5331",2009,"white", "diesel", "manual");


        garage.park(busMaz);
        garage.park(busMaz1);
        garage.park(busMaz2);
        garage.park(busMaz);
        garage.park(busMaz);
        garage.printMap();
    }
}

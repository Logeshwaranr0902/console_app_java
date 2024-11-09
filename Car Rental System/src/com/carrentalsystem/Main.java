package com.carrentalsystem;

public class Main {

    public static void main(String[] args) {
        CarRentalSystem rentalSystem = new CarRentalSystem();

        Car car1 = new Car("C001", "Toyota", 60.0, "Camry");
        Car car2 = new Car("C002", "Honda", 70.0, "Accord");
        Car car3 = new Car("C003", "Mahindra", 150.0, "Thar");
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);

        rentalSystem.menu();
    }
}

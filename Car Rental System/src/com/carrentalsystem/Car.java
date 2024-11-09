package com.carrentalsystem;

public class Car {

    private String carId;
    private String brand;
    private String model;
    private double carPricePerDay;
    private boolean isAvailable;

    public Car(String carId, String brand, double carPricePerDay, String model) {
        this.brand = brand;
        this.carId = carId;
        this.carPricePerDay = carPricePerDay;
        this.model = model;
        this.isAvailable = true;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getCarPricePerDay() {
        return carPricePerDay;
    }

    public double calculateCarPrice(int rentalDays) {
        return rentalDays * carPricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }

    public void rent() {
        isAvailable = false;
    }

    public void returnCar() {
        isAvailable = true;
    }

    public void setCarPricePerDay(double carPricePerDay) {
        this.carPricePerDay = carPricePerDay;
    }

}

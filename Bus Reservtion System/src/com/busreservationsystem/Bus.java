package com.busreservationsystem;

public class Bus {

    private int busNo;
    private String ac;
    private int capacity;

    public Bus(int busNo, String ac, int capacity) {
        this.busNo = busNo;
        this.ac = ac;
        this.capacity = capacity;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public String isAc() {

        return ac;
    }

    public void setAc(String ac) {
        this.ac = ac;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void displayBusInfo() {
        System.out.println("Bus No: " + busNo + "  " + ac + "\tTotalCapacity :" + capacity);
    }
}

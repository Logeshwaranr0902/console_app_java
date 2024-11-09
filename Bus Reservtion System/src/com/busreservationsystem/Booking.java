package com.busreservationsystem;

import java.util.Date;

public class Booking {

    private String passengerName;
    private int busNo;
    Date date;

    public Booking(String passengerName, int busNo, Date date) {
        this.passengerName = passengerName;
        this.busNo = busNo;
        this.date = date;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public int getBusNo() {
        return busNo;
    }

    public void setBusNo(int busNo) {
        this.busNo = busNo;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}

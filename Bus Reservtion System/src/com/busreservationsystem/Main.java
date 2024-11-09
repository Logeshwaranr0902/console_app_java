package com.busreservationsystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        List<Bus> buses = new ArrayList<>();
        List<Booking> bookings = new ArrayList<>();

        buses.add(new Bus(1, "AC: Available", 2));
        buses.add(new Bus(2, "AC: Not Available", 2));
        buses.add(new Bus(3, "AC: Available", 1));

        for (Bus b : buses) {
            b.displayBusInfo();
        }

        int userOpt = 1;
        try (Scanner s = new Scanner(System.in)) {
            while (userOpt == 1) {
                System.out.println("To Book Enter: 1  To Exit Enter: 2");
                userOpt = s.nextInt();
                if (userOpt == 1) {

                    System.out.println("Enter Passenger Name");
                    String name = s.next();
                    System.out.println("Enter BusNo");
                    int busno = s.nextInt();
                    System.out.println("Enter Date in format (DD/MM/YYYY)");
                    String enteredDate = s.next();
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                    Date date = null;
                    try {
                        date = dateFormat.parse(enteredDate);
                    } catch (ParseException e) {
                        System.out.println("Enter the Date in Correct Format");
                        break;
                    }
                    int capacity = 0;
                    for (Bus b : buses) {
                        if (busno == b.getBusNo()) {
                            capacity = b.getCapacity();
                        }
                    }
                    int booked = 0;
                    for (Booking b : bookings) {
                        if (b.getBusNo() == busno && b.getDate().equals(date)) {
                            booked++;
                        }
                    }
                    if (booked < capacity) {
                        Booking booking = new Booking(name, busno, date);
                        bookings.add(booking);
                        System.out.println("Booked Successfully");
                    } else {
                        System.out.println("Bus is Full. Try other bus or Date");
                    }

                }
            }
        }

    }
}

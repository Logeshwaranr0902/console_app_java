package com.carrentalsystem;

public class Customer {

    private String cutomerId;
    private String name;

    public Customer(String cutomerId, String name) {
        this.cutomerId = cutomerId;
        this.name = name;
    }

    public String getCutomerId() {
        return cutomerId;
    }

    public void setCutomerId(String cutomerId) {
        this.cutomerId = cutomerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

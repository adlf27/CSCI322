package com.example.caloriecalculator;

public class CalorieInfo {
    private int buggerPatty, turkeyPatty, veggiePatty;
    private int bacon;
    private int noChesse, cheddar, moza;

    public CalorieInfo()
    {
        buggerPatty = 50;
        turkeyPatty = 25;
        veggiePatty = 5;
        bacon = 45;
        noChesse = 0;
        cheddar = 12;
        moza = 22;

    }
    public int getBuggerPatty() {
        return buggerPatty;
    }

    public int getTurkeyPatty() {
        return turkeyPatty;
    }

    public int getVeggiePatty() {
        return veggiePatty;
    }

    public int getBacon() {
        return bacon;
    }

    public int getNoChesse() {
        return noChesse;
    }

    public int getCheddar() {
        return cheddar;
    }

    public int getMoza() {
        return moza;
    }
}

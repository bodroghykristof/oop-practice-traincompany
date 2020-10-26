package com.codecool.traincompany.trains;

import java.util.Random;
import java.util.UUID;

public abstract class Train {

    private final UUID id = UUID.randomUUID();
    protected final double monthlyCost;
    protected int workDaysPerMonth;
    protected static final Random RANDOM = new Random();

    public Train(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public abstract double calculateMonthlyRevenue();

    public void setWorkDaysPerMonth(int workDaysPerMonth) {
        this.workDaysPerMonth = workDaysPerMonth;
    }

    @Override
    public String toString() {
        return "Train{" +
                "id=" + id +
                '}';
    }

}

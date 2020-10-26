package com.codecool.traincompany.trains;

import java.util.Random;

public abstract class PassengerTrain extends Train {

    private static final int MINIMUM_NUMBER_OF_PASSENGERS = 115;
    private static final int MAXIMUM_NUMBER_OF_PASSENGERS = 250;

    private static final double IN_PLACE_BUYER_RATIO = 0.25;
    private static final double EXTRA_FEE_FOR_IN_PLACE_BUYING = 2;

    private static final double PUNISHED_PASSENGER_RATIO = 0.20;
    private static final double PUNISHMENT_FEE = 6;

    private double ticketPrice;
    private double punishmentPossibility;

    public PassengerTrain(double monthlyCost, double ticketPrice, double punishmentPossibility) {
        super(monthlyCost);
        this.ticketPrice = ticketPrice;
        this.punishmentPossibility = punishmentPossibility;
    }

    @Override
    public double calculateMonthlyRevenue() {
        System.out.printf("Monthly cost of %s: %.2f", this, monthlyCost);
        int passengers = randomizePassengers();
        double baseIncome = workDaysPerMonth * passengers *
                (ticketPrice * (1 - IN_PLACE_BUYER_RATIO) + IN_PLACE_BUYER_RATIO * (ticketPrice + EXTRA_FEE_FOR_IN_PLACE_BUYING));
        System.out.println("\nBase income: " + baseIncome);

        double extraIncome;
        if (hasBeenPunishments()) {
            extraIncome = workDaysPerMonth * passengers * PUNISHED_PASSENGER_RATIO * PUNISHMENT_FEE;
            System.out.println("Income from punishments: " + extraIncome+ "\n");
        } else {
            extraIncome = 0;
            System.out.println("There were no punishments this month\n");
        }
        return baseIncome + extraIncome - monthlyCost;
    }

    private int randomizePassengers() {
        return RANDOM.nextInt(MAXIMUM_NUMBER_OF_PASSENGERS - MINIMUM_NUMBER_OF_PASSENGERS) + MINIMUM_NUMBER_OF_PASSENGERS;
    }

    private boolean hasBeenPunishments() {
        return Math.random() < PUNISHED_PASSENGER_RATIO;
    }

}

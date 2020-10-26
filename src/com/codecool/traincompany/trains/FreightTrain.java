package com.codecool.traincompany.trains;

public class FreightTrain extends Train {

    private static final double MONTHLY_COST = 1200;
    private static final double MONTHLY_BASE_REVENUE = 550;
    private static final double ABROAD_POSSIBILITY = 0.35;
    private static final double ABROAD_EXTRA_INCOME = 110;

    public FreightTrain() {
        super(MONTHLY_COST);
    }

    @Override
    public double calculateMonthlyRevenue() {
        System.out.printf("Monthly cost of %s: %.2f", this, monthlyCost);

        double baseIncome = MONTHLY_BASE_REVENUE * workDaysPerMonth;
        System.out.println("\nBase income: " + baseIncome);

        double extraIncome;
        if (hasBeenAbroad()) {
            extraIncome = ABROAD_EXTRA_INCOME;
            System.out.println("Income from abroad travel: " + extraIncome + "\n");
        } else {
            extraIncome = 0;
            System.out.println("Train has not been abroad this month\n");
        }
        return baseIncome + extraIncome - monthlyCost;
    }

    private boolean hasBeenAbroad() {
        return Math.random() < ABROAD_POSSIBILITY;
    }

}

package com.codecool.traincompany.trains;

public class ICTrain extends PassengerTrain {

    private static final double MONTHLY_COST = 1200;
    private static final double TICKET_PRICE = 2;
    private static final double PUNISHMENT_POSSIBILITY = 0.08;

    public ICTrain() {
        super(MONTHLY_COST, TICKET_PRICE, PUNISHMENT_POSSIBILITY);
    }

}

package com.codecool.traincompany.trains;

public class NormalPassengerTrain extends PassengerTrain {

    private static final double MONTHLY_COST = 1000;
    private static final double TICKET_PRICE = 1.5;
    private static final double PUNISHMENT_POSSIBILITY = 0.1;

    public NormalPassengerTrain() {
        super(MONTHLY_COST, TICKET_PRICE, PUNISHMENT_POSSIBILITY);
    }

}

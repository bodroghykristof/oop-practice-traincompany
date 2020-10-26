package com.codecool.traincompany;

import com.codecool.traincompany.trains.FreightTrain;
import com.codecool.traincompany.trains.ICTrain;
import com.codecool.traincompany.trains.NormalPassengerTrain;
import com.codecool.traincompany.trains.Train;

import java.util.Set;

public class TrainCompany {

    private final Set<Train> trains;
    private double budget;
    private int workDays;

    public TrainCompany(Set<Train> trains, int workDays) {
        if (!trainSetIsValid(trains)) throw new IllegalArgumentException("Must have at least two trains of each type!");
        this.trains = trains;
        this.budget = 0;
        setWorkDays(workDays);
    }

    public double getBudget() {
        return budget;
    }

    private void setWorkDays(int workDays) {
        this.workDays = workDays;
        trains.forEach(train -> train.setWorkDaysPerMonth(workDays));
    }

    private boolean trainSetIsValid(Set<Train> trains) {
        long freights = trains.stream().filter(train -> train instanceof FreightTrain).count();
        long normals = trains.stream().filter(train -> train instanceof NormalPassengerTrain).count();
        long ics = trains.stream().filter(train -> train instanceof ICTrain).count();

        return 2 <= freights
                && 2 <= normals
                && 2 <= ics;
    }

    public void simulateMonth() {
        trains.forEach(train -> budget += train.calculateMonthlyRevenue());
    }

}

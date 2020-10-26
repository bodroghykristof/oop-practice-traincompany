package com.codecool.traincompany.app;

import com.codecool.traincompany.TrainCompany;
import com.codecool.traincompany.trains.FreightTrain;
import com.codecool.traincompany.trains.ICTrain;
import com.codecool.traincompany.trains.NormalPassengerTrain;
import com.codecool.traincompany.trains.Train;

import java.util.HashSet;
import java.util.Set;

public class App {

    public static void main(String[] args) {
        Set<Train> trains = createTrainSet();
        TrainCompany trainCompany = new TrainCompany(trains, 20);
        for (int i = 0; i < 24; i++) {
            trainCompany.simulateMonth();
            System.out.printf("%nBudget after %d month: %.2f%n", i + 1, trainCompany.getBudget());
        }
    }

    private static Set<Train> createTrainSet() {
        Set<Train> trains = new HashSet<>();

        trains.add(new NormalPassengerTrain());
        trains.add(new NormalPassengerTrain());
        trains.add(new ICTrain());
        trains.add(new ICTrain());
        trains.add(new FreightTrain());
        trains.add(new FreightTrain());

        return trains;
    }

}

package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

public class MeatEater extends Critter {

    private ArrayList<PlantEater> plantEaterList;
    private Random rand = new Random();

    public MeatEater(double size, double growthRate, double foodNeed, ArrayList<PlantEater> plantEaterList) {
        super(size, growthRate, foodNeed);
        this.plantEaterList = plantEaterList;
    }

    public void chase(PlantEater plantEater) {
        // 90% chance to catch the plantEater
        if (rand.nextDouble() < 0.90) {
            double meatEaten = plantEater.getSize();
            plantEater.die();
            eat(meatEaten);
        }
    }

    @Override
    public void simulateDay() {
        // Select a number 1 or 2
        int numberOfPlantEaters = rand.nextInt(2) + 1;

        if (!plantEaterList.isEmpty()) {
            for (int i = 0; i < numberOfPlantEaters; i++) {
                int index = rand.nextInt(plantEaterList.size());
                PlantEater plantEater = plantEaterList.get(index);
                chase(plantEater);
            }
        }

        super.simulateDay();
    }

    @Override
    public String toString() {
        return String.format(
                "MeatEater { size: %.2f, growthRate: %.2f, alive: %b, plantEaterListSize: %d }",
                getSize(), getGrowthRate(), isAlive(), plantEaterList.size()
        );
    }

}

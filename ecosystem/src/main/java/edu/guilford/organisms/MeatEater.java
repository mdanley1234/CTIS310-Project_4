package edu.guilford.organisms;

import java.util.ArrayList;
import java.util.Random;

import edu.guilford.organisms.abstracts.Critter;

/**
 * The meat eater selects a random subset of plantEaters to be eaten
 */
public class MeatEater extends Critter {

    private ArrayList<PlantEater> plantEaterList;
    private Random rand = new Random();

    // Life span
    @Override
    public int getLifespan() {
        return 500;
    }

    // Set size, growthRate, foodNeedPercentage, and the list of plantEaters to be eaten
    public MeatEater(double size, double growthRate, double foodNeedPercentage, ArrayList<PlantEater> plantEaterList) {
        super(size, growthRate, foodNeedPercentage);
        this.plantEaterList = plantEaterList;
    }

    /**
     * Chase a plantEater
     * @param plantEater
     */
    public void chase(PlantEater plantEater) {
        // 90% chance to catch the plantEater
        if (rand.nextDouble() < 0.90) {
            double meatEaten = plantEater.getSize();
            plantEater.die();
            eat(meatEaten);
        }
    }

    /**
     * The meat eater selects a random subset of plantEaters (1 or 2)
     * to be eaten. The entire plantEater is eaten
     */
    @Override
    public void simulateDay() {
        // Select a number 1 or 2
        int numberOfPlantEaters = rand.nextInt(2) + 1;

        // Check if all plantEaters are dead
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

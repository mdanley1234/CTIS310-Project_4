package edu.guilford.organisms;

import java.util.ArrayList;
import java.util.Random;

import edu.guilford.organisms.abstracts.Critter;

/**
 * The plant eater selects a random subset of plants to be eaten.
 */
public class PlantEater extends Critter {

    private ArrayList<Plant> plantList;
    private Random rand = new Random();

    // Set size, growthRate, foodNeedPercentage, and the list of plants to be eaten
    public PlantEater(double size, double growthRate, double foodNeedPercentage, ArrayList<Plant> plantList) {
        super(size, growthRate, foodNeedPercentage);
        this.plantList = plantList;
    }

    // Life span
    @Override
    public int getLifespan() {
        return 200;
    }

    /**
     * Chew on a plant
     * @param plant
     */
    public void chew(Plant plant) {
        // Select a chew amount between 0 and the maximums set by the conditionals
        double chewAmount = Math.min(stillNeed(), rand.nextDouble() * Math.min(plant.getSize() / 2, calculateFoodNeeded() * 0.1));
        plant.chewedOn(chewAmount); // Eat part of the plant
        eat(chewAmount);            // Add eaten food to the total
    }

    /**
     * The plant eater selects a random percentage of plants (0.5%-2%)
     * to be eaten. The eat amount from each plant is also randomized.
     */
    @Override
    public void simulateDay() {
        // Select a percentage between 0.5% and 2%
        double percentage = rand.nextDouble() * 1.5 + 0.5;
        int numberOfPlants = (int) (plantList.size() * percentage);

        for (int i = 0; i < numberOfPlants; i++) {
            int index = rand.nextInt(plantList.size());
            Plant plant = plantList.get(index);
            chew(plant);
        }

        super.simulateDay();
    }

    @Override
    public String toString() {
        return "PlantEater{" +
                "size=" + size +
                ", alive=" + alive +
                ", age=" + age +
                ", foodNeed=" + calculateFoodNeeded();
    }
}

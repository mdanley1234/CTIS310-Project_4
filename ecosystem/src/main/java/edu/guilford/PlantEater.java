package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

import edu.guilford.organisms.Plant;
import edu.guilford.organisms.abstracts.Critter;

public class PlantEater extends Critter {

    private ArrayList<Plant> plantList;
    private Random rand = new Random();

    public PlantEater(double size, double growthRate, double foodNeedPercentage, ArrayList<Plant> plantList) {
        super(size, growthRate, foodNeedPercentage);
        this.plantList = plantList;
    }

    /**
     * Chew on a plant
     * @param plant
     */
    public void chew(Plant plant) {
        // Select a chew amount between 0 and the maximums set by the conditionals
        double chewAmount = rand.nextDouble() * Math.min(plant.getSize() / 2, Math.min(stillNeed(), calculateFoodNeeded() * 0.1));
        plant.chewedOn(chewAmount); // Eat part of the plant
        eat(chewAmount);            // Add eaten food to the total
    }

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
                ", growthRate=" + growthRate +
                ", alive=" + alive +
                ", age=" + age +
                ", foodNeed=" + foodNeed;
    }
}

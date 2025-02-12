package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        System.out.println("Test 1");
        System.out.println("----------");

        // Create a list of 2000 plants
        Random rand = new Random();
        ArrayList<Plant> plants = new ArrayList<>();
        for (int i = 0; i < 2000; i++) {
            double plantSize = 250 + rand.nextDouble(100);
            plants.add(new Plant(plantSize, 5));
        }

        double plantEaterSize = rand.nextDouble(200) + 900;
        PlantEater plantEater = new PlantEater(plantEaterSize, 3, 50, plants);

        // Testing the plantEater object
        double beginningPlantMass = totalMass(plants);
        double beginningPlantEaterSize = plantEater.getSize();
        System.out.println("Beginning Plant Mass: " + beginningPlantMass);
        System.out.println("Beginning PlantEater size: " + beginningPlantEaterSize);
        System.out.println("Is Alive? " + plantEater.isAlive());

        // Simulate 100 days (No Plant Growth)
        System.out.println("");
        System.out.println("100 Days of PlantEater without Plant Growth");
        for (int i = 0; i < 100; i++) {
            plantEater.simulateDay();
        }
        System.out.println("");

        double endPlantMass = totalMass(plants);
        double endPlantEaterSize = plantEater.getSize();
        System.out.println("End Plant Mass: " + endPlantMass);
        System.out.println("End PlantEater size: " + endPlantEaterSize);
        System.out.println("Is Alive? " + plantEater.isAlive());

        // Calculate the change per day
        double changeInPlantMassPerDay = (beginningPlantMass - endPlantMass) / 100;
        double changeInPlantEaterSizePerDay = -(beginningPlantEaterSize - endPlantEaterSize) / 100;
        System.out.println("Change in Plant Mass per Day: " + changeInPlantMassPerDay);
        System.out.println("Change in PlantEater Size per Day: " + changeInPlantEaterSizePerDay);
        System.out.println("");

        // Review
        System.out.println("We should find that the per day changes are equal to the growthRate and foodNeed of the plantEater");
        System.out.println("PlantEater Food Need: " + plantEater.getFoodNeed());
        System.out.println("PlantEater Growth Rate: " + plantEater.getGrowthRate());
        System.out.println("");

        // Test 2
        ArrayList<Plant> morePlants = new ArrayList<>();
        for (int i = 0; i < 300; i++) {
            double plantSize = 250 + rand.nextDouble(100);
            morePlants.add(new Plant(plantSize, 5));
        }

        ArrayList<PlantEater> morePlantEaters = new ArrayList<>();
        morePlantEaters.add(plantEater);

        for (int i = 0; i < 1000 && stillAlive(morePlantEaters); i++) {
            // 5% chance of adding a new plant
            if (rand.nextDouble() <= 0.05) {
                double plantSize = 250 + rand.nextDouble(100);
                morePlants.add(new Plant(plantSize, 5));
            }
            // 30% chance of adding a new plantEater
            if (rand.nextDouble() <= 0.3) {
                plantEaterSize = rand.nextDouble(200) + 900;
                morePlantEaters.add(new PlantEater(plantEaterSize, 3, 50, morePlants));
            }

            // Simulate a day
            for (PlantEater pe : morePlantEaters) {
                pe.simulateDay();
            }
            for (Plant p : morePlants) {
                p.simulateDay();
            }

            // Remove dead plantEaters
            int plantIndex = 0;
            while (plantIndex < morePlantEaters.size()) {
                if (!morePlantEaters.get(plantIndex).isAlive()) {
                    morePlantEaters.remove(plantIndex);
                } else {
                    plantIndex++;
                }
            }

            // Print Data
            System.out.println("Day " + (i + 1) + ":");
            System.out.println("Number of Plants: " + morePlants.size());
            System.out.println("Number of PlantEaters: " + morePlantEaters.size());
            System.out.println("Total Plant Mass: " + totalMass(morePlants));
            System.out.println("Total PlantEater Mass: " + totalMass(morePlantEaters));
            System.out.println("");
        }
    }

    public static boolean stillAlive(ArrayList<? extends Creature> creatures) {
        for (Creature creature : creatures) {
            if (creature.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public static double totalMass(ArrayList<? extends Creature> creatures) {
        double total = 0;
        for (Creature creature : creatures) {
            total += creature.getSize();
        }
        return total;
    }

}

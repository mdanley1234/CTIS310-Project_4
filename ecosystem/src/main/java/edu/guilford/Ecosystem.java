package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

import edu.guilford.organisms.MeatEater;
import edu.guilford.organisms.Plant;
import edu.guilford.organisms.PlantEater;
import edu.guilford.organisms.abstracts.Creature;
import edu.guilford.organisms.abstracts.Critter;

public class Ecosystem {

    // Arrays of organisms in the ecosystem
    ArrayList<Plant> plants;
    ArrayList<PlantEater> plantEaters;
    ArrayList<MeatEater> meatEaters;

    // Random number generator
    Random rand = new Random();

    // New organism attributes
    private double plantGrowthRate = 5;             // Rate at which plants grow
    private double averagePlantSize = 300;          // Average size of plants
    private double plantEaterGrowthRate = 5;        // Rate at which plantEaters grow
    private double averagePlantEaterSize = 1000;    // Average size of plant eaters
    private double meatEaterGrowthRate = 5;         // Rate at which meatEaters grow
    private double averageMeatEaterSize = 2000;     // Average size of meat eaters
    private double variancePercentage = 0.15;   // Percentage of variance in size
    private double foodNeedPercentage = 0.025;      // Percentage of size that is needed for food

    // Birth Attributes
    private double plantBirthRate = 0.0005; // 0.05% chance of each plant creating a new plant
    private double plantEaterBirthRate = 0.05; // 5% chance of each plantEater creating a new plantEater
    private double meatEaterBirthRate = 0.05; // 5% chance of each meatEater creating a new meatEater

    // Simulation Counter
    private int days = 0;

    // Constructor with attributes
    public Ecosystem(double plantGrowthRate,
            double averagePlantSize,
            double plantEaterGrowthRate,
            double averagePlantEaterSize,
            double meatEaterGrowthRate,
            double averageMeatEaterSize,
            double variancePercentage,
            double foodNeedPercentage) {
        this.plantGrowthRate = plantGrowthRate;
        this.averagePlantSize = averagePlantSize;
        this.plantEaterGrowthRate = plantEaterGrowthRate;
        this.averagePlantEaterSize = averagePlantEaterSize;
        this.meatEaterGrowthRate = meatEaterGrowthRate;
        this.averageMeatEaterSize = averageMeatEaterSize;
        this.variancePercentage = variancePercentage;
        this.foodNeedPercentage = foodNeedPercentage;

        initArrays();
    }

    // Constructor with default attributes
    public Ecosystem() {
        initArrays();
    }

    // Create arrays
    private void initArrays() {
        plants = new ArrayList<>();
        plantEaters = new ArrayList<>();
        meatEaters = new ArrayList<>();
    }

    // Simulate a day
    public void simulateDay() {
        // Simulate organisms
        for (Plant plant : plants) {
            plant.simulateDay();
        }
        for (PlantEater plantEater : plantEaters) {
            plantEater.simulateDay();
        }
        removeDeadCritters(plantEaters);
        for (MeatEater meatEater : meatEaters) {
            meatEater.simulateDay();
        }
        removeDeadCritters(meatEaters);
        removeDeadCritters(plantEaters);

        // Birth cycle (Add new plants, plantEaters, & meatEaters)
        simulateBirths();
        days++;
    }

    // Check for dead organisms and remove
    private void removeDeadCritters(ArrayList<? extends Critter> critters) {
        int i = 0;
        while (i < critters.size()) {
            if (!critters.get(i).isAlive()) {
                critters.remove(i);
            } else {
                i++;
            }
        }
    }

    // Simulate new births added to the simulation
    private void simulateBirths() {
        for (int i = 0; i < plants.size(); i++) {
            if (rand.nextDouble() < plantBirthRate) {
                addPlants(1);
            }
        }
        for (int i = 0; i < plantEaters.size(); i++) {
            if (rand.nextDouble() < plantEaterBirthRate) {
                addPlantEaters(1);
            }
        }
        for (int i = 0; i < meatEaters.size(); i++) {
            if (rand.nextDouble() < meatEaterBirthRate) {
                addMeatEaters(1);
            }
        }
    }

    // Add new plants to the ecosystem
    public void addPlants(int numPlants) {
        for (int i = 0; i < numPlants; i++) {
            double plantSize = averagePlantSize + ((2 * rand.nextDouble() - 1) * averagePlantSize * variancePercentage);
            plants.add(new Plant(plantSize, plantGrowthRate));
        }
    }

    // Add new plant eaters to the ecosystem
    public void addPlantEaters(int numPlantEaters) {
        for (int i = 0; i < numPlantEaters; i++) {
            double plantEaterSize = averagePlantEaterSize + ((2 * rand.nextDouble() - 1) * averagePlantEaterSize * variancePercentage);
            plantEaters.add(new PlantEater(plantEaterSize, plantEaterGrowthRate, foodNeedPercentage, plants));
        }
    }

    // Add new meat eaters to the ecosystem
    public void addMeatEaters(int numMeatEaters) {
        for (int i = 0; i < numMeatEaters; i++) {
            double meatEaterSize = averageMeatEaterSize + ((2 * rand.nextDouble() - 1) * averageMeatEaterSize * variancePercentage);
            meatEaters.add(new MeatEater(meatEaterSize, meatEaterGrowthRate, foodNeedPercentage, plantEaters));
        }
    }

    @Override
    public String toString() {
        return String.format("""
                   Ecosystem {
                     days                = %d
                     plantsCount         = %d
                     plantEatersCount    = %d
                     meatEatersCount     = %d
                     totalPlantMass      = %.2f
                     totalPlantEaterMass = %.2f
                     totalMeatEaterMass  = %.2f
                     plantsStillAlive    = %b
                     plantEatersAlive    = %b
                     meatEatersAlive     = %b
                   }""",
                days,
                plants.size(),
                plantEaters.size(),
                meatEaters.size(),
                totalMass(plants),
                totalMass(plantEaters),
                totalMass(meatEaters),
                stillAlive(plants),
                stillAlive(plantEaters),
                stillAlive(meatEaters)
        );
    }       

    // Statistics calculations
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

    // Getters and setters
    public ArrayList<Plant> getPlants() {
        return plants;
    }

    public void setPlants(ArrayList<Plant> plants) {
        this.plants = plants;
    }

    public ArrayList<PlantEater> getPlantEaters() {
        return plantEaters;
    }

    public void setPlantEaters(ArrayList<PlantEater> plantEaters) {
        this.plantEaters = plantEaters;
    }

    public ArrayList<MeatEater> getMeatEaters() {
        return meatEaters;
    }

    public void setMeatEaters(ArrayList<MeatEater> meatEaters) {
        this.meatEaters = meatEaters;
    }

    public int getDays() {
        return days;
    }
}

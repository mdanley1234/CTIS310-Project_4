package edu.guilford;

import java.util.ArrayList;
import java.util.Random;

import edu.guilford.organisms.Plant;

public class Ecosystem {

    // Arrays of organisms in the ecosystem
    ArrayList<Plant> plants;
    ArrayList<PlantEater> plantEaters;
    ArrayList<MeatEater> meatEaters;

    // Random number generator
    Random rand = new Random();

    // New organism attributes
    private double plantGrowthRate = 5;             // Rate at which plants grow
    private double averagePlantSize = 300;            // Average size of plants
    private double averagePlantEaterSize = 1000;       // Average size of plant eaters
    private double averageMeatEaterSize = 2000;        // Average size of meat eaters
    private double variancePercentage = 0.20;   // Percentage of variance in size
    private double foodNeedPercentage = 0.025;  // Percentage of size that is needed for food

    // Constructor with attributes
    public Ecosystem(double plantGrowthRate, double averagePlantSize, double averagePlantEaterSize, double averageMeatEaterSize, double variancePercentage, double foodNeedPercentage) {
        plants = new ArrayList<>();
        plantEaters = new ArrayList<>();
        meatEaters = new ArrayList<>();
        this.plantGrowthRate = plantGrowthRate;
        this.averagePlantSize = averagePlantSize;
        this.averagePlantEaterSize = averagePlantEaterSize;
        this.averageMeatEaterSize = averageMeatEaterSize;
        this.variancePercentage = variancePercentage;
        this.foodNeedPercentage = foodNeedPercentage;
    }

    // Constructor with default attributes
    public Ecosystem() {
        plants = new ArrayList<>();
        plantEaters = new ArrayList<>();
        meatEaters = new ArrayList<>();
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
            plantEaters.add(new PlantEater(plantEaterSize, plantGrowthRate, 50, plants));
        }
    }

    // Add new meat eaters to the ecosystem
    public void addMeatEaters(int numMeatEaters) {
        for (int i = 0; i < numMeatEaters; i++) {
            double meatEaterSize = averageMeatEaterSize + ((2 * rand.nextDouble() - 1) * averageMeatEaterSize * variancePercentage);
            meatEaters.add(new MeatEater(meatEaterSize, plantEaters));
        }
    }
}

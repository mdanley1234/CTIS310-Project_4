package edu.guilford;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        // Methods for totalMass and stillAlive included in toString definition of Ecosystem class

        Scanner scan = new Scanner(System.in);

        // Test 1
        /*
         * In this test we will be testing the Ecosystem object, Plant object, and PlantEater object
         */
        Ecosystem ecosystem1 = new Ecosystem();
        System.out.println("Test 1");
        System.out.println("Let us begin with 2000 plants and 1 plant eater in our ecosystem.");
        ecosystem1.addPlants(2000);         // Default values: (size) 300 +- 10%
        ecosystem1.addPlantEaters(1);  // Default values: (size) 1000 +- 10%
        scan.nextLine();
        System.out.println();
        System.out.println(ecosystem1.toString());
        System.out.println();
        System.out.println("Let's try simulating 10 days. (Click Enter)");
        System.out.println();
        for (int i = 0; i < 10; i++) {
            ecosystem1.simulateDay();
            System.out.println(ecosystem1.toString());
            scan.nextLine();
        }
        System.out.println("Let's try simulating another 100 days.");
        scan.nextLine();
        for (int i = 0; i < 100; i++) {
            ecosystem1.simulateDay();
        }
        System.out.println(ecosystem1.toString());
        scan.nextLine();

        /*
         * Test One Conclusions:
         * We should find that the total plant mass grows as expected and more plants are born.
         * We should also find that the number of plantEaters has grown as more are born.
         * If we rerun the test with very few plants we find that the plantEaters die off.
         */

         // Test 2
         /*
          * This is a long-term simulation test. We want the simulation to last at least 1,000 days
          */
          System.out.println("Let's run a 1000 day simulation");
          Ecosystem ecosystem2 = new Ecosystem();
          ecosystem2.addPlants(100);
          ecosystem2.addPlantEaters(1);
          System.out.println(ecosystem2.toString());
          while (ecosystem2.getDays() < 1000 &&
          !ecosystem2.getPlantEaters().isEmpty()) {
            ecosystem2.simulateDay();
          }
          System.out.println("Results of 1000 day simulation.");
          System.out.println(ecosystem2.toString());
          scan.nextLine();
          /*
           * Test Two Conclusions:
           * The total number of plant eaters is clearly capped.
           * Even after 1,000 days the number of plantEaters is still very small.
           * The number of plants grows as expected.
           * Most interesting is the mass numbers.
           * The plantEater masses grow very big while the plant masses shrink from overconsumption
           */























    //     System.out.println("Test 1");
    //     System.out.println("----------");

    //     // Create a list of 2000 plants
    //     Random rand = new Random();
    //     ArrayList<Plant> plants = new ArrayList<>();
    //     for (int i = 0; i < 2000; i++) {
    //         double plantSize = 250 + rand.nextDouble(100);
    //         plants.add(new Plant(plantSize, 5));
    //     }

    //     double plantEaterSize = rand.nextDouble(200) + 900;
    //     PlantEater plantEater = new PlantEater(plantEaterSize, 3, 50, plants);

    //     // Testing the plantEater object
    //     double beginningPlantMass = totalMass(plants);
    //     double beginningPlantEaterSize = plantEater.getSize();
    //     System.out.println("Beginning Plant Mass: " + beginningPlantMass);
    //     System.out.println("Beginning PlantEater size: " + beginningPlantEaterSize);
    //     System.out.println("Is Alive? " + plantEater.isAlive());

    //     // Simulate 100 days (No Plant Growth)
    //     System.out.println("");
    //     System.out.println("100 Days of PlantEater without Plant Growth");
    //     for (int i = 0; i < 100; i++) {
    //         plantEater.simulateDay();
    //     }
    //     System.out.println("");

    //     double endPlantMass = totalMass(plants);
    //     double endPlantEaterSize = plantEater.getSize();
    //     System.out.println("End Plant Mass: " + endPlantMass);
    //     System.out.println("End PlantEater size: " + endPlantEaterSize);
    //     System.out.println("Is Alive? " + plantEater.isAlive());

    //     // Calculate the change per day
    //     double changeInPlantMassPerDay = (beginningPlantMass - endPlantMass) / 100;
    //     double changeInPlantEaterSizePerDay = -(beginningPlantEaterSize - endPlantEaterSize) / 100;
    //     System.out.println("Change in Plant Mass per Day: " + changeInPlantMassPerDay);
    //     System.out.println("Change in PlantEater Size per Day: " + changeInPlantEaterSizePerDay);
    //     System.out.println("");

    //     // Review
    //     System.out.println("We should find that the per day changes are equal to the growthRate and foodNeed of the plantEater");
    //     System.out.println("PlantEater Food Need: " + plantEater.getFoodNeed());
    //     System.out.println("PlantEater Growth Rate: " + plantEater.getGrowthRate());
    //     System.out.println("");

    //     Scanner scanner = new Scanner(System.in);
    //     System.out.println("Press Enter to continue...");
    //     scanner.nextLine();

    //     // Test 2
    //     ArrayList<Plant> morePlants = new ArrayList<>();
    //     for (int i = 0; i < 300; i++) {
    //         double plantSize = 250 + rand.nextDouble(100);
    //         morePlants.add(new Plant(plantSize, 5));
    //     }

    //     ArrayList<PlantEater> morePlantEaters = new ArrayList<>();
    //     morePlantEaters.add(plantEater);

    //     for (int i = 0; i < 1000 && stillAlive(morePlantEaters); i++) {
    //         // 5% chance of adding a new plant
    //         if (rand.nextDouble() <= 0.05) {
    //             double plantSize = 250 + rand.nextDouble(100);
    //             morePlants.add(new Plant(plantSize, 5));
    //         }
    //         // 30% chance of adding a new plantEater
    //         if (rand.nextDouble() <= 0.3) {
    //             plantEaterSize = rand.nextDouble(200) + 900;
    //             morePlantEaters.add(new PlantEater(plantEaterSize, 3, 50, morePlants));
    //         }

    //         // Simulate a day
    //         for (PlantEater pe : morePlantEaters) {
    //             pe.simulateDay();
    //         }
    //         for (Plant p : morePlants) {
    //             p.simulateDay();
    //         }

    //         // Remove dead plantEaters
    //         /*
    //          * The index is increased each time through the loop, but if a plantEater is removed
    //          * the same index is checked again since the whole list is shifted down one.
    //          */
    //         int plantIndex = 0;
    //         while (plantIndex < morePlantEaters.size()) {
    //             if (!morePlantEaters.get(plantIndex).isAlive()) {
    //                 morePlantEaters.remove(plantIndex);
    //             } else {
    //                 plantIndex++;
    //             }
    //         }

    //         // Print Data
    //         System.out.println("Day " + (i + 1) + ":");
    //         System.out.println("Number of Plants: " + morePlants.size());
    //         System.out.println("Number of PlantEaters: " + morePlantEaters.size());
    //         System.out.println("Total Plant Mass: " + totalMass(morePlants));
    //         System.out.println("Total PlantEater Mass: " + totalMass(morePlantEaters));
    //         System.out.println("");
    //     }
    //     /**
    //      * The results of test 2 show that the ecosystem reaches an equilibrium where the planteaters
    //      * and plants coexist. The number of plants and planteaters fluctuates around a certain number.
    //     */

    //     System.out.println("Press Enter to continue...");
    //     scanner.nextLine();

    //     // Test 3 (MeatEater)
    //     System.out.println("");
    //     System.out.println("MeatEater Test | 10 days");
    //     MeatEater meatEater = new MeatEater(1000, 3, 50, morePlantEaters);
    //     for (int i = 0; i < 10; i++) {
    //         meatEater.simulateDay();

    //         int plantIndex = 0;
    //         while (plantIndex < morePlantEaters.size()) {
    //             if (!morePlantEaters.get(plantIndex).isAlive()) {
    //                 morePlantEaters.remove(plantIndex);
    //             } else {
    //                 plantIndex++;
    //             }
    //         }
    //     }
    //     System.out.println(meatEater.toString());

    //     System.out.println("Press Enter to continue...");
    //     scanner.nextLine();

    //     // Test 4 (MeatEater and PlantEater)
    //     ArrayList<MeatEater> mE = new ArrayList<>();
    //     for (int i = 0; i < 0; i++) {
    //         mE.add(new MeatEater(1000, 3, 50, morePlantEaters));
    //     }
    //     ArrayList<PlantEater> pE = new ArrayList<>();
    //     for (int i = 0; i < 1; i++) {
    //         pE.add(new PlantEater(1000, 3, 50, morePlants));
    //     }
    //     ArrayList<Plant> p = new ArrayList<>();
    //     for (int i = 0; i < 500; i++) {
    //         p.add(new Plant(250, 5));
    //     }

    //     for (int i = 0; i < 1000 && stillAlive(pE); i++) {
    //         // 5% chance of adding a new plant
    //         if (rand.nextDouble() <= 0.05) {
    //             double plantSize = 250 + rand.nextDouble(100);
    //             p.add(new Plant(plantSize, 5));
    //         }
    //         // 30% chance of adding a new plantEater
    //         if (rand.nextDouble() <= 0.3) {
    //             plantEaterSize = rand.nextDouble(200) + 900;
    //             pE.add(new PlantEater(plantEaterSize, 3, 50, morePlants));
    //         }
    //         // // 30% chance of adding a new meatEater
    //         // if (rand.nextDouble() <= 0.3) {
    //         //     mE.add(new MeatEater(1000, 3, 50, morePlantEaters));
    //         // }

    //         // Simulate a day
    //         for (PlantEater aPlanetEater : pE) {
    //             aPlanetEater.simulateDay();
    //         }
    //         for (Plant aPlant : p) {
    //             aPlant.simulateDay();
    //         }
    //         for (MeatEater aMeatEater : mE) {
    //             aMeatEater.simulateDay();
    //         }

    //         // Remove dead plantEaters and meatEaters
    //         /*
    //          * The index is increased each time through the loop, but if a plantEater is removed
    //          * the same index is checked again since the whole list is shifted down one.
    //          */
    //         int plantIndex = 0;
    //         while (plantIndex < pE.size()) {
    //             if (!pE.get(plantIndex).isAlive()) {
    //                 pE.remove(plantIndex);
    //             } else {
    //                 plantIndex++;
    //             }
    //         }
    //         int meatIndex = 0;
    //         while (meatIndex < mE.size()) {
    //             if (!mE.get(meatIndex).isAlive()) {
    //                 mE.remove(meatIndex);
    //             } else {
    //                 meatIndex++;
    //             }
    //         }

    //         // Print Data
    //         System.out.println("Day " + (i + 1) + ":");
    //         System.out.println("Number of Plants: " + p.size());
    //         System.out.println("Number of PlantEaters: " + pE.size());
    //         System.out.println("Number of MeatEaters: " + mE.size());
    //         System.out.println("Total Plant Mass: " + totalMass(p));
    //         System.out.println("Total PlantEater Mass: " + totalMass(pE));
    //         System.out.println("Total MeatEater Mass: " + totalMass(mE));
    //         System.out.println("");
    //     }

    // }

    // public static boolean stillAlive(ArrayList<? extends Creature> creatures) {
    //     for (Creature creature : creatures) {
    //         if (creature.isAlive()) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // public static double totalMass(ArrayList<? extends Creature> creatures) {
    //     double total = 0;
    //     for (Creature creature : creatures) {
    //         total += creature.getSize();
    //     }
    //     return total;
    // }
    }
}

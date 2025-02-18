package edu.guilford.organisms.abstracts;

/**
 * The critter class extends the creature class and adds food requirements
 */
public abstract class Critter extends Creature {

    // Food requirements
    protected double foodNeedPercentage; // What percentage of size in food is needed to survive
    protected double foodEaten = 0;      // How much food has been eaten today

    // Constructor
    public Critter(double size, double growthRate, double foodNeedPercentage) {
        super(size, growthRate);
        this.foodNeedPercentage = foodNeedPercentage;
    }

    // Simulate a day in the life of the Critter
    @Override
    public void simulateDay() {        
        // Check if the Critter has eaten enough to survive
        if (foodEaten < calculateFoodNeeded()) {
            die();
        }
        
        // Reset daily food intake
        foodEaten = 0;
        super.simulateDay();
    }

    // Calculate the amount of food needed for the day
    protected double calculateFoodNeeded() {
        // The organism needs at least the growth rate or the food need percentage times the size to survive
        return Math.max(foodNeedPercentage * size, growthRate);
    }

    // Feed the Critter
    public void eat(double food) {
        foodEaten += food;
    }

    // Determine how much more food is needed
    public double stillNeed() {
        return Math.max(calculateFoodNeeded() - foodEaten, 0);
    }

    // Getters and setters
    public double getFoodNeed() {
        return calculateFoodNeeded();
    }

    public void setFoodNeedPercentage(double foodNeedPercentage) {
        this.foodNeedPercentage = foodNeedPercentage;
    }
}

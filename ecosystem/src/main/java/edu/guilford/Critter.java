package edu.guilford;

public abstract class Critter extends Creature {

    protected double foodNeed;
    protected  double foodEaten = 0;

    public Critter(double size, double growthRate, double foodNeed) {
        super(size, growthRate);
        this.foodNeed = foodNeed;
    }

    @Override
    public void simulateDay() {
        super.simulateDay();
        if (foodEaten < foodNeed) {
            die();
        }
        foodEaten = 0;
    }

    public void eat(double food) {
        foodEaten += food;
    }

    public double stillNeed() {
        return foodNeed - foodEaten;
    }

    // Getters and setters

    public double getFoodNeed() {
        return foodNeed;
    }

    public void setFoodNeed(double foodNeed) {
        this.foodNeed = foodNeed;
    }
}

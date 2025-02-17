package edu.guilford.organisms.abstracts;

/**
 * Abstract class for all creatures in the ecosystem
 */
public abstract class Creature {
    // Attributes of creatures
    protected double size;              // Size of the creature
    protected double growthRate;        // Linear growth rate of the creature
    protected boolean alive = true;     // Whether the creature is alive
    protected int age = 0;              // Age of the creature (simulation days)

    // Constructor to set size and growthRate of the creature
    public Creature(double size, double growthRate) {
        this.size = size;
        this.growthRate = growthRate;
    }

    /**
     * Change the size of the creature by a given amount
     * @param delta
     */
    public void changeSize(double delta) {
        size += delta;
        if (size <= 0) {
            die();
        }
    }

    /**
     * Simulate a day in the life of the creature
     */
    public void simulateDay() {
        changeSize(growthRate); // Increase size by growthRate
        age++;                  // Increase age by 1 
    }

    /**
     * Kill the creature
     */
    public void die() {
        size = 0;
        growthRate = 0;
        alive = false;
    }

    // Getters and setters
    public double getSize() {
        return size;
    }

    public double getGrowthRate() {
        return growthRate;
    }

    public boolean isAlive() {
        return alive;
    }

    public int getAge() {
        return age;
    }

    public void setGrowthRate(double growthRate) {
        this.growthRate = growthRate;
    }

}

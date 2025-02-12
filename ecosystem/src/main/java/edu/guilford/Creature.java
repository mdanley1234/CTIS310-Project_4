package edu.guilford;

public abstract class Creature {
    protected double size;
    protected double growthRate;
    protected boolean alive = true;
    protected int age = 0;

    public Creature(double size, double growthRate) {
        this.size = size;
        this.growthRate = growthRate;
    }

    public void changeSize(double delta) {
        size += delta;
        if (size <= 0) {
            die();
        }
    }

    public void simulateDay() {
        changeSize(growthRate);
        age++;
    }

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

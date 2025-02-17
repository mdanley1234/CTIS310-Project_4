package edu.guilford.organisms;

import edu.guilford.organisms.abstracts.Creature;

public class Plant extends Creature {
    
    public Plant(double size, double growthRate) {
        super(size, growthRate);
    }

    public void chewedOn(double eaten) {
        // If the plant is eaten more than its size, throw error
        if (eaten > size) {
            throw new IllegalArgumentException("Cannot eat more than the plant's size");
        }
        changeSize(-eaten);
    }

    @Override
    public String toString() {
        return "Plant{" +
                "size=" + size +
                ", growthRate=" + growthRate +
                ", alive=" + alive +
                ", age=" + age;
    }

}

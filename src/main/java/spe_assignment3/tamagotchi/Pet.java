package spe_assignment3.tamagotchi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Pet {
    private int hungriness;
    private int fullness;
    private int happiness;
    private int tiredness;

    public Pet(@Value("50") int hunger, @Value("25") int full, @Value("75") int happy, @Value("50") int tired) {
        hungriness = hunger;
        fullness = full;
        happiness = happy;
        tiredness = tired;
    }

    public void changeStats() {
        int change = 1;
        hungriness = checkStatOutOfBounds(hungriness + change);
        tiredness = checkStatOutOfBounds(tiredness + change);
        happiness = checkStatOutOfBounds(happiness - change);
    }

    private int checkStatOutOfBounds(int originalStat) {
        if (originalStat < 1) {
            return 1;
        } else return Math.min(originalStat, 100);
    }

    public void feed() {
        int change = 25;
        hungriness = checkStatOutOfBounds(hungriness - change);
        fullness = checkStatOutOfBounds(fullness + change);
    }

    public void play() {
        int change = 25;
        happiness = checkStatOutOfBounds(happiness + change);
        tiredness = checkStatOutOfBounds(tiredness + change);
    }

    public void sleep() {
        tiredness = 1;
    }

    public void poop() {
        fullness = 1;
    }

    public int getHungriness() {
        return hungriness;
    }

    public int getFullness() {
        return fullness;
    }

    public int getHappiness() {
        return happiness;
    }

    public int getTiredness() {
        return tiredness;
    }

    public void setHungriness(int i) {
        this.hungriness = i;
    }

    public void setFullness(int i) {
        this.fullness = i;
    }

    public void setHappiness(int i) {
        this.happiness = i;
    }

    public void setTiredness(int i) {
        this.tiredness = i;
    }
}

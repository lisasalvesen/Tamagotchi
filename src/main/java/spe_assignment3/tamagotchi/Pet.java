package spe_assignment3.tamagotchi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Pet {
    private int hungriness;
    private int fullness;
    private int happiness;
    private int tiredness;

    public Pet(@Value("50") int hunger, @Value("50") int full, @Value("50") int happy, @Value("50") int tired) {
        hungriness = hunger;
        fullness = full;
        happiness = happy;
        tiredness = tired;
    }

    public void changeStats() {
        hungriness++;
        tiredness++;
        happiness--;

        if (hungriness > 100) {
            hungriness = 100;
        }
        if (tiredness > 100) {
            tiredness = 100;
        }
    }

    public void feed() {
        hungriness -= 20;
        fullness += 20;
        if (fullness > 100) {
            fullness = 100;
        }
        if (hungriness < 1) {
            hungriness = 1;
        }
    }

    public void play() {
        happiness += 20;
        tiredness += 20;
        if (happiness > 100) {
            happiness = 100;
        }
        if (tiredness > 100) {
            tiredness = 100;
        }
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
}

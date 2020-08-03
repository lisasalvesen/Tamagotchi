package spe_assignment3.tamagotchi;

public class Pet {
    private int hungriness;
    private int fullness;
    private int happiness;
    private int tiredness;

    public Pet(int hunger, int full, int happy, int tired) {
        hungriness = hunger;
        fullness = full;
        happiness = happy;
        tiredness = tired;
    }

    public String feed() {
        hungriness -= 20;
        fullness += 20;
        if (fullness > 100) {
            fullness = 100;
        }
        if (hungriness < 1) {
            hungriness = 1;
        }
        return "Yummy!";
    }

    public String play() {
        happiness += 20;
        tiredness += 20;
        if (happiness > 100) {
            happiness = 100;
        }
        if (tiredness > 100) {
            tiredness = 100;
        }
        return "What a fun game!";
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

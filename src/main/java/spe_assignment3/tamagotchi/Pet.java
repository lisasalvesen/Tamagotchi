package spe_assignment3.tamagotchi;

public class Pet {
    private int hungriness;
    private int fullness;
    private int happiness;

    public Pet(int hunger, int full, int happy) {
        hungriness = hunger;
        fullness = full;
        happiness = happy;
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

    public void play() {
        happiness += 20;
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
}

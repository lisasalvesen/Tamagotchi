package spe_assignment3.tamagotchi;

public class Pet {
    private int hungriness;
    private int fullness;

    public Pet(int hunger, int full) {
        hungriness = hunger;
        fullness = full;
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

    public int getHungriness() {
        return hungriness;
    }

    public int getFullness() {
        return fullness;
    }
}

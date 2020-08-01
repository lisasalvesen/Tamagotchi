package spe_assignment3.tamagotchi;

public class Pet {
    private int hungriness;
    private int fullness;

    public void setHungriness(int i) {
        hungriness = i;
    }

    public void feed() {
        hungriness -= 20;
        fullness += 20;

        if (fullness > 100) {
            fullness = 100;
        }
    }

    public int getHungriness() {
        return hungriness;
    }

    public int getFullness() {
        return fullness;
    }

    public void setFullness(int i) {
        fullness = i;
    }
}

package spe_assignment3.tamagotchi;

public class Pet {
    private int hungriness;
    private int fullness;

    public void setHungriness(int hungriness) {
        this.hungriness = hungriness;
    }

    public void feed() {
        this.hungriness -= 20;
        this.fullness += 20;
    }

    public int getHungriness() {
        return this.hungriness;
    }

    public int getFullness() {
        return this.fullness;
    }
}

package spe_assignment3.tamagotchi;

public class Pet {
    private int hungriness;

    public void setHungriness(int hungriness) {
        this.hungriness = hungriness;
    }

    public void feed() {
        this.hungriness -= 20;
    }

    public int getHungriness() {
        return this.hungriness;
    }
}

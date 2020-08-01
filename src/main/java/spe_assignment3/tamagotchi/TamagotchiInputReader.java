package spe_assignment3.tamagotchi;

public class TamagotchiInputReader {

    private Pet pet;
    public TamagotchiInputReader(final Pet pet) {
        this.pet = pet;
    }

    public void readInput(String input) {
        switch (input) {
            case "FEED":
                System.out.println(pet.feed());
        }
    }
}

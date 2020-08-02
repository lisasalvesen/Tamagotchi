package spe_assignment3.tamagotchi;

public class TamagotchiInputReader {

    private Pet pet;
    public TamagotchiInputReader(final Pet pet) {
        this.pet = pet;
    }

    public boolean evaluateInput(String input) {
        String output;
        switch (input) {
            case "FEED":
                output = pet.feed();
                System.out.println(output);
                return true;
            default:
                System.out.println("Tamagotchi does not understand. Please try again.");
                return true;
        }
    }
}

package spe_assignment3.tamagotchi;

public class InputEvaluator {

    private Pet pet;
    public InputEvaluator(final Pet pet) {
        this.pet = pet;
    }

    public boolean evaluateInput(String input) {
        String output;
        switch (input) {
            case "FEED":
                output = pet.feed();
                System.out.println(output);
                return true;
            case "EXIT":
                System.out.println("Goodbye!");
                return false;
            default:
                System.out.println("Tamagotchi does not understand. Please try again.");
                return true;
        }
    }
}

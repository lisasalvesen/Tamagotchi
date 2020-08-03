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
                pet.feed();
                System.out.println("Yummy!");
                return true;
            case "PLAY":
                pet.play();
                System.out.println("What a fun game!");
                return true;
            case "BED":
                pet.sleep();
                System.out.println("Yawn... Zzzzz...");
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

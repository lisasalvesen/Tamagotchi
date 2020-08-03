package spe_assignment3.tamagotchi;

public class InputEvaluator {

    private Pet pet;
    public InputEvaluator(final Pet pet) {
        this.pet = pet;
    }

    public boolean evaluateInput(String input) {
        boolean continueGame;
        /*
        I would prefer to use a switch statement in this case, but I had problems
        in the past to get branch coverage in switch statements, so I decided on if/else.
        */
        if (input.equals("FEED")) {
            pet.feed();
            System.out.println("Yummy!");
            continueGame = true;
        } else if (input.equals("PLAY")) {
            pet.play();
            System.out.println("What a fun game!");
            continueGame = true;
        } else if (input.equals("BED")) {
            pet.sleep();
            System.out.println("Yawn... Zzzzz...");
            continueGame = true;
        } else if (input.equals("POOP")) {
            pet.poop();
            System.out.println("Don't forget to flush!");
            continueGame = true;
        } else if (input.equals("EXIT")) {
            System.out.println("Goodbye!");
            continueGame = false;
        } else {
            System.out.println("Tamagotchi does not understand. Please try again.");
            continueGame = true;
        }
        return continueGame;
    }
}

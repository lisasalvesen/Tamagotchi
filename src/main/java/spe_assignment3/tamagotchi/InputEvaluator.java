package spe_assignment3.tamagotchi;

public class InputEvaluator {

    private final Pet pet;
    private final StatusPrinter printer;

    public InputEvaluator(final Pet pet, final StatusPrinter printer) {
        this.pet = pet;
        this.printer = printer;
    }

    public boolean evaluateInput(String input) {
        boolean continueGame;
        /*
        * I would prefer to use a switch statement in this case, but I had problems/bugs
        * in the past to receive correct branch coverage in switch statements, so I decided on if/else.
        */
        if (input.equals("FEED")) {
            pet.feed();
            System.out.println("Yummy!\n");
            continueGame = true;
        } else if (input.equals("PLAY")) {
            pet.play();
            System.out.println("What a fun game!\n");
            continueGame = true;
        } else if (input.equals("BED")) {
            pet.sleep();
            System.out.println("Yawn... Zzzzz...\n");
            continueGame = true;
        } else if (input.equals("POOP")) {
            pet.poop();
            System.out.println("Don't forget to flush!\n");
            continueGame = true;
        } else if (input.equals("EXIT")) {
            System.out.println("Goodbye!\n");
            continueGame = false;
        } else {
            System.out.println("Tamagotchi does not understand. Please try again.\n");
            continueGame = true;
        }
        printer.printStatus(pet);
        return continueGame;
    }
}

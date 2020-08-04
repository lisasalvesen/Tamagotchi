package spe_assignment3.tamagotchi;

import org.springframework.stereotype.Component;

@Component
public class StatusPrinter {

    public void printStatus(Pet pet) {
        StringBuilder hungrinessString = new StringBuilder("hungriness: ");
        int hungriness = pet.getHungriness();
        int hungrinessRoundedDown = hungriness / 10;
        hungrinessString.append(buildProgressBar(hungrinessRoundedDown));
        hungrinessString.append(hungriness).append("/100");

        StringBuilder fullnessString = new StringBuilder("fullness: ");
        int fullness = pet.getFullness();
        int fullnessRoundedDown = fullness / 10;
        fullnessString.append(buildProgressBar(fullnessRoundedDown));
        fullnessString.append(fullness).append("/100");

        StringBuilder happinessString = new StringBuilder("happiness: ");
        int happiness = pet.getHappiness();
        int happinessRoundedDown = happiness / 10;
        happinessString.append(buildProgressBar(happinessRoundedDown));
        happinessString.append(happiness).append("/100");

        StringBuilder tirednessString = new StringBuilder("tiredness: ");
        int tiredness = pet.getTiredness();
        int tirednessRoundedDown = tiredness / 10;
        tirednessString.append(buildProgressBar(tirednessRoundedDown));
        tirednessString.append(tiredness).append("/100");

        System.out.println("(＾▽＾)");
        System.out.println(hungrinessString.toString());
        System.out.println(fullnessString.toString());
        System.out.println(happinessString.toString());
        System.out.println(tirednessString.toString());
        System.out.println("What do you want to do with Tamagotchi? (FEED, PLAY, BED, POOP)\n");
    }

    private String buildProgressBar(int quantity) {
        StringBuilder tempBuilder = new StringBuilder();
        for (int x = 0; x < quantity; x++) {
            tempBuilder.append("X");
        }
        for (int x = 0; x < 10-quantity; x++) {
            tempBuilder.append("_");
        }
        tempBuilder.append(" ");
        return tempBuilder.toString();
    }
}

package spe_assignment3.tamagotchi;

import org.springframework.stereotype.Component;

@Component
public class StatusPrinter {

    public void printStatus(Pet pet) {
        StringBuilder hungriness = new StringBuilder("hungriness: ");
        int hungrinessRoundedDown = pet.getHungriness() / 10;
        hungriness.append(buildProgressBar(hungrinessRoundedDown));
        hungriness.append(hungrinessRoundedDown).append("0/100");

        StringBuilder fullness = new StringBuilder("fullness: ");
        int fullnessRoundedDown = pet.getFullness() / 10;
        fullness.append(buildProgressBar(fullnessRoundedDown));
        fullness.append(fullnessRoundedDown).append("0/100");

        StringBuilder happiness = new StringBuilder("happiness: ");
        int happinessRoundedDown = pet.getHappiness() / 10;
        happiness.append(buildProgressBar(happinessRoundedDown));
        happiness.append(happinessRoundedDown).append("0/100");

        StringBuilder tiredness = new StringBuilder("tiredness: ");
        int tirednessRoundedDown = pet.getTiredness() / 10;
        tiredness.append(buildProgressBar(tirednessRoundedDown));
        tiredness.append(tirednessRoundedDown).append("0/100");

        System.out.println("(＾▽＾)");
        System.out.println(hungriness.toString());
        System.out.println(fullness.toString());
        System.out.println(happiness.toString());
        System.out.println(tiredness.toString());
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

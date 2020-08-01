package spe_assignment3.tamagotchi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetTests {

    @Test
    void testFeedingPet_decreasesHungriness() {
        Pet pet = new Pet();
        pet.setHungriness(70);

        pet.feed();

        assertEquals(50, pet.getHungriness());
    }

    @Test
    void testFeedPet_increaseFullness() {
        Pet pet = new Pet();

        pet.feed();

        assertEquals(20, pet.getFullness());
    }

    @Test
    void testFeedPet_fullnessNeverHigherThan100() {
        Pet pet = new Pet();
        pet.setFullness(90);

        pet.feed();

        assertEquals(100, pet.getFullness());
    }

    @Test
    void testFeedPet_hungrinessNeverLowerThanZero() {
        Pet pet = new Pet();

        pet.feed();

        assertEquals(0, pet.getHungriness());
    }

}

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

}

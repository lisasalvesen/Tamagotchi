package spe_assignment3.tamagotchi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetTests {
    private Pet pet;

    @BeforeEach
    public void init() {
        pet = new Pet(50, 50, 50, 50);
    }

    @Test
    void testFeedingPet_decreaseHungriness() {
        // arrange
        // act
        pet.feed();

        // assert
        assertEquals(30, pet.getHungriness());
    }

    @Test
    void testFeedPet_increaseFullness() {
        // arrange
        // act
        pet.feed();

        // assert
        assertEquals(70, pet.getFullness());
    }

    @Test
    void testFeedPet_fullnessNeverHigherThan100() {
        // arrange
        Pet pet = new Pet(50, 90, 50, 50);

        // act
        pet.feed();

        // assert
        assertEquals(100, pet.getFullness());
    }

    @Test
    void testFeedPet_hungrinessNeverLowerThanOne() {
        // arrange
        Pet pet = new Pet(1, 50, 50, 50);

        // act
        pet.feed();

        // assert
        assertEquals(1, pet.getHungriness());
    }

    @Test
    void testPlay_increaseHappiness() {
        // arrange
        // act
        pet.play();

        // assert
        assertEquals(70, pet.getHappiness());
    }

    @Test
    void testPlay_increaseTiredness() {
        // arrange
        // act
        pet.play();

        // assert
        assertEquals(70, pet.getTiredness());
    }

    @Test
    void testPlay_happinessNeverHigherThan100() {
        // arrange
        Pet pet = new Pet(50, 50, 90, 50);

        // act
        pet.play();

        // assert
        assertEquals(100, pet.getHappiness());
    }

    @Test
    void testPlay_tirednessNeverHigherThan100() {
        // arrange
        Pet pet = new Pet(50, 50, 50, 90);

        // act
        pet.play();

        // assert
        assertEquals(100, pet.getTiredness());
    }

    @Test
    void testSleep_decreaseTirednessToOne() {
        // arrange
        // act
        pet.sleep();

        // assert
        assertEquals(1, pet.getTiredness());
    }

    @Test
    void testPoop_decreaseFullnessToOne() {
        // arrange
        // act
        pet.poop();

        // assert
        assertEquals(1, pet.getFullness());
    }

}

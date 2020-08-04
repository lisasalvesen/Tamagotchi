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
    void testChangeStats_hungrinessIncreasesByOne() {
        // arrange
        // act
        pet.changeStats();

        // assert
        assertEquals(51, pet.getHungriness());
    }

    @Test
    void testChangeStats_tirednessIncreasesByOne() {
        // arrange
        // act
        pet.changeStats();

        // assert
        assertEquals(51, pet.getTiredness());
    }

    @Test
    void testChangeStats_happinessDecreasesByOne() {
        // arrange
        // act
        pet.changeStats();

        // assert
        assertEquals(49, pet.getHappiness());
    }

    @Test
    void testChangeStats_hungrinessNeverHigherThan100() {
        // arrange
        Pet pet = new Pet(100, 50, 50,50);

        // act
        pet.changeStats();

        // assert
        assertEquals(100, pet.getHungriness());
    }

    @Test
    void testFeedingPet_hungrinessDecreasesBy20() {
        // arrange
        // act
        pet.feed();

        // assert
        assertEquals(30, pet.getHungriness());
    }

    @Test
    void testFeedPet_fullnessIncreasesBy20() {
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
    void testPlay_happinessIncreasesBy20() {
        // arrange
        // act
        pet.play();

        // assert
        assertEquals(70, pet.getHappiness());
    }

    @Test
    void testPlay_tirednessIncreasesBy20() {
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
    void testSleep_tirednessDecreasesToOne() {
        // arrange
        // act
        pet.sleep();

        // assert
        assertEquals(1, pet.getTiredness());
    }

    @Test
    void testPoop_decreasesFullnessToOne() {
        // arrange
        // act
        pet.poop();

        // assert
        assertEquals(1, pet.getFullness());
    }

}

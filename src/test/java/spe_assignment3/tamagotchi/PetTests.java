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
    void testChangeStats_increasesHungrinessByOne() {
        // arrange
        // act
        pet.changeStats();

        // assert
        assertEquals(51, pet.getHungriness());
    }

    @Test
    void testChangeStats_increasesTirednessByOne() {
        // arrange
        // act
        pet.changeStats();

        // assert
        assertEquals(51, pet.getTiredness());
    }

    @Test
    void testChangeStats_decreasesHappinessByOne() {
        // arrange
        // act
        pet.changeStats();

        // assert
        assertEquals(49, pet.getHappiness());
    }

    @Test
    void testChangeStats_hungrinessNeverHigherThan100() {
        // arrange
        pet.setHungriness(100);

        // act
        pet.changeStats();

        // assert
        assertEquals(100, pet.getHungriness());
    }

    @Test
    void testChangeStats_tirednessNeverHigherThan100() {
        // arrange
        pet.setTiredness(100);

        // act
        pet.changeStats();

        // assert
        assertEquals(100, pet.getTiredness());
    }

    @Test
    void testChangeStats_happinessNeverLowerThanOne() {
        // arrange
        pet.setHappiness(1);

        // act
        pet.changeStats();

        // assert
        assertEquals(1, pet.getHappiness());
    }

    @Test
    void testFeedingPet_decreasesHungrinessBy25() {
        // arrange
        // act
        pet.feed();

        // assert
        assertEquals(25, pet.getHungriness());
    }

    @Test
    void testFeedPet_increasesFullnessBy25() {
        // arrange
        // act
        pet.feed();

        // assert
        assertEquals(75, pet.getFullness());
    }

    @Test
    void testFeedPet_fullnessNeverHigherThan100() {
        // arrange
        pet.setFullness(100);

        // act
        pet.feed();

        // assert
        assertEquals(100, pet.getFullness());
    }

    @Test
    void testFeedPet_hungrinessNeverLowerThanOne() {
        // arrange
        pet.setHungriness(1);

        // act
        pet.feed();

        // assert
        assertEquals(1, pet.getHungriness());
    }

    @Test
    void testPlay_increasesHappinessBy25() {
        // arrange
        // act
        pet.play();

        // assert
        assertEquals(75, pet.getHappiness());
    }

    @Test
    void testPlay_increasesTirednessBy25() {
        // arrange
        // act
        pet.play();

        // assert
        assertEquals(75, pet.getTiredness());
    }

    @Test
    void testPlay_happinessNeverHigherThan100() {
        // arrange
        pet.setHappiness(100);

        // act
        pet.play();

        // assert
        assertEquals(100, pet.getHappiness());
    }

    @Test
    void testPlay_tirednessNeverHigherThan100() {
        // arrange
        pet.setTiredness(100);

        // act
        pet.play();

        // assert
        assertEquals(100, pet.getTiredness());
    }

    @Test
    void testSleep_decreasesTirednessToOne() {
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

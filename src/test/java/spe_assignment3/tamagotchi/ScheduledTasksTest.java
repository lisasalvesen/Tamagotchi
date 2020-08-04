package spe_assignment3.tamagotchi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class ScheduledTasksTest {
    Pet pet;
    ScheduledTasks tasks;
    StatusPrinter printer;

    @BeforeEach
    public void init() {
        pet = spy(new Pet(50,50,50,50));
        printer = spy(new StatusPrinter());
        tasks = new ScheduledTasks(pet, printer);
    }

    /*
    * This test only tests the logic inside of the method.
    * No integration test was done to test whether Spring @Scheduled works as it should.
    * */
    @Test
    void testCallChangeStats_callPetChangeStats_statsIncreasedOrDecreased() {
        // arrange
        // act
        tasks.callChangeStats();

        // assert
        verify(pet, times(1)).changeStats();
        assertEquals(51, pet.getHungriness());
        assertEquals(51, pet.getTiredness());
        assertEquals(49, pet.getHappiness());
    }

    @Test
    void testCheckForStatChange_newHungrinessHigher() {
        // arrange
        pet.setHungriness(70);

        // act
        tasks.checkForStatChanges();

        // assert
        verify(printer, times(1)).printStatus(pet);
    }

    @Test
    void testCheckForStatChange_newHungrinessLower() {
        // arrange
        pet.setHungriness(30);

        // act
        tasks.checkForStatChanges();

        // assert
        verify(printer, times(1)).printStatus(pet);
    }

    @Test
    void testCheckForStatChange_newFullnessHigher() {
        // arrange
        pet.setFullness(70);

        // act
        tasks.checkForStatChanges();

        // assert
        verify(printer, times(1)).printStatus(pet);
    }

    @Test
    void testCheckForStatChange_newFullnessLower() {
        // arrange
        pet.setFullness(30);

        // act
        tasks.checkForStatChanges();

        // assert
        verify(printer, times(1)).printStatus(pet);
    }


    @Test
    void testCheckForStatChange_newHappinessHigher() {
        // arrange
        pet.setHappiness(70);

        // act
        tasks.checkForStatChanges();

        // assert
        verify(printer, times(1)).printStatus(pet);
    }
}

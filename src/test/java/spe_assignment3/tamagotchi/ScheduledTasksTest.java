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
        pet = spy(new Pet(55,55,55,55));
        printer = spy(new StatusPrinter());
        tasks = new ScheduledTasks(pet, printer);
    }

    @Test
    void testCallChangeStats_callsPetChangeStats_statsIncreasedOrDecreased() throws InterruptedException {
        // arrange
        // act
        tasks.callChangeStatsScheduled();
        Thread.sleep(2000);

        // assert
        verify(pet, times(1)).changeStats();
        assertEquals(56, pet.getHungriness());
        assertEquals(56, pet.getTiredness());
        assertEquals(54, pet.getHappiness());
    }

    @Test
    void testCheckForStatChange_newHungrinessHigher() throws InterruptedException {
        // arrange
        pet.setHungriness(70);

        // act
        tasks.callChangeStatsScheduled();
        Thread.sleep(2000);

        // assert
        verify(printer, times(1)).printStatus(pet);
    }

    @Test
    void testCheckForStatChange_newHungrinessLower() throws InterruptedException {
        // arrange
        pet.setHungriness(30);

        // act
        tasks.callChangeStatsScheduled();
        Thread.sleep(2000);

        // assert
        verify(printer, times(1)).printStatus(pet);
    }

    @Test
    void testCheckForStatChange_newFullnessHigher() throws InterruptedException {
        // arrange
        pet.setFullness(70);

        // act
        tasks.callChangeStatsScheduled();
        Thread.sleep(2000);

        // assert
        verify(printer, times(1)).printStatus(pet);
    }

    @Test
    void testCheckForStatChange_newFullnessLower() throws InterruptedException {
        // arrange
        pet.setFullness(30);

        // act
        tasks.callChangeStatsScheduled();
        Thread.sleep(2000);

        // assert
        verify(printer, times(1)).printStatus(pet);
    }

    @Test
    void testCheckForStatChange_newHappinessLower() throws InterruptedException {
        // arrange
        pet.setHappiness(30);

        // act
        tasks.callChangeStatsScheduled();
        Thread.sleep(2000);

        // assert
        verify(printer, times(1)).printStatus(pet);
    }

    @Test
    void testCheckForStatChange_newHappinessHigher() throws InterruptedException {
        // arrange
        pet.setHappiness(70);

        // act
        tasks.callChangeStatsScheduled();
        Thread.sleep(2000);

        // assert
        verify(printer, times(1)).printStatus(pet);
    }

    @Test
    void testCheckForStatChange_newTirednessLower() throws InterruptedException {
        // arrange
        pet.setTiredness(30);

        // act
        tasks.callChangeStatsScheduled();
        Thread.sleep(2000);

        // assert
        verify(printer, times(1)).printStatus(pet);
    }


    @Test
    void testCheckForStatChange_newTirednessHigher() throws InterruptedException {
        // arrange
        pet.setTiredness(70);

        // act
        tasks.callChangeStatsScheduled();
        Thread.sleep(2000);

        // assert
        verify(printer, times(1)).printStatus(pet);
    }
}

package spe_assignment3.tamagotchi;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScheduledTasksTest {

    /*
    * This test only tests the logic inside of the method.
    * No integration test was done to test whether Spring @Scheduled works as it should.
    * */
    @Test
    void testCallChangeStats_callPetChangeStats_statsIncreasedOrDecreased() {
        Pet pet = new Pet(50,50,50,50);
        ScheduledTasks tasks = new ScheduledTasks(pet);

        tasks.callChangeStats();

        assertEquals(51, pet.getHungriness());
        assertEquals(51, pet.getTiredness());
        assertEquals(49, pet.getHappiness());
    }

}

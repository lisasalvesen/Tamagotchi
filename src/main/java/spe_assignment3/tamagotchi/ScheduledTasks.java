package spe_assignment3.tamagotchi;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTasks {
    private final Pet pet;

    public ScheduledTasks(Pet pet) {
        this.pet = pet;
    }

    @Scheduled(fixedRate = 2000)
    public void callChangeStats() {
        pet.changeStats();
    }
}

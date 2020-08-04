package spe_assignment3.tamagotchi;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledTasks {
    private final Pet pet;
    private final StatusPrinter printer;
    private int oldHungriness;

    public ScheduledTasks(Pet pet, StatusPrinter printer) {
        this.pet = pet;
        this.printer = printer;
        oldHungriness = pet.getHungriness() / 10;
    }

    @Scheduled(fixedRate = 2000)
    public void callChangeStats() {
        pet.changeStats();
    }

    @Scheduled(fixedRate = 500)
    public void checkForStatChanges() {
        int newHungriness = pet.getHungriness() / 10;
        if (oldHungriness < newHungriness) {
            oldHungriness = newHungriness;
            printer.printStatus(pet);
        }

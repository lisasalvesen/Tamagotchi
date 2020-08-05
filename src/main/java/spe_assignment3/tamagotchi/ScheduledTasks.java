package spe_assignment3.tamagotchi;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Timer;
import java.util.TimerTask;

@Service
public class ScheduledTasks {
    private final Pet pet;
    private final StatusPrinter printer;
    private final Timer updateTimer;
    private int oldHungriness;
    private int oldFullness;
    private int oldHappiness;
    private int oldTiredness;

    public ScheduledTasks(Pet pet, StatusPrinter printer) {
        this.pet = pet;
        this.printer = printer;
        updateTimer = new Timer();
        oldHungriness = pet.getHungriness() / 10;
        oldFullness = pet.getFullness() / 10;
        oldHappiness = pet.getHappiness() / 10;
        oldTiredness = pet.getTiredness() / 10;
    }

    public void callChangeStatsScheduled() {
        this.updateTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                pet.changeStats();
                checkForStatChanges();
            }
        }, 1000, 3000);
    }

    private void checkForStatChanges() {
        int newHungriness = pet.getHungriness() / 10;
        int newFullness = pet.getFullness() / 10;
        int newHappiness = pet.getHappiness() / 10;
        int newTiredness = pet.getTiredness() / 10;

        if (oldHungriness < newHungriness || oldHungriness > newHungriness) {
            updateStats(newHungriness, newFullness, newHappiness, newTiredness);
            printer.printStatus(pet);
        } else if (oldFullness < newFullness || oldFullness > newFullness) {
            updateStats(newHungriness, newFullness, newHappiness, newTiredness);
            printer.printStatus(pet);
        } else if (oldHappiness < newHappiness || oldHappiness > newHappiness) {
            updateStats(newHungriness, newFullness, newHappiness, newTiredness);
            printer.printStatus(pet);
        } else if (oldTiredness < newTiredness || oldTiredness > newTiredness) {
            updateStats(newHungriness, newFullness, newHappiness, newTiredness);
            printer.printStatus(pet);
        }
    }

    private void updateStats(int hungry, int full, int happy, int tired) {
        oldHungriness = hungry;
        oldFullness = full;
        oldHappiness = happy;
        oldTiredness = tired;
    }
}

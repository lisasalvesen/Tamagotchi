package spe_assignment3.tamagotchi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
@EnableScheduling
public class TamagotchiApplication {

    public void start(BufferedReader stdin) throws IOException {
        // Pet values initialized using @value in Pet class.
        final Pet pet = new Pet(50, 25, 75, 50);
        final StatusPrinter printer = new StatusPrinter();
        final InputEvaluator reader = new InputEvaluator(pet, printer);
        final ScheduledTasks tasks = new ScheduledTasks(pet, printer);
        boolean running = true;

        printer.printStatus(pet);
        tasks.callChangeStatsScheduled();

        while (running) {
            String trimmedInput = stdin.readLine().trim();
            running = reader.evaluateInput(trimmedInput);
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        SpringApplication.run(TamagotchiApplication.class, args);
        new TamagotchiApplication().start(stdin);
        System.exit(0);
    }

}

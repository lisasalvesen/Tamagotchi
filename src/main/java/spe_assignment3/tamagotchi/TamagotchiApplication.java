package spe_assignment3.tamagotchi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
        final InputEvaluator reader = new InputEvaluator(pet);
        final StatusPrinter printer = new StatusPrinter();
        boolean running = true;

        new ScheduledTasks(pet, printer);

        printer.printStatus(pet);

        while (running) {
            String trimmedInput = stdin.readLine().trim();
            running = reader.evaluateInput(trimmedInput);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        SpringApplication.run(TamagotchiApplication.class, args);
        new TamagotchiApplication().start(stdin);
    }

}

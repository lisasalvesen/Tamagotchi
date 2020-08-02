package spe_assignment3.tamagotchi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@SpringBootApplication
public class TamagotchiApplication {

    public void start(BufferedReader stdin, TamagotchiInputReader reader) throws IOException {
        boolean running = true;

        while (running) {
            String trimmedInput = stdin.readLine().trim();
            running = reader.evaluateInput(trimmedInput);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in));
        Pet pet = new Pet(0, 0);
        TamagotchiInputReader reader = new TamagotchiInputReader(pet);
        SpringApplication.run(TamagotchiApplication.class, args);
        new TamagotchiApplication().start(stdin, reader);
    }

}

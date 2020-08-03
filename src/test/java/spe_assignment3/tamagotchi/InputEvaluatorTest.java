package spe_assignment3.tamagotchi;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InputEvaluatorTest {

    @Test
    void testEvaluateInput_feed() {
        // arrange
        final Pet pet = mock(Pet.class);
        final InputEvaluator reader = new InputEvaluator(pet);
        final String input = "FEED";
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        boolean result = reader.evaluateInput(input);

        // assert
        verify(pet, times(1)).feed();
        verify(out).println("Yummy!");
        assertTrue(result);
    }

    @Test
    void testEvaluateInput_play() {
        // arrange
        final Pet pet = mock(Pet.class);
        final InputEvaluator reader = new InputEvaluator(pet);
        final String input = "PLAY";
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        boolean result = reader.evaluateInput(input);

        // assert
        verify(pet, times(1)).play();
        verify(out).println("What a fun game!");
        assertTrue(result);
    }

    @Test
    void testEvaluateInput_petSleeps() {
        // arrange
        final Pet pet = mock(Pet.class);
        final InputEvaluator reader = new InputEvaluator(pet);
        final String input = "SLEEP";
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        boolean result = reader.evaluateInput(input);

        // assert
        verify(pet, times(1)).sleep();
        verify(out).println("Yawn... Zzzzz...");
        assertTrue(result);
    }

    @Test
    void testEvaluateInput_exitGame() {
        // arrange
        final Pet pet = mock(Pet.class);
        final InputEvaluator reader = new InputEvaluator(pet);
        final String input = "EXIT";
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        boolean result = reader.evaluateInput(input);

        // assert
        verify(out).println("Goodbye!");
        assertFalse(result);
    }

    @Test
    void testEvaluateInput_invalidInput_user() {
        // arrange
        final Pet pet = mock(Pet.class);
        final InputEvaluator reader = new InputEvaluator(pet);
        final String input = "invalid";
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        boolean result = reader.evaluateInput(input);

        // assert
        verify(out).println("Tamagotchi does not understand. Please try again.");
        assertTrue(result);
    }

}

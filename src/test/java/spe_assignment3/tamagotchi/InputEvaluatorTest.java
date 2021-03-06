package spe_assignment3.tamagotchi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InputEvaluatorTest {

    Pet pet;
    StatusPrinter printer;
    InputEvaluator reader;

    @BeforeEach
    void init() {
        pet = mock(Pet.class);
        printer = mock(StatusPrinter.class);
        reader = new InputEvaluator(pet, printer);
    }

    @Test
    void testEvaluateInput_inputFeed_petEats() {
        // arrange
        final String input = "FEED";
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        boolean result = reader.evaluateInput(input);

        // assert
        verify(pet, times(1)).feed();
        verify(out).println("Yummy!\n");
        assertTrue(result);
    }

    @Test
    void testEvaluateInput_inputPlay_playWithPet() {
        // arrange
        final String input = "PLAY";
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        boolean result = reader.evaluateInput(input);

        // assert
        verify(pet, times(1)).play();
        verify(out).println("What a fun game!\n");
        assertTrue(result);
    }

    @Test
    void testEvaluateInput_inputBed_petSleeps() {
        // arrange
        final String input = "BED";
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        boolean result = reader.evaluateInput(input);

        // assert
        verify(pet, times(1)).sleep();
        verify(out).println("Yawn... Zzzzz...\n");
        assertTrue(result);
    }

    @Test
    void testEvaluateInput_inputPoop_petPoops() {
        // arrange
        final String input = "POOP";
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        boolean result = reader.evaluateInput(input);

        // assert
        verify(pet, times(1)).poop();
        verify(out).println("Don't forget to flush!\n");
        assertTrue(result);
    }

    @Test
    void testEvaluateInput_inputExit_exitGame() {
        // arrange
        final String input = "EXIT";
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        boolean result = reader.evaluateInput(input);

        // assert
        verify(out).println("Goodbye!\n");
        assertFalse(result);
    }

    @Test
    void testEvaluateInput_invalidInput_userHasToTryAgain() {
        // arrange
        final String input = "invalid";
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        boolean result = reader.evaluateInput(input);

        // assert
        verify(out).println("Tamagotchi does not understand. Please try again.\n");
        assertTrue(result);
    }

}

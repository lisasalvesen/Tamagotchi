package spe_assignment3.tamagotchi;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class TamagotchiInputReaderTest {

    @Test
    void testEvaluateInput_feed() {
        // arrange
        final Pet pet = mock(Pet.class);
        when(pet.feed()).thenReturn("Yummy!");
        final TamagotchiInputReader reader = new TamagotchiInputReader(pet);
        final String input = "FEED";
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        boolean result = reader.evaluateInput(input);

        // assert
        verify(pet, times(1)).feed();
        verify(out).println("Yummy!");
        assertEquals(true, result);
    }

    @Test
    void testEvaluateInput_invalidInput() {
        // arrange
        final Pet pet = mock(Pet.class);
        final TamagotchiInputReader reader = new TamagotchiInputReader(pet);
        final String input = "EXIT";
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        boolean result = reader.evaluateInput(input);

        // assert
        verify(out).println("Tamagotchi does not understand. Please try again.");
        assertEquals(true, result);
    }

}

package spe_assignment3.tamagotchi;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class TamagotchiInputReaderTest {

    @Test
    void testInput_feed() {
        // arrange
        final Pet pet = mock(Pet.class);
        when(pet.feed()).thenReturn("Yummy!");
        final TamagotchiInputReader reader = new TamagotchiInputReader(pet);
        final String input = "FEED";
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        reader.readInput(input);

        // assert
        verify(pet, times(1)).feed();
        verify(out).println("Yummy!");
    }

}

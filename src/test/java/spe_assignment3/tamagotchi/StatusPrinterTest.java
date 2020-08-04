package spe_assignment3.tamagotchi;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class StatusPrinterTest {

    StatusPrinter printer;

    @BeforeEach
    public void init() {
        printer = new StatusPrinter();
    }

    @Test
    public void testPrintStatus() {
        // arrange
        final Pet pet = new Pet(50,50,50,50);
        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        printer.printStatus(pet);

        // assert
        verify(out).println("(＾▽＾)");
        verify(out).println("hungriness: XXXXX_____ 50/100");
        verify(out).println("fullness: XXXXX_____ 50/100");
        verify(out).println("happiness: XXXXX_____ 50/100");
        verify(out).println("tiredness: XXXXX_____ 50/100");
        verify(out).println("What do you want to do with Tamagotchi? (FEED, PLAY, BED, POOP)\n");
    }

}

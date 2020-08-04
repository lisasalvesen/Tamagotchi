package spe_assignment3.tamagotchi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class TamagotchiApplicationTests {

    @Test
    void testStart_userEntersInputAndExitsGame() throws IOException {
        // arrange
        TamagotchiApplication application = new TamagotchiApplication();
        BufferedReader in = mock(BufferedReader.class);
        when(in.readLine()).thenReturn("FEED", "EXIT");

        final PrintStream out = mock(PrintStream.class);
        System.setOut(out);

        // act
        application.start(in);

        // assert
        verify(in, times(2)).readLine();
        verify(out).println("Yummy!\n");
        verify(out).println("Goodbye!\n");
    }
}

package spe_assignment3.tamagotchi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.BufferedReader;
import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class TamagotchiApplicationTests {

    @Test
    void testStart_userEntersInputAndExitsGame() throws IOException {
        // arrange
        TamagotchiApplication application = new TamagotchiApplication();
        BufferedReader in = mock(BufferedReader.class);
        InputEvaluator reader = mock(InputEvaluator.class);
        when(in.readLine()).thenReturn("FEED", "EXIT");
        when(reader.evaluateInput("FEED")).thenReturn(true);
        when(reader.evaluateInput("EXIT")).thenReturn(false);

        // act
        application.start(in, reader);

        // assert
        verify(in, times(2)).readLine();
        verify(reader, times(1)).evaluateInput("FEED");
        verify(reader, times(1)).evaluateInput("EXIT");
    }
}

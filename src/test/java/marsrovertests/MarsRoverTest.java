package marsrovertests;

import marsrover.MarsRover;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverTest {
    @ParameterizedTest
    @CsvSource({
            "'', 0:0:N",
            "R, 0:0:E",
            "RR, 0:0:S",
            "RRR, 0:0:W",
            "L, 0:0:W",
            "LL, 0:0:S",
            "LLL, 0:0:E",
            "M, 0:1:N",
            "MM, 0:2:N",
            "MMM, 0:3:N",
            "MMMMMMMMMM, 0:0:N",
            "RM, 1:0:E",
            "RMM, 2:0:E",
            "RMMM, 3:0:E",
            "RMMMMMMMMMM, 0:0:E",
            "LM, 9:0:W",
            "LLM, 0:9:S",
    })
    void should_run_commands(String input, String expected) {

        // act
        MarsRover marsRover = new MarsRover();
        String actualOutput = marsRover.run(input);
        // assert
        assertEquals(expected, actualOutput);
    }
}

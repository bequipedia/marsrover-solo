package marsrovertests;

import marsrover.MarsRover;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MarsRoverAcceptanceTest {
    @Test
    void should_navigate_rover(){
        // arrange
        String expectedOutput = "9:0:W";

        // act
        MarsRover marsRover = new MarsRover();
        String actualOutput = marsRover.run("MRMRMRMM");
        // assert
        assertEquals(expectedOutput, actualOutput);
    }

}

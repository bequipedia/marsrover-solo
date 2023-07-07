package marsrover;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateRightTest {
    @ParameterizedTest
    @MethodSource("turnRightSource")
    void should_turn_right(Direction startingDirection, Direction expectedDirection) {

        RotateRight rotateRight = new RotateRight();

        Location location = new Location(startingDirection);
        rotateRight.execute(location);

        assertEquals(expectedDirection, location.direction);
    }
    private static Stream<Arguments> turnRightSource() {
        return Stream.of(
                Arguments.of(Direction.SOUTH, Direction.WEST),
                Arguments.of(Direction.NORTH, Direction.EAST),
                Arguments.of(Direction.EAST, Direction.SOUTH),
                Arguments.of(Direction.WEST, Direction.NORTH)
        );
    }
}

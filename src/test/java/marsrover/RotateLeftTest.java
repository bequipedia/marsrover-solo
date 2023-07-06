package marsrover;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RotateLeftTest {
    @ParameterizedTest
    @MethodSource("turnLeftSource")
    void should_turn_left(Direction startingDirection, Direction expectedDirection) {

        RotateLeft rotateLeft = new RotateLeft();
        Location location = new Location(startingDirection);
        rotateLeft.execute(location);

        assertEquals(expectedDirection, location.direction);
    }
    private static Stream<Arguments> turnLeftSource() {
        return Stream.of(
                Arguments.of(Direction.NORTH, Direction.WEST),
                Arguments.of(Direction.WEST, Direction.SOUTH),
                Arguments.of(Direction.SOUTH, Direction.EAST),
                Arguments.of(Direction.EAST, Direction.NORTH)
        );
    }

}

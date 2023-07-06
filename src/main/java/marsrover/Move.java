package marsrover;

public class Move implements Instructions {
    
    @Override
    public void execute(Location location) {
        if (location.direction.equals(Direction.NORTH)) {
            location.moveNorth();
        }
        if (location.direction.equals(Direction.SOUTH)) {
            location.moveSouth();
        }
        if (location.direction.equals(Direction.EAST)) {
            location.moveEast();
        }
        if (location.direction.equals(Direction.WEST)) {
            location.moveWest();
        }
    }
}

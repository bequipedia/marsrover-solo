package marsrover;

public class RotateLeft implements Instructions{

    @Override
    public void execute(Location location) {
        switch (location.direction) {
            case EAST -> location.faceNorth();
            case SOUTH -> location.faceEast();
            case WEST -> location.faceSouth();
            default -> location.faceWest();
        }
    }
}

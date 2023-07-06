package marsrover;

public class RotateRight implements Instructions {
    @Override
    public void execute(Location location) {
        switch (location.direction) {
            case EAST -> location.faceSouth();
            case SOUTH -> location.faceWest();
            case WEST -> location.faceNorth();
            default -> location.faceEast();
        }
    }

//    state pattern because I'm changing states
//    youtube Mauro and Cameron from functional to oop
}

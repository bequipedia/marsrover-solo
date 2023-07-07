package marsrover;

public class Location {
    Direction direction;
    Coordinates coordinates = new Coordinates();

    public Location() {
        this.direction = Direction.NORTH;
    }
    public Location(Direction direction) {
        this.direction = direction;
    }

    public void faceNorth() {
        direction = Direction.NORTH;
    }
    public void faceEast() {
        direction = Direction.EAST;
    }
    public void faceSouth() {
        direction = Direction.SOUTH;
    }
    public void faceWest() {
        direction = Direction.WEST;
    }

    public void moveNorth() {
        coordinates.yAxis ++;
        if (coordinates.yAxis > 9) {
            coordinates.yAxis = 0;
        }
    }
    public void moveSouth() {
        coordinates.yAxis --;
        if (coordinates.yAxis < 0) {
            coordinates.yAxis = 9;
        }
    }
    public void moveEast() {
        coordinates.xAxis ++;
        if (coordinates.xAxis > 9) {
            coordinates.xAxis = 0;
        }
    }
    public void moveWest() {
        coordinates.xAxis --;
        if (coordinates.xAxis < 0) {
            coordinates.xAxis = 9;
        }
    }
}
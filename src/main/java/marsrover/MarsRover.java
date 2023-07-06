package marsrover;

public class MarsRover {
    final Location location = new Location();
    RotateRight rotateRight = new RotateRight();
    RotateLeft rotateLeft = new RotateLeft();
    Move move = new Move();

    public String run(String input) {
        for (int i = 0; i < input.length(); i++) {
            String turnRight = Commands.RIGHT.getValue();
            String turnLeft = Commands.LEFT.getValue();
            String moveForward = Commands.MOVE.getValue();
            String individualCommand = String.valueOf(input.charAt(i));

            if (individualCommand.equals(turnRight)) {
                rotateRight.execute(location);
            }
            if (individualCommand.equals(turnLeft)) {
                rotateLeft.execute(location);
            }
            if (individualCommand.equals(moveForward)) {
                move.execute(location);
            }
        }
        return location.coordinates.toString() + location.direction.getValue();
    }

//    command pattern
//    create an interface for execute commands
//    EXPAND create a new implementation of that interface for every instruction
//    MIGRATE replacing the old implementation with the new one (not delete yet)
//    CONTRACT delete the old implementation once the new one is implemented


}

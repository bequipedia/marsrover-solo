package marsrover;

public enum Direction {
    WEST("W"), SOUTH("S"), EAST("E"), NORTH("N");
    private String value;

    public String getValue() {
        return value;
    }

    Direction(String value) {
        this.value = value;
    }


}
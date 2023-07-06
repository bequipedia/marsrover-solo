package marsrover;

public enum Commands {
    RIGHT("R"), LEFT("L"), MOVE("M");
    private String value;

    public String getValue() {
        return value;
    }

    Commands(String value) {
        this.value = value;
    }
}
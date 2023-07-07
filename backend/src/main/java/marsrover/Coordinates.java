package marsrover;

public class Coordinates {
    public int xAxis;
    public int yAxis;

    public Coordinates() {
        this.xAxis = 0;
        this.yAxis = 0;
    }
    @Override
    public String toString() {
        return xAxis + ":" + yAxis + ":";
    }


}

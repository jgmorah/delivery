package delivery.domain;

public class Position {

    private int coordinateX;
    private int coordinateY;
    private CardinalDirection direction;

    public int getCoordinateX() {
        return coordinateX;
    }

    public void setCoordinateX(int coordinateX) {
        this.coordinateX = coordinateX;
    }

    public int getCoordinateY() {
        return coordinateY;
    }

    public void setCoordinateY(int coordinateY) {
        this.coordinateY = coordinateY;
    }

    public CardinalDirection getDirection() {
        return direction;
    }

    public void setDirection(CardinalDirection direction) {
        this.direction = direction;
    }

    public static Position defaultPosition() {
        Position position = new Position();
        position.coordinateX = 0;
        position.coordinateY = 0;
        position.direction = CardinalDirection.NORTH;

        return position;
    }
}

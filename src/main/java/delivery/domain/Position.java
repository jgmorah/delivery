package delivery.domain;

public class Position {

  private int coordinateX;
  private int coordinateY;
  private CardinalDirection direction;

  public Position(Position sourcePosition) {
    this.coordinateX = sourcePosition.getCoordinateX();
    this.coordinateY = sourcePosition.getCoordinateY();
    this.direction = sourcePosition.getDirection();
  }

  public Position() {
    this.coordinateX = 0;
    this.coordinateY = 0;
    this.direction = CardinalDirection.NORTH;


  }

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


  @Override
  public String toString() {
    return "Position{" +
            "coordinateX=" + coordinateX +
            ", coordinateY=" + coordinateY +
            ", direction=" + direction +
            '}';
  }
}

package application;

import delivery.application.MovementService;
import delivery.application.imp.MovementServiceImpl;
import delivery.domain.CardinalDirection;
import delivery.domain.Position;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class MovementServiceImplTest {

  private static final int DRONE_DISTANCE_LIMIT = 10;

  MovementService movementService = new MovementServiceImpl(DRONE_DISTANCE_LIMIT);

  @Test
  public void validateGoodInstructionTest() {
    String instruction = "AADDIAA";
    Boolean result = movementService.validateInstruction(instruction);
    assertTrue(result);
  }

  @Test
  public void validateBasInstructionTest() {
    String instruction = "AADSIAA";
    Boolean result = movementService.validateInstruction(instruction);
    assertFalse(result);
  }

  @Test
  public void IsInCoverageZoneTest() {
    Position position = new Position();
    Boolean result = movementService.IsInCoverageZone(position);
    assertTrue(result);
  }

  @Test
  public void IsOutOfCoverageZoneXTest() {
    Position position = new Position();
    position.setCoordinateX(11);
    position.setCoordinateY(0);
    position.setDirection(CardinalDirection.NORTH);
    Boolean result = movementService.IsInCoverageZone(position);
    assertFalse(result);
  }

  @Test
  public void IsOutOfCoverageZoneYTest() {
    Position position = new Position();
    position.setCoordinateX(3);
    position.setCoordinateY(-12);
    position.setDirection(CardinalDirection.SOUTH);
    Boolean result = movementService.IsInCoverageZone(position);
    assertFalse(result);
  }

  @Test
  public void AdvanceTest() {
    Position position = new Position();
    position.setCoordinateX(3);
    position.setCoordinateY(5);
    position.setDirection(CardinalDirection.SOUTH);
    Position result = movementService.advance(position);
    Position expected = new Position();
    expected.setCoordinateX(3);
    expected.setCoordinateY(4);
    expected.setDirection(CardinalDirection.SOUTH);

    assertEquals(result.getCoordinateX(), expected.getCoordinateX());
    assertEquals(result.getCoordinateY(), expected.getCoordinateY());
    assertEquals(result.getDirection(), expected.getDirection());
  }

  @Test
  public void TurnTest() {
    Position position = new Position();
    position.setCoordinateX(3);
    position.setCoordinateY(5);
    position.setDirection(CardinalDirection.SOUTH);
    Position result = movementService.turn(position, "D");
    Position expected = new Position();
    expected.setCoordinateX(3);
    expected.setCoordinateY(5);
    expected.setDirection(CardinalDirection.WEST);

    assertEquals(result.getCoordinateX(), expected.getCoordinateX());
    assertEquals(result.getCoordinateY(), expected.getCoordinateY());
    assertEquals(result.getDirection(), expected.getDirection());
  }
}

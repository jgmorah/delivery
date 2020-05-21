package delivery.application;

import delivery.domain.Drone;
import delivery.domain.Position;
import delivery.exceptions.InvalidMovementException;
import delivery.exceptions.OutOfCoverageException;

public interface MovementService {

  Boolean validateInstruction(String instruction);

  void move(Drone drone) throws InvalidMovementException, OutOfCoverageException;

  Boolean IsInCoverageZone(Position position);

  Position advance(Position position);

  Position turn(Position position, String instruction);
}

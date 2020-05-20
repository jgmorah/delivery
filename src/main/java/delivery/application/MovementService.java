package delivery.application;

import delivery.domain.Position;
import delivery.exceptions.InvalidMovementException;
import delivery.exceptions.OutOfCoverageException;

public interface MovementService {

    Boolean validateInstructions(String instructions);

    void move(Position currentPosition, String instructions) throws InvalidMovementException, OutOfCoverageException;

    Boolean IsInCoverageZone(Position position);
}

package delivery.application.imp;

import delivery.application.MovementService;
import delivery.domain.CardinalDirection;
import delivery.domain.Position;
import delivery.exceptions.InvalidMovementException;
import delivery.exceptions.OutOfCoverageException;

import java.util.Arrays;
import java.util.function.Predicate;

public class MovementServiceImpl implements MovementService {

    private static final String INVALID_INSTRUCTION_ERROR = "Instrucciones invalidads";
    private static final String OUT_OF_COVERAGE_ERROR = "Fuera de covertura";
    private static final String ADVANCE = "A";
    private static final String TURN_LEFT = "I";
    private static final String TURN_RIGHT = "D";

    private int droneDistanceLimit;

    public MovementServiceImpl(int droneDistanceLimit) {
        this.droneDistanceLimit = droneDistanceLimit;
    }

    @Override
    public Boolean validateInstructions(String instructions) {
        Predicate<String> predicate = s -> s.equals(ADVANCE) || s.equals(TURN_RIGHT) || s.equals(TURN_LEFT);
        return Arrays.stream(instructions.split(""))
                .allMatch(predicate);
    }

    @Override
    public Boolean IsInCoverageZone(Position position) {
        return position.getCoordinateX() <= droneDistanceLimit && position.getCoordinateY() <= droneDistanceLimit;
    }

    @Override
    public void move(Position currentPosition, String instructions) throws InvalidMovementException, OutOfCoverageException {
        if (!validateInstructions(instructions)) {
            throw new InvalidMovementException(INVALID_INSTRUCTION_ERROR);
        }
        Arrays.stream(instructions.split("")).forEach(
                instruction -> {
                    if (instruction.equals(ADVANCE)) {
                        advance(currentPosition);
                    } else {
                        turn(currentPosition, instruction);
                    }
                });
        if (!IsInCoverageZone(currentPosition)) {
            throw new OutOfCoverageException(OUT_OF_COVERAGE_ERROR);
        }
    }

    public Position advance(Position position) {
        switch (position.getDirection()) {
            case NORTH:
                position.setCoordinateY(position.getCoordinateY() + 1);
                break;
            case SOUTH:
                position.setCoordinateY(position.getCoordinateY() - 1);
                break;
            case EAST:
                position.setCoordinateX(position.getCoordinateX() + 1);
                break;
            case WEST:
                position.setCoordinateX(position.getCoordinateX() - 1);
                break;
        }
        return position;
    }

    public Position turn(Position position, String instruction) {
        if (instruction.equals("D")) {
            switch (position.getDirection()) {
                case NORTH:
                    position.setDirection(CardinalDirection.EAST);
                    break;
                case EAST:
                    position.setDirection(CardinalDirection.SOUTH);
                    break;
                case SOUTH:
                    position.setDirection(CardinalDirection.WEST);
                    break;
                case WEST:
                    position.setDirection(CardinalDirection.NORTH);
                    break;
            }
        }
        if (instruction.equals("I")) {
            switch (position.getDirection()) {
                case NORTH:
                    position.setDirection(CardinalDirection.WEST);
                    break;
                case WEST:
                    position.setDirection(CardinalDirection.SOUTH);
                    break;
                case SOUTH:
                    position.setDirection(CardinalDirection.EAST);
                    break;
                case EAST:
                    position.setDirection(CardinalDirection.NORTH);
                    break;
            }
        }

        return position;
    }
}

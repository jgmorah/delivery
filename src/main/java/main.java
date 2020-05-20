import delivery.application.DroneService;
import delivery.application.MovementService;
import delivery.application.imp.DroneServiceImpl;
import delivery.application.imp.MovementServiceImpl;
import delivery.domain.Drone;

import java.util.ArrayList;
import java.util.List;

public class main {

  private static final int STORAGE_SIZE_BY_DRONE = 3;
  private static final int DRONES_QUANTITY = 1;
  private static final int NUMBER_OF_BLOCKS_COVERAGE = 10;

  public static void main(String[] args) {

    DroneService droneService = new DroneServiceImpl();
    MovementService movementService = new MovementServiceImpl(NUMBER_OF_BLOCKS_COVERAGE);

    String instruction1 = "AADA";
    String instruction2 = "IADAIA";
    String instruction3 = "IAIAAA";
    ArrayList instructions = new ArrayList();
    instructions.add(instruction1);
    instructions.add(instruction2);
    instructions.add(instruction3);
    List<Drone> drones = droneService.setupDrones(DRONES_QUANTITY);

    Drone drone1 = drones.get(0);
    drone1.setInstructions(instructions);

    try {
      movementService.move(drone1);
    } catch (Exception e) {
      e.printStackTrace();
    }

    System.out.println("output");
  }
}

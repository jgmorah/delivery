import delivery.application.DroneService;
import delivery.application.MovementService;
import delivery.application.imp.DroneServiceImpl;
import delivery.application.imp.MovementServiceImpl;
import delivery.domain.Drone;

import java.util.List;

public class main {

    private static final int STORAGE_SIZE_BY_DRONE = 3;
    private static final int DRONES_QUANTITY = 1;
    private static final int NUMBER_OF_BLOCKS_COVERAGE = 10;

    public static void main(String[] args) throws Exception {

        DroneService droneService = new DroneServiceImpl();
        MovementService movementService = new MovementServiceImpl(NUMBER_OF_BLOCKS_COVERAGE);

        List<Drone> drones = droneService.setupDrones(DRONES_QUANTITY);

        String instructions = "AADA";
        Drone drone1 = drones.get(0);
        movementService.move(drone1.getCurrentPosition(), instructions);
        System.out.println("output");
    }
}
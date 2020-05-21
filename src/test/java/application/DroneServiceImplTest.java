package application;

import delivery.adapters.FileProcessor;
import delivery.application.DroneService;
import delivery.application.imp.DroneServiceImpl;
import delivery.domain.Drone;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class DroneServiceImplTest {

  private static final int DRONE_QUANTITY = 2;
  private static final int DRONE_CAPACITY = 3;
  FileProcessor fileProcessor = FileProcessor.getInstance();

  DroneService droneService = new DroneServiceImpl(fileProcessor, DRONE_CAPACITY);

  @Test
  public void validateDronesSetup() {
    String firstDroneId = "01";

    List<Drone> drones = droneService.setupDrones(DRONE_QUANTITY);
    Drone drone = drones.get(0);
    assertEquals(DRONE_QUANTITY, drones.size());
    assertEquals(drone.getId(), firstDroneId);
  }
}

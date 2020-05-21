package delivery.application.imp;

import delivery.adapters.FileProcessor;
import delivery.application.DroneService;
import delivery.domain.Drone;
import delivery.domain.Position;

import java.util.ArrayList;
import java.util.List;

public class DroneServiceImpl implements DroneService {
  private final FileProcessor fileProcessor;
  private final int storageSize;

  public DroneServiceImpl(FileProcessor fileProcessor, int storageSize) {
    this.fileProcessor = fileProcessor;
    this.storageSize = storageSize;
  }

  @Override
  public List<Drone> setupDrones(int dronesQuantity) {
    ArrayList<Drone> drones = new ArrayList<>();
    for (int id = 1; id <= dronesQuantity; id++) {
      Position defaultPosition = new Position();
      String droneId = String.format("%02d", id);
      drones.add(new Drone(droneId, defaultPosition, getDroneInstructions(droneId)));
    }

    return drones;
  }

  @Override
  public ArrayList<String> getDroneInstructions(String droneId) {
    ArrayList<String> instructionsFromFile = fileProcessor.readFile(droneId);

    return new ArrayList<>(instructionsFromFile.subList(0, storageSize));
  }
}

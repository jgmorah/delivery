package delivery.application.imp;

import delivery.application.DroneService;
import delivery.domain.Drone;
import delivery.domain.Position;

import java.util.ArrayList;
import java.util.List;

public class DroneServiceImpl implements DroneService {

  public DroneServiceImpl() {}

  @Override
  public List<Drone> setupDrones(int dronesQuantity) {
    ArrayList<Drone> drones = new ArrayList<Drone>();
    Position defaultPosition = Position.defaultPosition();
    for (int id = 1; id <= dronesQuantity; id++) {
      String droneId = String.valueOf(id);
      drones.add(new Drone(droneId, defaultPosition));
    }
    return drones;
  }
}

package delivery.application;

import delivery.domain.Drone;

import java.util.List;

public interface DroneService {

  public List<Drone> setupDrones(int dronesQuantity);
}

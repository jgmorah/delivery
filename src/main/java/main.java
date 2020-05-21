import delivery.adapters.FileProcessor;
import delivery.application.DroneService;
import delivery.application.MovementService;
import delivery.application.ReportService;
import delivery.application.imp.DroneServiceImpl;
import delivery.application.imp.MovementServiceImpl;
import delivery.application.imp.ReportServiceImpl;
import delivery.domain.Drone;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class main {

  private static final int STORAGE_SIZE_BY_DRONE = 3;
  private static final int DRONES_QUANTITY = 5;
  private static final int NUMBER_OF_BLOCKS_COVERAGE = 10;

  public static void main(String[] args) {
    FileProcessor fileProcessor = FileProcessor.getInstance();
    DroneService droneService = new DroneServiceImpl(fileProcessor, STORAGE_SIZE_BY_DRONE);
    MovementService movementService = new MovementServiceImpl(NUMBER_OF_BLOCKS_COVERAGE);
    ReportService reportService = new ReportServiceImpl(fileProcessor);

    List<Drone> drones = droneService.setupDrones(DRONES_QUANTITY);

    ExecutorService exService = Executors.newFixedThreadPool(DRONES_QUANTITY);
    for (Drone drone : drones) {
      exService.execute(
          () -> {
            try {
              movementService.move(drone);
              reportService.generateReport(drone);

            } catch (Exception e) {
              e.printStackTrace();
            }
          });
    }
    exService.shutdownNow();

    System.out.println("PROCESS COMPLETED");
  }
}

package delivery.application.imp;

import delivery.adapters.FileProcessor;
import delivery.application.ReportService;
import delivery.domain.Drone;
import delivery.domain.Position;

import java.util.ArrayList;

public class ReportServiceImpl implements ReportService {
  private static final String HEADER = "== Reporte de entregas ==";
  private FileProcessor fileProcessor;

  public ReportServiceImpl(FileProcessor fileProcessor) {
    this.fileProcessor = fileProcessor;
  }

  @Override
  public void generateReport(Drone drone) {
    ArrayList<String> report = new ArrayList<>();
    report.add(HEADER);
    for (Position position : drone.getRouteTraveled()) {
      report.add(
          "("
              + position.getCoordinateX()
              + ","
              + position.getCoordinateY()
              + ") "
              + position.getDirection());
    }

    fileProcessor.writeFile(drone.getId(), report);
  }
}

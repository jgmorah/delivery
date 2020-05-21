package delivery.adapters;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FileProcessor {

  private static final String PREFIX_INCOME_FILE_NAME = "init";
  private static final String PREFIX_OUTPUT_FILE_NAME = "out";
  private static final String EXTENSION = ".txt";
  private static final String INPUT_PATH = "src/main/resources/input/";
  private static final String OUTPUT_PATH = "src/main/resources/output/";

  private Logger logger = Logger.getLogger(FileProcessor.class.getName());

  private static FileProcessor instance;

  private FileProcessor() {}

  public static synchronized FileProcessor getInstance() {
    if (instance == null) {
      instance = new FileProcessor();
    }
    return instance;
  }

  public ArrayList<String> readFile(String name) {
    ArrayList<String> content = new ArrayList<>();

    File file = new File(INPUT_PATH + PREFIX_INCOME_FILE_NAME + name + EXTENSION);

    try (Scanner scanner = new Scanner(file)) {

      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        content.add(line);
      }
    } catch (IOException e) {
      logger.log(Level.WARNING, "ERROR READING FILE");
      e.printStackTrace();
    }

    return content;
  }

  public void writeFile(String fileName, ArrayList<String> lines) {

    FileWriter writer;
    try {
      File file = new File(OUTPUT_PATH);
      writer =
          new FileWriter(
              file.getAbsolutePath() + "/" + PREFIX_OUTPUT_FILE_NAME + fileName + EXTENSION);
      for (String line : lines) {
        writer.write(line + "\n");
      }

      writer.close();
    } catch (IOException e) {
      logger.log(Level.WARNING, "ERROR WRITING FILE");
      e.printStackTrace();
    }
  }
}

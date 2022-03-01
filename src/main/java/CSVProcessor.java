import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * CSVProcessor class represents the object to process the .csv file
 */
public class CSVProcessor {

  private static String fileName;
  private static Path myPath;

  /**
   * @param fileName .cvs file name
   */
  public CSVProcessor(String fileName) {
    this.fileName = fileName;
    this.myPath = Paths.get(fileName);
  }

  /**
   * @return a List of PersonInfo of certain .csv file
   * @throws IOException when i/o happens
   */
  public List<PersonInfo> openCSVToBean() throws IOException {

//    BufferedReader br = Files.newBufferedReader(getMyPath(), StandardCharsets.UTF_8);
//    HeaderColumnNameMappingStrategy<PersonInfo> strategy = new HeaderColumnNameMappingStrategy<>();
//    strategy.setType(PersonInfo.class);
//
//    CsvToBean ctb = new CsvToBeanBuilder(br)
//        .withType(PersonInfo.class)
//        .withMappingStrategy(strategy)
//        .withIgnoreLeadingWhiteSpace(true)
//        .build();
//
//    List<PersonInfo> personInfos = ctb.parse();
    List<PersonInfo> personInfos = ProcessorHelper.openCSV();

    return personInfos;
  }

  /**
   *
   * @return file name
   */
  public static String getFileName() {
    return fileName;
  }

  /**
   *
   * @param fileName set file name
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }

  /**
   *
   * @return myPath
   */
  public static Path getMyPath() {
    return myPath;
  }

  /**
   *
   * @param myPath set myPath
   */
  public void setMyPath(Path myPath) {
    this.myPath = myPath;
  }

}

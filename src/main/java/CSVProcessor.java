import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * CSVProcessor class represents the object to process the .csv file
 */
public class CSVProcessor {

  private static String file;
  private static Path path;

  /**
   * @param file .cvs file name
   */
  public CSVProcessor(String file) {
    this.file = file;
    this.path = Paths.get(file);
  }

  /**
   * @return a List of PersonInfo of certain .csv file
   * @throws IOException when i/o happens
   */
  public List<MemberInfo> openCSVToBean() throws IOException {

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

    List<MemberInfo> memberInfos = ProcessorHelper.openCSV();

    return memberInfos;
  }

  /**
   *
   * @return file name
   */
  public static String getFile() {
    return file;
  }

  /**
   *
   * @param file set file name
   */
  public void setFile(String file) {
    this.file = file;
  }

  /**
   *
   * @return path
   */
  public static Path getPath() {
    return path;
  }

  /**
   *
   * @param path set path
   */
  public void setPath(Path path) {
    this.path = path;
  }

}

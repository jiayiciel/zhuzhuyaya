import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * CSVReader class reads insurance-company-members.csv
 */
public class CSVReader {

  private static String file;
  private static Path path;

  /**
   * @param file- filename
   */
  public CSVReader(String file) {
    this.file = file;
    this.path = Paths.get(file);
  }

  /**
   * @return a List of memberInfo of insurance-company-members.csv
   * @throws IOException when i/o happens
   */
  public List<MemberInfo> openCSVToBean() throws IOException {
    List<MemberInfo> memberInfos = ProcessorHelper.openCSV();
    return memberInfos;
  }

  /**
   *
   * @return filename
   */
  public static String getFile() {
    return file;
  }

  /**
   *
   * @param file set filename
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

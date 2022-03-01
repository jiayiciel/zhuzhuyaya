import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CSVProcessorTest {

  private CSVProcessor cptest;
  private TemplateFiller tftest;
  private Integer listSize;

  @Test
  void openCSVToBean() throws IOException {
    cptest = new CSVProcessor("docs\\insurance-company-members.csv");
    listSize = 500;
    Assertions.assertEquals(listSize, cptest.openCSVToBean().size());
  }

  @Test
  void getFileName() {
    cptest = new CSVProcessor("docs\\insurance-company-members.csv");
    Assertions.assertEquals("docs\\insurance-company-members.csv", cptest.getFileName());
  }

  @Test
  void setFileName() {
    cptest = new CSVProcessor("docs\\insurance-company-members.csv");
    cptest.setFileName(null);
    Assertions.assertEquals(null, cptest.getFileName());
  }

  @Test
  void getMyPath() {
    cptest = new CSVProcessor("docs\\insurance-company-members.csv");
    Path expectedPath = Paths.get("docs\\insurance-company-members.csv");
    Assertions.assertEquals(expectedPath, cptest.getMyPath());
  }

  @Test
  void setMyPath() {
    cptest = new CSVProcessor("docs\\insurance-company-members.csv");
    Path expectedPath = null;
    cptest.setMyPath(null);
    Assertions.assertEquals(expectedPath, cptest.getMyPath());
  }
}
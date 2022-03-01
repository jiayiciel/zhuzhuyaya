import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TemplateFillerTest {

  private CSVProcessor cptest;
  private TemplateFiller tftest;


  @BeforeEach
  void setUp() throws IOException {
    cptest = new CSVProcessor("docs\\insurance-company-members.csv");
    tftest = new TemplateFiller(cptest.openCSVToBean(), "docs/letter-template.txt");
  }


//  @Test
//  void fillAll() throws IOException {
//    tftest.fillAll();
//  }

  @Test
  void testFillAll() throws IOException {
    int fileCount = 0;
    File d = new File("letters");
    File list[] = d.listFiles();
    for (int i = 0; i < list.length; i++){
      if (list[i].isFile()) fileCount++;
    }
    tftest.fillAll(null);
    tftest.fillAll("letters\\");
    Assertions.assertEquals(500,fileCount);
  }

}
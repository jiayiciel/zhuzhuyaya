import static org.junit.jupiter.api.Assertions.*;

import java.io.File;
import java.io.IOException;
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CLIRunnerTest {

  CLIRunner runTester;

  @BeforeEach
  void setUp() throws IOException {
    runTester = new CLIRunner();
  }

  @Test
  void mainTest1() throws ParseException, IOException {
    String[] args = new String[]{"--letter"};
    runTester.main(args);
  }

  @Test
  void mainTest2() throws ParseException, IOException {
    String[] args = new String[]{"--email"};
    runTester.main(args);
  }

  @Test
  void mainTest3() throws ParseException, IOException {
    String[] args = new String[]{"--letter","--letter-template","docs/letter-template.txt"};
    runTester.main(args);
  }

  @Test
  void mainTest4() throws ParseException, IOException {
    String[] args = new String[]{"--letter","--letter-template","docs/letter-template.txt"};
    runTester.main(args);
  }

  @Test
  void mainTest5() throws ParseException, IOException {
    String[] args = new String[]{"--letter","--letter-template","docs/letter-template.txt"};
    runTester.main(args);
  }

  @Test
  void mainTest6() throws ParseException, IOException {
    String[] args = new String[]{"--letter","--letter-template","docs/letter-template.txt", "--output-dir", "letters\\"};
    runTester.main(args);
    int fileCount = 0;
    File d = new File("letters");
    File list[] = d.listFiles();
    for (int i = 0; i < list.length; i++){
      if (list[i].isFile()) fileCount++;
    }
    Assertions.assertEquals(500,fileCount);
  }

  @Test
  void mainTest7() throws ParseException, IOException {
    String[] args = new String[]{"--email","--email-template","docs/email-template.txt", "--output-dir", "emails\\"};
    runTester.main(args);
    int fileCount = 0;
    File d = new File("emails");
    File list[] = d.listFiles();
    for (int i = 0; i < list.length; i++){
      if (list[i].isFile()) fileCount++;
    }
    Assertions.assertEquals(500,fileCount);
  }
}
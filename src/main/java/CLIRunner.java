import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * this CLIRunner contains main() method which is the entry of the CLI application.
 * you can use "Edit Configuration" to make the input of CLI arguments
 */
public class CLIRunner {

  private static final String DEFAULT_CSV_PATH = "docs/insurance-company-members.csv";
  private static final String DEFAULT_LETTER_TEMP = "docs/letter-template.txt";
  private static final String DEFAULT_EMAIL_TEMP = "docs/email-template.txt";

  private static CSVProcessor defaultCSVProcessor;
  private static TemplateFiller defaultEmailTF;
  private static TemplateFiller defaultLetterTF;

  /**
   *
   * @throws IOException constructor of CLIRunner
   */
  public CLIRunner() throws IOException {
  }


  /**
   *
   * @param args a String[]
   * @throws ParseException when parse exception happens
   * @throws IOException when i/o exception happens
   */
  public static void main(String[] args) throws ParseException, IOException {


    defaultCSVProcessor = new CSVProcessor(DEFAULT_CSV_PATH);
    defaultEmailTF = new TemplateFiller(defaultCSVProcessor.openCSVToBean(), DEFAULT_EMAIL_TEMP);
    defaultLetterTF = new TemplateFiller(defaultCSVProcessor.openCSVToBean(), DEFAULT_LETTER_TEMP);

    Options options = new Options();
    options = RunnerHelper.addOption(options);

    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = parser.parse(options, args);

    HelpFormatter formatter = new HelpFormatter();

    formatter.printHelp("txt_filler", options, true);

    RunnerHelper.cmdHelper(defaultCSVProcessor, defaultEmailTF, defaultEmailTF, cmd, options, formatter);

  }

}

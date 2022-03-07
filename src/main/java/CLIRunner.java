import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * this CLIRunner contains main() method which is the entry of the CLI application.
 * you can use "Edit Configuration" to make the input of CLI arguments
 */
public class CLIRunner {

  private static final String MEMBER_CSV_PATH = "docs/insurance-company-members.csv";
  private static final String LETTER_TEMPLATE_TXT = "docs/letter-template.txt";
  private static final String EMAIL_TEMPLATE_TXT = "docs/email-template.txt";

  private static CSVProcessor csvProcessor;
  private static TemplateFiller EmailTF;
  private static TemplateFiller LetterTF;

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


    csvProcessor = new CSVProcessor(MEMBER_CSV_PATH);
    EmailTF = new TemplateFiller(csvProcessor.openCSVToBean(), EMAIL_TEMPLATE_TXT);
    LetterTF = new TemplateFiller(csvProcessor.openCSVToBean(), LETTER_TEMPLATE_TXT);

    Options options = new Options();
    options = RunnerHelper.addOption(options);

    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = parser.parse(options, args);

    HelpFormatter formatter = new HelpFormatter();

    formatter.printHelp("txt_filler", options, true);

    RunnerHelper.cmdHelper(csvProcessor, EmailTF, EmailTF, cmd, options, formatter);

  }

}

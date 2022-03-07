import java.io.IOException;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * this CLIRunner contains main() method to run the application
 */
public class CLIRunner {

  private static final String MEMBER_CSV_PATH = "docs/insurance-company-members.csv";
  private static final String LETTER_TEMPLATE_TXT = "docs/letter-template.txt";
  private static final String EMAIL_TEMPLATE_TXT = "docs/email-template.txt";

  private static CSVReader csvProcessor;
  private static TemplatePopulator EmailTF;
  private static TemplatePopulator LetterTF;


  /**
   *
   * @param args default String[]
   * @throws ParseException throws parse exception
   * @throws IOException throws i/o exception
   */
  public static void main(String[] args) throws ParseException, IOException {


    csvProcessor = new CSVReader(MEMBER_CSV_PATH);
    EmailTF = new TemplatePopulator(csvProcessor.openCSVToBean(), EMAIL_TEMPLATE_TXT);
    LetterTF = new TemplatePopulator(csvProcessor.openCSVToBean(), LETTER_TEMPLATE_TXT);

    Options options = new Options();
    options = RunnerHelper.addOption(options);

    CommandLineParser parser = new DefaultParser();
    CommandLine cmd = parser.parse(options, args);


    RunnerHelper.cmdHelper(csvProcessor, EmailTF, EmailTF, cmd, options);

  }

}

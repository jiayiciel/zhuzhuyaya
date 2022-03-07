import java.io.IOException;
import java.nio.file.Paths;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;


/**
 * Helper class for CLIRunner
 */
public class RunnerHelper {


    private static String CSVPath;
    private static String outPath;


    private static final String LETTER_TEMPLATE_TXT = "docs/letter-template.txt";
    private static final String EMAIL_TEMPLATE_TXT = "docs/email-template.txt";
    private static final String MEMBER_CSV_PATH = "docs/insurance-company-members.csv";


    /**
     * @param options options help create the CLI
     * @return options
     */
    public static Options addOption(Options options){
        options.addOption("e", "email", false, "only generate email messages");
        options.addOption("l", "letter", false, "only generate letters");
        options.addOption(Option.builder("et").longOpt("email-template")
                .desc("accept a filename that holds the email template, required if --email is used")
                .argName("file")
                .hasArg()
                .build());
        options.addOption(Option.builder("lt").longOpt("letter-template")
                .desc("accept a filename that holds the letter template, required if --letter is used")
                .argName("file")
                .hasArg()
                .build());
        options.addOption(Option.builder("od").longOpt("output-dir")
                .desc("accept the name of a folder, all output is placed in this folder")
                .argName("path")
                .hasArg()
                .build());
        options.addOption(Option.builder("cf").longOpt("csv-file")
                .desc("accept a filename that holds the email template")
                .argName("path")
                .hasArg()
                .build());
        return options;
    }


    /**
     * @param csvReader csvReader
     * @param emailTemplate email template populator
     * @param letterTemplate letter template populator
     * @param cmd command line
     * @param options options
     * @throws IOException when format is bad
     */
    public static void cmdHelper(CSVReader csvReader, TemplatePopulator emailTemplate, TemplatePopulator letterTemplate, CommandLine cmd, Options options ) throws IOException {

        emailTemplate = new TemplatePopulator(csvReader.openCSVToBean(), EMAIL_TEMPLATE_TXT);
        letterTemplate = new TemplatePopulator(csvReader.openCSVToBean(), LETTER_TEMPLATE_TXT);

        if (!cmd.hasOption("output-dir")){
            System.out.println("Error: no output directory provided");
        }
        else{
            outPath = cmd.getOptionValue("output-dir");
        }

        if (cmd.hasOption("csv-file")){


            CSVPath = cmd.getOptionValue("csv-file");
            csvReader = new CSVReader(CSVPath);


        }


        if (cmd.hasOption("email") ){
            if(cmd.hasOption("email-template")){
                emailTemplate.setPath(Paths.get(cmd.getOptionValue("email-template")));
                emailTemplate.populateAll(outPath);

            }
            else {
                System.out.println("Error: --email provided but no --email-template was provided");
            }

        }


        else if (cmd.hasOption("letter")){
            if(cmd.hasOption("letter-template")){
                letterTemplate.setPath(Paths.get(cmd.getOptionValue("letter-template")));
                letterTemplate.populateAll(outPath);

            } else{
                System.out.println("Error: --letter provided but no --letter-template was provided");
            }

        }

    }



}

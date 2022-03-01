import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;



public class RunnerHelper {


    private static String CSVPath;
    private static String outPath;


    private static final String DEFAULT_LETTER_TEMP = "docs/letter-template.txt";
    private static final String DEFAULT_EMAIL_TEMP = "docs/email-template.txt";
    private static final String DEFAULT_CVS_PATH = "docs/insurance-company-members.csv";


    public RunnerHelper() throws IOException {
    }


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
        options.addOption(Option.builder("h").longOpt("help")
                .desc("print help information")
                .build());
        return options;
    }


    public static void cmdHelper(CSVProcessor defaultCSVProcessor, TemplateFiller defaultEmailTF, TemplateFiller defaultLetterTF,CommandLine cmd, Options options,HelpFormatter formatter ) throws IOException {
        if (cmd.hasOption("output-dir")){
            outPath = cmd.getOptionValue("output-dir");
        }

        if (cmd.hasOption("csv-file")){
            CSVPath = cmd.getOptionValue("csv-file");

            defaultCSVProcessor = new CSVProcessor(CSVPath);
            defaultEmailTF = new TemplateFiller(defaultCSVProcessor.openCSVToBean(), DEFAULT_EMAIL_TEMP);
            defaultLetterTF = new TemplateFiller(defaultCSVProcessor.openCSVToBean(), DEFAULT_LETTER_TEMP);
        }

        if (cmd.hasOption("email") && cmd.hasOption("email-template")){
            defaultEmailTF.setMyPath(Paths.get(cmd.getOptionValue("email-template")));
//            defaultEmailTF.fillAll();
            defaultEmailTF.fillAll(outPath);
        }

        else if (cmd.hasOption("letter") && cmd.hasOption("letter-template")){
            defaultLetterTF.setMyPath(Paths.get(cmd.getOptionValue("letter-template")));
//            defaultLetterTF.fillAll();
            defaultLetterTF.fillAll(outPath);
        }

        if (cmd.hasOption("letter") && !cmd.hasOption("letter-template")){
            System.out.println("Error: --letter provided but no --letter-template was given");
            formatter.printHelp("please make sure you make right input" ,options);
        }

        if (cmd.hasOption("email") && !cmd.hasOption("email-template")){
            System.out.println("Error: --email provided but no --email-template was given");
            formatter.printHelp("please make sure you make right input" ,options);
        }

    }



}

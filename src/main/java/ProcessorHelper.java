import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class ProcessorHelper {

    private String fileName;
    private Path myPath;

    public ProcessorHelper(String fileName) {
        this.fileName = fileName;
        this.myPath = Paths.get(fileName);
    }


    public ProcessorHelper() throws IOException {
    }


    public static List<PersonInfo> openCSV() throws IOException {

        BufferedReader br = Files.newBufferedReader(CSVProcessor.getMyPath(), StandardCharsets.UTF_8);
        HeaderColumnNameMappingStrategy<PersonInfo> strategy = new HeaderColumnNameMappingStrategy<>();
        strategy.setType(PersonInfo.class);

        CsvToBean ctb = new CsvToBeanBuilder(br)
                .withType(PersonInfo.class)
                .withMappingStrategy(strategy)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        List<PersonInfo> personInfos = ctb.parse();
        return personInfos;
    }



}

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

    private String file;
    private Path path;

    public ProcessorHelper(String file) {
        this.file = file;
        this.path = Paths.get(file);
    }


    public ProcessorHelper() throws IOException {
    }


    public static List<MemberInfo> openCSV() throws IOException {

        BufferedReader br = Files.newBufferedReader(CSVProcessor.getPath(), StandardCharsets.UTF_8);
        HeaderColumnNameMappingStrategy<MemberInfo> mappingStrategy = new HeaderColumnNameMappingStrategy<>();
        mappingStrategy.setType(MemberInfo.class);
        CsvToBean bean = BeanBuilder(br, mappingStrategy);
        List<MemberInfo> memberInfos = bean.parse();
        return memberInfos;
    }

    public static CsvToBean BeanBuilder(BufferedReader br, HeaderColumnNameMappingStrategy<MemberInfo> mappingStrategy){

        CsvToBean bean = new CsvToBeanBuilder(br)
                .withType(MemberInfo.class)
                .withMappingStrategy(mappingStrategy)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        return bean;

    }



}

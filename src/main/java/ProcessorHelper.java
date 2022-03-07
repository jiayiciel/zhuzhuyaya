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
import java.util.Objects;

/**
 * CSV reader helper
 */
public class ProcessorHelper {

    private String file;
    private Path path;

    /**
     * @param file the file name and path
     */
    public ProcessorHelper(String file) {
        this.file = file;
        this.path = Paths.get(file);
    }


    /**
     * @return parsed memberInfo class
     * @throws IOException when the csv format is bad
     */
    public static List<MemberInfo> openCSV() throws IOException {

        BufferedReader br = Files.newBufferedReader(CSVReader.getPath(), StandardCharsets.UTF_8);
        HeaderColumnNameMappingStrategy<MemberInfo> mappingStrategy = new HeaderColumnNameMappingStrategy<>();
        mappingStrategy.setType(MemberInfo.class);
        CsvToBean bean = BeanBuilder(br, mappingStrategy);
        List<MemberInfo> memberInfos = bean.parse();
        return memberInfos;
    }

    /**
     * @param br bufferreader
     * @param mappingStrategy mapping strategy
     * @return bean from csv
     */
    public static CsvToBean BeanBuilder(BufferedReader br, HeaderColumnNameMappingStrategy<MemberInfo> mappingStrategy){

        CsvToBean bean = new CsvToBeanBuilder(br)
                .withType(MemberInfo.class)
                .withMappingStrategy(mappingStrategy)
                .withIgnoreLeadingWhiteSpace(true)
                .build();

        return bean;

    }

    /**
     * @return processorhelper to string
     */
    @Override
    public String toString() {
        return "ProcessorHelper{" +
                "file='" + file + '\'' +
                ", path=" + path +
                '}';
    }

    /**
     * @param o - processorhelper object
     * @return if two objects are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProcessorHelper)) return false;
        ProcessorHelper that = (ProcessorHelper) o;
        return Objects.equals(file, that.file) && Objects.equals(path, that.path);
    }

    /**
     * @return processorhelper's hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(file, path);
    }
}

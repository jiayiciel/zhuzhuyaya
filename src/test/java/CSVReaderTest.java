import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class CSVReaderTest {

    private CSVReader csvReader;

    @BeforeEach
    void setUp() throws IOException {
        csvReader = new CSVReader("docs/insurance-company-members.csv");
    }

    @Test
    void openCSVToBean() throws IOException {
        Assertions.assertEquals(500, csvReader.openCSVToBean().size());
    }

    @Test
    void getFile() {
        Assertions.assertEquals(csvReader.getFile(), "docs/insurance-company-members.csv");
    }

    @Test
    void setFile() {
        csvReader.setFile("docs");
        Assertions.assertEquals(csvReader.getFile(), "docs");
    }

    @Test
    void getPath() {
        Assertions.assertEquals(csvReader.getPath(), Paths.get("docs/insurance-company-members.csv"));
    }

    @Test
    void setPath() {
        Path path = Paths.get("docs");
        csvReader.setPath(path);
        Assertions.assertEquals(csvReader.getPath(), Paths.get("docs"));
    }
}
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.HeaderColumnNameMappingStrategy;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProcessorHelperTest {

    ProcessorHelper processorHelper;


    ProcessorHelperTest() throws IOException {

    }

    @BeforeEach
    void setUp() {
        processorHelper = new ProcessorHelper("docs/insurance-company-members.csv");
    }

    @Test
    void openCSV() throws IOException {
        Assertions.assertEquals(processorHelper.openCSV(), processorHelper.openCSV());
    }

    @Test
    void beanBuilder() {
    }

    @Test
    void testToString() {
        Assertions.assertEquals(processorHelper.toString(), processorHelper.toString());
        ProcessorHelper processorHelper2 = new ProcessorHelper("/insurance-company-members.csv");
        Assertions.assertFalse(processorHelper.equals(null));
        Assertions.assertFalse(processorHelper.equals(""));
        Assertions.assertFalse(processorHelper.equals(processorHelper2));
    }

    @Test
    void testEquals() {
        Assertions.assertEquals(processorHelper, (processorHelper));
        Assertions.assertFalse(processorHelper.equals(null));
        Assertions.assertFalse(processorHelper.equals(""));
    }

    @Test
    void testHashCode() {
        Assertions.assertTrue(processorHelper.hashCode()==(processorHelper.hashCode()));
    }
}
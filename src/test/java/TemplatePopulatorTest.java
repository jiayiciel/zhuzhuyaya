import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class TemplatePopulatorTest {

    private TemplatePopulator templatePopulator;
    private CSVReader csvReader;

    @BeforeEach
    void setUp() throws IOException {
        csvReader = new CSVReader("docs/insurance-company-members.csv");
        templatePopulator = new TemplatePopulator(csvReader.openCSVToBean(), "docs/email-template.txt");
    }

    @Test
    void populateTemplate() throws IOException {
        templatePopulator = new TemplatePopulator(csvReader.openCSVToBean(), "docs/email-template.txt");
    }

    @Test
    void populateAll() throws IOException {
        templatePopulator = new TemplatePopulator(csvReader.openCSVToBean(), "docs/email-template.txt");
        templatePopulator.populateAll("emails/");
        templatePopulator.populateAll(null);

    }

    @Test
    void setPath() {
        Path path = Paths.get("docs");
        templatePopulator.setPath(path);
        csvReader.setPath(path);
        Assertions.assertEquals(csvReader.getPath(), Paths.get("docs"));
    }

    @Test
    void testToString() {
        Assertions.assertEquals(templatePopulator.toString(), templatePopulator.toString());
        Assertions.assertFalse(templatePopulator.equals(null));
        Assertions.assertFalse(templatePopulator.equals(""));
    }

    @Test
    void testEquals() throws IOException {
        Assertions.assertEquals(templatePopulator, templatePopulator);
        Assertions.assertFalse(templatePopulator.equals(null));
        TemplatePopulator templatePopulator2 = new TemplatePopulator(csvReader.openCSVToBean(), "email-template.txt");
        Assertions.assertFalse(templatePopulator.equals(""));
        Assertions.assertFalse(templatePopulator.equals(templatePopulator2));
    }

    @Test
    void testHashCode() {
        Assertions.assertEquals(templatePopulator.hashCode(), templatePopulator.hashCode());
    }
}
import org.apache.commons.cli.ParseException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class CLIRunnerTest {

    private CLIRunner cliRunner;


    @BeforeEach
    void setUp() throws IOException {
        cliRunner = new CLIRunner();
    }

    @Test
    void main() throws ParseException, IOException {
        String[] args = new String[]{"--letter"};
        cliRunner.main(args);
    }

    @Test
    void main2() throws ParseException, IOException {
        String[] args = new String[]{"--email"};
        cliRunner.main(args);
    }

    @Test
    void main3() throws ParseException, IOException {
        String[] args = new String[]{"--letter","--letter-template","docs/letter-template.txt"};
        cliRunner.main(args);
    }

    @Test
    void main4() throws ParseException, IOException {
        String[] args = new String[]{"--email","--email-template","docs/email-template.txt"};
        cliRunner.main(args);
    }

    @Test
    void main5() throws ParseException, IOException {
        String[] args = new String[]{"--letter","--letter-template","docs/letter-template.txt", "--output-dir", "letters/"};
        cliRunner.main(args);
    }

    @Test
    void main6() throws ParseException, IOException {
        String[] args = new String[]{"--letter","--letter-template","docs/letter-template.txt", "--output-dir", "letters/", "--csv-file", "docs/insurance-company-members.csv"};
        cliRunner.main(args);
    }
}
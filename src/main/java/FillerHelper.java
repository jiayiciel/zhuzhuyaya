import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class FillerHelper {


    private List<PersonInfo> personInfosGetter;
    private String templateFileName;
    private Path myPath;

    public FillerHelper(List<PersonInfo> personInfosGetter, String templateFileName) {
        this.personInfosGetter = personInfosGetter;
        this.templateFileName = templateFileName;
        this.myPath = Paths.get(templateFileName);
    }


    /**
     *
     * @return personInfoGetter
     */
    public List<PersonInfo> getPersonInfosGetter() {
        return personInfosGetter;
    }

    /**
     *
     * @return template file name
     */
    public String getFileName() {
        return templateFileName;
    }

    /**
     *
     * @param personInfosGetter set personInfoGetter
     */
    public void setPersonInfosGetter(List<PersonInfo> personInfosGetter) {
        this.personInfosGetter = personInfosGetter;
    }

    /**
     *
     * @param templateFileName set template file name
     */
    public void setTemplateFileName(String templateFileName) {
        this.templateFileName = templateFileName;
    }



}

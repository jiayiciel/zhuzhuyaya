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


/**
 * this class uses List of PersonInfo and to fill a template
 */
public class TemplateFiller {

  private List<PersonInfo> personInfosGetter;
  private String templateFileName;
  private Path myPath;


  private static String REGEX_FIR_NAME = "\\[\\[first_name]]";
  private static String REGEX_LAST_NAME = "\\[\\[last_name]]";
  private static String REGEX_COMP_NAME = "\\[\\[company_name]]";
  private static String REGEX_ADD = "\\[\\[address]]";
  private static String REGEX_CITY = "\\[\\[city]]";
  private static String REGEX_COUNTY = "\\[\\[county]]";
  private static String REGEX_STATE = "\\[\\[state]]";
  private static String REGEX_ZIP = "\\[\\[zip]]";
  private static String REGEX_PHONE1 = "\\[\\[phone1]]";
  private static String REGEX_PHONE2 = "\\[\\[phone2]]";
  private static String REGEX_EMAIL = "\\[\\[email]]";
  private static String REGEX_WEB = "\\[\\[web]]";

  /**
   * constructor
   * @param personInfosGetter handle List of PersonInfo
   * @param templateFileName template file name
   */
  public TemplateFiller(List<PersonInfo> personInfosGetter, String templateFileName) {
    this.personInfosGetter = personInfosGetter;
    this.templateFileName = templateFileName;
    this.myPath = Paths.get(templateFileName);
  }

  /**
   *
   * @param information one element in List of PersonInfo
   * @return template filling result as a String data
   * @throws IOException when i/o exception happens
   */
  public String fillTemplate(PersonInfo information) throws IOException {

    String data = Files.readString(this.myPath);

    data = data.replaceAll(REGEX_FIR_NAME, information.getFirst_name());
    data = data.replaceAll(REGEX_LAST_NAME, information.getLast_name());
    data = data.replaceAll(REGEX_COMP_NAME, information.getCompany_name());
    data = data.replaceAll(REGEX_ADD, information.getAddress());
    data = data.replaceAll(REGEX_CITY, information.getCity());
    data = data.replaceAll(REGEX_COUNTY, information.getCounty());
    data = data.replaceAll(REGEX_STATE, information.getState());
    data = data.replaceAll(REGEX_ZIP, information.getZip());
    data = data.replaceAll(REGEX_PHONE1, information.getPhone1());
    data = data.replaceAll(REGEX_PHONE2, information.getPhone2());
    data = data.replaceAll(REGEX_EMAIL, information.getEmail());
    data = data.replaceAll(REGEX_WEB, information.getWeb());

    return data;

  }

//  /**
//   * print all template filling result in console, when fillALl()method does not have input
//   * @throws IOException when i/o exception happens
//   */
//  public void fillAll() throws IOException {
//    for (int i = 0; i < this.personInfosGetter.size(); i++){
//      System.out.println(fillTemplate(this.personInfosGetter.get(i)));
//    }
//  }
  /**
   * print all template filling result in a file, when fillALl()method has the input of the file name
   * @throws IOException when i/o exception happens
   * @param outFilePath the file that the method will print all template filling result in
   */
  public void fillAll(String outFilePath) throws IOException {

    if (outFilePath == null){
      for (int i = 0; i < this.personInfosGetter.size(); i++){
        System.out.println(fillTemplate(this.personInfosGetter.get(i)));
      }
    }
    else {
      FileWriter writer;
      for (int i = 0; i < this.personInfosGetter.size(); i++){

        try {
          writer = new FileWriter(outFilePath
                  + personInfosGetter.get(i).getFirst_name()
                  + "_"
                  + personInfosGetter.get(i).getLast_name()
                  + ".txt");
          writer.write(fillTemplate(this.personInfosGetter.get(i)));
          writer.flush();
          writer.close();
        }catch (Exception e){
          e.printStackTrace();
        }
      }
    }
  }


  /**
   *
   * @param myPath set mypath
   */
  public void setMyPath(Path myPath) {
    this.myPath = myPath;
  }





}

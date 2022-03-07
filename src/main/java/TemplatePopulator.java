import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;


/**
 * this class uses List of PersonInfo and to fill a template
 */
public class TemplatePopulator {

  private List<MemberInfo> memberInfoList;
  private String template;
  private Path path;

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
   * @param memberInfoList handle List of PersonInfo
   * @param template template file name
   */
  public TemplatePopulator(List<MemberInfo> memberInfoList, String template) {
    this.memberInfoList = memberInfoList;
    this.template = template;
    this.path = Paths.get(template);
  }

  /**
   *
   * @param info one element in List of PersonInfo
   * @return template filling result as a String data
   * @throws IOException when i/o exception happens
   */
  public String populateTemplate(MemberInfo info) throws IOException {

    String data = Files.readString(this.path);
    data = data.replaceAll(REGEX_FIR_NAME, info.getFirst_name());
    data = data.replaceAll(REGEX_LAST_NAME, info.getLast_name());
    data = data.replaceAll(REGEX_COMP_NAME, info.getCompany_name());
    data = data.replaceAll(REGEX_ADD, info.getAddress());
    data = data.replaceAll(REGEX_CITY, info.getCity());
    data = data.replaceAll(REGEX_COUNTY, info.getCounty());
    data = data.replaceAll(REGEX_STATE, info.getState());
    data = data.replaceAll(REGEX_ZIP, info.getZip());
    data = data.replaceAll(REGEX_PHONE1, info.getPhone1());
    data = data.replaceAll(REGEX_PHONE2, info.getPhone2());
    data = data.replaceAll(REGEX_EMAIL, info.getEmail());
    data = data.replaceAll(REGEX_WEB, info.getWeb());
    return data;

  }


  /**
   * @throws IOException when format is bad
   * @param output output path
   */
  public void populateAll(String output) throws IOException {
    FileWriter writer;
    if (output == null){
      for (int i = 0; i < this.memberInfoList.size(); i++){
        System.out.println(populateTemplate(this.memberInfoList.get(i)));
      }
    }
    else {
      for (int i = 0; i < this.memberInfoList.size(); i++){
                  writer = new FileWriter(output
                  + memberInfoList.get(i).getFirst_name()
                  + "_"
                  + memberInfoList.get(i).getLast_name()
                  + ".txt");
          writer.write(populateTemplate(this.memberInfoList.get(i)));
          writer.flush();
          writer.close();
      }
    }
  }


  /**
   *
   * @param path set path
   */
  public void setPath(Path path) {
    this.path = path;
  }

  /**
   * @return TemplatePopulator to string
   */
  @Override
  public String toString() {
    return "TemplatePopulator{" +
            "memberInfoList=" + memberInfoList +
            ", template='" + template + '\'' +
            ", path=" + path +
            '}';
  }

  /**
   * @param o object TemplatePopulator
   * @return if two objects are equal
   */
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TemplatePopulator)) return false;
    TemplatePopulator that = (TemplatePopulator) o;
    return Objects.equals(memberInfoList, that.memberInfoList) && Objects.equals(template, that.template) && Objects.equals(path, that.path);
  }

  /**
   * @return TemplatePopulator's hashcode
   */
  @Override
  public int hashCode() {
    return Objects.hash(memberInfoList, template, path);
  }
}

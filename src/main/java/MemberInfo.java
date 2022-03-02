import com.opencsv.bean.CsvBindByName;

/**
 * this class helps CSVProcessor. Fields in this class is the headers of insurance-company-members.csv
 */
public class MemberInfo {

  @CsvBindByName
  private String first_name;

  @CsvBindByName
  private String last_name;

  @CsvBindByName
  private String company_name;

  @CsvBindByName
  private String address;

  @CsvBindByName
  private String city;

  @CsvBindByName
  private String county;

  @CsvBindByName
  private String state;

  @CsvBindByName
  private String zip;

  @CsvBindByName
  private String phone1;

  @CsvBindByName
  private String phone2;

  @CsvBindByName
  private String email;

  @CsvBindByName
  private String web;

  /**
   *
   * @return first name
   */
  public String getFirst_name() {
    return first_name;
  }
  /**
   *
   * @return last name
   */
  public String getLast_name() {
    return last_name;
  }
  /**
   *
   * @return company name
   */
  public String getCompany_name() {
    return company_name;
  }
  /**
   *
   * @return address
   */
  public String getAddress() {
    return address;
  }

  /**
   *
   * @return city
   */
  public String getCity() {
    return city;
  }

  /**
   *
   * @return county
   */
  public String getCounty() {
    return county;
  }

  /**
   *
   * @return state
   */
  public String getState() {
    return state;
  }

  /**
   *
   * @return zip
   */
  public String getZip() {
    return zip;
  }

  /**
   *
   * @return phone1
   */
  public String getPhone1() {
    return phone1;
  }

  /**
   *
   * @return phone2
   */
  public String getPhone2() {
    return phone2;
  }

  /**
   *
   * @return email
   */
  public String getEmail() {
    return email;
  }

  /**
   *
   * @return web
   */
  public String getWeb() {
    return web;
  }



  @Override
  public String toString() {
    return "MemberInfo{" +
            "first_name='" + first_name + '\'' +
            ", last_name='" + last_name + '\'' +
            ", company_name='" + company_name + '\'' +
            ", address='" + address + '\'' +
            ", city='" + city + '\'' +
            ", county='" + county + '\'' +
            ", state='" + state + '\'' +
            ", zip='" + zip + '\'' +
            ", phone1='" + phone1 + '\'' +
            ", phone2='" + phone2 + '\'' +
            ", email='" + email + '\'' +
            ", web='" + web + '\'' +
            '}';
  }
}

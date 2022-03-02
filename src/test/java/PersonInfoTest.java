import java.io.IOException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PersonInfoTest {

  MemberInfo information;
  private CSVProcessor cptest;

  @BeforeEach
  void setUp() throws IOException {

    cptest = new CSVProcessor("docs\\insurance-company-members.csv");
    information = cptest.openCSVToBean().get(0);
  }

  @Test
  void getFirst_name() {
    Assertions.assertEquals("James", information.getFirst_name());
  }

  @Test
  void getLast_name() {
    Assertions.assertEquals("Butt", information.getLast_name());
  }

  @Test
  void getCompany_name() {
    Assertions.assertEquals("Benton, John B Jr", information.getCompany_name());
  }

  @Test
  void getAddress() {
    Assertions.assertEquals("6649 N Blue Gum St", information.getAddress());
  }

  @Test
  void testToString() {
    Assertions.assertEquals("PersonInfo{first_name='James', last_name='Butt', company_name='Benton, John B Jr', "
        + "address='6649 N Blue Gum St', city='New Orleans', county='Orleans', state='LA', zip='70116', phone1='504-621-8927', "
        + "phone2='504-845-1427', email='jbutt@gmail.com', web='http://www.bentonjohnbjr.com'}", information.toString());
  }

  @Test
  void getCity() {
    Assertions.assertEquals("New Orleans", information.getCity());
  }

  @Test
  void getCounty() {
    Assertions.assertEquals("Orleans", information.getCounty());
  }

  @Test
  void getState() {
    Assertions.assertEquals("LA", information.getState());
  }

  @Test
  void getZip() {
    Assertions.assertEquals("70116", information.getZip());
  }

  @Test
  void getPhone1() {
    Assertions.assertEquals("504-621-8927", information.getPhone1());
  }

  @Test
  void getPhone2() {
    Assertions.assertEquals("504-845-1427", information.getPhone2());
  }

  @Test
  void getEmail() {
    Assertions.assertEquals("jbutt@gmail.com", information.getEmail());
  }


  @Test
  void getWeb() {
    Assertions.assertEquals("http://www.bentonjohnbjr.com", information.getWeb());
  }
}
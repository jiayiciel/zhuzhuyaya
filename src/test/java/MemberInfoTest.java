import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class MemberInfoTest {

    private MemberInfo memberInfo;
    private CSVReader csvReader;

    @BeforeEach
    void setUp() throws IOException {
        csvReader = new CSVReader("docs/insurance-company-members.csv");
        memberInfo = csvReader.openCSVToBean().get(1);
    }

    @Test
    void getFirst_name() {
        Assertions.assertEquals("Josephine", memberInfo.getFirst_name());
    }

    @Test
    void getLast_name() {
        Assertions.assertEquals("Darakjy", memberInfo.getLast_name());
    }

    @Test
    void getCompany_name() {
        Assertions.assertEquals("Chanay, Jeffrey A Esq", memberInfo.getCompany_name());
    }

    @Test
    void getAddress() {
        Assertions.assertEquals("4 B Blue Ridge Blvd", memberInfo.getAddress());
    }

    @Test
    void getCity() {
        Assertions.assertEquals("Brighton", memberInfo.getCity());
    }

    @Test
    void getCounty() {
        Assertions.assertEquals("Livingston", memberInfo.getCounty());
    }

    @Test
    void getState() {
        Assertions.assertEquals("MI", memberInfo.getState());
    }

    @Test
    void getZip() {
        Assertions.assertEquals("48116", memberInfo.getZip());
    }

    @Test
    void getPhone1() {
        Assertions.assertEquals("810-292-9388", memberInfo.getPhone1());
    }

    @Test
    void getPhone2() {
        Assertions.assertEquals("810-374-9840", memberInfo.getPhone2());
    }

    @Test
    void getEmail() {
        Assertions.assertEquals("josephine_darakjy@darakjy.org", memberInfo.getEmail());
    }

    @Test
    void getWeb() {
        Assertions.assertEquals("http://www.chanayjeffreyaesq.com", memberInfo.getWeb());
    }

    @Test
    void testToString() throws IOException {
        Assertions.assertEquals(memberInfo.toString(), memberInfo.toString());
        Assertions.assertFalse(memberInfo.toString().equals(null));Assertions.assertFalse(memberInfo.equals(""));
        Assertions.assertFalse(memberInfo.toString().equals(""));
    }

    @Test
    void testEquals() throws IOException {
        Assertions.assertEquals(memberInfo, memberInfo);
        Assertions.assertFalse(memberInfo.equals(null));
        Assertions.assertFalse(memberInfo.equals(""));
        MemberInfo memberInfo2 = csvReader.openCSVToBean().get(2);
        Assertions.assertFalse(memberInfo.equals(memberInfo2));
    }

    @Test
    void testHashCode() {
        Assertions.assertEquals(memberInfo.hashCode(), memberInfo.hashCode());
    }
}
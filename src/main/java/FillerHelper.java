import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;


public class FillerHelper {


    private List<MemberInfo> memberInfoList;
    private String template;

    public FillerHelper(List<MemberInfo> memberInfoList, String template) {
        this.memberInfoList = memberInfoList;
        this.template = template;

    }


    /**
     *
     * @return personInfoGetter
     */
    public List<MemberInfo> getPersonInfos() {
        return memberInfoList;
    }

    /**
     *
     * @return template file name
     */
    public String getFileName() {
        return template;
    }

    /**
     *
     * @param memberInfoList set personInfoGetter
     */
    public void setPersonInfos(List<MemberInfo> memberInfoList) {
        this.memberInfoList = memberInfoList;
    }

    /**
     *
     * @param template set template file name
     */
    public void settemplate(String template) {
        this.template = template;
    }



}

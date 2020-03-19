import java.util.Date;

/**
 * <h3>HealthReport</h3>
 * <p></p>
 *
 * @author : ZhouKun
 * @date : 2020-03-19 11:28
 **/
public class ReportModel {
    Date date;
    String address;
    int attendance;
    String cityId;
    String cityName;
    int codeColor;
    String codeDes;
    String company;
    String companyId;
    int hbConcat;
    int health;
    String healthdes;
    int isFace;
    int otherConcat;
    String otherConcatDes;
    int outConcatMan;
    String outConcatManDes;
    int outPlayStatus;
    String outPlayStatusDes;
    String proviceId;
    String proviceName;
    String staffId;
    int togetherHealth;
    String togetherHealthDes;

    public ReportModel(Date date, String address,
                       int attendance, String cityId, String cityName,
                       int codeColor, String codeDes, String company,
                       String companyId, int hbConcat, int health,
                       String healthdes, int isFace, int otherConcat,
                       String otherConcatDes, int outConcatMan, String outConcatManDes,
                       int outPlayStatus, String outPlayStatusDes, String proviceId,
                       String proviceName, String staffId,
                       int togetherHealth, String togetherHealthDes) {
        this.date = date;
        this.address = address;
        this.attendance = attendance;
        this.cityId = cityId;
        this.cityName = cityName;
        this.codeColor = codeColor;
        this.codeDes = codeDes;
        this.company = company;
        this.companyId = companyId;
        this.hbConcat = hbConcat;
        this.health = health;
        this.healthdes = healthdes;
        this.isFace = isFace;
        this.otherConcat = otherConcat;
        this.otherConcatDes = otherConcatDes;
        this.outConcatMan = outConcatMan;
        this.outConcatManDes = outConcatManDes;
        this.outPlayStatus = outPlayStatus;
        this.outPlayStatusDes = outPlayStatusDes;
        this.proviceId = proviceId;
        this.proviceName = proviceName;
        this.staffId = staffId;
        this.togetherHealth = togetherHealth;
        this.togetherHealthDes = togetherHealthDes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAttendance() {
        return attendance;
    }

    public void setAttendance(int attendance) {
        this.attendance = attendance;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCodeColor() {
        return codeColor;
    }

    public void setCodeColor(int codeColor) {
        this.codeColor = codeColor;
    }

    public String getCodeDes() {
        return codeDes;
    }

    public void setCodeDes(String codeDes) {
        this.codeDes = codeDes;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public int getHbConcat() {
        return hbConcat;
    }

    public void setHbConcat(int hbConcat) {
        this.hbConcat = hbConcat;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public String getHealthdes() {
        return healthdes;
    }

    public void setHealthdes(String healthdes) {
        this.healthdes = healthdes;
    }

    public int getIsFace() {
        return isFace;
    }

    public void setIsFace(int isFace) {
        this.isFace = isFace;
    }

    public int getOtherConcat() {
        return otherConcat;
    }

    public void setOtherConcat(int otherConcat) {
        this.otherConcat = otherConcat;
    }

    public String getOtherConcatDes() {
        return otherConcatDes;
    }

    public void setOtherConcatDes(String otherConcatDes) {
        this.otherConcatDes = otherConcatDes;
    }

    public int getOutConcatMan() {
        return outConcatMan;
    }

    public void setOutConcatMan(int outConcatMan) {
        this.outConcatMan = outConcatMan;
    }

    public String getOutConcatManDes() {
        return outConcatManDes;
    }

    public void setOutConcatManDes(String outConcatManDes) {
        this.outConcatManDes = outConcatManDes;
    }

    public int getOutPlayStatus() {
        return outPlayStatus;
    }

    public void setOutPlayStatus(int outPlayStatus) {
        this.outPlayStatus = outPlayStatus;
    }

    public String getOutPlayStatusDes() {
        return outPlayStatusDes;
    }

    public void setOutPlayStatusDes(String outPlayStatusDes) {
        this.outPlayStatusDes = outPlayStatusDes;
    }

    public String getProviceId() {
        return proviceId;
    }

    public void setProviceId(String proviceId) {
        this.proviceId = proviceId;
    }

    public String getProviceName() {
        return proviceName;
    }

    public void setProviceName(String proviceName) {
        this.proviceName = proviceName;
    }

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public int getTogetherHealth() {
        return togetherHealth;
    }

    public void setTogetherHealth(int togetherHealth) {
        this.togetherHealth = togetherHealth;
    }

    public String getTogetherHealthDes() {
        return togetherHealthDes;
    }

    public void setTogetherHealthDes(String togetherHealthDes) {
        this.togetherHealthDes = togetherHealthDes;
    }
}

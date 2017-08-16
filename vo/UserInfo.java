package vo;

import java.sql.Date;

public class UserInfo {

    private int FKaccount;

    @Override
    public String toString() {
        return "UserInfo{" +
                "FKaccount=" + FKaccount +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", address='" + address + '\'' +
                ", tel=" + tel +
                ", createDate=" + createDate +
                ", nickName='" + nickName + '\'' +
                ", gender=" + gender +
                '}';
    }

    public int getFKaccount() {
        return FKaccount;
    }

    public void setFKaccount(int FKaccount) {
        this.FKaccount = FKaccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    private String name;
    private Date birth;
    private String address;
    private int tel;
    private Date createDate;
    private String nickName;
    private int gender;

}

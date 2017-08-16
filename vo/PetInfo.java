package vo;

import java.sql.Date;

/**
 * Created by user on 2017-08-10.
 */
public class PetInfo {
    int pk;
    int fkAccount;
    String name;
    Date birth;
    int fkPetBreed;
    int gender;
    int isNeuter;

    @Override
    public String toString() {
        return "PetInfo{" +
                "pk=" + pk +
                ", fkAccount=" + fkAccount +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", fkPetBreed=" + fkPetBreed +
                ", gender=" + gender +
                ", isNeuter=" + isNeuter +
                '}';
    }

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public int getFkAccount() {
        return fkAccount;
    }

    public void setFkAccount(int fkAccount) {
        this.fkAccount = fkAccount;
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

    public int getFkPetBreed() {
        return fkPetBreed;
    }

    public void setFkPetBreed(int fkPetBreed) {
        this.fkPetBreed = fkPetBreed;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getIsNeuter() {
        return isNeuter;
    }

    public void setIsNeuter(int isNeuter) {
        this.isNeuter = isNeuter;
    }
}

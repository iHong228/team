package vo;

/**
 * Created by user on 2017-08-09.
 */
public class Account {
    int pk;
    String email;
    String password;
    int count;
    int autholization;

    public int getPk() {
        return pk;
    }

    public void setPk(int pk) {
        this.pk = pk;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getAutholization() {
        return autholization;
    }

    public void setAutholization(int autholization) {
        this.autholization = autholization;
    }

    @Override
    public String toString() {
        return "Account{" +
                "pk=" + pk +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", count=" + count +
                ", autholization=" + autholization +
                '}';
    }
}

package vo;

/**
 * Created by user on 2017-08-16.
 */
public class SecurityQuestion {

    private int pk;
    private int fkAccount;
    private String question;
    private String answer;
    private int cnt;

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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    @Override
    public String toString() {
        return "SecurityQuestion{" +
                "pk=" + pk +
                ", fkAccount=" + fkAccount +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", cnt=" + cnt +
                '}';
    }
}

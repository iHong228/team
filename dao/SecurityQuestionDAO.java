package dao;

import connection.ConnectionMaker;
import vo.Account;
import vo.SecurityQuestion;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-08-16.
 */
public class SecurityQuestionDAO {

    PreparedStatement ps;

    public void create(SecurityQuestion securityQuestion) {
        String sql = "INSERT INTO practice.securityquestion(fkaccount, question, answer, cnt) VALUES (?, ?, ?, ?)";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setInt(1, securityQuestion.getFkAccount());
            ps.setString(2, securityQuestion.getQuestion());
            ps.setString(3, securityQuestion.getAnswer());
            ps.setInt(4, securityQuestion.getCnt());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<SecurityQuestion> read(String fieldName, String key) {
        ResultSet rs;
        String sql = "SELECT * FROM practice.securityQuestion WHERE " + fieldName + " = ?";
        SecurityQuestion securityQuestion = new SecurityQuestion();
        List<SecurityQuestion> list = null;

        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, key);

            rs = ps.executeQuery();

            while (rs.next()) {
                list = new ArrayList<SecurityQuestion>();
                securityQuestion.setPk(rs.getInt("pk"));
                securityQuestion.setFkAccount(rs.getInt("fkaccount"));
                securityQuestion.setQuestion(rs.getString("question"));
                securityQuestion.setAnswer(rs.getString("answer"));
                securityQuestion.setCnt(rs.getInt("cnt"));
                list.add(securityQuestion);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void update(SecurityQuestion securityQuestion) {
        String sql = "UPDATE practice.securityQuestion SET fkaccount = ? , question = ?, answer = ?, cnt = ? WHERE pk = ?";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setInt(1, securityQuestion.getFkAccount());
            ps.setString(2, securityQuestion.getQuestion());
            ps.setString(3, securityQuestion.getAnswer());
            ps.setInt(4, securityQuestion.getCnt());
            ps.setInt(5, securityQuestion.getPk());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(SecurityQuestion securityQuestion) {
        String sql = "DELETE FROM practice.securityQuestion WHERE fkaccount = ?";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setInt(1, securityQuestion.getFkAccount());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAll() {
        String sql = "DELETE FROM practice.securityQuestion";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int count() {
        ResultSet rs;
        String sql = "SELECT COUNT(*) FROM practice.securityQuestion";
        int cnt = 0;
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            cnt = rs.getInt("count(*)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cnt;
    }
}

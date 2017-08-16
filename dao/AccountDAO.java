package dao;

import connection.ConnectionMaker;
import vo.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-08-09.
 */
public class AccountDAO {
    PreparedStatement ps;

    public void create(Account Account) {
        String sql = "INSERT INTO practice.account(email, password) VALUES (?, ?)";

        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, Account.getEmail());
            ps.setString(2, Account.getPassword());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Account> read(String FieldName, String key) {
        ResultSet rs;
        String sql = "SELECT * FROM practice.account WHERE " + FieldName + " = ?";
        Account account = new Account();
        List<Account> list = null;

        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, key);

            rs = ps.executeQuery();

            while (rs.next()) {
                list = new ArrayList<Account>();
                account.setPk(rs.getInt("pk"));
                account.setEmail(rs.getString("email"));
                account.setPassword(rs.getString("password"));
                account.setCount(rs.getInt("count"));
                account.setAutholization(rs.getInt("autholization"));
                list.add(account);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(Account account) {
        String sql = "UPDATE practice.account SET email = ? , password = ?, count = ?, autholization = ? WHERE pk = ?";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, account.getEmail());
            ps.setString(2, account.getPassword());
            ps.setInt(3, account.getCount());
            ps.setInt(4, account.getAutholization());
            ps.setInt(5, account.getPk());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(Account account) {
        String sql = "DELETE FROM practice.account WHERE email = ?";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, account.getEmail());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteAll() {
        String sql = "DELETE FROM practice.account";

        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int count() {
        ResultSet rs;
        String sql = "SELECT COUNT(*) FROM practice.account";
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

     /*public void update(Account account, String FieldName, String key, String editField) {
        String sql = "UPDATE practice.account SET "+ editField+" = ? WHERE " + FieldName + " = ?";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, account.getPassword());
            ps.setString(2, key);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }*/

}

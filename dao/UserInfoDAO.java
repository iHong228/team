package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMaker;
import vo.UserInfo;

public class UserInfoDAO {

    private PreparedStatement ps;
    private ResultSet rs;

    public void create(UserInfo userInfo) {
        String sql = "INSERT INTO practice.userinfo(NAME, BIRTH, ADDRESS, TEL, CREATEDATE, NICKNAME, GENDER) VALUES(?,?,?,?,?,?,?)";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, userInfo.getName());
            ps.setDate(2, userInfo.getBirth());
            ps.setString(3, userInfo.getAddress());
            ps.setInt(4, userInfo.getTel());
            ps.setDate(5, userInfo.getCreateDate());
            ps.setString(6, userInfo.getNickName());
            ps.setInt(7, userInfo.getGender());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<UserInfo> read(String fieldName, String key) {
        String sql = "SELECT FKaccount, NAME, BIRTH, ADDRESS, TEL, CREATEDATE,NICKNAME, GENDER FROM practice.userinfo WHERE " + fieldName + " = ?";
        List<UserInfo> list = null;
        UserInfo userInfo = new UserInfo();

        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, key);
            rs = ps.executeQuery();
            while (rs.next()) {
                list = new ArrayList<UserInfo>();
                userInfo.setFKaccount(rs.getInt("fkaccount"));
                userInfo.setName(rs.getString("name"));
                userInfo.setBirth(rs.getDate("birth"));
                userInfo.setAddress(rs.getString("address"));
                userInfo.setTel(rs.getInt("tel"));
                userInfo.setCreateDate(rs.getDate("createdate"));
                userInfo.setNickName(rs.getString("nickname"));
                userInfo.setGender(rs.getInt("gender"));

                list.add(userInfo);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(UserInfo userInfo) {
        String sql = "UPDATE practice.userinfo SET NAME = ?, BIRTH = ?, ADDRESS = ?, TEL = ?, CREATEDATE = ?, NICKNAME = ?, GENDER = ? WHERE FKaccount = ?";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, userInfo.getName());
            ps.setDate(2, userInfo.getBirth());
            ps.setString(3, userInfo.getAddress());
            ps.setInt(4, userInfo.getTel());
            ps.setDate(5, userInfo.getCreateDate());
            ps.setString(6, userInfo.getNickName());
            ps.setInt(7, userInfo.getGender());

            ps.setInt(8, userInfo.getFKaccount());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String fieldName, String key) {
        String sql = "DELETE FROM practice.userinfo WHERE " + fieldName + " = ?";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, key);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

package dao;

import connection.ConnectionMaker;
import vo.Account;
import vo.P_Photo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class P_PhotoDAO {
    PreparedStatement ps;

    public void create(P_Photo p_photo) {
        String sql = "INSERT INTO practice.p_photo(name, path, size, petid) VALUES (?, ?, ?, ?)";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, p_photo.getName());
            ps.setString(2, p_photo.getPath());
            ps.setInt(3, p_photo.getSize());
            ps.setInt(4, p_photo.getPetid());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<P_Photo> read(String fieldName, String key) {
        ResultSet rs;
        String sql = "SELECT * FROM practice.p_photo WHERE " + fieldName + " = ?";
        P_Photo p_photo = new P_Photo();
        List<P_Photo> list = null;

        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, key);

            rs = ps.executeQuery();

            while (rs.next()) {
                list = new ArrayList<P_Photo>();
                p_photo.setName(rs.getString("name"));
                p_photo.setPath(rs.getString("path"));
                p_photo.setSize(rs.getInt("size"));
                p_photo.setPetid(rs.getInt("petid"));
                list.add(p_photo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(String value, String key) {
        String sql = "UPDATE practice.breed SET name = ? WHERE name = ?";

        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, value);
            ps.setString(2, key);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(String name) {
        String sql = "DELETE FROM practice.p_photo WHERE name = ?";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, name);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteAll() {
        String sql = "DELETE FROM practice.breed";

        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int count() {
        ResultSet rs;
        String sql = "SELECT COUNT(*) FROM practice.breed";
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

package dao;

import connection.ConnectionMaker;
import vo.Breed;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-08-11.
 */
public class BreedDAO {
    PreparedStatement ps;

    public void create(String breed) {
        String sql = "INSERT INTO practice.breed(name) VALUES (?)";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, breed);

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String read(String key) {
        ResultSet rs;
        String sql = "SELECT * FROM practice.breed WHERE name = ?";
        String breed = "";

        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, key);

            rs = ps.executeQuery();

            rs.next();
            breed = rs.getString("name");

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return breed;
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
        String sql = "DELETE FROM practice.breed WHERE name = ?";
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

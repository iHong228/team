package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMaker;
import vo.Location;

public class LocationDAO {

    private PreparedStatement ps;
    private ResultSet rs;

    public void create(Location location) {
        String sql = "INSERT INTO practice.location(PLACE_CODE,NAME,ADDRESS,TIME,USERID,IMG,favorite) VALUES(?,?,?,?,?,?,?)";

        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);

            ps.setInt(1, location.getPlaceCode());
            ps.setString(2, location.getName());
            ps.setInt(3, location.getAddress());
            ps.setInt(4, location.getTime());
            ps.setInt(5, location.getUserId());
            ps.setInt(6, location.getImg());
            ps.setInt(7, location.getLike());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Location> read(String fieldName, String key) {
        String sql = "SELECT LOCATION_CODE,PLACE_CODE,NAME,ADDRESS,TIME,USERID,IMG,favorite FROM practice.location WHERE " + fieldName + " = ?";
        List<Location> list = null;
        Location location = new Location();

        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, key);
            rs = ps.executeQuery();

            while (rs.next()) {
                list = new ArrayList<Location>();
                location.setLocationCode(rs.getInt(1));
                location.setPlaceCode(rs.getInt(2));
                location.setName(rs.getString(3));
                location.setTime(rs.getInt(4));
                location.setUserId(rs.getInt(5));
                location.setImg(rs.getInt(6));
                location.setLike(rs.getInt(7));
                list.add(location);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(Location location) {
        String sql = "UPDATE practice.location SET name = ?, ADDRESS = ?, TIME = ?, USERID = ?, IMG = ?, favorite = ?, PLACE_CODE = ? WHERE pk = ?";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, location.getName());
            ps.setInt(2, location.getAddress());
            ps.setInt(3, location.getTime());
            ps.setInt(4, location.getUserId());
            ps.setInt(5, location.getImg());
            ps.setInt(6, location.getLike());
            ps.setInt(7, location.getPlaceCode());

            ps.setInt(8, location.getLocationCode());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void delete(String fieldName, String key) {
        String sql = "DELETE FROM practice.location WHERE " + fieldName + " = ?";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, key);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

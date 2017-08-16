package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMaker;
import vo.Place;

public class PlaceDAO {
	
	private PreparedStatement ps;
	private ResultSet rs;
    
    public void addPlace(Place dto) {
    	String sql = "INSERT INTO PLACE(PLACE_NAME) VALUES (?)";
    	try {
			ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
			ps.setString(1, dto.getPlaceName());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public List<Place> getPlace(String fieldName, String key) {
    	String sql = "SELECT PLACE_CODE,PLACE_NAME FROM PLACE WHERE "+fieldName+"= ?";
    	List<Place> list = null;
    	Place dto = new Place();
    	try {
			ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
			ps.setString(1, key);
			rs = ps.executeQuery();
			while(rs.next()) {
				list = new ArrayList<Place>();
				dto.setPlaceCode(rs.getInt(1));
				dto.setPlaceName(rs.getString(2));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return list;
    }
    
    public void delPlace(String fieldName, String key) {
    	String sql = "DELETE FROM PLACE WHERE "+ fieldName +" = ?";
    	try {
			ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
			ps.setString(1, key);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void modPlace(String fieldName, String key, String fieldName2, String key2) {
    	String sql = "UPDATE PLACE SET "+ fieldName2 +" = ?" +
				" WHERE "+ fieldName +" = ?";
    	try {
			ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
			ps.setString(1, key2);
			ps.setString(2, key);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
}

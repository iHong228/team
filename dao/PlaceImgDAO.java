package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMaker;
import vo.PlaceImg;

public class PlaceImgDAO {
	
	private PreparedStatement ps;
	private ResultSet rs;
    
    public void addPlaceImg(PlaceImg dto) {
    	String sql = "INSERT INTO PLACE_IMG(IMG_CODE,SIZE,NAME,WRITER,PATH,LOCATION_CODE)"+ 
    			"VALUES(?,?,?,?,?,?)";
    	try {
			ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
			ps.setInt(1, dto.getImgCode());
			ps.setInt(2, dto.getSize());
			ps.setString(3, dto.getName());
			ps.setString(4, dto.getWriter());
			ps.setInt(5, dto.getPath());
			ps.setInt(6, dto.getLocationCode());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public List<PlaceImg> getPlaceImg(String fieldName, String key) {
    	String sql = "SELECT SIZE,NAME,WRITER,PATH,LOCATION_CODE FROM PLACE_IMG"+
    				" WHERE "+fieldName+" = ?";
    	List<PlaceImg> list = null;
    	PlaceImg dto = new PlaceImg();
    	try {
			ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
			ps.setString(1, key);
			rs = ps.executeQuery();
			while(rs.next()) {
				list = new ArrayList<PlaceImg>();
				dto.setSize(rs.getInt(1));
				dto.setName(rs.getString(2));
				dto.setWriter(rs.getString(3));
				dto.setPath(rs.getInt(4));
		    	dto.setLocationCode(rs.getInt(5));
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
    	return list;
    }
    
    public void delPlaceImg(String fieldName, String key) {
    	String sql = "DELETE FROM PLACE_IMG WHERE "+ fieldName +" = ?";
    	try {
			ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
			ps.setString(1, key);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    
    public void modPlaceImg(String fieldName, String key, String fieldName2, String key2) {
    	String sql = "UPDATE PLACE_IMG SET "+ fieldName2 +" = ?" +
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

package dao;

import connection.ConnectionMaker;
import vo.PetInfo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 2017-08-10.
 */
public class PetInfoDAO {
    PreparedStatement ps;

    public void create(PetInfo pet) {
        String sql = "INSERT INTO practice.petinfo(FKaccount, NAME, BIRTH, FKpetbreed, GENDER, ISNEUTER) VALUES (?, ?, ?, ?, ?, ?)";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setInt(1, pet.getFkAccount());
            ps.setString(2, pet.getName());
            ps.setDate(3, pet.getBirth());
            ps.setInt(4, pet.getFkAccount());
            ps.setInt(5, pet.getGender());
            ps.setInt(6, pet.getIsNeuter());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PetInfo> read(String fieldName, String key) {
        ResultSet rs;
        String sql = "SELECT * FROM practice.petinfo WHERE " + fieldName + " = ?";
        PetInfo petInfo = new PetInfo();
        List<PetInfo> list = null;

        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, key);

            rs = ps.executeQuery();

            while (rs.next()) {
                list = new ArrayList<PetInfo>();
                petInfo.setPk(rs.getInt("pk"));
                petInfo.setFkAccount(rs.getInt("fkaccount"));
                petInfo.setName(rs.getString("name"));
                petInfo.setBirth((rs.getDate("birth")));
                petInfo.setFkPetBreed(rs.getInt("fkpetbreed"));
                petInfo.setGender(rs.getInt("gender"));
                petInfo.setIsNeuter(rs.getInt("isneuter"));
                list.add(petInfo);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void update(PetInfo petInfo) {
        String sql = "UPDATE practice.petinfo SET FKaccount = ?, NAME = ?, BIRTH = ?, FKpetbreed = ?, GENDER = ?, ISNEUTER = ? WHERE PK = ?";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setInt(1, petInfo.getFkAccount());
            ps.setString(2, petInfo.getName());
            ps.setDate(3, petInfo.getBirth());
            ps.setInt(4, petInfo.getFkPetBreed());
            ps.setInt(5, petInfo.getGender());
            ps.setInt(6, petInfo.getIsNeuter());
            ps.setInt(7, petInfo.getPk());

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void delete(String pName) {
        String sql = "DELETE FROM practice.petinfo WHERE NAME = ?";
        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);
            ps.setString(1, pName);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void deleteAll() {
        String sql = "DELETE FROM practice.petinfo";

        try {
            ps = ConnectionMaker.ConnectDB().prepareStatement(sql);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public int count() {
        ResultSet rs;
        String sql = "SELECT COUNT(*) FROM practice.petinfo";
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

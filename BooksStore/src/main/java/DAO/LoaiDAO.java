package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modal.Loai;

public class LoaiDAO {
	public ArrayList<Loai> getAllLoai(){
		ArrayList<Loai> dsLoai= new ArrayList<>();
		try(Connection conn = KetNoiJDBC.getConnection()) {
			String sql="SELECT * FROM LOAI";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Loai l = new  Loai();
				l.setMaLoai(rs.getString("maloai"));
				l.setTenLoai(rs.getString("tenloai"));
				dsLoai.add(l);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsLoai;
	}
}

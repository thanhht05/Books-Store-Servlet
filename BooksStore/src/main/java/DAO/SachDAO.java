package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modal.Sach;

public  class SachDAO {
	public ArrayList<Sach> getAllSach() {
		ArrayList<Sach> ds = new ArrayList<Sach>();
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql="SELECT * FROM sach";
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Sach s = new Sach();
				s.setAnh(rs.getString(anh));
			}

			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
	
	
}

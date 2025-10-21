package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;

public class HoaDonDAO {
	public void luuHoaDon(long maKH, Date ngayMua) {
		try (Connection conn = KetNoiJDBC.getConnection()){
			String sql="INSERT INTO HoaDon (makhachhang, ngaymua) VALUES(?,?)";
			PreparedStatement stmt= conn.prepareStatement(sql);
			stmt.setLong(1, maKH);
			stmt.setDate(2, ngayMua);
			
			stmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

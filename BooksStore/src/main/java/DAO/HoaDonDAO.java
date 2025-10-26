package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modal.HoaDon;
import modal.User;

import java.sql.Date;

public class HoaDonDAO {
	UserDAO userDAO = new UserDAO();
	public long luuHoaDon(HoaDon hoaDon) {
		long maHoaDon = -1;
		String sql = "INSERT INTO HoaDon (makhachhang, ngaymua) VALUES (?, ?)";

		try (Connection conn = KetNoiJDBC.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

			stmt.setLong(1, hoaDon.getUser().getId());
			stmt.setDate(2, hoaDon.getNgayMua());

			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();

			if (rs.next()) {
				maHoaDon = rs.getLong(1);
				hoaDon.setMaHoaDon(maHoaDon);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return maHoaDon;
	}
	
	public HoaDon getHoaDonById(Long id) {
		try (Connection conn = KetNoiJDBC.getConnection()){
			String sql="SELECT * FROM HoaDon WHERE mahoadon =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next()) {
				HoaDon hd = new HoaDon();
				hd.setMaHoaDon(rs.getLong("mahoadon"));
				hd.setNgayMua(rs.getDate("ngaymua"));
				
				User user = userDAO.getUserById(rs.getLong("makhachhang"));
				if(user!=null) {
					hd.setUser(user);
				}
				
				return hd;
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
}

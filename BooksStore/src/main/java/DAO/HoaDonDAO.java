package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modal.HoaDon;

import java.sql.Date;

public class HoaDonDAO {
	public long luuHoaDon(HoaDon hoaDon) {
		long maHoaDon = -1;
		String sql = "INSERT INTO HoaDon (makhachhang, ngaymua) VALUES (?, ?)";

		try (Connection conn = KetNoiJDBC.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

			stmt.setLong(1, hoaDon.getMaKH());
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
}

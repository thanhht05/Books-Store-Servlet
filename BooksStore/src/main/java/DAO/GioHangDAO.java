package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import modal.ChiTietGioHang;
import modal.GioHang;
import modal.Sach;
import modal.User;

public class GioHangDAO {
	UserDAO userDAO = new UserDAO();

	public GioHang timGioHangByUserId(Long id) {
		GioHang gh = null;
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT u.id AS userId, u.HoTen, u.DiaChi, u.SDT AS phone, u.email, u.GioiTinh, "
					+ "g.id AS gioHangId, g.soLuong " + "FROM users u " + "JOIN GioHang g ON u.id = g.khachHang_id "
					+ "WHERE u.id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				gh = new GioHang();
				gh.setId(rs.getLong("gioHangId"));
				gh.setSoLuong(rs.getLong("soLuong"));

				User user = new User();
				user.setDiaChi(rs.getString("DiaChi"));
				user.setEmail(rs.getString("email"));
				user.setPhone(rs.getString("phone"));
				user.setHoTen(rs.getString("HoTen"));
				user.setGioTinh(rs.getBoolean("GioiTinh"));

				gh.setUser(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return gh;
	}

	public GioHang saveGioHang(GioHang gh) {
		GioHang ghn = null;
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "INSERT INTO GioHang (khachHang_id, soLuong) VALUES (?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

			stmt.setLong(1, gh.getUser().getId());
			stmt.setLong(2, gh.getSoLuong());

			stmt.executeUpdate();

			ResultSet rs = stmt.getGeneratedKeys();
			if (rs.next()) {
				long maGioHang = rs.getLong(1);

				ghn = new GioHang();
				ghn.setId(maGioHang);
				ghn.setUser(gh.getUser());
				ghn.setSoLuong(gh.getSoLuong());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return ghn;
	}

	public void updateGioHang(GioHang gh) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "UPDATE GIoHang SET soLuong =? WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, gh.getSoLuong());
			stmt.setLong(2, gh.getId());

			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	


}

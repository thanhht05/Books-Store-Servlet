package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import modal.User;

public class UserDAO {
	public User createUser(User newUser) {
		User user = new User();
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "INSERT INTO Users (HoTen, MatKhau, SDT, DiaChi, email, GioiTinh) VALUES(?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, newUser.getHoTen());
			stmt.setString(2, newUser.getPassword());
			stmt.setString(3, newUser.getPhone());
			stmt.setString(4, newUser.getDiaChi());
			stmt.setString(5, newUser.getEmail());
			stmt.setBoolean(6, newUser.getGioTinh());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}

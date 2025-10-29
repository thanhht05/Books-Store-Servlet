package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

import configuration.PasswordEncryptor;
import modal.Role;
import modal.User;

public class UserDAO {
	RoleDAO roleDAO = new RoleDAO();

	public User createUser(User newUser) {
		User user = new User();
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "INSERT INTO Users (HoTen, MatKhau, SDT, DiaChi, email, GioiTinh, role_id) VALUES(?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, newUser.getHoTen());
			String hashedPassword = PasswordEncryptor.hashPassword(newUser.getPassword());
			stmt.setString(2, hashedPassword);
			stmt.setString(3, newUser.getPhone());
			stmt.setString(4, newUser.getDiaChi());
			stmt.setString(5, newUser.getEmail());
			stmt.setBoolean(6, newUser.getGioTinh());
			stmt.setLong(7, newUser.getRole().getId());
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	public boolean checkExistsUserByEmail(String email) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT 1 FROM users WHERE email =?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {

		}
		return false;
	}

	public User getUserByEmail(String email) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT * FROM Users WHERE email=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("matKhau"));
				user.setHoTen(rs.getString("hoten"));
				user.setId(rs.getLong("id"));

				Role role = roleDAO.getRoleById(rs.getLong("role_id"));
				if (role != null) {

					user.setRole(role);
				}
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean checkLogin(String email, String pass) {
		User user = getUserByEmail(email);
		if (user == null) {
			return false;
		}
		if (!user.getPassword().equals(PasswordEncryptor.hashPassword(pass))) {
			return false;
		}
		return true;

	}

	public ArrayList<User> getAllUser() {
		ArrayList<User> ds = new ArrayList<User>();
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT * FROM users";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				User user = new User();
				Role role = roleDAO.getRoleById(rs.getLong("role_id"));
				if (role != null) {
					user.setRole(role);
				}
				user.setId(rs.getLong("id"));
//				user.setDiaChi(rs.getString("diachi"));
				user.setEmail(rs.getString("email"));
				user.setGioTinh(rs.getBoolean("gioitinh"));
				user.setHoTen(rs.getString("hoten"));
				ds.add(user);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ds;
	}

	public User getUserById(long id) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "SELECT * FROM Users WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setDiaChi(rs.getString("diachi"));
				user.setEmail(rs.getString("email"));
				user.setGioTinh(rs.getBoolean("gioitinh"));
				user.setHoTen(rs.getString("hoten"));
				user.setPhone(rs.getString("SDT"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean updateUserById(User user) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "UPDATE Users SET hoten=?, email=?, gioitinh=?, diachi=?, SDT=? WHERE id=?";

			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, user.getHoTen());
			stmt.setString(2, user.getEmail());
			stmt.setBoolean(3, user.getGioTinh());
			stmt.setString(4, user.getDiaChi());
			stmt.setString(5, user.getPhone());
			stmt.setLong(6, user.getId());

			return stmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean deleteUserById(long id) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "DELETE FROM Users WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);

			return stmt.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public void updateSessionUser(long userId, String sessionId, Instant  sessionExpire) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql="UPDATE Users SET session_id =?, session_expire=? WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, sessionId);
			stmt.setTimestamp(2,  Timestamp.from(sessionExpire));
			stmt.setLong(3, userId);
			
			stmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public User getUserBySessionId(String sessionId) {
		try (Connection conn = KetNoiJDBC.getConnection()){
			String sql ="SELECT * FROM Users WHERE session_id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1,sessionId);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				User user = new User();
				user.setId(rs.getLong("id"));
				user.setDiaChi(rs.getString("diachi"));
				user.setEmail(rs.getString("email"));
				user.setGioTinh(rs.getBoolean("gioitinh"));
				user.setHoTen(rs.getString("hoten"));
				user.setPhone(rs.getString("SDT"));
				user.setSessionExpire(rs.getTimestamp("session_expire").toInstant());
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

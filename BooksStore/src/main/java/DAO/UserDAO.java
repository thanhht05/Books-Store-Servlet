package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import configuration.PasswordEncryptor;
import modal.User;

public class UserDAO {
	public User createUser(User newUser) {
		User user = new User();
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql = "INSERT INTO Users (HoTen, MatKhau, SDT, DiaChi, email, GioiTinh) VALUES(?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, newUser.getHoTen());
			String hashedPassword = PasswordEncryptor.hashPassword(newUser.getPassword());
			stmt.setString(2, hashedPassword);
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
			String sql="SELECT * FROM Users WHERE email=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, email);
			
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				User user = new User();
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("matKhau"));
				user.setHoTen(rs.getString("hoten"));
				return user;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean checkLogin(String email, String pass) {
		User user = getUserByEmail(email);
		if(user==null) {
			return false;
		}
		if(!user.getPassword().equals(PasswordEncryptor.hashPassword(pass))) {
			return false;
		}
		return true;
		
	}
	
	public ArrayList<User> getAllUser(){
		ArrayList<User> ds = new ArrayList<User>();
		try (Connection conn = KetNoiJDBC.getConnection()){
			String sql="SELECT * FROM users";
			PreparedStatement stmt=conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				User user= new User();
//				user
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return ds;
	}
}

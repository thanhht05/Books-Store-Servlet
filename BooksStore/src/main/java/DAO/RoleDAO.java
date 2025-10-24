package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modal.Role;

public class RoleDAO {
	public Role getRoleById(Long id) {
		try (Connection conn = KetNoiJDBC.getConnection()) {
			String sql="SELECT * FROM role WHERE id=?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, id);
			
			ResultSet rs = stmt.executeQuery();
			
			Role role = new Role();
			if(rs.next()) {
				role.setId(rs.getLong("id"));
				role.setName(rs.getString("name"));
				
				return role;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}

package BO;

import DAO.RoleDAO;
import modal.Role;

public class RoleBO {
	RoleDAO roleDAO = new RoleDAO();
	public Role getRoleById(Long id) {
		return roleDAO.getRoleById(id);
	}
}

package BO;

import DAO.UserDAO;
import modal.User;

public class UserBO {
	UserDAO userDAO = new UserDAO();
	public User createUser(User user) {
		return userDAO.createUser(user);
	}
}

package BO;

import java.util.ArrayList;

import DAO.UserDAO;
import modal.User;

public class UserBO {
	UserDAO userDAO = new UserDAO();
	public User createUser(User user) {
		return userDAO.createUser(user);
	}
	
	public boolean checkExistsUserByEmail(String email) {
		return userDAO.checkExistsUserByEmail(email);
	}
	
	public boolean checkLogin(String email, String pass) {
		return userDAO.checkLogin(email, pass);
	}
	
	public User getUserByEmail(String email) {
		return userDAO.getUserByEmail(email);
	}
	
	public ArrayList<User> getAllUser(){
		return userDAO.getAllUser();
	}
	
	public User getUserById(Long id) {
		return userDAO.getUserById(id);
	}
	public boolean updateUserById(User user) {
		return userDAO.updateUserById(user);
	}
	public boolean deleteUserById(long id) {
		return userDAO.deleteUserById(id);
	}
}

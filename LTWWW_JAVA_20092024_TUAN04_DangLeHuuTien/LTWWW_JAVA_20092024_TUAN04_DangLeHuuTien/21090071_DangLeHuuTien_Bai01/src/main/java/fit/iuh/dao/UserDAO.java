package fit.iuh.dao;

import java.util.List;

import fit.iuh.models.User;

public interface UserDAO {
	public List<User> getAllUsers();
	public User getById(int id);
	public void addUser(User u);
}

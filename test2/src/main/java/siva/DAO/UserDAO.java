package siva.DAO;

import siva.model.User;

public interface UserDAO {

	public boolean registerUser(siva.model.User user);
	public boolean modifyUser(User user);
	public User getUser(String username);
	
}

package creacionales.abstractFactory.dao;

import java.util.List;

import creacionales.abstractFactory.entities.User;

public interface IUserDAO {

	public List<User> getAll();
	public User getById(long id);
}

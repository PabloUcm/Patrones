package creacionales.abstractFactory.factories;

import creacionales.abstractFactory.dao.IProductDAO;
import creacionales.abstractFactory.dao.IUserDAO;

public interface IDAOServiceFactory {

	public IUserDAO getUserDAOService();
	public IProductDAO getProductDAOService();
}

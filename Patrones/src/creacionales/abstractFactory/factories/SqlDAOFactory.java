package creacionales.abstractFactory.factories;

import creacionales.abstractFactory.dao.IProductDAO;
import creacionales.abstractFactory.dao.IUserDAO;
import creacionales.abstractFactory.dao.impl.SqlProductDAO;
import creacionales.abstractFactory.dao.impl.SqlUserDAO;

public class SqlDAOFactory implements IDAOServiceFactory{

	@Override
	public IUserDAO getUserDAOService() {
		return new SqlUserDAO();
	}

	@Override
	public IProductDAO getProductDAOService() {
		return new SqlProductDAO();
	}

}

package creacionales.abstractFactory;

import java.util.List;

import creacionales.abstractFactory.dao.IProductDAO;
import creacionales.abstractFactory.entities.Product;
import creacionales.abstractFactory.factories.IDAOServiceFactory;

public class Main {

	public static void main(String[] args) {
		IDAOServiceFactory factoryDAO = DAOServiceFactory.getDefaultFactory();
		
		IProductDAO productDAO = factoryDAO.getProductDAOService();
		
		List<Product> l = productDAO.getAll();
		
		for(Product p: l) {
			System.out.println(p);
		}
	}

}

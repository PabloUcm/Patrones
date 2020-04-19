package creacionales.factoryMethod;

import java.sql.SQLException;
import java.util.List;

import creacionales.factoryMethod.dao.ProductDAO;
import creacionales.factoryMethod.entity.Product;

public class FactoryMain {
	
	public static void main(String args[]) throws SQLException{
		Product productA = new Product(1L,"Product A",100);
		Product productB = new Product(2L,"Product B",100);
		
		ProductDAO productDAO = new ProductDAO();
		
		productDAO.saveProduct(productA);
		productDAO.saveProduct(productB);
		
		List<Product> products = productDAO.findAllProducts();
		System.out.println("Product size ==>" + products.size());
		for(Product p: products) System.out.println(p);
	}
}

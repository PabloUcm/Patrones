package creacionales.factoryMethod.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import creacionales.factoryMethod.DBFactory;
import creacionales.factoryMethod.IDBAdapter;
import creacionales.factoryMethod.entity.Product;

public class ProductDAO {
	private IDBAdapter dbAdapter;
	
	public ProductDAO() {
		dbAdapter = DBFactory.getDefaultAdapter();
	}
	
	public List<Product> findAllProducts(){
		Connection connection = dbAdapter.getConnection();
		List<Product> productList = new ArrayList<>();
		
		try {
			PreparedStatement statement =
					connection.prepareStatement("SELECT idProductos,productName" + ",productPrice FROM Productos");
			ResultSet results = statement.executeQuery();
			
			while(results.next()) {
				productList.add(new Product(results.getLong(1),results.getString(2),results.getDouble(3)));
			}
			return productList;
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public boolean saveProduct(Product product) {
		Connection connection = dbAdapter.getConnection();
		try {
			PreparedStatement statement= 
					connection.prepareStatement("INSERT INTO Productos(idProductos," + "productName,productPrice) VALUES(?,?,?)");
			
			statement.setLong(1, product.getIdProduct());
			statement.setString(2, product.getProductName());
			statement.setDouble(3, product.getPrice());
			statement.executeUpdate();
			return true;
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}

package creacionales.abstractFactory.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import creacionales.abstractFactory.dao.IProductDAO;
import creacionales.abstractFactory.entities.Product;
import creacionales.factoryMethod.DBFactory;
import creacionales.factoryMethod.IDBAdapter;

public class SqlProductDAO implements IProductDAO{

	private IDBAdapter dbAdapter;
	
	public SqlProductDAO() {
		dbAdapter = DBFactory.getDefaultAdapter();
	}
	
	@Override
	public List<Product> getAll() {
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

	@Override
	public Product getById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}

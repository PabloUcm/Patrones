package creacionales.abstractFactory.dao;

import java.util.List;

import creacionales.abstractFactory.dbAdapters.IDBAdapter;
import creacionales.abstractFactory.entities.Product;

public interface IProductDAO {
	
	public List<Product> getAll();
	public Product getById(long id);
}

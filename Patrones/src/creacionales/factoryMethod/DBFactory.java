package creacionales.factoryMethod;

import java.util.Properties;

import creacionales.factoryMethod.impl.MySQLDBAdapter;
import creacionales.factoryMethod.impl.OracleDBAdapter;
import creacionales.factoryMethod.util.PropertiesUtil;

public class DBFactory {
	
	private static final String DB_FACTORY_PROPERTY_URL = "metaInf/DBFactory.properties";
	private static final String DEFAULT_DB_CLASS_PROP = "defaultDBClass";
	
	public static IDBAdapter getIDBadapter(DBType dbType) {
		switch(dbType) {
		case MySQL:
			return new MySQLDBAdapter();
		case Oracle:
			return new OracleDBAdapter();
		default:
			throw new IllegalArgumentException("No soportado");
		}
	}
	
	@SuppressWarnings("deprecation")
	public static IDBAdapter getDefaultAdapter() {
		try {
			Properties prop = PropertiesUtil.loadProperty(DB_FACTORY_PROPERTY_URL);
			String defaultDBClass = prop.getProperty(DEFAULT_DB_CLASS_PROP);
			System.out.println("DefaultDBClass ==>" + defaultDBClass);
			return (IDBAdapter) Class.forName(defaultDBClass).newInstance();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

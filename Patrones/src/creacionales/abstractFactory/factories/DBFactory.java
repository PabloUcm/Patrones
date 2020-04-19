package creacionales.abstractFactory.factories;

import java.util.Properties;

import creacionales.abstractFactory.dbAdapters.DBType;
import creacionales.abstractFactory.dbAdapters.IDBAdapter;
import creacionales.abstractFactory.dbAdapters.MySqlAdapter;
import creacionales.abstractFactory.dbAdapters.OracleAdapter;
import creacionales.factoryMethod.util.PropertiesUtil;

public class DBFactory {
	
	private final static String DEFAULT_DB ="metaInfAbstractFactory/DBFactory.properties";
	private final static String DEFAULT_DB_PROPERTY="deafultDB";
	
	public static IDBAdapter getAdapter(DBType db) {
		switch(db) {
			case MySql: return new MySqlAdapter();
			case Oracle: return new OracleAdapter();
		}
		return null;
	}
	
	@SuppressWarnings("deprecation")
	public static IDBAdapter getDefaultAdapter(){
		try {
			Properties p = PropertiesUtil.loadProperty(DEFAULT_DB);
			String dbName = p.getProperty(DEFAULT_DB_PROPERTY);
			return (IDBAdapter) Class.forName(dbName).newInstance();
		}catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}

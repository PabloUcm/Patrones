package creacionales.abstractFactory.dbAdapters;

import java.sql.Connection;

public interface IDBAdapter {

	public Connection getConnection();
}

package dbHandler;

import java.sql.*;

public interface DbHandler 
{
	void createDatabase(Connection connection);
	void deleteDatabase(Connection connection);
	
	String getDatabaseName();
}

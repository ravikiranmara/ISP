package utils;

import java.sql.Date;

public class globals 
{
    static public String propertiesPath = "WEB-INF";
	static public String webInfPath = null;
	static public String webConfig_dbname = "dbname";
	static public String webConfig_dbdriver = "dbDriver";
	static public String webConfig_username = "username";
	static public String webConfig_password = "password";
	static public String webConfig_connString = "connectionString";
	static public int valid = 0;
	static public int invalid = 1;
	static public Date invalidDate =  java.sql.Date.valueOf( "1970-01-01" );
}

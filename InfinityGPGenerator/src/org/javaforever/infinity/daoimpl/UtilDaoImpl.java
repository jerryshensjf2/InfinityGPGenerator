package org.javaforever.infinity.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import org.javaforever.infinity.dao.UtilDao;
import org.javaforever.infinity.database.DBConf;
import org.javaforever.infinity.domain.Naming;
import org.javaforever.infinity.domain.Util;

public class UtilDaoImpl implements UtilDao{

	@Override
	public String generateUtilString(Naming naming, String standardName) throws Exception {
		 	Connection connection = DBConf.initDB();
	        String query = "SELECT * FROM utils where naming_id = ? and standard_name=?";
	        
	        PreparedStatement ps = connection.prepareStatement(query);
	        
	        ps.setLong(1,naming.getNamingid());
	        ps.setString(2, standardName);
	        String content = "";
	        ResultSet result = ps.executeQuery();

	        while(result.next()) {            
	        	content = result.getString("content");	            
	        }
	        DBConf.closeDB(connection);
	        return content;
	}

}

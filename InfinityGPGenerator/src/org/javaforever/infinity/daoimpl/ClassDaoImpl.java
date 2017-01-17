package org.javaforever.infinity.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.javaforever.infinity.dao.ClassDao;
import org.javaforever.infinity.database.DBConf;
import org.javaforever.infinity.domain.Class;
import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Naming;

public class ClassDaoImpl implements ClassDao {

	@Override
	public String generateClassString(Naming naming, String standardName)
			throws Exception {
		Class clazz = this.generateClass(naming, standardName);
		return clazz.generateClassString();
	}
	
	@Override
	public Class generateClass(Naming naming, String standardName)
			throws Exception {
		Connection connection = DBConf.initDB();
        String query = "SELECT * FROM domain,domain_fields,naming " +
        		"where domain.domain_id = domain_fields.domain_id " + 
        		"and naming.naming_id=domain.naming_id " +
        		"and naming.naming_id = ? " +
        		"and domain.domain_name=? ";
        
        PreparedStatement ps = connection.prepareStatement(query);
        
        ps.setLong(1,naming.getNamingid());
        ps.setString(2, standardName);
        Class domain = new Class();
        ResultSet result = ps.executeQuery();

        while(result.next()) {
   	
        }
        DBConf.closeDB(connection);     
		return null;
	}

}

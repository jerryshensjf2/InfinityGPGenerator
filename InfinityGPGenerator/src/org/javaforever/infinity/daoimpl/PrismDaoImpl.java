package org.javaforever.infinity.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.javaforever.infinity.dao.PrismDao;
import org.javaforever.infinity.database.DBConf;
import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.Naming;
import org.javaforever.infinity.domain.Prism;

public class PrismDaoImpl implements PrismDao {
	
	@Override
	public Prism generatePrism(Naming naming, String standardName,Domain domain)
			throws Exception {
		
		
		return null;
	}

	@Override
	public void generatePrismFiles(Prism prism) {
		// TODO Auto-generated method stub
		
	}

}

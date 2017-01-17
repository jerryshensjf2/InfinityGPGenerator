package test.javaforever.infinity.daoimpl;

import java.sql.Connection;

import junit.framework.Assert;

import org.javaforever.infinity.dao.DomainDao;
import org.javaforever.infinity.daoimpl.DomainDaoImpl;
import org.javaforever.infinity.database.DBConf;
import org.javaforever.infinity.domain.Naming;

import test.javaforever.infinity.database.DataSafeTestCase;

public class DomainDaoImplTest extends DataSafeTestCase {

	private DomainDao domainDao = new DomainDaoImpl();
     
	public DomainDao getDomainDao() {
		return domainDao;
	}

	public void setDomainDao(DomainDao domainDao) {
		this.domainDao = domainDao;
	}

	public void testGenerateDomainString() throws Exception
	{
		// prepare data
		Connection con = DBConf.getConnection();
		//con.prepareStatement("delete from domain;").executeUpdate();
		// Test begin
		Naming naming = new Naming();
		naming.setNamingid(8L);
		String domainStr = getDomainDao().generateDomainString(naming, "Leave");	
		System.out.println(domainStr);

		Assert.assertTrue(domainStr.length()>0);
		
		// Clean
		//con.prepareStatement("delete from domain;").executeUpdate();
		
	}
	

}

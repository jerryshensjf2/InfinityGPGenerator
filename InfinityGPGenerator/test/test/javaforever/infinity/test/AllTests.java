package test.javaforever.infinity.test;

import junit.framework.Test;
import junit.framework.TestSuite;

import org.javaforever.infinity.database.DBConf;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite("Test for default package");
		if (!DBConf.isTestsuiteOffline()){			
			//$JUnit-BEGIN$
//			suite.addTestSuite(PrivilegeDaoImplTest.class);

		} 
		//$JUnit-END$
		return suite;
	}
	
	public static void main(String[] args){
		junit.textui.TestRunner.run(suite());
	}
}

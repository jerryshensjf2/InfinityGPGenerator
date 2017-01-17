package test.javaforever.infinity.generator;

import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.TestCase;
import org.javaforever.infinity.generator.NamedStatementGenerator;
import org.javaforever.infinity.utils.InterVarUtil;
import org.junit.Test;

public class NamedStatementGeneratorTest extends TestCase{
	@Test
	public void testGenerateUpdateStatement(){
		Domain domain = new Domain();
		domain.setPackageToken("com.javaforever.infinity");
		domain.setStandardName("Employee");
		domain.addField("EmployeeId","long");
		domain.addField("Name", "String");
		domain.addField("Gender", "String");
		domain.addField("Age", "int");
		domain.addField("EmployeeDescription", "String");
		domain.addField("EmployeeComment","String");
		domain.addField("updateTime","Timestamp", "java.sql");
		
		System.out.println(NamedStatementGenerator.getUpdateSqlStatement(1000L, 2,domain, InterVarUtil.DB.query).getContentWithSerial());
		
	}
	
	@Test
	public void testDBConfInitDB(){
		System.out.println(NamedStatementGenerator.getDBConfInitDB(1000L, 2, InterVarUtil.DB.connection, InterVarUtil.DB.dbconf).getContentWithSerial());
	}
	
	@Test
	public void testDBConfCloseDB(){
		System.out.println(NamedStatementGenerator.getDBConfCloseDB(1000L, 2, InterVarUtil.DB.connection, InterVarUtil.DB.dbconf).getContentWithSerial());
	}
}

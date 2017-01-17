package test.javaforever.infinity.util;

import junit.framework.TestCase;

import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.utils.SqlReflector;
import org.javaforever.infinity.utils.StringUtil;
import org.junit.Assert;
import org.junit.Test;

public class StringUtilTest extends TestCase{
	@Test
	public void testChangeDomainFieldtoTableColum(){
		String s = "DomainNameTokenId";
		String result = StringUtil.changeDomainFieldtoTableColum(s);
		System.out.println(result);
		Assert.assertEquals("domain_name_token_id",result);
	}
	
	@Test
	public void testGenerateSelectAllStatement() throws Exception{
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
		
		System.out.println(SqlReflector.generateSelectAllStatement(domain));
	}
	
}

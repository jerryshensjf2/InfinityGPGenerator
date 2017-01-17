package test.javaforever.infinity.util;

import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.utils.DomainTokenUtil;
import org.junit.Test;

public class DomainTokenUtilTest {
	@Test
	public void testDomaintoCommaList(){
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
		
		System.out.println(DomainTokenUtil.generateTableCommaFields(domain));
	}
}

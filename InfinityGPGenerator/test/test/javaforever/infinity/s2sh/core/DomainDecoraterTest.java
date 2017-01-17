package test.javaforever.infinity.s2sh.core;

import org.javaforever.infinity.core.Verb;
import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.Field;
import org.javaforever.infinity.limitedverb.NoControllerVerb;
import org.javaforever.infinity.s2sh.core.S2SHDomainDecorater;
import org.javaforever.infinity.s2sh.verb.CountAllPage;
import org.javaforever.infinity.s2sh.verb.S2SHVerbFactory;
import org.junit.Test;

public class DomainDecoraterTest {
	@Test
	public void testDomainDecorater() throws Exception{

		
		Domain domain = new Domain();
		domain.setPackageToken("com.javaforever.infinity");
		domain.setStandardName("Employee");
		domain.setPlural("Employee");
		domain.addField("employeeId","long");
		domain.addField("name", "String");
		domain.addField("gender", "String");
		domain.addField("age", "int");
		domain.addField("employeeDescription", "String");
		domain.addField("employeeComment","String");
		domain.addField("updateTime","Timestamp", "java.sql");
		domain.setDomainId(new Field("employeeId", "long"));
		domain.setDomainName(new Field("employeeName", "String"));
		domain.setActive(new Field("active", "boolean"));
		
		System.out.println(S2SHDomainDecorater.generateDecroatedDomainString(domain));
	}
	
	
}

package test.javaforever.infinity.domain;

import org.javaforever.infinity.core.Verb;
import org.javaforever.infinity.core.VerbFactory;
import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.Field;
import org.javaforever.infinity.generator.JsonPagingGridJspTemplate;
import org.junit.Test;

public class JsonPagingGridJspTemplateTest {
	@Test
	public void testGridJspTemplate() throws Exception{
		Verb listAll = VerbFactory.getInstance("listAll");
		
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
		domain.setActive(new Field("active","boolean"));
		
		JsonPagingGridJspTemplate grid = new JsonPagingGridJspTemplate(domain);
		System.out.println(grid.generateJspString());
		System.out.println("===============WithSerial==================");
		System.out.println(grid.generateStatementList().getContentWithSerial());
	}
	
	
}

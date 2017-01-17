package test.javaforever.infinity.domain;

import org.javaforever.infinity.core.Verb;
import org.javaforever.infinity.core.VerbFactory;
import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.Field;
import org.javaforever.infinity.domain.JavascriptBlock;
import org.javaforever.infinity.domain.Type;
import org.javaforever.infinity.domain.Var;
import org.javaforever.infinity.generator.NamedJavascriptBlockGenerator;
import org.junit.Test;

public class JavascriptBlockTest {
	@Test
	public void testDocumentReadyListDomainList(){
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
		
		listAll.setDomain(domain);
		
		Var pagesize = new Var("pagesize",new Type("var"),"10");
		Var pagenum = new Var("pagenum",new Type("var"),"1");
		JavascriptBlock block = NamedJavascriptBlockGenerator.documentReadyListDomainList(domain, pagesize, pagenum);

		System.out.println("========================documentReadyListDomainList===========");
		System.out.println(block.generateBlockContentString());
		System.out.println("======================documentReadyListDomainListWithSerial====");
		System.out.println(block.generateBlockContentStringWithSerial());

	}

}

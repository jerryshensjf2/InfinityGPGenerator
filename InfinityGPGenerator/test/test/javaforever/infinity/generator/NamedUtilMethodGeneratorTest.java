package test.javaforever.infinity.generator;

import junit.framework.TestCase;

import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Type;
import org.javaforever.infinity.domain.Var;
import org.javaforever.infinity.generator.NamedStatementListGenerator;
import org.javaforever.infinity.generator.NamedUtilMethodGenerator;
import org.junit.Test;

public class NamedUtilMethodGeneratorTest extends TestCase{

	@Test
	public void testGenerateServletDoGetCallProcessRequestMethod() {
		Var request = new Var("request",new Type("HttpServletRequest","javax.servlet.http"));
		Var response = new Var("response",new Type("HttpServletResponse","javax.servlet.http"));
		Method method = NamedUtilMethodGenerator.generateServletDoGetCallProcessRequestMethod(2, request, response);
		System.out.println(method.generateMethodString());
	}
	
	@Test
	public void testGenerateServletDoPostCallProcessRequestMethod() {
		Var request = new Var("request",new Type("HttpServletRequest","javax.servlet.http"));
		Var response = new Var("response",new Type("HttpServletResponse","javax.servlet.http"));
		Method method = NamedUtilMethodGenerator.generateServletDoPostCallProcessRequestMethod(2, request, response);
		System.out.println(method.generateMethodString());
	}
	
	@Test
	public void testGenerateGetServletInfoMethod() {
		Method method = NamedUtilMethodGenerator.generateGetServletInfoMethod(2, "JerryTest");
		System.out.println(method.generateMethodString());
	}
}

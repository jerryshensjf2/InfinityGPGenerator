package test.javaforever.infinity.domain;

import junit.framework.TestCase;

import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Signature;
import org.javaforever.infinity.domain.Type;

public class MethodTest extends TestCase{
	public void testGetStandardCallString(){
		Method method = new Method();
		method.setStandardName("myMethod");
		
		Signature s1 = new Signature(0, "var1", new Type("int"));
		Signature s2 = new Signature(1, "myString", new Type("String"));
		
		method.addSignature(s1);
		method.addSignature(s2);
		
		System.out.println(method.getStandardCallString());
	}
}

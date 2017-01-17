package test.javaforever.infinity.domain;

import junit.framework.TestCase;

import org.javaforever.infinity.domain.Class;
import org.javaforever.infinity.domain.Field;
import org.javaforever.infinity.domain.Interface;
import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Signature;
import org.javaforever.infinity.domain.Type;
import org.junit.Test;

public class InterfaceTest extends TestCase {

	@Test
	public void testGenerateInterfaceString() {
		Interface ifc = new Interface();
		ifc.setStandardName("Leave");
		ifc.setPackageToken("com.javaforever.infinity");
		ifc.addField(new Field("id", "long"));
		ifc.addField(new Field("name", "String"));
		ifc.addField(new Field("comment", "String"));
		ifc.addField(new Field("description", "String"));
		ifc.addField(new Field("price", "double"));
		ifc.addField(new Field("amount", "int"));
		ifc.addField(new Field("updateTime", "Timestamp", "java.sql"));

		Method methoda = new Method();
		methoda.setStandardName("methoda");
		methoda.setReturnType(new Type("String"));
		Signature sig1 = new Signature(1, 0, "myid", new Type("long"));
		Signature sig2 = new Signature(2, 1, "mydescription", new Type("String"));
		methoda.addSignature(sig1);
		methoda.addSignature(sig2);
		methoda.setContent("// TODO:Jerry comments");

		ifc.addMethod(methoda);

		System.out.println(ifc.generateInterfaceString());
	}
}

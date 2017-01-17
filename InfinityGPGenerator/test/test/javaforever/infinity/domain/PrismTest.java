package test.javaforever.infinity.domain;

import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;

import org.javaforever.infinity.core.Verb;
import org.javaforever.infinity.domain.Controller;
import org.javaforever.infinity.domain.Dao;
import org.javaforever.infinity.domain.DaoImpl;
import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.Field;
import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Prism;
import org.javaforever.infinity.domain.Service;
import org.javaforever.infinity.domain.ServiceImpl;
import org.javaforever.infinity.domain.Signature;
import org.javaforever.infinity.domain.Type;
import org.javaforever.infinity.domain.ValidateInfo;
import org.javaforever.infinity.exception.ValidateException;
import org.javaforever.infinity.generator.DBDefinitionFactory;
import org.javaforever.infinity.generator.DBDefinitionGenerator;
import org.javaforever.infinity.generator.JspTemplate;
import org.javaforever.infinity.generator.JspTemplateFactory;
import org.javaforever.infinity.utils.StringUtil;
import org.javaforever.infinity.verb.ListAll;
import org.junit.Test;

public class PrismTest extends TestCase {
	@Test
	public void testGeneratePrismFiles()  throws Exception{
		try {
		Prism prism = new Prism();
		
		Domain domain = new Domain();
		domain.setStandardName("Employee");
		domain.setPlural("Employee");
		domain.addField("EmployeeId","long");
		domain.addField("Name", "String");
		domain.addField("Gender", "String");
		domain.addField("Age", "int");
		domain.addField("EmployeeDescription", "String");
		domain.addField("EmployeeComment","String");
		
		Field f = new Field("EmployeeId","long");
		domain.setDomainId(f);
		
		Method promotion = new Method();
		promotion.setStandardName("Promotion");
		List<Signature> signatures = new ArrayList<Signature>();
		signatures.add(new Signature(1,"employeeId",new Type("long")));
		signatures.add(new Signature(1,"positionId",new Type("long")));
		promotion.setSignatures(signatures);
		//promotion.setReturnType("void");
		domain.addMethod(promotion);
		
		prism.setDomain(domain);
		
		Dao dao = new Dao();
		dao.setDomain(domain);
		DaoImpl daoimpl = new DaoImpl();
		daoimpl.setDomain(domain);
		daoimpl.setDao(dao);
		
		Service service = new Service();
		service.setDomain(domain);
		ServiceImpl serviceimpl = new ServiceImpl(domain);
		serviceimpl.setDomain(domain);
		serviceimpl.setService(service);
		
		Verb listAll = new ListAll(domain);
	
		Controller c = new Controller(listAll,domain);
			
		prism.setDao(dao);
		prism.setDaoImpl(daoimpl);
		prism.setService(service);
		prism.setServiceImpl(serviceimpl);
		prism.addController(c);
		
		DBDefinitionGenerator dbg = DBDefinitionFactory.getInstance("mysql");
		dbg.setDbName("employee");
		prism.setDbDefinitionGenerator(dbg);	
		
		JspTemplate jt = JspTemplateFactory.getInstance("grid",domain);
		jt.setDomain(domain);
		jt.setStandardName("employee");
		
		prism.addJspTemplate(jt);
		
		prism.generatePrismFiles();
		} catch(ValidateException e){
			ValidateInfo info = e.getValidateInfo();
			for (String s : info.getCompileErrors()){
				System.out.println(s);
			}
		}
	}
}

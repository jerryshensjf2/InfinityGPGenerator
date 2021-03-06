package org.javaforever.infinity.s2sh.verb;

import java.util.ArrayList;
import java.util.List;

import org.javaforever.infinity.core.Writeable;
import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Signature;
import org.javaforever.infinity.domain.StatementList;
import org.javaforever.infinity.domain.Type;
import org.javaforever.infinity.domain.Var;
import org.javaforever.infinity.generator.NamedStatementListGenerator;
import org.javaforever.infinity.limitedverb.NoControllerVerb;
import org.javaforever.infinity.s2sh.core.NamedS2SHStatementGenerator;
import org.javaforever.infinity.s2sh.core.NamedS2SHStatementListGenerator;
import org.javaforever.infinity.utils.InterVarUtil;
import org.javaforever.infinity.utils.StringUtil;
import org.javaforever.infinity.utils.WriteableUtil;

public class CountSearchByNameByPage extends NoControllerVerb {

	@Override
	public Method generateDaoImplMethod() {		
			try {
				Method method = new Method();
				method.setStandardName("countSearch"+StringUtil.capFirst(this.domain.getPlural())+"ByNameByPage");
				method.setReturnType(new Type("int"));
				method.addAdditionalImport(this.domain.getPackageToken()+".domain."+this.domain.getStandardName());
				method.addSignature(new Signature(1, "name", new Type("String")));
				method.addSignature(new Signature(2, "pagesize", new Type("int")));
				method.setThrowException(true);
				method.addMetaData("Override");
				
				List<Writeable> list = new ArrayList<Writeable>();
				Var pageSize = new Var("pagesize",new Type("int"));
				StatementList sl = NamedS2SHStatementListGenerator.generateCountPageStatementList(2000L,2,this.domain,pageSize);
				list.add(sl);
				method.setMethodStatementList(WriteableUtil.merge(list));
				return method;
			} catch (Exception e){
				return null;
			}
	}

	@Override
	public String generateDaoImplMethodString() {
		Method m = this.generateDaoImplMethod();
		String s = m.generateMethodString();
		return s;
	}

	@Override
	public String generateDaoImplMethodStringWithSerial() {
		Method m = this.generateDaoImplMethod();
		m.setContent(m.generateMethodContentStringWithSerial());
		m.setMethodStatementList(null);
		return m.generateMethodString();
	}

	@Override
	public Method generateDaoMethodDefinition() {
		Method method = new Method();
		method.setStandardName("countAll"+StringUtil.capFirst(this.domain.getPlural())+"Page");
		method.setReturnType(new Type("int"));
		method.addAdditionalImport(this.domain.getPackageToken()+".domain."+this.domain.getStandardName());
		method.addSignature(new Signature(1, "name", new Type("String")));
		method.addSignature(new Signature(2, "pagesize", new Type("int")));
		method.setThrowException(true);
		return method;
	}

	@Override
	public String generateDaoMethodDefinitionString() {
		return generateDaoMethodDefinition().generateMethodDefinition();
	}

	@Override
	public Method generateServiceMethodDefinition() {
		Method method = new Method();
		method.setStandardName("countSearch"+StringUtil.capFirst(this.domain.getPlural())+"ByNameByPage");
		method.setReturnType(new Type("int"));
		method.addAdditionalImport(this.domain.getPackageToken()+".domain."+this.domain.getStandardName());
		method.addSignature(new Signature(1, "name", new Type("String")));
		method.addSignature(new Signature(2, "pagesize", new Type("int")));
		method.setThrowException(true);
		
		return method;
	}

	@Override
	public String generateServiceMethodDefinitionString() {
		return generateServiceMethodDefinition().generateMethodDefinition();
	}

	@Override
	public Method generateServiceImplMethod() {
		Method method = new Method();
		method.setStandardName("countSearch"+StringUtil.capFirst(this.domain.getPlural())+"ByNameByPage");
		method.setReturnType(new Type("int"));
		method.addSignature(new Signature(1, "name", new Type("String")));
		method.addSignature(new Signature(2, "pagesize", new Type("int")));
		method.addAdditionalImport(this.domain.getPackageToken()+".domain."+this.domain.getStandardName());
		method.addAdditionalImport(this.domain.getPackageToken()+".dao."+this.domain.getStandardName()+"Dao");
		method.addAdditionalImport(this.domain.getPackageToken()+".daoimpl."+this.domain.getStandardName()+"DaoImpl");
		method.addAdditionalImport(this.domain.getPackageToken()+".service."+this.domain.getStandardName()+"Service");
		method.setThrowException(true);
		method.addMetaData("Override");
		
		Method daomethod = this.generateDaoMethodDefinition();
		
		List<Writeable> list = new ArrayList<Writeable>();
		list.add(NamedS2SHStatementGenerator.generateServiceImplReturnInt(1000L, 2, InterVarUtil.DB.dao, daomethod));
		method.setMethodStatementList(WriteableUtil.merge(list));

		return method;
	}

	@Override
	public String generateServiceImplMethodString() {
		return generateServiceImplMethod().generateMethodString();
	}

	@Override
	public String generateServiceImplMethodStringWithSerial() {
		Method m = this.generateServiceImplMethod();
		m.setContent(m.generateMethodContentStringWithSerial());
		m.setMethodStatementList(null);
		return m.generateMethodString();
	}
	
	public CountSearchByNameByPage(Domain domain){
		super();
		this.domain = domain;
		this.verbName = "countSearch"+StringUtil.capFirst(this.domain.getPlural())+"ByNameByPage";
	}
	
	public CountSearchByNameByPage(){
		super();
	}

}

package org.javaforever.infinity.s2shc.verb;

import java.util.ArrayList;
import java.util.List;

import org.javaforever.infinity.core.Writeable;
import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Signature;
import org.javaforever.infinity.domain.Statement;
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

public class CountAllPage extends NoControllerVerb {

	@Override
	public Method generateDaoImplMethod() {		
			try {
				Method method = new Method();
				method.setStandardName("countAll"+StringUtil.capFirst(this.domain.getPlural())+"Page");
				method.setReturnType(new Type("int"));
				method.addAdditionalImport(this.domain.getPackageToken()+".domain."+this.domain.getStandardName());
				method.addSignature(new Signature(1, "pagesize", new Type("int")));
				method.setThrowException(true);
				method.addMetaData("Override");
				
				List<Writeable> list = new ArrayList<Writeable>();
				Var pageSize = new Var("pagesize",new Type("int"));
				Var recordCount = new Var("recordcount",new Type("int"));
				Var pageCount = new Var("pagecount",new Type("int"));
				Var countNum = new Var("countNum",new Type("String"));
				list.add(new Statement(1000L,2,"if ("+pageSize.getVarName()+" <= 0) "+pageSize.getVarName()+" = 10;"));
				list.add(new Statement(2000L,2,pageCount.getVarType() + " "+ pageCount.getVarName() + " = 1;"));
				list.add(new Statement(3000L,2,recordCount.getVarType() + " "+ recordCount.getVarName() + " = 0;"));
				list.add(new Statement(4000L,2, "Session s = this.getHibernateTemplate().getSessionFactory().getCurrentSession();"));
				list.add(new Statement(5000L,2,"Criteria criteria = s.createCriteria("+this.domain.getStandardName()+".class);"));
				list.add(new Statement(6000L,2,recordCount.getVarName() + " = criteria.list().size();"));
				list.add(new Statement(7000L,2,pageCount.getVarName()+" = (int)Math.ceil((double)"+ recordCount.getVarName() + "/"+pageSize.getVarName()+");"));
				list.add(new Statement(8000L,2,"if ("+ pageCount.getVarName() + " <= 1)"+ pageCount.getVarName() +" = 1;"));
				list.add(new Statement(9000L,2,"return "+pageCount.getVarName() +";"));

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
		method.addSignature(new Signature(1, "pagesize", new Type("int")));
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
		method.setStandardName("countAll"+StringUtil.capFirst(this.domain.getPlural())+"Page");
		method.setReturnType(new Type("int"));
		method.addAdditionalImport(this.domain.getPackageToken()+".domain."+this.domain.getStandardName());
		method.addSignature(new Signature(1, "pagesize", new Type("int")));
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
		method.setStandardName("countAll"+StringUtil.capFirst(this.domain.getPlural())+"Page");
		method.setReturnType(new Type("int"));
		method.addSignature(new Signature(1, "pagesize", new Type("int")));
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
	
	public CountAllPage(Domain domain){
		super();
		this.domain = domain;
		this.verbName = "countAll"+this.domain.getPlural()+"Page";
	}
	
	public CountAllPage(){
		super();
	}

}

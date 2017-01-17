package org.javaforever.infinity.s2sh.core;

import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Signature;
import org.javaforever.infinity.domain.Statement;
import org.javaforever.infinity.domain.StatementList;
import org.javaforever.infinity.domain.Type;
import org.javaforever.infinity.domain.Var;

public class S2SHNamedUtilMethodGenerator {
	public static Method generateStruts2SetRequestMethod(int indent, Var request, Var domainRequest){
		Method method = new Method();
		method.setStandardName("setRequest");
		method.setReturnType(new Type("void"));
		method.addAdditionalImport("java.util.Map");
		method.setThrowException(false);
		method.addSignature(new Signature(1,"request",new Type("Map<String, Object>","java.util")));
		method.addMetaData("Override");
		
		StatementList sl = new StatementList();
		sl.add(new Statement(100L,indent, domainRequest.getVarName() +" = "+request.getVarName()+";"));
		method.setMethodStatementList(sl);
		return method;
	}
	
	public static Method generateSetResponseJsonMethod(int indent, Var domainRequest, Var jsonMap){
		Method method = new Method();
		method.setStandardName("setResponseJson");
		method.setReturnType(new Type("void"));
		method.addAdditionalImport("java.util.Map");
		method.setThrowException(false);
		method.addSignature(new Signature(1,"responseJson",new Type("Map","java.util")));
		
		StatementList sl = new StatementList();
		sl.add(new Statement(100L,indent, "this."+domainRequest.getVarName() +" = "+jsonMap.getVarName()+";"));
		method.setMethodStatementList(sl);
		return method;
	}
	
	public static Method generateGetResponseJsonMethod(int indent, Var domainRequest, Var jsonMap){
		Method method = new Method();
		method.setStandardName("getResponseJson");
		method.setReturnType(new Type("Map","java.util"));
		method.addAdditionalImport("java.util.Map");
		method.setThrowException(false);
		
		StatementList sl = new StatementList();
		sl.add(new Statement(100L,indent, "return this."+domainRequest.getVarName()+";"));
		method.setMethodStatementList(sl);
		return method;
	}
	
	public static Method generateStruts2PrepareMethod(int indent){
		Method method = new Method();
		method.setStandardName("prepare");
		method.setReturnType(new Type("void"));
		method.setThrowException(true);
		method.addMetaData("Override");
		
		StatementList sl = new StatementList();
		sl.add(new Statement(100L,indent, "// TODO Auto-generated method stub"));
		method.setMethodStatementList(sl);
		return method;
	}

}

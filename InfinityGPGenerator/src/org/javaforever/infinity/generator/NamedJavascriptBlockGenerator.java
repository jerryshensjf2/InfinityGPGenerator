package org.javaforever.infinity.generator;

import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.JavascriptBlock;
import org.javaforever.infinity.domain.Statement;
import org.javaforever.infinity.domain.StatementList;
import org.javaforever.infinity.domain.Var;
import org.javaforever.infinity.utils.StringUtil;


public class NamedJavascriptBlockGenerator {
	public static JavascriptBlock documentReadyListDomainList(Domain domain, Var pagesize,Var pagenum){
		JavascriptBlock block = new JavascriptBlock();
		block.setSerial(100);
		block.setStandardName("documentReadyList"+domain.getCapFirstDomainName()+"List");
		StatementList sl = new StatementList();
		sl.add(new Statement(1000,0, "$(document).ready(function(){"));
		sl.add(new Statement(2000,1, "listAll"+StringUtil.capFirst(domain.getPlural())+"ByPage("+pagesize.getVarName()+","+pagenum.getVarName()+");"));
		sl.add(new Statement(3000,0, "});"));
		block.setMethodStatementList(sl);
		return block;
	}
}

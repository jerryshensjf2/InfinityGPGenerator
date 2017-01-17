package org.javaforever.infinity.s2sh.core;

import org.javaforever.infinity.domain.Controller;
import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.Field;
import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Statement;
import org.javaforever.infinity.domain.StatementList;
import org.javaforever.infinity.domain.Var;
import org.javaforever.infinity.utils.FieldUtil;
import org.javaforever.infinity.utils.SqlReflector;
import org.javaforever.infinity.utils.StringUtil;

public class S2SHJSPNamedStatementGenerator {
	public static Statement getJSPStartTag(long serial,int indent){
		try {
			Statement statement = new Statement(serial,indent,"<%");
			return statement;
		} catch (Exception e){
			return null;
		}
	}
	
	public static Statement getJSPEndTag(long serial,int indent){
		try {
			Statement statement = new Statement(serial,indent,"%>");
			return statement;
		} catch (Exception e){
			return null;
		}
	}

	public static Statement getSetContentUTF8(long serial,int indent){
		try {
			Statement statement = new Statement(serial,indent,"<%@page contentType=\"text/html\" pageEncoding=\"UTF-8\"%>");
			return statement;
		} catch (Exception e){
			return null;
		}
	}
	
	public static Statement getHideInputDomainIdStatement(long serial,int indent,Domain domain, Var mydomain){
		try {
			Statement statement = new Statement(serial,indent,"<input type='hidden' name='"+domain.getLowerFirstDomainName()+"."+domain.getDomainId().getFieldName()+"' value='<%="+mydomain.getVarName()+".get"+StringUtil.capFirst(domain.getDomainId().getFieldName())+"()%>'/>");
			return statement;
		} catch (Exception e){
			return null;
		}
	}
	
	public static Statement getSetImportStatement(long serial,int indent, Var clazz){
		try {
			Statement statement = new Statement(serial,indent,"<%@page import=\""+clazz.getVarType().getPackageToken()+"."+clazz.getVarType().getTypeName()+"\" %>");
			return statement;
		} catch (Exception e){
			return null;
		}
	}
	
	public static Statement getSetAddFormStatement(long serial,int indent,Domain domain,Method addMethod){
		try {
			Statement statement = new Statement(serial,indent,"<form action='../action/"+StringUtil.lowerFirst(addMethod.getStandardName())+"' method='post'>");
			return statement;
		} catch (Exception e){
			return null;
		}
	}
	
	public static Statement getFormEndStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"</form>");
		return statement;
	}
	
	public static Statement getTdStartStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"<td>");
		return statement;
	}
	
	public static Statement getTdEndStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"</td>");
		return statement;
	}
	
	public static Statement getTrStartStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"<tr>");
		return statement;
	}
	
	public static Statement getTrEndStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"</tr>");
		return statement;
	}
	
	public static Statement getTableEndStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"</table>");
		return statement;
	}
	
	public static Statement getTableStartStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"<table>");
		return statement;
	}
	
	public static Statement getTableWithAAClassStartStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"<table class=\"aatable\">\n");
		return statement;
	}
	
	public static Statement getDivEndStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"</div>");
		return statement;
	}
	
	public static Statement getDivStartStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"<div>");
		return statement;
	}	
	
	public static Statement getSpanEndStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"</span>");
		return statement;
	}
	
	public static Statement getSpanStartStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"<span>");
		return statement;
	}
	
	public static Statement getBodyEndStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"</body>");
		return statement;
	}
	
	public static Statement getBodyStartStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"<body>");
		return statement;
	}
	
	public static Statement getHtmlEndStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"</html>");
		return statement;
	}
	
	public static Statement getHtmlStartStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"<html>");
		return statement;
	}
	
	public static Statement getJavaNotionEndStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"%>");
		return statement;
	}
	
	public static Statement getJavaNotionStartStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"<%");
		return statement;
	}
	
	public static Statement getLoopEndWithJavaNotionStatement(long serial,int indent){
		Statement statement = new Statement(serial,indent,"<% } %>");
		return statement;
	}
	
	public static Statement getSubmitButtonStatement(long serial,int indent,String buttonValue){
		try {
			Statement statement = new Statement(serial,indent,"<input type='submit' value='"+buttonValue+"' />");
			return statement;
		} catch (Exception e){
			return null;
		}
	}
	
	public static Statement getBrStatement(long serial,int indent){
		try {
			Statement statement = new Statement(serial,indent,"<br />");
			return statement;
		} catch (Exception e){
			return null;
		}
	}
}


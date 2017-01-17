package org.javaforever.infinity.s2sh.core;

import java.util.HashSet;

import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.Field;
import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.exception.ValidateException;
import org.javaforever.infinity.utils.StringUtil;
import org.javaforever.infinity.utils.TableStringUtil;

public class S2SHDomainDecorater {
	public static Domain generateDecroatedDomain(Domain domain) throws ValidateException{
		domain.addClassImports("javax.persistence.Column");
		domain.addClassImports("javax.persistence.Entity");
		domain.addClassImports("javax.persistence.GeneratedValue");
		domain.addClassImports("javax.persistence.Id");
		domain.addClassImports("javax.persistence.Table");
		domain.addClassImports("javax.persistence.UniqueConstraint");
		domain.addClassAnnotation("Entity");
		domain.addClassAnnotation("Table(name = \""+TableStringUtil.domainNametoLowerTableName(domain)+"\", uniqueConstraints = { @UniqueConstraint(columnNames = { \""+StringUtil.changeDomainFieldtoTableColum(domain.getDomainName().getFieldName())+"\" }) })");
		domain.setSetters(new HashSet<Method>());
		domain.setGetters(new HashSet<Method>());
		for (Field f:domain.getFields()){
			domain.generateSetterGetter(f);
		}
		for (Method m:domain.getGetters()){
			if (m.getLowerFirstMethodName().equals("get"+domain.getDomainId().getCapFirstFieldName())){				
				m.addMetaData("Column(name = \""+StringUtil.changeDomainFieldtoTableColum(domain.getDomainId().getFieldName())+"\")");
				m.addMetaData("GeneratedValue");
				m.addMetaData("Id");
			}else{
				m.addMetaData("Column(name=\""+StringUtil.changeDomainFieldtoTableColum(m.getStandardName().substring(3))+"\""+(m.getReturnType().generateTypeString().equals("String")?", length = 255 ":"")+")");	
			}
		}
		return domain;
	}
	
	public static String generateDecroatedDomainString(Domain domain) throws Exception{
		return generateDecroatedDomain(domain).generateClassString();
	}
}

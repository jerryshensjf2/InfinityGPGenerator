package org.javaforever.infinity.utils;

import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.exception.ValidateException;

public class TableStringUtil {
	public static String domainNametoTableName(Domain domain) throws Exception {
		return StringUtil.changeDomainFieldtoTableColum(domain.getPlural());
	}
	
	public static String domainNametoCapTableName(Domain domain) throws Exception {
		return (domain.getDbPrefix()+StringUtil.changeDomainFieldtoTableColum(domain.getPlural())).toUpperCase();
	}
	
	public static String domainNametoLowerTableName(Domain domain) throws ValidateException {
		return (domain.getDbPrefix()+StringUtil.changeDomainFieldtoTableColum(domain.getPlural())).toLowerCase();
	}
}

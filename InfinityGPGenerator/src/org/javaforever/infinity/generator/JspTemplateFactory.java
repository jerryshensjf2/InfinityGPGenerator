package org.javaforever.infinity.generator;

import org.javaforever.infinity.domain.Domain;

public class JspTemplateFactory {
	public static JspTemplate getInstance(String type,Domain domain) throws Exception{
		switch (type) {
			case "grid" : return new GridJspTemplate(domain);
			case "pagingGrid" : return new PagingGridJspTemplate(domain);
			case "onlyloginindex":
						  return new OnlyLoginIndexJspTemplate();
			case "jsonPagingGrid": return new JsonPagingGridJspTemplate(domain);
			case "s2shJsonPagingGrid": return new org.javaforever.infinity.s2sh.core.JsonPagingGridJspTemplate(domain);
			default		: return null;
		}
	}
}

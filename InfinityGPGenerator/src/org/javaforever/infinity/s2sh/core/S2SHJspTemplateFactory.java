package org.javaforever.infinity.s2sh.core;

import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.exception.ValidateException;
import org.javaforever.infinity.generator.JspTemplate;

public class S2SHJspTemplateFactory {
	public static JspTemplate getInstance(String type,Domain domain) throws Exception {
		switch (type) {
			case "grid" : return new GridJspTemplate(domain);
			case "pagingGrid" : return new PagingGridJspTemplate(domain);
			case "onlyloginindex":
						  return new OnlyLoginIndexJspTemplate();
			default		: return null;
		}
	}
}

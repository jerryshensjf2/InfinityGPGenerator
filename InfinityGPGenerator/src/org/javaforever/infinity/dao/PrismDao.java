package org.javaforever.infinity.dao;

import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.Naming;
import org.javaforever.infinity.domain.Prism;

public interface PrismDao {
	public Prism generatePrism(Naming naming, String standardName,Domain domain) throws Exception;
	public void generatePrismFiles(Prism prism);
}

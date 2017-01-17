package org.javaforever.infinity.dao;

import org.javaforever.infinity.domain.Class;
import org.javaforever.infinity.domain.Naming;

public interface ClassDao {
	public Class generateClass(Naming naming, String standardName) throws Exception;
	public String generateClassString(Naming naming, String standardName) throws Exception;
}

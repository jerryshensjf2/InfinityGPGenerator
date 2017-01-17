package org.javaforever.infinity.dao;

import java.util.List;

import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Naming;

public interface UtilDao {
	public String generateUtilString(Naming naming, String standardName) throws Exception;

}

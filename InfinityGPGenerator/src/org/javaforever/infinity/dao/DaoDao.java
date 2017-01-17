package org.javaforever.infinity.dao;

import java.util.List;

import org.javaforever.infinity.core.Verb;
import org.javaforever.infinity.domain.Class;
import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.Interface;
import org.javaforever.infinity.domain.Naming;

public interface DaoDao {
	public Interface generateDao(Domain domain, List<Verb> verbs) throws Exception;
	public Class generateDaoImpl(Domain domain, List<Verb> verbs) throws Exception;	
}

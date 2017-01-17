package org.javaforever.infinity.dao;

import java.util.List;

import org.javaforever.infinity.domain.Class;
import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.Interface;
import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Naming;

public interface ServiceDao {
	public Interface generateService(Naming naming, Domain domain,List<Method> methods) throws Exception;
	public Class generateServiceImpl(Naming naming, Domain domain,List<Method> methods) throws Exception;
}

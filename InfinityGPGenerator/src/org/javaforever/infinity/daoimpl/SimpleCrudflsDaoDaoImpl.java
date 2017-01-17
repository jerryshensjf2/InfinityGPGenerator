package org.javaforever.infinity.daoimpl;

import java.util.List;

import org.javaforever.infinity.core.Verb;
import org.javaforever.infinity.dao.DaoDao;
import org.javaforever.infinity.domain.Class;
import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.Interface;
import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Naming;

public class SimpleCrudflsDaoDaoImpl implements DaoDao{

	@Override
	public Interface generateDao(Domain domain,List<Verb> verbs) throws Exception {
		Interface dao = new Interface();
		return null;
	}

	@Override
	public Class generateDaoImpl(Domain domain,List<Verb> verbs) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}

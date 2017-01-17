package org.javaforever.infinity.daoimpl;

import java.util.List;

import org.javaforever.infinity.dao.ServiceDao;
import org.javaforever.infinity.domain.Class;
import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.Interface;
import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Naming;
import org.javaforever.infinity.domain.Service;

public class ServiceDaoImpl implements ServiceDao{

	@Override
	public Interface generateService(Naming naming, Domain domain,List<Method> methods)
			throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Class generateServiceImpl(Naming naming, Domain domain,List<Method> methods) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Class generateServiceImpl(Service service) throws Exception {
		return null;
	}
	
	public Service generateService(){
		return null;
	}
}

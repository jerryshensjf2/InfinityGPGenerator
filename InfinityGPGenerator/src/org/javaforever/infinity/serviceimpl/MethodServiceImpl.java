package org.javaforever.infinity.serviceimpl;

import java.util.List;

import org.javaforever.infinity.dao.MethodDao;
import org.javaforever.infinity.daoimpl.MethodDaoImpl;
import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Naming;
import org.javaforever.infinity.service.MethodService;

public class MethodServiceImpl implements MethodService{
	private MethodDao methodDao = new MethodDaoImpl();

	@Override
	public boolean validateMethodSignature(List<String> signature)
			throws Exception {
		return methodDao.validateMethodSignature(signature);
	}

	@Override
	public Method generateMethod(Naming naming, String standardName)
			throws Exception {
		return methodDao.generateMethod(naming, standardName);
	}

	@Override
	public String generateMethodToString(Naming naming, String standardName)
			throws Exception {
		return methodDao.generateMethodToString(naming, standardName);
	}

	@Override
	public String generateMethodSkeleton(Naming naming, String standardName)
			throws Exception {
		return methodDao.generateMethodSkeleton(naming, standardName);
	}

	@Override
	public String generateMethodContent(Naming naming, String standardName)
			throws Exception {
		return methodDao.generateMethodContent(naming, standardName);
	}

}

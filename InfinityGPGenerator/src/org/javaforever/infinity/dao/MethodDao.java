package org.javaforever.infinity.dao;

import java.util.List;
import java.util.Map;

import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Naming;
import org.javaforever.infinity.domain.Signature;

public interface MethodDao {
	public boolean validateMethodSignature(List<String> signature) throws Exception;

	public Method generateMethod(Naming naming,String standardName) throws Exception;
	public Method generateMethod(Naming naming, String standardName,Map<String, String> vars) throws Exception;
	public String generateMethodToString(Naming naming, String standardName) throws Exception;
	public String generateMethodSkeleton(Naming naming, String standardName) throws Exception;
	public String generateMethodContent(Naming naming, String standardName) throws Exception;
	public Method generateMethod(Naming naming, String standardName, String returnVal, List<Signature> signatures) throws Exception;
}

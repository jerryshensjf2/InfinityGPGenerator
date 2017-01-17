package org.javaforever.infinity.service;

import java.util.List;

import org.javaforever.infinity.domain.Method;
import org.javaforever.infinity.domain.Naming;

public interface MethodService {
	public boolean validateMethodSignature(List<String> signature) throws Exception;

	public Method generateMethod(Naming naming,String standardName) throws Exception;
	public String generateMethodToString(Naming naming, String standardName) throws Exception;
	public String generateMethodSkeleton(Naming naming, String standardName) throws Exception;
	public String generateMethodContent(Naming naming, String standardName) throws Exception;

}

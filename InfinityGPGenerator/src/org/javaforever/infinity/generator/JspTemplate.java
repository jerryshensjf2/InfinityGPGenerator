package org.javaforever.infinity.generator;

import java.util.ArrayList;
import java.util.List;

import org.javaforever.infinity.core.Verb;
import org.javaforever.infinity.domain.Controller;
import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.domain.StatementList;

public abstract class JspTemplate {
	protected Domain domain;
	protected List<Controller> controllers = new ArrayList<Controller>();
	protected List<Verb> verbs = new ArrayList<Verb>();
	protected String standardName;
	
	public abstract String generateJspString();
	
	public abstract StatementList generateStatementList();

	public Domain getDomain() {
		return domain;
	}

	public void setDomain(Domain domain) {
		this.domain = domain;
	}


	public List<Controller> getControllers() {
		return controllers;
	}

	public void setControllers(List<Controller> controllers) {
		this.controllers = controllers;
	}

	public List<Verb> getVerbs() {
		return verbs;
	}

	public void setVerbs(List<Verb> verbs) {
		this.verbs = verbs;
	}

	public String getStandardName() {
		return standardName;
	}

	public void setStandardName(String standardName) {
		this.standardName = standardName;
	}

}

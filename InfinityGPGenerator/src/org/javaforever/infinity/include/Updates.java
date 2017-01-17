package org.javaforever.infinity.include;

import org.javaforever.infinity.domain.Include;

public class Updates extends Include{
	public Updates(){
		super();
		this.fileName = "updates.jsp";
		this.packageToken = "";
	}
	
	public Updates(String title, String year){
		super();
		this.fileName = "updates.jsp";
		this.packageToken = "";
	}

	@Override
	public String generateIncludeString() {
		StringBuilder sb = new StringBuilder(" ");
		return sb.toString();
	}
}

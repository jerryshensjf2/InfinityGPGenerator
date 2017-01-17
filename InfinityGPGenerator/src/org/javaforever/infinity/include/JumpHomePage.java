package org.javaforever.infinity.include;

import org.javaforever.infinity.domain.Include;

public class JumpHomePage extends Include{
	public JumpHomePage(){
		super();
		this.fileName = "index.jsp";
		this.packageToken = "";
	}

	@Override
	public String generateIncludeString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<html>\n");
		sb.append("<head>\n");
		sb.append("<meta http-equiv=\"refresh\"  content=\"0;url=jsp/index.jsp\"/>\n");
		sb.append("</head>\n");
		sb.append("<body>\n");
		sb.append("</body>\n");
		return sb.toString();
	}

}

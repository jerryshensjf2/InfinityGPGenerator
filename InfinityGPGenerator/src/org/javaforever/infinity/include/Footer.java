package org.javaforever.infinity.include;

import org.javaforever.infinity.domain.Include;

public class Footer extends Include{
	protected String company = "Mind Rules";
	
	public Footer(){
		super();
		this.fileName = "footer.jsp";
		this.packageToken = "";
	}
	
	public Footer(String company){
		super();
		this.fileName = "footer.jsp";
		this.packageToken = "";
		this.company = company;
	}

	@Override
	public String generateIncludeString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<!-- Common footer for our site -->");
		sb.append("<div id=\"footer_wide\">");
		sb.append("\t<p id=\"legal\">Copyright &copy; 2014  "+this.company+". Author:jerry_shen_sjf@qq.com  QQ group:277689737<br/>");
		sb.append("\t</p>");
		sb.append("\t</div>");
		return sb.toString();
	}
}

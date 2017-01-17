package org.javaforever.infinity.database;

import java.util.Properties;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.net.URL;

public class ParseXML {
	// 定义一个Properties 用来存放 dbhost dbuser dbpassword的值
	private Properties props;

	// 这里的props
	public Properties getProps() {
		return this.props;
	}

	public synchronized void parse(String filename) {
		// 将我们的解析器对象化
		ConfigParser handler = new ConfigParser();
		// 获取SAX工厂对象
		SAXParserFactory factory = SAXParserFactory.newInstance();
		factory.setNamespaceAware(false);
		factory.setValidating(false);
		// 获取SAX解析
		SAXParser parser = null;
		try {
			parser = factory.newSAXParser();
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		URL confURL = null;
		// 得到配置文件config.xml所在目录eclipse中是在WEB-INF/classes/config.xml,

		// 该config.xml必须放在classes文件夹中，否则会报java.lang.NullPointerException错误。
		try {
			confURL = ParseXML.class.getClassLoader().getResource(filename);
			// 只需要将我们所需要的XML文件名字输入进去就可以了！
		} catch (Exception e) {
			System.out.print(e.toString());
		}
		try { // 将解析器和解析对象config.xml联系起来,开始解析
			parser.parse(confURL.toString(), handler);
			// 获取解析成功后的属性 以后 我们其他应用程序只要调用本程序的props就可以提取出属性名称和值了
			props = handler.getProps();
		} catch (Exception e) {
			System.out.println(e.toString());
		} finally {
			factory = null;
			parser = null;
			handler = null;
		}
	}
}

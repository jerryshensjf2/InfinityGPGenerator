package org.javaforever.infinity.generator;

import org.javaforever.infinity.utils.SqlReflector;

public class DBDefinitionFactory {
	public static DBDefinitionGenerator getInstance(String type){
		switch (type) {
		case "mysql" : return new MysqlDBDefinitionGenerator();
		default : return null;
		}
	}
}

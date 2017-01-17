package org.javaforever.infinity.utils;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.javaforever.infinity.core.Writeable;
import org.javaforever.infinity.domain.Statement;
import org.javaforever.infinity.domain.StatementList;

public class WriteableUtil {
	public static StatementList merge(List<Writeable> cw){
		StatementList sc = new StatementList();
		Collections.sort(cw);
		long ii = 100;
		for (Writeable wc:cw){
			if (wc instanceof Statement) {
				Statement s = (Statement)wc;
				s.setSerial(ii);
				sc.add(s);
				ii += 100;
			}
			else if (wc instanceof StatementList){
				List<Statement> list = ((StatementList) wc).getStatementList();
				Collections.sort(list);
				for (Statement s:list){
					s.setSerial(ii);
					ii += 100;
					sc.add(s);
				}
			}
		}
		return sc;
	}
}

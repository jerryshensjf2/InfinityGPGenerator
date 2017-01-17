package org.javaforever.infinity.core;

import org.javaforever.infinity.domain.Domain;
import org.javaforever.infinity.verb.Add;
import org.javaforever.infinity.verb.AddAll;
import org.javaforever.infinity.verb.Delete;
import org.javaforever.infinity.verb.DeleteAll;
import org.javaforever.infinity.verb.FindById;
import org.javaforever.infinity.verb.FindByName;
import org.javaforever.infinity.verb.ListActive;
import org.javaforever.infinity.verb.ListAll;
import org.javaforever.infinity.verb.ListAllByPage;
import org.javaforever.infinity.verb.ListMy;
import org.javaforever.infinity.verb.SearchByComment;
import org.javaforever.infinity.verb.SearchByDescription;
import org.javaforever.infinity.verb.SearchByField;
import org.javaforever.infinity.verb.SearchByName;
import org.javaforever.infinity.verb.SearchByNameByPage;
import org.javaforever.infinity.verb.SoftDelete;
import org.javaforever.infinity.verb.SoftDeleteAll;
import org.javaforever.infinity.verb.Update;
import org.javaforever.infinity.verb.UpdateAll;

public class VerbFactory {
	public static Verb getInstance(String type){
		switch (type){
		case "listAll": 		return new ListAll();
		case "listMy":			return new ListMy();
		case "listActive":		return new ListActive();
		case "findById": 		return new FindById();
		case "findByName":		return new FindByName();
		case "delete":			return new Delete();
		case "deleteAll":		return new DeleteAll();
		case "softDelete":		return new SoftDelete();
		case "softDeleteAll":	return new SoftDeleteAll();
		case "add":				return new Add();
		case "addAll":			return new AddAll();
		case "update":			return new Update();
		case "updateAll":		return new UpdateAll();
		case "searchByName":	return new SearchByName();
		case "searchByNameByPage":	return new SearchByNameByPage();
		case "searchByDescription": return new SearchByDescription();
		case "searchByComment": return new SearchByDescription();
		case "searchByField": 	return new SearchByDescription();
		case "listAllByPage":	return new ListAllByPage();
		default:			return null;
		}
	}
	
	public static Verb getInstance(String type, Domain domain){
		switch (type){
		case "listAll": 		return new ListAll(domain);
		case "listActive":		return new ListActive(domain);
		case "findById": 		return new FindById(domain);
		case "findByName":		return new FindByName(domain);
		case "delete":			return new Delete(domain);
		case "deleteAll":		return new DeleteAll(domain);
		case "softDelete":		return new SoftDelete(domain);
		case "softDeleteAll":	return new SoftDeleteAll(domain);
		case "add":				return new Add(domain);
		case "addAll":			return new AddAll(domain);
		case "update":			return new Update(domain); 
		case "updateAll":		return new UpdateAll(domain);
		case "searchByName":	return new SearchByName(domain);
		case "searchByNameByPage":	return new SearchByNameByPage(domain);
		case "listAllByPage":	return new ListAllByPage(domain);
		default:			return null;
		}
	}
	
	public static Verb getInstance(String type, Domain domain, String fieldName){
		switch (type){
		case "searchByDescription": return new SearchByDescription(domain,fieldName);
		case "searchByComment": return new SearchByComment(domain,fieldName); 
		case "searchByField": 	return new SearchByField(domain,fieldName);
		case "listMy": 	return new ListMy(domain,fieldName);
		default:			return null;
		}
	}
}

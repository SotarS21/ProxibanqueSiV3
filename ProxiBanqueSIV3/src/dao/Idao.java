package dao;

import java.util.List;

public interface Idao {

	public <T> List<T> getAllElement(Class<T> classType,String table);
	
}

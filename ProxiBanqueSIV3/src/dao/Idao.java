package dao;

import java.util.List;


public interface Idao {

	public void initDao();
	
	
	public void connection();
	
	public void deconnection();
	
	public <T> void updateObj(T obj);
	public <T> T getElementById(Class<T> classType, long id);
	public <T> void removeObject(Class<T> classType , long id);
	public <T> void AddObject(T obj);
	
	public <T> List<T> getElementsByType(Class<T> classType,String table);
	
}

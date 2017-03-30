package dao;

import java.util.List;

import metier.*;

public interface Idao {

	public void connection();
	
	public void deconnection();
	
	public <T> void updateObj(T obj);
	public <T> T getElementById(Class<T> classType, long id);
	public <T> void removeObject(T obj);
	public <T> void AddObject(T obj);
	public <T> List<T> getElementsByType(Class<T> classtype);
	
	
}

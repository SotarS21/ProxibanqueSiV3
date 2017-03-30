package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import metier.Person;


public class linkDao implements Idao{

	private  static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Carambar");
	private static EntityManager em ;
	
	
	@Override
	public void connection()
	{
		em = emf.createEntityManager();
		
	}
	

	@Override
	public <T> void AddObject(T obj)
	{
		
		
		try
		{
			linkDao.em.getTransaction().begin();
		
			linkDao.em.persist(obj);

			linkDao.em.getTransaction().commit();
		}
		catch (Exception e) {
			if (linkDao.em != null)
				linkDao.em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			
		}
	}

	@Override
	public <T> void removeObject(T obj)
	{
		
		
		try
		{
			linkDao.em.getTransaction().begin();
		
			linkDao.em.remove(obj);

			linkDao.em.getTransaction().commit();
		}
		catch (Exception e) {
			if (linkDao.em != null)
				linkDao.em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
		}
	}
	@Override
	public <T> T getElementById(Class<T> classType, long id)
	{
		T ret = null;
		
		try
		{
			linkDao.em.getTransaction().begin();
		
		ret = (T) em.find(classType, id);

		linkDao.em.getTransaction().commit();
		}
		catch (Exception e) {
			if (linkDao.em != null)
				linkDao.em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			
		}
		return ret;
	}

	@Override
	public <T> void updateObj(T obj)
	{

		try
		{
			linkDao.em.getTransaction().begin();
		
			linkDao.em.merge(obj);

			linkDao.em.getTransaction().commit();
		}
		catch (Exception e) {
			if (linkDao.em != null)
				linkDao.em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			
		}
	}
	

	@Override
	public void deconnection()
	{
		if (em != null)
			linkDao.em.close();
		if (emf != null)
			emf.close();
		
	}


	@Override
	public <T> List<T> getElementsByType(Class<T> classtype) {
		
		List<T> retList = new ArrayList<>();
		
		return retList;
	}
	
	
}

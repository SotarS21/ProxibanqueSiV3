package dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;


@Named
public class linkDao implements Idao{

	private  static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Carambar");
	private static EntityManager em ;
	
	
	public linkDao(){
		
	}
	
	@Override
	public void connection()
	{
		em = emf.createEntityManager();
		
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
	public <T> void removeObject(Class<T> classType ,long id)
	{
		
		try
		{
			linkDao.em.getTransaction().begin();
		
			T obj = (T) em.find(classType, id);
			
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
	public <T> List<T> getElementsByType(Class<T> classType, String table) {
		connection();
		List<T> list = null ;
		String sql = "SELECT c FROM "+ table + " c ";
		EntityTransaction etxn = linkDao.em.getTransaction();
		try {
			etxn.begin();
			TypedQuery<T> query = linkDao.em.createQuery(sql, classType);
			list = query.getResultList();
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null)
				linkDao.em.getTransaction().rollback();
			System.out.println(e.getMessage());
			
		} finally {
		}
		return list;
	}

	@Override
	public void initDao() {
		
		System.out.println("init");
	}
	
	
}

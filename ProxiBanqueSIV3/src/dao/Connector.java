package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

public class Connector {

	private  static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Carambar");
	private static EntityManager em ;
	
	
	private static class Holder {
        static final Connector INSTANCE = new Connector();
    }

    public static Connector getInstance() {
        return Holder.INSTANCE;
    } 
	
	public void connection()
	{
		em = emf.createEntityManager();
		
	}
	
	
	public <T> void AddObject(T obj)
	{
		
		
		try
		{
			Connector.em.getTransaction().begin();
		
			Connector.em.persist(obj);

			Connector.em.getTransaction().commit();
		}
		catch (Exception e) {
			if (Connector.em != null)
				Connector.em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			Connector.em.close();			
		}
	}
	
	public <T> void removeObject(T obj)
	{
		
		
		try
		{
			Connector.em.getTransaction().begin();
		
			Connector.em.remove(obj);

			Connector.em.getTransaction().commit();
		}
		catch (Exception e) {
			if (Connector.em != null)
				Connector.em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			Connector.em.close();
		}
	}
	
	
	public <T> List<T> getAllElement(Class<T> classType,String table) {

		List<T> list = null ;
		String sql = "SELECT c FROM "+ table + " c ";
		EntityTransaction etxn = Connector.em.getTransaction();
		try {
			etxn.begin();
			TypedQuery<T> query = Connector.em.createQuery(sql, classType);
			list = query.getResultList();
			etxn.commit();
		} catch (Exception e) {
			if (etxn != null)
				Connector.em.getTransaction().rollback();
			System.out.println(e.getMessage());
			
		} finally {
			if (em != null)
				Connector.em.close();
		}
		return list;
	}
	
	public <T> T getElementById(Class<T> classType, long id)
	{
		T ret = null;
		
		try
		{
			Connector.em.getTransaction().begin();
		
		ret = (T) em.find(classType, id);

		Connector.em.getTransaction().commit();
		}
		catch (Exception e) {
			if (Connector.em != null)
				Connector.em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			Connector.em.close();
		}
		return ret;
	}
	
	public <T> void updateObj(T obj)
	{

		try
		{
			Connector.em.getTransaction().begin();
		
			Connector.em.merge(obj);

			Connector.em.getTransaction().commit();
		}
		catch (Exception e) {
			if (Connector.em != null)
				Connector.em.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			Connector.em.close();
		}
	}
	
	
	public void deconnection()
	{
		if (em != null)
			Connector.em.close();
		if (emf != null)
			emf.close();
		
	}
	
	
}

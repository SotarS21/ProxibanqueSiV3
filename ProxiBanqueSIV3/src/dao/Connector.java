package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
		}
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

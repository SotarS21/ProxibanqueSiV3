package dao;

import static org.junit.Assert.*;

import org.junit.Test;

import metier.Client;

public class dao {


	Idao idao = new linkDao();
	Client client = new Client("toto", "tata");
	
	@Test
	public void addclientToDB() {
		
		idao.AddObject(client );
		
		assertTrue(idao.getElementsByType(Client.class, "Client").size() == 1);
	}
	

	@Test
	public void removeclientToDB() {
		//idao.AddObject(new Client("toto", "tata"));
		idao.removeObject(client);
		assertTrue(idao.getElementsByType(Client.class, "Client").size() < 1);
	}
	
	@Test
	public void updateClient() {
		idao.AddObject(client);
		String tmp = "toto";
		Client tmpClient = idao.getElementsByType(Client.class, "Client").get(0);
		
		assertTrue(client.getLastName().equals(tmpClient.getLastName()));
	}


}

package launcher;

import java.util.List;

import dao.Idao;
import dao.linkDao;
import metier.Adviser;
import metier.BankAccount;
import metier.Client;

public class Launcher {

	public static void main(String[] args) throws InterruptedException {
		Idao idao = new linkDao();
		
		
		
		idao.connection();
		
		Client obj = new Client("Bob", "Moran");
		obj.setCellphone("0615478789");
		obj.setAddress("42 rue de la boustifaille");
		obj.setEmail("bob@gmail.com");
		obj.setLogin("bob");
		obj.setPassword("bob");
		obj.setZipCode("78452");
		obj.setTown("Filaville");
		obj.setType(Client.etype.CASUAL);
		Client cl2 = new Client("truc", "Bidule");
		cl2.setCellphone("0615478789");
		cl2.setAddress("42 rue de la chambre");
		cl2.setEmail("truc@gmail.com");
		cl2.setLogin("truc");
		cl2.setPassword("truc");
		cl2.setZipCode("78457");
		cl2.setTown("Filaville2");
		cl2.setType(Client.etype.CASUAL);
		
		Client cl3 = new Client("Sam", "Malin");
		cl3.setCellphone("0611278789");
		cl3.setAddress("42 de la rue");
		cl3.setEmail("sam@gmail.com");
		cl3.setLogin("sam");
		cl3.setPassword("sam");
		cl3.setZipCode("98457");
		cl3.setTown("Filaville3");
		cl3.setType(Client.etype.ENTERPRISE);
		idao.AddObject(obj);
		idao.AddObject(cl2);
		idao.AddObject(cl3);
		List<Client> list =  idao.getElementsByType(Client.class, "Client");

		System.out.println("Liste des client = "+list.size());
		
		BankAccount account = new BankAccount(list.get(0), 500, "2017-03-30", BankAccount.etype.CURRENT_ACCOUNT);
		BankAccount account2 = new BankAccount(list.get(1), 5789, "2017-03-30", BankAccount.etype.CURRENT_ACCOUNT);
		BankAccount account3 = new BankAccount(list.get(2), 801521, "2017-03-30", BankAccount.etype.CURRENT_ACCOUNT);
		
		idao.AddObject(account);
		idao.AddObject(account2);
		idao.AddObject(account3);
		list.get(0).setAccountCurrent(account);
		list.get(1).setAccountCurrent(account2);
		list.get(2).setAccountCurrent(account3);
		
		idao.updateObj(obj);
		idao.updateObj(cl2);
		idao.updateObj(cl3);
		
		
		
		idao.deconnection();
	}

}

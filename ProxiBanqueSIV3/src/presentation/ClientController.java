package presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;


import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import metier.BankAccount;
import metier.Client;
import service.IServiceActor;

@Named
//@SessionScoped
public class ClientController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static List<Client> listClient = new ArrayList<>();
	private static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
	static{
		BankAccount compt1 = new BankAccount();
		compt1.setSold(254);
		BankAccount compt2 = new BankAccount();
		compt1.setSold(25454);
		Client c1 = new Client("toto", "toto");
		Client c2 = new Client("titi", "titi");
		c1.getAccounts().add(compt2);
		c1.getAccounts().add(compt1);
		compt1.setClient(c1);
		compt2.setClient(c1);
		
		listClient.add(c1);
		listClient.add(c2);
	}
	@Inject
	private IServiceActor service;

	public List<Client> getListClient() {
		return listClient;
	}

	public void loadClients(){
		//listClient.clear();
		try{
		for (Client client : listClient) {
			for (BankAccount c : client.getAccounts()) {
				System.out.println(c.getSold());
			}
		}
		
			//listClient = service.getAllClient();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public String updateClient(Client client){
		LOGGER.info("Update Client!");
		try {
			service.updateClientToBDD(client);
			
		} catch (Exception e) {
			return null;
		}
		return "listClient";
	}
	public String deleteClient(long id){
		LOGGER.info("Delete CLient!");
		try {
			service.removeClient(id);
		} catch (Exception e) {
			return null;
		}
		return "listClient";
	}

	public void cancel(RowEditEvent event) {
		LOGGER.info("Cancel modification!");
  }
}

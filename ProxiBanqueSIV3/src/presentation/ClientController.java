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

import metier.Client;
import service.IServiceActor;

@Named
//@SessionScoped
public class ClientController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Client> listClient = new ArrayList<>();
	private static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
	
	@Inject
	private IServiceActor service;

	public List<Client> getListClient() {
		return listClient;
	}

	public void loadClients(){
		listClient.clear();
		try{
			listClient = service.getAllClient();
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

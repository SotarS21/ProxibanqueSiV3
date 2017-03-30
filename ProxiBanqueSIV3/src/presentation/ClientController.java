package presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.jboss.logging.Logger;
import org.primefaces.event.RowEditEvent;
import org.slf4j.LoggerFactory;

import metier.Client;

@Named
@SessionScoped
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
			listClient = service.getClients();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public String updateClient(Client client){
		LOGGER.info("Update Client!");
		try {
			service.updateClient(client);
			
		} catch (Exception e) {
			return null;
		}
		return "listClient";
	}
	public String deleteClient(long id){
		LOGGER.info("Delete CLient!");
		try {
			service.deleteClient(id);
		} catch (Exception e) {
			return null;
		}
		return "listClient";
	}
	
	public void cancel(RowEditEvent event) {
		LOGGER.info("Cancel modification!");
  }
}

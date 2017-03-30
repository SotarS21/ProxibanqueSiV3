package presentation;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.primefaces.event.RowEditEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import metier.Adviser;
import metier.BankAccount;
import metier.Client;

@Named
public class ConseillerController implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3609975386276172308L;
	private static List<Adviser> listAdviser = new ArrayList<>();
	private static Logger LOGGER = LoggerFactory.getLogger(ClientController.class);
	
	static{
	
		Client c1 = new Client("toto", "toto");
		Client c2 = new Client("titi", "titi");
		Adviser a1 = new Adviser("tata", "tata");
		Adviser a2 = new Adviser("titoune", "titoune");
		a1.getListOfClient().add(c1);
		a1.getListOfClient().add(c2);
		
		c1.setAdviserCurrent(a1);
		c2.setAdviserCurrent(a1);
		
		listAdviser.add(a1);
		listAdviser.add(a2);
	}

	public static List<Adviser> getListAdviser() {
		return listAdviser;
	}
	
	public void loadAdvisers(){
		//listClient.clear();
		try{
	
		
		
			//listClient = service.getAllClient();
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	public String updateAdviser(Adviser adviser){
		LOGGER.info("Update Client!");
		try {
			
			
		} catch (Exception e) {
			return null;
		}
		return "listConseiller";
	}
	public String deleteAdviser(long id){
		LOGGER.info("Delete CLient!");
		try {
			//service.removeClient(id);
		} catch (Exception e) {
			return null;
		}
		return "listConseiller";
	}

	public void cancel(RowEditEvent event) {
		LOGGER.info("Cancel modification!");
  }
	
	
	
}

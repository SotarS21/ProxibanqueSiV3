package metier;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@ManagedBean
@Entity
@DiscriminatorValue("ADVISER")
public class Adviser extends Person {

	private List<Client> listOfClient = new ArrayList<>();

	public static final int MAXCLIENT = 10;

	private String login = "login";
	private String pwd = "pwd";

	private static Adviser INSTANCE = null;
	
	
	public Adviser() {
		super();
	}

	
	public String getLogin() {
		return login;
	}

	public String getPwd() {
		return pwd;
	}

	// Point d'acces pour l'instance unique du singleton.
	public static Adviser getInstance() {
		if (INSTANCE == null)
			INSTANCE = new Adviser();
		return INSTANCE;
	}
		
	public boolean checkPassword(String nlogin, String npwd) {
		if (login.equals(nlogin) && pwd.equals(npwd)) {
			return true;
		} else {
			return false;
		}
	
	}

	public boolean addClient(Client cl) {
		if (this.listOfClient.size() < MAXCLIENT) {
			this.listOfClient.add(cl);
			return true;
		} else
			return false;

	}

	public boolean isAviableToNewClient() {
		if (this.listOfClient.size() < 10)
			return true;
		else
			return false;
	}

	public List<Client> getListOfClient() {
		return listOfClient;
	}

}

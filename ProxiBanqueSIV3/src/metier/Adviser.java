package metier;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@ManagedBean
@Entity
@DiscriminatorValue("ADVISER")
public class Adviser extends Person {

	@OneToMany(mappedBy = "adviserCurrent", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	private List<Client> listOfClient = new ArrayList<>();
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="agenceId")
	private Agence agence;
	
	public static final int MAXCLIENT = 10;


	public Adviser() {
		super();
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

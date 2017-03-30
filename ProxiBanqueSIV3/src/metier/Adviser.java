package metier;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@ManagedBean
@Entity
public class Adviser {


	@Id
	@Column(name="adviserId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String lastName;
	private String firstName;
	private String cellphone;
	private String email;
	private String login;
	private String password;
	
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


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getCellphone() {
		return cellphone;
	}


	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Agence getAgence() {
		return agence;
	}

	public void setListOfClient(List<Client> listOfClient) {
		this.listOfClient = listOfClient;
	}

}

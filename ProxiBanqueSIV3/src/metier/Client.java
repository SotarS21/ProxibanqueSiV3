package metier;

import java.io.Serializable;
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
import javax.persistence.OneToOne;

@ManagedBean
@Entity
public class Client implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6186053888360369087L;
	

	@Id
	@Column(name="clientId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String lastName;
	private String firstName;
	private String cellphone;
	private String email;
	private String login;
	private String password;
	
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(updatable = false, insertable = false, name = "adviserId")
	private Adviser adviserCurrent;
	private String address;
	private String zipCode;
	private String town;

	@OneToMany(mappedBy = "client", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	private List<BankAccount> accounts = new ArrayList<>();
	private boolean clientIsRich;
	@OneToOne
	@JoinColumn(name = "numCard", referencedColumnName = "numCard")
	private BankCard currentCard;

	public Adviser getAdviserCurrent() {
		return adviserCurrent;
	}

	public void setAdviserCurrent(Adviser adviserCurrent) {
		this.adviserCurrent = adviserCurrent;
	}

	public List<BankAccount> getAccounts() {
		return accounts;
	}

	protected double overdraftRate;

	public Client() {

	}

	public Client(String lastName, String firstName) {
		this.lastName = lastName;
		this.firstName = firstName;
	}

	public enum etype {
		CASUAL, ENTERPRISE;
	}

	protected etype type;

	public String getAddress() {
		return address;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String getTown() {
		return town;
	}

	public void AddBankCard(BankCard bc) {
		this.currentCard = bc;
	}

	public boolean isClientIsRich() {
		return clientIsRich;
	}

	public BankCard getCurrentCard() {
		return currentCard;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public void setTown(String town) {
		this.town = town;
	}

	public etype getType() {
		return type;
	}

	public void setType(etype type) {
		this.type = type;
	}

	public void setClientIsRich(boolean clientIsRich) {
		this.clientIsRich = clientIsRich;
	}

	public double getOverdraftRate() {
		return overdraftRate;
	}

	public void setOverdraftRate(double overdraftRate) {
		this.overdraftRate = overdraftRate;
	}

	public BankAccount getAccountCurrent() {
		for (BankAccount bankAccount : accounts) {
			if (bankAccount.getType() == BankAccount.etype.CURRENT_ACCOUNT)
				return bankAccount;
		}
		return null;
	}

	public BankAccount getAccountSaving() {
		for (BankAccount bankAccount : accounts) {
			if (bankAccount.getType() == BankAccount.etype.SAVING_ACCOUNT)
				return bankAccount;
		}
		return null;
	}

	public void setAccountCurrent(BankAccount newBA) {
		for (BankAccount bankAccount : accounts) {
			if (bankAccount.getType() == BankAccount.etype.CURRENT_ACCOUNT)
				bankAccount = newBA;
		}
	}

	public void setAccountSaving(BankAccount newBA) {
		for (BankAccount bankAccount : accounts) {
			if (bankAccount.getType() == BankAccount.etype.SAVING_ACCOUNT)
				bankAccount = newBA;
		}
	}
	
	public void addBanqueAccount(BankAccount Ba)
	{
		this.accounts.add(Ba);
	}
	public void removeBanqueAccount(BankAccount Ba)
	{
		if (Ba != null)
			this.accounts.remove(Ba);
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

	public void setCurrentCard(BankCard currentCard) {
		this.currentCard = currentCard;
	}

}

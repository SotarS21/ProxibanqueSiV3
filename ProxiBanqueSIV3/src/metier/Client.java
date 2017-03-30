package metier;

import javax.annotation.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@ManagedBean
@Entity
@DiscriminatorValue("CLIENT")
public class Client extends Person {

	private Adviser aviserCurrent;
	private String address;
	private String zipCode;
	private String town;

	private AccountCurrent accountCurrent;
	private AccountSaving accountSaving;
	private boolean clientIsRich;
	private BankCard currentCard;

	protected double overdraftRate;
	
	public Client() {

	}

	
	public Client(String lastName, String firstName) {
		super(lastName, firstName);
		// TODO Auto-generated constructor stub
	}


	public enum etype{
		CASUAL,ENTERPRISE;
	}
	protected etype type;

	


	public AccountCurrent getAccountCurrent() {
		return accountCurrent;
	}

	public void setAccountCurrent(AccountCurrent accountCurrent) {
		this.accountCurrent = accountCurrent;
	}

	public AccountSaving getAccountSaving() {
		return accountSaving;
	}

	public void setAccountSaving(AccountSaving accountSaving) {
		this.accountSaving = accountSaving;
	}

	public Adviser getIdAviser() {
		return aviserCurrent;
	}

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

	public void setIdAviser(Adviser current) {
		this.aviserCurrent = current;
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


}

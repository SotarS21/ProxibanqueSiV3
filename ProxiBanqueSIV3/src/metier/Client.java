package metier;

import java.io.Serializable;
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
import javax.persistence.OneToOne;

@ManagedBean
@Entity
@DiscriminatorValue("CLIENT")
public class Client extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6186053888360369087L;
	@ManyToOne(cascade = { CascadeType.PERSIST })
	@JoinColumn(updatable = false, insertable = false, name = "personId")
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
		super(lastName, firstName);
		// TODO Auto-generated constructor stub
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

}

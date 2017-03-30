
package metier;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;


@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="ACCOUNT_TYPE")
@DiscriminatorValue("MERE")
public class BankAccount {

	// attributs
	private long idClient;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numAccount;
	private double sold;
	private String openDate;

	public enum etype {
		CURRENT_ACCOUNT, SAVING_ACCOUNT
	};

	protected etype type;

	// constructeur

	public etype getType() {
		return type;
	}

	public BankAccount(long numAccount, long idClient, double sold, String openDate, etype type) {
		super();
		this.numAccount = numAccount;
		this.idClient = idClient;
		this.type = type;
		this.sold = sold;
		this.openDate = openDate;
	}

	// Getters setters
	public double getSold() {
		return this.sold;
	}

	public void setSold(double sold) {
		this.sold += sold;
	}

	public long getIdClient() {
		return idClient;
	}

	public long getNumAccount() {
		return numAccount;
	}

	public String getOpenDate() {
		return openDate;
	}

	public BankAccount() {
		super();
	}

	
}

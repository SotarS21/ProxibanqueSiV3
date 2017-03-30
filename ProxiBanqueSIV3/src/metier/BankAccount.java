
package metier;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class BankAccount implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5997378757741814279L;
	// attributs
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long numAccount;
	private double sold;
	private String openDate;
	private double rateAccount;
	private boolean isOverdraw;
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="personId")
	private Client client;
	

	public double getRateAccount() {
		return rateAccount;
	}

	public void setRateAccount(double rateAccount) {
		this.rateAccount = rateAccount;
	}

	public boolean isOverdraw() {
		return isOverdraw;
	}

	public void setOverdraw(boolean isOverdraw) {
		this.isOverdraw = isOverdraw;
	}


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

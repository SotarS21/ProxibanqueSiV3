package metier;

import javax.annotation.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@ManagedBean
@Entity
@DiscriminatorValue("CURRENT")
public class AccountCurrent extends BankAccount {

	// qttribut

	private boolean isOverdraw;

	public AccountCurrent() {
	}

	// Constructeur
	public AccountCurrent(long numAccount, long idClient, double sold, String openDate) {
		super(numAccount, idClient, sold, openDate, etype.CURRENT_ACCOUNT);
		this.isOverdraw = false;
		super.type = BankAccount.etype.CURRENT_ACCOUNT;
	}

	// Getter setter

	public boolean isOverdraw() {
		return isOverdraw;
	}

	public void setOverdraw(boolean isOverdraw) {
		this.isOverdraw = isOverdraw;
	}

}

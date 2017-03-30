package metier;

import javax.annotation.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@ManagedBean
@Entity
@DiscriminatorValue("ELECTRON")
public class CardElectron extends BankCard{
	
	
	public CardElectron() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardElectron(long idClient) {
		super(idClient);
		super.type = BankCard.etype.ELECTRON;
	}
}

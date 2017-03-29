package metier;

import javax.annotation.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@ManagedBean
@Entity
@DiscriminatorValue("VISA")
public class CardVisa extends BankCard{

	
	public CardVisa() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CardVisa(long idClient) {
		super(idClient);
		super.type = BankCard.etype.VISA;
	}

}

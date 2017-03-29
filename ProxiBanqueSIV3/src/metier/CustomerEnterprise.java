package metier;

import javax.annotation.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@ManagedBean
@Entity
@DiscriminatorValue("ENTERPRISE")
public class CustomerEnterprise extends Client{
	

	public CustomerEnterprise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomerEnterprise(long id, String idAgence, String lastName, String firstName, String cellphone, String adress, String zipCode, String town, String email) {
		super(id, idAgence, lastName, firstName, cellphone,  adress,  zipCode,  town, email);
		super.type = Client.etype.ENTERPRISE;
		super.overdraftRate = -1000.0;
		
	}
	public CustomerEnterprise(String idAgence, String lastName) {
		this(0, idAgence, lastName, "", "", "", "", "", "");
	}

}

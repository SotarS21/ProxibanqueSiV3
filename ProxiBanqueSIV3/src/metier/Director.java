package metier;

import javax.annotation.ManagedBean;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@ManagedBean
@Entity
@DiscriminatorValue("DIRECTOR")
public class Director extends Person {

	
	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Director(String idAgence, String lastName, String firstName, String cellphone, String email) {
		super(0, idAgence, lastName, firstName, cellphone, email);
	}
	
	public Director(String idAgence, String lastName) {
		this(idAgence, lastName, "", "", "");
	}
	
	

}

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


	

}

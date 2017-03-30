package metier;

import javax.annotation.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@ManagedBean
@Entity
@DiscriminatorValue("DIRECTOR")
public class Director extends Person {
	
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="agenceId")
	private Agence agence;
	
	public Director() {
		super();
		// TODO Auto-generated constructor stub
	}


	

}

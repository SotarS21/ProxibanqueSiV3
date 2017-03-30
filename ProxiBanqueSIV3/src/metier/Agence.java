package metier;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@ManagedBean
@Entity
public class Agence {

	@Id
	@Column(name="agenceId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String identification;
	private String openDate;
	
	@OneToOne    
	@JoinColumn(name="directorId", referencedColumnName = "directorId")
	private Director currentDirector;
	
	@OneToMany(mappedBy = "agence", fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST })
	private List<Adviser> currentListOfAdviser = new ArrayList<Adviser>();
	

	public Agence() {
		super();
	}

	
	public String getIdentification() {
		return identification;
	}


	public void setIdentification(String identification) {
		this.identification = identification;
	}


	public Agence(String openDate) {
		this.openDate = openDate;
	}


	public Director getCurrentDirector() {
		return currentDirector;
	}


	public void setCurrentDirector(Director currentDirector) {
		this.currentDirector = currentDirector;
	}


	public List<Adviser> getCurrentListOfAdviser() {
		return currentListOfAdviser;
	}


	public void AddAdviser(Adviser newAd) {
		this.currentListOfAdviser.add(newAd);
	}


	public long getId() {
		return id;
	}


	public String getOpenDate() {
		return openDate;
	}
	
	
}

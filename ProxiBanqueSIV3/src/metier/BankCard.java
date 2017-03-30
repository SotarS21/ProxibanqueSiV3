package metier;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class BankCard {

	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numCard;
	private int passwordCard;
	@ManyToOne(cascade={CascadeType.PERSIST})
	@JoinColumn(name="personId")
	private Client client;


	public BankCard() {
		super();
	}

	// Valeurs ENUM
	public enum etype {
		VISA, ELECTRON;
	}

	protected etype type;

	// Constructeur
	public BankCard(Client client) {
		this.passwordCard = 1234;
		this.client = client;
	}

	public BankCard(Client idCl, etype type2) {
		this.passwordCard = 1234;
		this.client = idCl;
		this.type = type2;
	}

	// Getters
	public long getNumCard() {
		return numCard;
	}

	public int getPasswordCard() {
		return passwordCard;
	}

	public Client getIdClient() {
		return client;
	}

	public etype getType() {
		return type;
	}

	// méthode de création de mot de passe.
	private int numPassword() {
		int somme = 0;
		int puissanceDix = 1;
		for (int i = 0; i < 4; i++) {
			somme += ((int) (Math.random() * 10)) * puissanceDix;
			puissanceDix *= 10;
		}
		return somme;
	}

}

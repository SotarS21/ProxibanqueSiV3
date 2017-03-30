package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class BankCard {

	// Attributs
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long numCard;
	private int passwordCard;
	private long idClient;

	private static long newNum = 100L;

	public BankCard() {
		super();
	}

	// Valeurs ENUM
	public enum etype {
		VISA, ELECTRON;
	}

	protected etype type;

	// Constructeur
	public BankCard(long idClient) {
		super();
		newNum++;
		this.numCard = newNum;
		this.passwordCard = numPassword();
		this.idClient = idClient;
	}

	// Getters
	public long getNumCard() {
		return numCard;
	}

	public int getPasswordCard() {
		return passwordCard;
	}

	public long getIdClient() {
		return idClient;
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

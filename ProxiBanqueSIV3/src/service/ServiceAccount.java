package service;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import dao.Idao;
import metier.AccountCurrent;
import metier.AccountSaving;
import metier.BankAccount;
import metier.BankAccount.etype;
import metier.Client;

/**
 * @author Jonas kevin
 *
 */
@Named
@Dependent
public class ServiceAccount implements IServiceAccount {

	public static long RICH_CONDITION = 500000;

	@Inject
	Idao dao;

	/**
	 * Ajoute un compte au client selon son type.
	 * 
	 * @param idClient
	 *            : client identifiant
	 * @param type
	 *            : type de compte
	 * @param startSold
	 *            : montant � la cr�ation du compte, ne peux �tre n�gatif
	 */
	@Override
	public void addAccountToClient(long idClient, BankAccount.etype type, long startSold) {
		if (startSold < 0) {
			// TO DO : LOOGER
			startSold = 0;
		}

		switch (type) {
		case CURRENT_ACCOUNT:
			AccountCurrent tmpCur = new AccountCurrent(5454, idClient, startSold, "2017-03-15");
			// dao.getElementById(Client.class, idClient).setAccount(tmp);
			dao.AddObject(tmpCur);
			break;
		case SAVING_ACCOUNT:
			AccountSaving tmpSav = new AccountSaving(5454, idClient, startSold, "2017-03-15");
			// dao.getElementById(Client.class, idClient).setAccount(tmp);
			dao.AddObject(tmpSav);// changer l'ini du compte
			break;

		}
	}

	/**
	 * Supprime un client de la base de donn�es
	 * 
	 * @param idClient
	 *            : client identifiant
	 * @param type
	 *            : type de compte
	 */
	public void removeAccountToClient(long idClient, BankAccount.etype type) {
		Client tmp = dao.getElementById(Client.class, idClient);
		if (type == BankAccount.etype.CURRENT_ACCOUNT)	
			dao.removeObject(tmp.getAccountCurrent());
		else
			dao.removeObject(tmp.getAccountSaving());
	}

	/**
	 * Mets � jour le d�couvert d'un compte
	 * 
	 * @param idClient
	 *            : client identifiant
	 * @param newOverdraft
	 *            : nouvel valeur
	 */
	public void updateOverdrawToClient(long idClient, long newOverdraft) {
		Client tmp = dao.getElementById(Client.class, idClient);
		if (tmp.getType() == Client.etype.CASUAL && newOverdraft < 5000)
			tmp.setOverdraftRate(newOverdraft);
		else if (tmp.getType() == Client.etype.ENTERPRISE && newOverdraft < 50000)
			tmp.setOverdraftRate(newOverdraft);
		// else
		// error
		dao.updateObj(tmp);
	}

	/**
	 * Effectuer un transf�re de solds du compte host au compte dest
	 * 
	 * @param host
	 *            : compte d�biteur
	 * @param dest
	 *            : compt cr�diteur
	 * @param sold
	 *            : somme
	 */
	public void transferAccoutToAccount(BankAccount host, BankAccount dest, double sold) {

		// System.out.println("host old sold = "+host.getSold());
		host.setSold(-sold);
		// System.out.println("host id = "+host.getNumAccount());
		// System.out.println("host new sold = "+host.getSold());
		dao.updateObj(host);
		// System.out.println("dest old sold = "+dest.getSold());
		dest.setSold(sold);

		dao.updateObj(dest);

		// System.out.println("dest new sold =
		// "+DaoAccount.getInstance().getAccountById(dest.getNumAccount()).getSold());
		/*
		 * if (!checkRich(host)) { Client destClient =
		 * DaoClient.getInstance().getClientById(dest.getIdClient());
		 * destClient.setClientIsRich(false);
		 * DaoClient.getInstance().updateClient(destClient); } if
		 * (!checkOverdraft(dest)) { if (checkRich(dest)) { Client
		 * destClientRitch =
		 * DaoClient.getInstance().getClientById(dest.getIdClient());
		 * destClientRitch.setClientIsRich(true);
		 * DaoClient.getInstance().updateClient(destClientRitch);
		 * 
		 * } } else SService.sendInfoToclient(host.getIdClient(),
		 * "Carfull you still overdraw , sold : " + dest.getSold());
		 * 
		 * if (!checkOverdraft(host))
		 * SService.sendInfoToclient(host.getIdClient(),
		 * "Carfull you don't have enought money to make a transfert sold : " +
		 * host.getSold());
		 */
	}

	/**
	 * V�rification du solde du compte, d�couvert ou non
	 * 
	 * @param myAccount
	 *            : compte � v�rifier
	 * @return vrai si � d�couvert, faux si non
	 */
	public boolean checkOverdraft(BankAccount myAccount) {
		if (myAccount.getSold() > dao.getElementById(Client.class, myAccount.getIdClient()).getOverdraftRate())
			return false;
		return true;
	}

	/**
	 * V�rification du solde pour savoir si il est riche
	 * 
	 * @param myAccount
	 *            : compte � v�rifier
	 * @return vrai si le client a plus de 500000, faux si le client a moins de
	 *         500000
	 */
	public boolean checkRich(BankAccount myAccount) {

		double tmpsold = myAccount.getSold();
		if (myAccount.getType() == etype.CURRENT_ACCOUNT) {
			if (dao.getElementById(Client.class,myAccount.getIdClient()).getAccountCurrent() != null)
				tmpsold += dao.getElementById(Client.class, myAccount.getIdClient()).getAccountSaving().getSold();
		} else if (myAccount.getType() == etype.SAVING_ACCOUNT) {
			if (dao.getElementById(Client.class,myAccount.getIdClient())
					.getAccountCurrent() != null)
				tmpsold += dao.getElementById(Client.class,myAccount.getIdClient())
						.getAccountSaving().getSold();

		}

		if (tmpsold < RICH_CONDITION)
			return false;
		return true;
	}

	/**
	 * r�cup�ration de la litse des comptes existant
	 * @return list des comptes
	 */
	public List<BankAccount> getAllAccount() {
		return dao.getElementsByType(BankAccount.class, "Account");
	}

	/**
	 * r�cup�ration d'un comptes par rapport � son identifiant
	 * @param id = identifiant
	 */
	public BankAccount getAccountById(long id) {
		return dao.getElementById(BankAccount.class, id);
	}
}

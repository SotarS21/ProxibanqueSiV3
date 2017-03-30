package service;

import java.util.List;

import javax.enterprise.context.Dependent;

import metier.AccountCurrent;
import metier.AccountSaving;
import metier.BankAccount;
import metier.BankAccount.etype;
import metier.Client;

/**
 * @author Jonas Maeva
 *
 */
@Dependent
public class ServiceAccount implements {

	public static long RITCH_CONDITION = 500000;

	/**
	 * @deprecated
	 * Ajoute un compte au client selon son type.
	 * 
	 * @param idClient
	 *            : client identifiant
	 * @param type
	 *            : type de compte
	 * @param startSold
	 *            : montant � la cr�ation du compte, ne peux �tre n�gatif
	 */
	public static void addAccountToClient(long idClient, BankAccount.etype type, long startSold) {
		if (startSold < 0) {
			// TO DO : LOOGER
			startSold = 0;
		}

		switch (type) {
		case CURRENT_ACCOUNT:
			break;
		case SAVING_ACCOUNT:
			Connector.getInstance().getElementById(Client.class,idClient)
					.addBankAccount(new AccountSaving(5848, idClient, startSold, "2017-03-15")); // changer l'ini du compte
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
	public static void removeAccountToClient(long idClient, BankAccount.etype type) {
		Client tmp = DaoClient.getInstance().getClientById(idClient);
		DaoAccount.getInstance().removeAccountById(tmp.getAccount(type));
		tmp.removeBankAccount(tmp.getAccount(type));

	}

	/**
	 * Mets � jour le d�couvert d'un compte
	 * 
	 * @param idClient
	 *            : client identifiant
	 * @param newOverdraft
	 *            : nouvel valeur
	 */
	public static void updateOverdrawToClient(long idClient, long newOverdraft) {
		DaoClient.getInstance().getClientById(idClient).setOverdraftRate(newOverdraft);
		DaoClient.getInstance().updateClient(DaoClient.getInstance().getClientById(idClient));
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
	public static void transferAccoutToAccount(BankAccount host, BankAccount dest, double sold) {

		// System.out.println("host old sold = "+host.getSold());
		host.setSold(-sold);
		System.out.println("host id = "+host.getNumAccount());
		// System.out.println("host new sold = "+host.getSold());
		DaoAccount.getInstance().updateAccountByid(host.getNumAccount(), host.getSold());
		// System.out.println("dest old sold = "+dest.getSold());
		dest.setSold(sold);

		DaoAccount.getInstance().updateAccountByid(dest.getNumAccount(), dest.getSold());

		// System.out.println("dest new sold =
		// "+DaoAccount.getInstance().getAccountById(dest.getNumAccount()).getSold());
	/*	if (!checkRich(host)) {
			Client destClient = DaoClient.getInstance().getClientById(dest.getIdClient());
			destClient.setClientIsRich(false);
			DaoClient.getInstance().updateClient(destClient);
		}
		if (!checkOverdraft(dest)) {
			if (checkRich(dest)) {
				Client destClientRitch = DaoClient.getInstance().getClientById(dest.getIdClient());
				destClientRitch.setClientIsRich(true);
				DaoClient.getInstance().updateClient(destClientRitch);

			}
		} else
			SService.sendInfoToclient(host.getIdClient(), "Carfull you still overdraw , sold : " + dest.getSold());

		if (!checkOverdraft(host))
			SService.sendInfoToclient(host.getIdClient(),
					"Carfull you don't have enought money to make a transfert sold : " + host.getSold());*/
	}

	/**
	 * V�rification du solde du compte, d�couvert ou non
	 * 
	 * @param myAccount
	 *            : compte � v�rifier
	 * @return vrai si � d�couvert, faux si non
	 */
	public static boolean checkOverdraft(BankAccount myAccount) {
		if (myAccount.getSold() > DaoClient.getInstance().getClientById(myAccount.getIdClient()).getOverdraftRate())
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
	public static boolean checkRich(BankAccount myAccount) {

		double tmpsold = myAccount.getSold();
		if (myAccount.getType() == etype.CURRENT_ACCOUNT) {
			if (DaoClient.getInstance().getClientById(myAccount.getIdClient()).getAccount(etype.SAVING_ACCOUNT) != null)
				tmpsold += DaoClient.getInstance().getClientById(myAccount.getIdClient())
						.getAccount(etype.SAVING_ACCOUNT).getSold();
		} else if (myAccount.getType() == etype.SAVING_ACCOUNT) {
			if (DaoClient.getInstance().getClientById(myAccount.getIdClient())
					.getAccount(etype.CURRENT_ACCOUNT) != null)
				tmpsold += DaoClient.getInstance().getClientById(myAccount.getIdClient())
						.getAccount(etype.CURRENT_ACCOUNT).getSold();

		}

		if (tmpsold < RITCH_CONDITION)
			return false;
		return true;
	}

	
	public static List<BankAccount> getAllAccount()
	{
		return DaoAccount.getInstance().getAllAccount();
	}
	
	public static BankAccount getAccountById(long id)
	{
		return DaoAccount.getInstance().getAccountById(id);
	}
}


package service;

import javax.inject.Inject;

import dao.Idao;
import metier.BankAccount.etype;
import metier.BankCard;
import metier.Client;

/**
 * @author Jonas Maëva
 *
 */
public class ServiceCard {
	
	@Inject
	Idao idao;
	
/**
 * Ajoute une carte au client pour son compte courant
 * @param idCl : identifiant client
 * @param type : type de compt
 */
	public void addCardToClient(long idCl, BankCard.etype type) {

		Client cl = idao.getElementById(Client.class, idCl);

		if (cl.getAccountCurrent() != null) {

			cl.AddBankCard(new BankCard(idCl, type));
			idao.AddObject(cl);
		}
	}

}

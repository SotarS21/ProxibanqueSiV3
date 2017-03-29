package service;

import java.util.List;

import dao.DaoClient;

import metier.Client;

/**
 * @author Jonas Maeva
 *
 */
public class ServiceActor {

	/**
	 * Modification des donn�es d'un client
	 *  de la base de donn�es
	 * 
	 * @param cl = client � modifier
	 */
	public static void updateClientToBDD(Client cl) {
		DaoClient.getInstance().updateClient(cl);
	}

	/**
	 * Ajout du client dans la base de donn�es, ajout du client dans la liste
	 * des clients d'un conseiller SI il en existe de disponible le client re�oit
	 * alors l'identifiant de ce conseiller SINON aucun conseiller ne lui est
	 * attribu�
	 * 
	 * @param cl = nouveau client
	 */
	public static void addNewClient(Client cl) {
	/*	Adviser adtmp = DAO.getInstance().getAdviserDispo();
		if (adtmp != null) {
			adtmp.addClient(cl);
			cl.setIdAgence(adtmp.getIdAgence());
		}*/
		//cl.setIdAviser(Adviser.current);
		DaoClient.getInstance().addClient(cl);
	}

	/**
	 * Demande la suppression d'un client � la base de donn�es
	 * 
	 * @param cl
	 */
	public static void removeClient(Client cl) {
		DaoClient.getInstance().removeClient(cl);
	}


	public static Client getClientById(long id)
	{
		return DaoClient.getInstance().getClientById(id);
	}


	/**
	 * 
	 * @return Retourne la liste de tous les clients de la base de donn�es
	 */
	public static List<Client> getAllClient() {
		return DaoClient.getInstance().getAllClient();
	}
}

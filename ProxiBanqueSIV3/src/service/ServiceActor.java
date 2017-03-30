package service;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.inject.Named;

import dao.linkDao;
import metier.Adviser;
import metier.Agence;
import metier.Client;

/**
 * @author Jonas Kevin
 *
 */
@Named
@Dependent
public class ServiceActor implements IServiceActor {

	private static double valueAuditCasual = -5000.0;
	private static double valueAuditEntreprise = -50000.0;

	@Inject
	linkDao dao;

	@PostConstruct
	public void initService() {
		dao.initDao();
	}

	/**
	 * Modification des donn�es d'un client de la base de donn�es
	 * 
	 * @param cl
	 *            = client � modifier
	 */
	@Override
	public void updateClientToBDD(Client cl) {
		dao.updateObj(cl);
	}

	/**
	 * Ajout du client dans la base de donn�es, ajout du client dans la liste
	 * des clients d'un conseiller SI il en existe de disponible le client
	 * re�oit alors l'identifiant de ce conseiller SINON aucun conseiller ne lui
	 * est attribu�
	 * 
	 * @param cl
	 *            = nouveau client
	 */
	@Override
	public void addNewClient(Client cl) {
		// TO DO get adviser from BDD to add client into him and updateAdviser
		System.out.println("dao = " + dao);
		dao.AddObject(cl);

	}

	/**
	 * Demande la suppression d'un client � la base de donn�es
	 * 
	 * @param id
	 *            = identifiant ddu client a supprimer
	 */
	@Override
	public void removeClient(long id) {
		dao.removeObject(id);
	}

	/**
	 * r�cup�re le client sur la base de donn�es
	 * 
	 * @param id
	 *            = identifiant du client
	 * @return le client
	 */
	@Override
	public Client getClientById(long id) {
		return dao.getElementById(Client.class, id);
	}

	/**
	 * 
	 * @return Retourne la liste de tous les clients de la base de donn�es
	 */
	@Override
	public List<Client> getAllClient() {
		return dao.getElementsByType(Client.class, "Client");
	}

	/**
	 * Modification des donn�es d'un conseiller de la base de donn�es
	 * 
	 * @param ad
	 *            = conseiller � modifier
	 */
	@Override
	public void updateAdviserToBDD(Adviser ad) {
		dao.updateObj(ad);
	}

	// ** CONSEILLER METHODE

	/**
	 * Ajout du conseiller dans la base de donn�es,
	 * 
	 * @param ad
	 *            = nouveau conseiller
	 */
	@Override
	public void addNewAdviser(Adviser ad) {
		dao.AddObject(ad);

	}

	/**
	 * Demande la suppression d'un conseiller � la base de donn�es
	 * 
	 * @param id
	 *            = identifiant du conseiller � supprimer
	 */
	@Override
	public void removeAdviser(long id) {
		dao.removeObject(id);
	}

	/**
	 * R�cup�re le conseiller depuis la base de donn�es par rapport � son
	 * identifiant
	 * 
	 * @param id
	 *            = identifiant du conseiller
	 * @return conseiller de la base
	 */
	@Override
	public Adviser getAdviserById(long id) {
		return dao.getElementById(Adviser.class, id);
	}

	/**
	 * 
	 * @return Retourne la liste de tous les conseiller de la base de donn�es
	 */
	@Override
	public List<Adviser> getAllAdviser() {
		return dao.getElementsByType(Adviser.class, "Adviser");
	}

	// ** AGENCE METHODE

	/**
	 * Ajout d'une agence dans la base de donn�es,
	 * 
	 * @param ad
	 *            = nouvel Agence
	 */
	@Override
	public void addNewAgence(Agence ag) {
		dao.AddObject(ag);

	}

	/**
	 * Demande la suppression d'une agence � la base de donn�es
	 * 
	 * @param id
	 *            = identifiant de l'agence
	 */
	@Override
	public void removeAgence(long id) {
		dao.removeObject(id);
	}

	/**
	 * R�cup�re l'agence depuis la base de donn�es par rapport � son identifiant
	 * 
	 * @param id
	 *            = identifiant de l'agence
	 * @return l'agence
	 */
	@Override
	public Agence getAgenceById(long id) {
		return dao.getElementById(Agence.class, id);
	}

	/**
	 * 
	 * @return Retourne la liste de toutes les agences de la base de donn�es
	 */
	@Override
	public List<Agence> getAllAgence() {
		return dao.getElementsByType(Agence.class, "Agence");
	}

	@Override
	public List<Client> doAudit() {

		List<Client> listClient = dao.getElementsByType(Client.class, "Client");

		List<Client> retList = new ArrayList<>();

		for (Client client : listClient) {
			double solde = 0.0;
			switch (client.getType()) {
			case CASUAL:
				solde = client.getAccountCurrent().getSold();
				if (solde < valueAuditCasual)
					retList.add(client);
				break;
			case ENTERPRISE:
				solde = client.getAccountCurrent().getSold();
				if (solde < valueAuditEntreprise)
					retList.add(client);
				break;
			}
		}

		return null;
	}

	/**
	 * Change les valeurs � v�rifier pour les comptes
	 * 
	 * @param vAC
	 *            : valueAuditCasual
	 * @param vAE
	 *            : valueAuditEntreprise
	 */
	public void changeValues(double vAC, double vAE) {
		valueAuditCasual = vAC;
		valueAuditEntreprise = vAE;
	}

}

package service;

import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

import dao.Idao;
import metier.Adviser;
import metier.Agence;
import metier.Client;

/**
 * @author Jonas Maeva
 *
 */
@Dependent
public class ServiceActor implements IServiceActor {

	@Inject
	Idao dao;

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
	 * @param id = identifiant du client 
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
		return dao.getElementsByType(Client.class);
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
		return dao.getElementsByType(Adviser.class);
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
		return dao.getElementsByType(Agence.class);
	}

}

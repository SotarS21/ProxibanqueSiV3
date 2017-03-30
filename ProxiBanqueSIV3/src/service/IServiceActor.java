package service;

import java.util.List;

import metier.Adviser;
import metier.Agence;
import metier.Client;

public interface IServiceActor {

	public void updateClientToBDD(Client cl);
	public void addNewClient(Client cl);
	public  void removeClient(long id);
	public  Client getClientById(long id);
	public  List<Client> getAllClient();
	public void updateAdviserToBDD(Adviser ad);
	public void addNewAdviser(Adviser ad);
	public void removeAdviser(long id);
	public  Adviser getAdviserById(long id);
	public  List<Adviser> getAllAdviser();
	public void addNewAgence(Agence ag);
	public  void removeAgence(long id);
	public  Agence getAgenceById(long id);
	public  List<Agence> getAllAgence();
}

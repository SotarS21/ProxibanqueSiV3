package launcher;

import java.util.List;

import org.hibernate.hql.internal.ast.tree.FromReferenceNode;

import dao.Idao;
import dao.linkDao;
import metier.Adviser;
import metier.Client;

public class LancherAdviser {

	public static void main(String[] args) {
		Idao idao = new linkDao();

		idao.connection();
		List<Client> list = idao.getElementsByType(Client.class, "Client");
		

		Adviser adviser = new Adviser("Kevin", "Kornaton");
		adviser.setCellphone("45781230");
		adviser.setEmail("kevin@gmail.com");
		adviser.setLogin("kev");
		adviser.setPassword("kev");

		for (Client client : list) {

			adviser.addClient(client);
		}
		idao.AddObject(adviser);

		for (Client client : list) {

			client.setAdviserCurrent(adviser);
		}

		idao.AddObject(adviser);
		
		for (Client client : list) {
			idao.updateObj(client);
		}
		
		// idao.removeObject(Client.class, obj.getId());
		System.out.println("adviser list of client = " + adviser.getListOfClient());

		idao.deconnection();
	}

}

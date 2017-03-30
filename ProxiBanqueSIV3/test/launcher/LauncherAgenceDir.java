package launcher;

import java.util.List;

import dao.Idao;
import dao.linkDao;
import metier.Adviser;
import metier.Agence;
import metier.Director;

public class LauncherAgenceDir {

	public static void main(String[] args) {

		Idao idao = new linkDao();

		idao.connection();
		
		Agence agence = new Agence("2017-03-30");
		Director director = new Director();
		director.setFirstName("Aurelie");
		director.setLastName("Module");
		director.setCellphone("78594565");
		director.setLogin("aur");
		director.setPassword("aur");
		director.setAgence(agence);
		idao.AddObject(director);
		
		agence.setCurrentDirector(director);
		idao.AddObject(agence);
		List<Adviser> list = idao.getElementsByType(Adviser.class, "Adviser");
		System.out.println("list of adviser size = "+list.size());
		
		for (Adviser adviser : list) {
			agence.AddAdviser(adviser);	
		}
		
		
		
		
		idao.deconnection();
	}

}

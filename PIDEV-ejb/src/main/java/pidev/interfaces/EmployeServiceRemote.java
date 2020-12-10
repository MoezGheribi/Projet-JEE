package pidev.interfaces;

import java.util.List;

import javax.ejb.Remote;

import pidev.entity.*;


public interface EmployeServiceRemote {
	
	//gerer employee
	
	void ajouterEmploye(User e);
	public List<User> getAllEmployes();
	public void deleteEmployeById(int id_user);
	public void updateEmploye(User e);
	public User getEmployeeByLoginAndPassword(String User_Name, String Password);
	
	//gerer publication
	
	void ajouterPub(Publication pub);
	public List<Publication> getAllPub();
	void deletePubById(int idPub);
	void updatePub(Publication pub);
	
	//gerer congé
	
	void ajouterConge(Conge con);
	public List<Conge> getAllConges();
	public void deleteCongeById(int idConge);
	public void updateConge(Conge con);

}

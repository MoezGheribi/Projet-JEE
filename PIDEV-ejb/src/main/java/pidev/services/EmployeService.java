package pidev.services;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pidev.entity.*;
import pidev.interfaces.EmployeServiceRemote;


@Stateful
@LocalBean
public class EmployeService implements EmployeServiceRemote{
	
	@PersistenceContext(unitName = "pidevGL-ejb")
	EntityManager em;
	
	
	//gerer employee
	
	
	public void ajouterEmploye(User e) {
		em.persist(e);
	}
	
	public void ajouterJaime(Jaime j) {
		em.persist(j);
	}
	
	public List<User> getAllEmployes() {
		List<User> emp = em.createQuery("Select e from User e", User.class).getResultList();
		return emp;
	}
	
	public void deleteEmployeById(int id_user) {
		User e = em.find(User.class,id_user); 
		em.remove(e); 
		}
	
	public void updateEmploye(User e) {
		em.merge(e); 
		}
	
	
	public User getEmployeeByLoginAndPassword(String user_Name, String password) {
		System.out.println(user_Name+password);
		TypedQuery<User> query= em.createQuery("select e from User e where e.User_Name=:user_Name AND e.Password=:password", User.class);
		query.setParameter("user_Name", user_Name);
		query.setParameter("password", password);
		User user = null;
		try{
			user = query.getSingleResult();
		}
		catch(NoResultException e){
			Logger.getAnonymousLogger().info("Not found");
		}

		return user;
	}
	
	
	
	
	
	
	//gerer publication
	
	public void ajouterPub(Publication pub) {
		em.persist(pub);
	}
	
	public List<Publication> getAllPub() {
		List<Publication> pub = em.createQuery("Select pub from Publication pub", Publication.class).getResultList();
		//return em.createQuery("from publication p",publication.class).getResultList();
		return pub;
	}
	public List<Publication> getMyPub(User user) {
		
		List<Publication> pub = em.createQuery("Select pub from Publication pub where pub.user=:user", Publication.class)
				.setParameter("user", user)
				.getResultList();
		//return em.createQuery("from publication p",publication.class).getResultList();
		return pub;
	}
	
	public void deletePubById(int idPub) {
		Publication pub = em.find(Publication.class,idPub); 
		em.remove(pub); 
		}
	
	public void updatePub(Publication pub) {
		em.merge(pub); 
		}
	
	
	public void deleteJaime(Publication pub ,User user) {
		TypedQuery<Jaime> query= em.createQuery("select e from Jaime e where e.user=:user AND e.publication=:pub", Jaime.class);
		query.setParameter("user", user);
		query.setParameter("pub", pub);
		Jaime jaime = null;
		try{
			jaime = query.getSingleResult();
		}
		catch(NoResultException e){
			Logger.getAnonymousLogger().info("Not found");
		}	
		em.remove(jaime); 
	}
	public boolean verifJaime(Publication pub ,User user) {
		TypedQuery<Jaime> query= em.createQuery("select e from Jaime e where e.user=:user AND e.publication=:pub", Jaime.class);
		query.setParameter("user", user);
		query.setParameter("pub", pub);
		Jaime jaime = null;
		try{
			jaime = query.getSingleResult();
		}
		catch(NoResultException e){
			Logger.getAnonymousLogger().info("Not found");
		}	
		if (jaime == null)
			return false;
		return true;
	}
	
	
	
	
	//gerer congé
	
	
	public void ajouterConge(Conge con) {
		em.persist(con);
	}
	
	public List<Conge> getAllConges() {
		List<Conge> con = em.createQuery("Select con from Conge con", Conge.class).getResultList();
		return con;
	}
	public List<Conge> getMyConges(User user) {
		List<Conge> con = em.createQuery("Select con from Conge con where con.user=:user", Conge.class)
				.setParameter("user", user)
				.getResultList();
		return con;
	}
	public void deleteCongeById(int idConge) {
		Conge con = em.find(Conge.class,idConge); 
		em.remove(con); 
		}
	
	public void updateConge(Conge con) {
		em.merge(con); 
		}
	
	
	

}

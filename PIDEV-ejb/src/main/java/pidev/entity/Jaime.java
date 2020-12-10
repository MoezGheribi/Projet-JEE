package pidev.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Jaime implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idJaime;
	
	@ManyToOne
	private User user;
	
	
	@ManyToOne
	private Publication publication;


	public Jaime(int idLike, User user, Publication publication) {
		super();
		this.idJaime = idJaime;
		this.user = user;
		this.publication = publication;
	}


	public Jaime() {
		super();
	}


	public int getIdJaime() {
		return idJaime;
	}


	public void setIdJaime(int idJaime) {
		this.idJaime = idJaime;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Publication getPublication() {
		return publication;
	}


	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	
	
	
	
	
	

}

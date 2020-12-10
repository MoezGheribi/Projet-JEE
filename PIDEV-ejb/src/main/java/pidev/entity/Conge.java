package pidev.entity;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Conge implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idConge;
	private Date dateDebut;
	private Date dateFin;
	private String cause; 
	private int isValid;
	
	@ManyToOne
	private User user;

	public Conge() {
		super();
	}

	public Conge(int idConge, Date dateDebut, Date dateFin, String cause) {
		
		this.idConge = idConge;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.cause = cause;
	}
	

	public Conge(int idConge, Date dateDebut, Date dateFin, String cause, int isValid) {
		super();
		this.idConge = idConge;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.cause = cause;
		this.isValid = isValid;
	}

	public int getIdConge() {
		return idConge;
	}

	public void setIdConge(int idConge) {
		this.idConge = idConge;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public int getIsValid() {
		return isValid;
	}

	public void setIsValid(int isValid) {
		this.isValid = isValid;
	}

	
	
	

}

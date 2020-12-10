package pidev.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Publication implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idPub;
	private String photoPub;
	private String descPub;
	private Date datePub;
	
	
	
	@ManyToOne
	private User user;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "publication", cascade = CascadeType.REMOVE)
	private List<Jaime> jaimes;
	

	public Publication() {
		super();
	}
	public Publication(String photoPub, String descPub, Date datePub, User user) {
		super();
		this.photoPub = photoPub;
		this.descPub = descPub;
		this.datePub = datePub;
		this.user = user;
	}
	
	public List<Jaime> getJaimes() {
		return jaimes;
	}
	public void setJaimes(List<Jaime> jaimes) {
		this.jaimes = jaimes;
	}
	public int getIdPub() {
		return idPub;
	}
	public void setIdPub(int idPub) {
		this.idPub = idPub;
	}
	public String getPhotoPub() {
		return photoPub;
	}
	public void setPhotoPub(String photoPub) {
		this.photoPub = photoPub;
	}
	public String getDescPub() {
		return descPub;
	}
	public void setDescPub(String descPub) {
		this.descPub = descPub;
	}
	public Date getDatePub() {
		return datePub;
	}
	public void setDatePub(Date datePub) {
		this.datePub = datePub;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}

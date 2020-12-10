package pidev.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "t_Utilisateur")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_user;
	private String Last_Name;
	private String First_Name;
	private String Email;
	private String Addresse;
	private int Tel;
	private String User_Name;
	private String Password;
	private String Grade;
	@Temporal(TemporalType.DATE)
	private Date DateNaissance;
	private Boolean isActif;
	private int CIN;
	private String Photo;
	private String Statue;
	private Role role;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Publication> publications;

	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Conge> conges;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
	private List<Jaime> jaimes;

	public User() {
		super();
	}
	
	

	public User(String last_Name, String first_Name, String email, String addresse, int tel, String user_Name,
			String password, String grade, Date dateNaissance, int cIN, String photo, Role role) {
		
		Last_Name = last_Name;
		First_Name = first_Name;
		Email = email;
		Addresse = addresse;
		Tel = tel;
		User_Name = user_Name;
		Password = password;
		Grade = grade;
		DateNaissance = dateNaissance;
		CIN = cIN;
		Photo = photo;
		this.role = role;
	}



	

	

	public List<Publication> getPublications() {
		return publications;
	}



	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}



	public List<Conge> getConges() {
		return conges;
	}



	public void setConges(List<Conge> conges) {
		this.conges = conges;
	}



	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getLast_Name() {
		return Last_Name;
	}

	public void setLast_Name(String last_Name) {
		Last_Name = last_Name;
	}

	public String getFirst_Name() {
		return First_Name;
	}

	public void setFirst_Name(String first_Name) {
		First_Name = first_Name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddresse() {
		return Addresse;
	}

	public void setAddresse(String addresse) {
		Addresse = addresse;
	}

	public int getTel() {
		return Tel;
	}

	public void setTel(int tel) {
		Tel = tel;
	}

	public String getUser_Name() {
		return User_Name;
	}

	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getGrade() {
		return Grade;
	}

	public void setGrade(String grade) {
		Grade = grade;
	}

	public int getCIN() {
		return CIN;
	}

	public void setCIN(int cIN) {
		CIN = cIN;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public String getStatue() {
		return Statue;
	}

	public void setStatue(String statue) {
		Statue = statue;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Date getDateNaissance() {
		return DateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		DateNaissance = dateNaissance;
	}

	public Boolean getIsActif() {
		return isActif;
	}

	public void setIsActif(Boolean isActif) {
		this.isActif = isActif;
	}

	@Override
	public String toString() {
		return "User [id_user=" + id_user + ", Last_Name=" + Last_Name + ", First_Name=" + First_Name + ", Tel=" + Tel
				+ ", User_Name=" + User_Name + ", Password=" + Password + ", CIN=" + CIN + ", Statue=" + Statue + "]";
	}

}

package pidev.managedbeans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

import pidev.entity.Conge;
import pidev.services.EmployeService;

@ManagedBean(name = "mycongeBean")
@SessionScoped
public class MyCongeBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String dateDebut;
	private String dateFin;
	private String cause; 
	private Conge conge; 
	private List<Conge> Conges;
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean lb;
	private boolean verif;
	
	@EJB
	EmployeService employeService;
	
	@PostConstruct
    public void init(){
		verif=false;
    }
	
	public void AjouterConge () throws ParseException {
		Conge con=new Conge();
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date d=sdf.parse(dateDebut);
		SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd");
		Date d1=sdf1.parse(dateFin);

		if (d.compareTo(d1) > 0) {
			verif = true;
		}else {
		con.setDateFin(d1);
		con.setCause(cause);
		con.setUser(lb.getUser());
		con.setDateDebut(d);

		employeService.ajouterConge(con);
		}
		
	}
	
	public boolean isVerif() {
		return verif;
	}

	public void setVerif(boolean verif) {
		this.verif = verif;
	}

	public List<Conge> getAllConges() {
		Conges = employeService.getAllConges(); 
		return Conges; 
		}
	
	public void removeConge(int idConge) { 
		employeService.deleteCongeById(idConge); 
		} 
	
	
	public void updateConge (Conge conge) {
		this.setDateDebut(conge.getDateDebut().toString());
		this.setDateFin(conge.getDateFin().toString());
		this.setCause(conge.getCause());
		this.conge=conge;
	}
	
	
	public LoginBean getLb() {
		return lb;
	}

	public void setLb(LoginBean lb) {
		this.lb = lb;
	}

	public void mettreAjourConge() throws ParseException{ 
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date d=sdf.parse(dateDebut);
		conge.setDateDebut(d);
		SimpleDateFormat sdf1= new SimpleDateFormat("yyyy-MM-dd");
		Date d1=sdf1.parse(dateFin);
		conge.setDateDebut(d1);
		conge.setCause(cause);
		
		employeService.updateConge(conge); 
		}

	
	
	
	
	


	


	public String getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(String dateDebut) {
		this.dateDebut = dateDebut;
	}

	public String getDateFin() {
		return dateFin;
	}

	public void setDateFin(String dateFin) {
		this.dateFin = dateFin;
	}

	public String getCause() {
		return cause;
	}


	public void setCause(String cause) {
		this.cause = cause;
	}


	public Conge getConge() {
		return conge;
	}


	public void setConge(Conge conge) {
		this.conge = conge;
	}


	public List<Conge> getConges() {
		Conges = employeService.getMyConges(lb.getUser()); 
		return Conges; 
	}


	public void setConges(List<Conge> Conges) {
		this.Conges = Conges;
	}


	public EmployeService getEmployeService() {
		return employeService;
	}


	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}

	
}

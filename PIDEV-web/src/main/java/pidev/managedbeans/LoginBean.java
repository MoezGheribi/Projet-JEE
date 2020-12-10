package pidev.managedbeans;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import pidev.entity.*;
import pidev.services.EmployeService;

@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String user_Name;
	private String password;
	private User user;
	private Boolean loggedIn;
	private int selectedEmployeId;
	@ManagedProperty(value="#{employeBean}")
	private EmployeBean lb;
	private boolean x;

	@EJB
	EmployeService employeService;

	

	public String loginn() {
		String navigateTo = "null";
		
		user = employeService.getEmployeeByLoginAndPassword(user_Name, password);
		
		
		if (user != null) {
			lb.setUser(user);
			loggedIn = true;
			if (user.getRole()==Role.ADMIN){
				x=true;
			navigateTo = "/listConge?faces-redirect=true";
			 }
			 if (user.getRole()==Role.EMPLOYE){
				 x=false;
			 navigateTo="/espacemployee?faces-redirect=true";
			 }

		}

		else {
			FacesContext.getCurrentInstance().addMessage("form:btn", new FacesMessage("bad credentials"));
		}
		return navigateTo;
	}

	public String doLogout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		return "/login?faces-redirect=true";
	}

	
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public EmployeBean getLb() {
		return lb;
	}

	public void setLb(EmployeBean lb) {
		this.lb = lb;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String userName) {
		user_Name = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String passwordd) {
		password = passwordd;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Boolean getLoggedIn() {
		return loggedIn;
	}

	public void setLoggedIn(Boolean loggedIn) {
		this.loggedIn = loggedIn;
	}

	public int getSelectedEmployeId() {
		return selectedEmployeId;
	}

	public void setSelectedEmployeId(int selectedEmployeId) {
		this.selectedEmployeId = selectedEmployeId;
	}

	public EmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;

	}

	public boolean isX() {
		return x;
	}

	public void setX(boolean x) {
		this.x = x;
	}
}

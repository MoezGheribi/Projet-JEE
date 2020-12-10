package pidev.managedbeans;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.UUID;


import pidev.entity.Role;
import pidev.entity.User;

import pidev.services.EmployeService;


@ManagedBean(name = "employeBean")
@SessionScoped
public class EmployeBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String Last_Name;
	private String First_Name;
	private String Email;
	private String Addresse;
	private int Tel;
	private String User_Name;
	private String Password;
	private String Grade;
	private String DateNaissance;
	private int CIN;
	private String Photo;
	private Role role;
	private Part file;
	private boolean upladed;
	public boolean isUpladed() {
		return upladed;
	}



	public void setUpladed(boolean upladed) {
		this.upladed = upladed;
	}

	private User user;
	private List<User> users;
	

	@EJB
	EmployeService employeService;
	
	
	public void uploadFile(String uid){
        try{
            InputStream input=file.getInputStream();
            File f=new File("C:\\Users\\Moez\\git\\PIDEV\\PIDEV-web\\src\\main\\webapp\\image\\"+uid+".jpg");
            if(!f.exists()){
                f.createNewFile();
            }
            FileOutputStream output=new FileOutputStream(f);
            byte[] buffer=new byte[1024];
            int length;
            while((length=input.read(buffer))>0){
                output.write(buffer, 0, length);
            }	
            
            input.close();
            output.close();
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", f.getAbsolutePath());
            upladed=true;
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
        
        try{
            InputStream input=file.getInputStream();
            File f=new File("C:\\Users\\Moez\\git\\PIDEV\\PIDEV-web\\src\\main\\webapp\\image\\"+uid+".jpg");
            if(!f.exists()){
                f.createNewFile();
            }
            FileOutputStream output=new FileOutputStream(f);
            byte[] buffer=new byte[1024];
            int length;
            while((length=input.read(buffer))>0){
                output.write(buffer, 0, length);
            }
            
            input.close();
            output.close();
            
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("path", f.getAbsolutePath());
            upladed=true;
        }catch(Exception e){
            e.printStackTrace(System.out);
        }
    }
	

	
	public void AjouterUser () throws ParseException {
		User e=new User();
		
		String uniqueID = UUID.randomUUID().toString();
		uploadFile( uniqueID);
		
		e.setLast_Name(Last_Name);
		e.setFirst_Name(First_Name);
		e.setEmail(Email);
		e.setAddresse(Addresse);
		e.setTel(Tel);
		e.setUser_Name(User_Name);
		e.setPassword(Password);
		e.setGrade(Grade);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date d=sdf.parse(DateNaissance);
		e.setDateNaissance(d);
		e.setCIN(CIN);
		
		
		e.setPhoto(uniqueID);
		//if (role.equals("ADMIN")) {
		e.setRole(role);
		//}else if (role.equals("MANAGER")) {
			//e.setRole(Role.MANAGER);
		//}else {
			//e.setRole(Role.EMPLOYE);
		//} 
	
		e.setStatue("active");
		e.setIsActif(true);
		
		
		System.out.println(e.toString());
		employeService.ajouterEmploye(e);
		
	}
	
	public List<User> getAllUsers() {
		users = employeService.getAllEmployes(); 
		return users; 
		}

	public void removeUser(int id_user) { 
		employeService.deleteEmployeById(id_user); 
		} 
	
	
	public void updateUser (User e) {
		this.setLast_Name(e.getLast_Name());
		this.setFirst_Name(e.getFirst_Name());
		this.setEmail(e.getEmail());
		this.setAddresse(e.getAddresse());
		this.setTel(e.getTel());
		this.setUser_Name(e.getUser_Name());
		this.setPassword(e.getPassword());
		this.setGrade(e.getGrade());
		if(e.getDateNaissance()!=null) {
		this.setDateNaissance(e.getDateNaissance().toString());}
		else this.setDateNaissance(null);
		this.setCIN(e.getCIN());
		this.setPhoto(e.getPhoto());
		this.setRole(e.getRole());
	}
	
	
	public void mettreAjourEmploye() throws ParseException{ 
		String uniqueID = UUID.randomUUID().toString();
		uploadFile( uniqueID);
		
		user.setLast_Name(Last_Name);
		user.setFirst_Name(First_Name);
		user.setEmail(Email);
		user.setAddresse(Addresse);
		user.setTel(Tel);
		user.setUser_Name(User_Name);
		user.setPassword(Password);
		user.setGrade(Grade);
		SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
		Date d=sdf.parse(DateNaissance);
		user.setDateNaissance(d);
		user.setCIN(CIN);
		user.setPhoto(uniqueID);
		employeService.updateEmploye(user); 
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

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
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

	public String getDateNaissance() {
		return DateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		DateNaissance = dateNaissance;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getUsers() {
		users = employeService.getAllEmployes(); 
		return users; 
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public EmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}
	
	

}

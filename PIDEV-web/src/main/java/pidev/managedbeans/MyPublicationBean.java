package pidev.managedbeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;

import pidev.entity.Publication;
import pidev.services.EmployeService;

@ManagedBean(name = "mypublicationBean")
@SessionScoped
public class MyPublicationBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String descPub;
	private Date datePub;
	private String photoPub;
	private Publication publication;
	private List<Publication> publications;
	@ManagedProperty(value = "#{loginBean}")
	private LoginBean lb;
	private Part file;
	private boolean upladed;
	public boolean isUpladed() {
		return upladed;
	}

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
            File f=new File("C:\\Users\\Moez\\git\\PIDEV\\PIDEV-web\\src\\main\\webapp\\"+uid+".jpg");
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

	public void AjouterPub() {
		Publication p = new Publication();
		
		String uniqueID = UUID.randomUUID().toString();
		uploadFile( uniqueID);
		p.setPhotoPub(uniqueID);
		p.setUser(lb.getUser());
		p.setDescPub(descPub);
		p.setDatePub(new Date());
		this.setPhotoPub(uniqueID);
		
		
		employeService.ajouterPub(p);
		

	}



	public void removePub(int idPub) {
		employeService.deletePubById(idPub);
	}

	public void updatePub(Publication publication) {
		this.setDescPub(publication.getDescPub());
		this.setPhotoPub(publication.getPhotoPub());
		this.publication=publication;
	}

	public void mettreAjourPub() {
		
		
		publication.setDescPub(descPub);
		publication.setPhotoPub(photoPub);
		publication.setDatePub(new Date());
		uploadFile(photoPub);
		employeService.updatePub(publication);
		
	}

	
	
	
	
	public String getPhotoPub() {
		return photoPub;
	}

	public void setPhotoPub(String photoPub) {
		this.photoPub = photoPub;
	}

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public void setUpladed(boolean upladed) {
		this.upladed = upladed;
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

	public LoginBean getLb() {
		return lb;
	}

	public void setLb(LoginBean lb) {
		this.lb = lb;
	}

	public EmployeService getEmployeService() {
		return employeService;
	}

	public void setEmployeService(EmployeService employeService) {
		this.employeService = employeService;
	}

	public List<Publication> getPublications() {
		publications = employeService.getMyPub(lb.getUser());
		
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}



	public Publication getPublication() {
	
		return publication;
	}



	public void setPublication(Publication publication) {
		this.publication = publication;
	}
	
	

}

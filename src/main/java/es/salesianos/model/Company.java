package es.salesianos.model;

import java.sql.Date;

public class Company {
	
	private String name;
	private Date creationDate;
	//private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	public String getName() {
		return name;
	}
	
	public void setName(String nombre) {
		this.name = nombre;
	}
	
	public Date getCreationDate() {
		return creationDate;
	}
	
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}

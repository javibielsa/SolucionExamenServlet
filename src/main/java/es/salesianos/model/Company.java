package es.salesianos.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Company {
	
	private String name;
	private Date creationDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
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
	
	public void setCreationDate(String creationDate) {
		try {
			this.creationDate = sdf.parse(creationDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public String toString() {
		return "Empresa [Nombre=" + name + ", fechaCreacion=" + creationDate + "]";
	}

}

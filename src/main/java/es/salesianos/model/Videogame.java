package es.salesianos.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Videogame {
	
	private String title;
	private String recommendedAge;
	private Date releaseDate;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private String consoleName;
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getRecommendedAge() {
		return recommendedAge;
	}
	
	public void setRecommendedAge(String recommendedAge) {
		this.recommendedAge = recommendedAge;
	}
	
	public Date getReleaseDate() {
		return releaseDate;
	}
	
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	public void setReleaseDate(String releaseDate) {
		try {
			this.releaseDate = sdf.parse(releaseDate);
		} catch (ParseException e) {
			throw new RuntimeException(e);
		}
	}

	public String getConsoleName() {
		return consoleName;
	}

	public void setConsoleName(String consoleName) {
		this.consoleName = consoleName;
	}
	
	public String dateToString() {
		DateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		return formatoFecha.format(this.releaseDate);
	}


}

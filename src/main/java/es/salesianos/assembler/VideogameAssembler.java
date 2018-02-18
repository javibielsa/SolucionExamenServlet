package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Videogame;

public class VideogameAssembler implements Assembler<Videogame>{
	
	public Videogame assembleObjectFrom(HttpServletRequest req) {
		Videogame videogame = new Videogame();
		videogame.setTitle(req.getParameter("title"));
		videogame.setRecommendedAge(req.getParameter("recommendedAge"));
		videogame.setReleaseDate(req.getParameter("releaseDate"));
		videogame.setConsoleName(req.getParameter("consoleName"));
		return videogame;
	}

}

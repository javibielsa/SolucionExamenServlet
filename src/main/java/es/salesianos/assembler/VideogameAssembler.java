package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Videogame;

public class VideogameAssembler implements Assembler<Videogame>{
	
	public Videogame assembleObjectFrom(HttpServletRequest req) {
		Videogame videogame = new Videogame();
		videogame.setTitle(req.getParameter("titulo"));
		videogame.setRecommendedAge(req.getParameter("edadRecomendada"));
		videogame.setReleaseDate(req.getParameter("fechaLanzamiento"));
		videogame.setConsoleName(req.getParameter("nombreConsola"));
		return videogame;
	}

}

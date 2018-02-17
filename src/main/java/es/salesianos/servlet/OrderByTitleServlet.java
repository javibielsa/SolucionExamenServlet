package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Videogame;
import es.salesianos.service.Service;
import es.salesianos.service.VideogameService;

public class OrderByTitleServlet extends HttpServlet{
	
	private Service<Videogame> service = new VideogameService();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Videogame> listVideogames = (List<Videogame>) req.getAttribute("videogames");
		listVideogames = service.orderByTitle();
		req.setAttribute("listVideogames", listVideogames);
		redirect(req,resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListRecommendedAge.jsp");
		dispatcher.forward(req,resp);
	}

}

package es.salesianos.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Videogame;
import es.salesianos.service.VideogameService;

public class OrderVideogamesServlet extends HttpServlet{
	
	private VideogameService service = new VideogameService();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String recommendedAge = req.getParameter("selectedAge");
		req.setAttribute("recommendedAge", recommendedAge);
		List<Videogame> listAllVideogames = service.order(recommendedAge, req.getParameter("order"));
		req.setAttribute("listAllVideogames", listAllVideogames);
		redirect(req,resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListRecommendedAge.jsp");
		dispatcher.forward(req,resp);
	}

}

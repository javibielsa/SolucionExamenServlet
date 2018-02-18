package es.salesianos.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.assembler.VideogameAssembler;
import es.salesianos.model.Videogame;
import es.salesianos.service.Service;
import es.salesianos.service.VideogameService;

public class RegisterVideogameServlet extends HttpServlet{
	
	public Service<Videogame> service = new VideogameService();
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Videogame videogame = new VideogameAssembler().assembleObjectFrom(req);
		service.insert(videogame);
		redirect(req,resp);
	}

	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListVideogames.jsp");
		dispatcher.forward(req,resp);
	}
	


}

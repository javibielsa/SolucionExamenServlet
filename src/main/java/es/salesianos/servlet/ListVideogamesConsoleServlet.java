package es.salesianos.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.service.ConsoleService;
import es.salesianos.service.Service;
import es.salesianos.service.VideogameService;

public class ListVideogamesConsoleServlet extends HttpServlet{
	
private ConsoleService consoleService = new ConsoleService();
private VideogameService service = new VideogameService();
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Console> listAllConsoles = consoleService.listAll();
		req.setAttribute("listAllConsoles", listAllConsoles);
		List<Videogame> listAllVideogames = new ArrayList<Videogame>();
		if(req.getParameter("selectConsole") == null) {
			listAllVideogames = service.listByConsole(listAllConsoles.get(0).getName());
		}else {
			listAllVideogames = service.listByConsole(req.getParameter("selectConsole"));
		}
		req.setAttribute("listAllVideogames", listAllVideogames);
		redirect(req,resp);
	}
	protected void redirect(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/ListVideogamesConsoles.jsp");
		dispatcher.forward(req,resp);
	}
}

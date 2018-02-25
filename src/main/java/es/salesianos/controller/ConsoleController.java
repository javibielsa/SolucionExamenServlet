package es.salesianos.controller;

import javax.websocket.server.PathParam;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.service.ConsoleService;

@Controller
public class ConsoleController {
	
	private static Logger log = LogManager.getLogger(ConsoleController.class);
	
	@Autowired
	private ConsoleService service;
	
	@PostMapping("registerconsole")
	public ModelAndView consoleInsert(@ModelAttribute Console console) {
		log.debug("Insertando la consola:" + console.getName());
		service.insert(console);
		ModelAndView modelAndView = new ModelAndView("RegisterConsole", "command", new Console());
		return modelAndView;
	}
	
	@GetMapping("/ListConsoles")
	public ModelAndView listConsoles() {
		log.debug("Listando todas las consolas");
		ModelAndView modelAndView = new ModelAndView("ListConsoles", "command", new Console());
		modelAndView.addObject("listAllConsoles", service.listAll());
		return modelAndView;
	}
	
	@GetMapping("/RegisterVideogame")
	public ModelAndView registerVideogame() {
		log.debug("Listando todas las consolas");
		ModelAndView modelAndView = new ModelAndView("RegisterVideogame", "command", new Videogame());
		modelAndView.addObject("listAllConsoles", service.listAll());
		return modelAndView;
	}
	
	@GetMapping("/ListVideogamesConsoles")
	public ModelAndView listVideogamesConsoles() {
		log.debug("Listando las consolas...");
		ModelAndView modelAndView = new ModelAndView("ListVideogamesConsoles", "command", new Videogame());
		modelAndView.addObject("listAllConsoles", service.listAll());
		return modelAndView;
	}
	
	@PostMapping("/listConsolesByCompany")
	public ModelAndView listConsolesByCompanies(@ModelAttribute("companyName") String companyName) {
		log.debug("Listando las consolas...");
		ModelAndView modelAndView = new ModelAndView("ListConsolesCompanies", "command", new Console());
		modelAndView.addObject("listAllConsoles", service.listByCompany(companyName));
		return modelAndView;
	}

}

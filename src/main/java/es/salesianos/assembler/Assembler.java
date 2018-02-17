package es.salesianos.assembler;

import javax.servlet.http.HttpServletRequest;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;

public interface Assembler<T> {

	T assembleObjectFrom(HttpServletRequest req);

}

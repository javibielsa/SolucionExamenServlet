package es.salesianos.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import es.salesianos.model.Console;

@Repository
public class ConsoleRepository implements es.salesianos.repository.Repository<Console>{
	
	private static final String SELECT = "SELECT * FROM CONSOLES";
	private static final String INSERT = "INSERT INTO CONSOLES (name,companyName) VALUES (:name,:companyName)";
	private static final String DELETE = "DELETE * FROM CONSOLES WHERE name = :name";
	private static final String SELECTBYNAME = SELECT + " WHERE name = :name";
	private static final String SELECTBYCOMPANY = SELECT + " WHERE companyName = :companyName";
	
	
	private static Logger log = LogManager.getLogger(ConsoleRepository.class);

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public Console search(Console console) {
		log.debug("Ejecutando la consulta: " + SELECTBYNAME);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", console.getName());
		namedJdbcTemplate.update(SELECTBYNAME, params);
		Console listConsole = template.query(SELECTBYNAME, new BeanPropertyRowMapper(Console.class));
		return listConsole;
	}

	public List<Console> searchAll() {
		log.debug("Ejecutando la consulta: " + SELECT);
		List<Console> listConsole = template.query(SELECT, new BeanPropertyRowMapper(Console.class));
		return listConsole;
	}
	
	public List<Console> searchByCompany(String companyName) {
		log.debug("Ejecutando la consulta: " + SELECTBYCOMPANY);
		List<Console> listConsole = namedJdbcTemplate.query(SELECTBYCOMPANY,
                new MapSqlParameterSource("companyName", companyName), (resultSet, i) -> {
                    return toConsole(resultSet);
                });	
		return listConsole;
	}
	
	private Console toConsole(ResultSet resultSet) throws SQLException {
		Console console = new Console();
		console.setName((resultSet.getString("name")));
		console.setCompanyName((resultSet.getString("companyName")));
        return console;
    }
	
	public void insert(Console console) {
		log.debug("Ejecutando la consulta: " + INSERT);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", console.getName());
		params.addValue("companyName", console.getCompanyName());
		namedJdbcTemplate.update(INSERT, params);
	}
	
	public void delete(Console console) {
		log.debug("Ejecutando la consulta: " + DELETE);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", console.getName());
		namedJdbcTemplate.update(DELETE, params);
	}

}

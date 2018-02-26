package es.salesianos.repository;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import es.salesianos.model.Company;

@Repository
public class CompanyRepository implements es.salesianos.repository.Repository<Company>{
	
	private static final String SELECT = "SELECT * FROM COMPANIES";
	private static final String INSERT = "INSERT INTO COMPANIES (name,creationDate) VALUES (:name, :creationDate)";
	private static final String DELETE = "DELETE * FROM COMPANIES WHERE name = :name";
	private static final String SELECTBYNAME = SELECT + " WHERE name = :name";
	
	private static Logger log = LogManager.getLogger(CompanyRepository.class);

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public Company search(Company company) {
		log.debug("Ejecutando la consulta: " + SELECTBYNAME);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", company.getName());
		namedJdbcTemplate.update(SELECTBYNAME, params);
		Company listCompany = template.query(SELECTBYNAME, new BeanPropertyRowMapper(Company.class));
		return listCompany;
	}

	public List<Company> searchAll() {
		log.debug("Ejecutando la consulta: " + SELECT);
		List<Company> listCompany = template.query(SELECT, new BeanPropertyRowMapper(Company.class));
		return listCompany;
	}
	
	public void insert(Company company) {
		log.debug("Ejecutando la consulta: " + INSERT);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", company.getName());
		params.addValue("creationDate", company.getCreationDate());
		namedJdbcTemplate.update(INSERT, params);
	}
	
	public void delete(Company company) {
		log.debug("Ejecutando la consulta: " + DELETE);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("name", company.getName());
		namedJdbcTemplate.update(DELETE, params);
	}

}

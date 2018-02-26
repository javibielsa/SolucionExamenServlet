package es.salesianos.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import es.salesianos.model.Console;
import es.salesianos.model.Videogame;

@Repository
public class VideogameRepository implements es.salesianos.repository.Repository<Videogame>{
	
	private static final String SELECT = "SELECT * FROM VIDEOGAMES";
	private static final String INSERT = "INSERT INTO VIDEOGAMES (title,recommendedAge,releaseDate,consoleName) VALUES (:title,:recommendedAge,:releaseDate, :consoleName)";
	private static final String DELETE = "DELETE * FROM VIDEOGAMES WHERE title = :title";
	private static final String SELECTBYTITLE = SELECT + " WHERE title = :title";
	private static final String SELECTBYCONSOLE = SELECT + " WHERE consoleName = :consoleName";
	private static final String SELECTBYRECOMMENDEDAGE = SELECT + " WHERE recommendedAge = :recommendedAge";
	
	private static Logger log = LogManager.getLogger(VideogameRepository.class);

	@Autowired
	private JdbcTemplate template;

	@Autowired
	private NamedParameterJdbcTemplate namedJdbcTemplate;
	
	public Videogame search(Videogame videogame) {
		log.debug("Ejecutando la consulta: " + SELECTBYTITLE);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("title", videogame.getTitle());
		namedJdbcTemplate.update(SELECTBYTITLE, params);
		Videogame listVideogame = template.query(SELECTBYTITLE, new BeanPropertyRowMapper(Videogame.class));
		return listVideogame;
	}

	public List<Videogame> searchAll() {
		log.debug("Ejecutando la consulta: " + SELECT);
		List<Videogame> listVideogame = template.query(SELECT, new BeanPropertyRowMapper(Videogame.class));
		return listVideogame;
	}
	
	public List<Videogame> searchByConsole(String consoleName){
		log.debug("Ejecutando la consulta: " + SELECTBYCONSOLE);
		List<Videogame> listVideogame = namedJdbcTemplate.query(SELECTBYCONSOLE,
                new MapSqlParameterSource("consoleName", consoleName), (resultSet, i) -> {
                    return toVideogame(resultSet);
                });	
		return listVideogame;
	}
	
	public List<Videogame> searchByRecommendedAge(String recommendedAge){
		log.debug("Ejecutando la consulta: " + SELECTBYRECOMMENDEDAGE);
		List<Videogame> listVideogame = namedJdbcTemplate.query(SELECTBYRECOMMENDEDAGE,
                new MapSqlParameterSource("recommendedAge", recommendedAge), (resultSet, i) -> {
                    return toVideogame(resultSet);
                });	
		return listVideogame;
	}
	
	private Videogame toVideogame(ResultSet resultSet) throws SQLException {
		Videogame videogameInDatabase = new Videogame();
		videogameInDatabase.setTitle((resultSet.getString("title")));
		videogameInDatabase.setRecommendedAge((resultSet.getString("recommendedAge")));
		videogameInDatabase.setReleaseDate((resultSet.getDate("releaseDate")));
		videogameInDatabase.setConsoleName((resultSet.getString("consoleName")));
        return videogameInDatabase;
    }
	
	public String selectOrder(String order) {
		if(order.equals("orderByTitle")) {
			return " ORDER BY title ASC";
		}else{
			return " ORDER BY releaseDate ASC";
		}
	}
	
	public List<Videogame> orderBy(String recommendedAge, String order){
		log.debug("Ejecutando la consulta: " + SELECTBYRECOMMENDEDAGE + selectOrder(order));
		List<Videogame> listVideogame = namedJdbcTemplate.query(SELECTBYRECOMMENDEDAGE + selectOrder(order),
                new MapSqlParameterSource("recommendedAge", recommendedAge), (resultSet, i) -> {
                    return toVideogame(resultSet);
                });	
		return listVideogame;
	}
	
	public void insert(Videogame videogame) {
		log.debug("Ejecutando la consulta: " + INSERT);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("title", videogame.getTitle());
		params.addValue("recommendedAge", videogame.getRecommendedAge());
		params.addValue("releaseDate", videogame.getReleaseDate());
		params.addValue("consoleName", videogame.getConsoleName());
		namedJdbcTemplate.update(INSERT, params);
	}
	
	public void delete(Videogame videogame) {
		log.debug("Ejecutando la consulta: " + DELETE);
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("title", videogame.getTitle());
		namedJdbcTemplate.update(DELETE, params);
	}
	
}
	
	
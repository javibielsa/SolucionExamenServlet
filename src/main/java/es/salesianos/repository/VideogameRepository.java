package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.H2Connection;
import es.salesianos.model.Videogame;

public class VideogameRepository implements Repository<Videogame>{
	
	private static final String SELECT = "SELECT * FROM VIDEOJUEGOS";
	private static final String INSERT = "INSERT INTO VIDEOJUEGOS (titulo,edadRecomendada,fechaLanzamiento, nombreConsola)";
	private static final String DELETE = "DELETE * FROM VIDEOJUEGOS WHERE titulo = ?";
	
	private static final String AGETP = "SELECT * FROM VIDEOJUEGOS";
	private static final String AGE7 = "SELECT * FROM VIDEOJUEGOS WHERE edadRecomendada = '+7' or edadRecomendada = '+13' or edadRecomendada = '+18'";
	private static final String AGE13 = "SELECT * FROM VIDEOJUEGOS WHERE edadRecomendada = '+13' or edadRecomendada = '+18'";
	private static final String AGE18 = "SELECT * FROM VIDEOJUEGOS WHERE edadRecomendada = '+18'";
	
	private H2Connection manager = new H2Connection();
	
	public Videogame search(Videogame videogame) {
		Videogame videogameInDatabase = new Videogame();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = null;
		try {
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement(SELECT + " WHERE titulo = ?");
			prepareStatement.setString(1, videogame.getTitle());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				videogameInDatabase.setTitle(resultSet.getString(1));
				videogameInDatabase.setRecommendedAge(resultSet.getString(2));
				videogameInDatabase.setReleaseDate(resultSet.getDate(3));
				videogameInDatabase.setConsoleName(resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(conn);
		}
			return videogameInDatabase;
		}
	
	public List<Videogame> searchAll() {
		List<Videogame> listVideogames = new ArrayList<Videogame>();
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement("SELECT * FROM VIDEOJUEGOS");
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Videogame videogameInDatabase = new Videogame();
				videogameInDatabase.setTitle(resultSet.getString(1));
				videogameInDatabase.setRecommendedAge(resultSet.getString(2)); 
				videogameInDatabase.setReleaseDate(resultSet.getString(3));
				videogameInDatabase.setConsoleName(resultSet.getString(4));
				listVideogames.add(videogameInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(conn);
		}
		return listVideogames;
	}

	public List<Videogame> searchByConsole(String consoleName){
		List<Videogame> listVideogames = new ArrayList<Videogame>();
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement(SELECT + " WHERE nombreConsola = ?");
			prepareStatement.setString(1, consoleName);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Videogame videogameInDatabase = new Videogame();
				videogameInDatabase.setTitle(resultSet.getString(1));
				videogameInDatabase.setRecommendedAge(resultSet.getString(2));
				videogameInDatabase.setReleaseDate(resultSet.getString(3));
				videogameInDatabase.setConsoleName(resultSet.getString(4));
				listVideogames.add(videogameInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(conn);
		}
		return listVideogames;
	}
	
	public String ageHelper(String recommendedAge) {
		if(recommendedAge.equals("TP")) {
			return AGETP;
		}else if(recommendedAge.equals("+7")) {
			return AGE7;
		}else if(recommendedAge.equals("+13")) {
			return AGE13;
		}else {
			return AGE18;
		}
	}
	
	public List<Videogame> searchByRecommendedAge(String recommendedAge){
		List<Videogame> listVideogames = new ArrayList<Videogame>();
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement(ageHelper(recommendedAge));
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Videogame videogameInDatabase = new Videogame();
				videogameInDatabase.setTitle(resultSet.getString(1));
				videogameInDatabase.setRecommendedAge(resultSet.getString(2));
				videogameInDatabase.setReleaseDate(resultSet.getString(3));
				videogameInDatabase.setConsoleName(resultSet.getString(4));
				listVideogames.add(videogameInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(conn);
		}
		return listVideogames;
	}
	
	public String selectOrder(String order) {
		if(order.equals("orderByTitle")) {
			return " ORDER BY titulo ASC";
		}else{
			return " ORDER BY fechaLanzamiento ASC";
		}
	}
	
	public List<Videogame> orderBy(String recommendedAge, String order){
		List<Videogame> listVideogames = new ArrayList<Videogame>();
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement(ageHelper(recommendedAge) + selectOrder(order));
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Videogame videogameInDatabase = new Videogame();
				videogameInDatabase.setTitle(resultSet.getString(1));
				videogameInDatabase.setRecommendedAge(resultSet.getString(2));
				videogameInDatabase.setReleaseDate(resultSet.getString(3));
				videogameInDatabase.setConsoleName(resultSet.getString(4));
				listVideogames.add(videogameInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(conn);
		}
		return listVideogames;
	}
	
	public void insert(Videogame videogame) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			preparedStatement = conn.prepareStatement(INSERT + "VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, videogame.getTitle());
			preparedStatement.setString(2, videogame.getRecommendedAge());
			preparedStatement.setDate(3, new java.sql.Date(videogame.getReleaseDate().getTime()));
			preparedStatement.setString(4, videogame.getConsoleName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
	
	public void delete(Videogame videogame) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			preparedStatement = conn.prepareStatement(DELETE);
			preparedStatement.setString(1, videogame.getTitle());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
}
	
	
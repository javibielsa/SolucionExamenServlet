package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.salesianos.connection.H2Connection;
import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.model.Videogame;
import es.salesianos.utils.AgeHelper;

public class VideogameRepository implements Repository<Videogame>{
	
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	private static final String SELECT = "SELECT * FROM VIDEOJUEGOS";
	private static final String INSERT = "INSERT INTO VIDEOJUEGOS (titulo,edadRecomendada,fechaLanzamiento, nombreConsola)";
	private static final String DELETE = "DELETE * FROM VIDEOJUEGOS";
	
	H2Connection manager = new H2Connection();
	
	public Videogame search(Videogame ObjectInFormulary) {
		Videogame VideogameInDatabase= null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = null;
		try {
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement(SELECT + " WHERE titulo = ?");
			prepareStatement.setString(1, ObjectInFormulary.getTitle());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				VideogameInDatabase = new Videogame();
				VideogameInDatabase.setTitle(resultSet.getString(1));
				VideogameInDatabase.setRecommendedAge(resultSet.getString(2));
				VideogameInDatabase.setReleaseDate(resultSet.getDate(3));
				VideogameInDatabase.setConsoleName(resultSet.getString(4));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
		}
			manager.close(conn);
			return VideogameInDatabase;
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
				Videogame VideogameInDatabase = new Videogame();
				VideogameInDatabase.setTitle(resultSet.getString(1));
				VideogameInDatabase.setRecommendedAge(resultSet.getString(2)); 
				VideogameInDatabase.setReleaseDate(resultSet.getString(3));
				VideogameInDatabase.setConsoleName(resultSet.getString(4));
				listVideogames.add(VideogameInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
		}
		manager.close(conn);
		return listVideogames;
	}

	public List<Videogame> searchByConsole(String consoleName){
		List<Videogame> listVideogames= null;
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			listVideogames= new ArrayList<Videogame>();
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement(SELECT + " WHERE nombreConsola = ?");
			prepareStatement.setString(1, consoleName);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Videogame VideogameInDatabase = new Videogame();
				VideogameInDatabase.setTitle(resultSet.getString(1));
				VideogameInDatabase.setRecommendedAge(resultSet.getString(2));
				VideogameInDatabase.setReleaseDate(resultSet.getString(3));
				VideogameInDatabase.setConsoleName(resultSet.getString(4));
				
				listVideogames.add(VideogameInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
		}
		manager.close(conn);
		return listVideogames;
	}
	
	public List<Videogame> searchByRecommendedAge(String recommendedAge){
		List<Videogame> listVideogames= null;
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			listVideogames= new ArrayList<Videogame>();
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement(SELECT + " WHERE edadRecomendada = ?");
			prepareStatement.setString(1, recommendedAge);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Videogame VideogameInDatabase = new Videogame();
				VideogameInDatabase.setTitle(resultSet.getString(1));
				VideogameInDatabase.setRecommendedAge(resultSet.getString(2));
				VideogameInDatabase.setReleaseDate(resultSet.getString(3));
				VideogameInDatabase.setConsoleName(resultSet.getString(4));
				
				listVideogames.add(VideogameInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
		}
		manager.close(conn);
		return listVideogames;
	}
	
	@Override
	public List<Videogame> orderTitles() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void insert(Videogame VideogameFormulary) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			preparedStatement = conn.prepareStatement(INSERT + "VALUES (?, ?, ?, ?)");
			preparedStatement.setString(1, VideogameFormulary.getTitle());
			preparedStatement.setString(2, VideogameFormulary.getRecommendedAge());
			preparedStatement.setDate(3, new java.sql.Date(VideogameFormulary.getReleaseDate().getTime()));
			preparedStatement.setString(4, VideogameFormulary.getConsoleName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(preparedStatement);
		}
		manager.close(conn);
	}
	
	public void delete(Videogame VideogameFormulary) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			preparedStatement = conn.prepareStatement(DELETE + " WHERE titulo = ?");
			preparedStatement.setString(1, VideogameFormulary.getTitle());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(preparedStatement);
		}
		manager.close(conn);
	}
	
	public void update(Videogame VideogameFormulary) {
		Connection conn = manager.open(jdbcUrl);
		manager.close(conn);
	}
}
	
	
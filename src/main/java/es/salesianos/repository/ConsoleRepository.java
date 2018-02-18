package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.H2Connection;
import es.salesianos.model.Company;
import es.salesianos.model.Console;
import es.salesianos.model.Videogame;

public class ConsoleRepository implements Repository<Console>{
	
	private static final String SELECT = "SELECT * FROM CONSOLAS";
	private static final String INSERT = "INSERT INTO CONSOLAS (nombre,empresa)";
	private static final String DELETE = "DELETE * FROM CONSOLAS WHERE nombre = ?";
	
	private H2Connection manager = new H2Connection();
	private CompanyRepository repository = new CompanyRepository();
	
	public Console search(Console objectInFormulary) {
		Console console = new Console();
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement(SELECT+" WHERE nombre = ?");
			prepareStatement.setString(1, objectInFormulary.getName());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Console ConsoleInDatabase = new Console();
				ConsoleInDatabase.setName(resultSet.getString(1));
				Company company = new Company();
				company.setName(resultSet.getString(2));
				ConsoleInDatabase.setCompany(repository.search(company));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(conn);
		}
		return console;
	}
	
	
	public List<Console> searchAll() {
		List<Console> listConsoles= null;
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			listConsoles= new ArrayList<Console>();
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement(SELECT);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Console ConsoleInDatabase = new Console();
				ConsoleInDatabase.setName(resultSet.getString(1));
				Company company = new Company();
				company.setName(resultSet.getString(2));
				ConsoleInDatabase.setCompany(repository.search(company));
				
				listConsoles.add(ConsoleInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(conn);
		}
		return listConsoles;
	}
	
	public List<Console> searchByCompany(String formConsole) {
		List<Console> listConsoles= null;
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			listConsoles= new ArrayList<Console>();
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement(SELECT + " WHERE empresa = ?");
			prepareStatement.setString(1, formConsole);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Console ConsoleInDatabase = new Console();
				ConsoleInDatabase.setName(resultSet.getString(1));
				Company company = new Company();
				company.setName(resultSet.getString(2));
				ConsoleInDatabase.setCompany(repository.search(company));
				
				listConsoles.add(ConsoleInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(conn);
		}
		return listConsoles;
	}
	
	public void insert(Console formConsole) {
		Connection conn = manager.open(jdbcUrl);;
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(INSERT + " VALUES (?, ?)");
			preparedStatement.setString(1, formConsole.getName());
			preparedStatement.setString(2, formConsole.getCompany().getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(preparedStatement);
			manager.close(conn);
		}
	}
	
	public void delete(Console formConsole) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			preparedStatement = conn.prepareStatement(DELETE);
			preparedStatement.setString(1, formConsole.getName());
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

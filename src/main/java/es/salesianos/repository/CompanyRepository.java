package es.salesianos.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import es.salesianos.connection.H2Connection;
import es.salesianos.model.Company;
import es.salesianos.model.Videogame;


public class CompanyRepository implements Repository<Company>{
	
	private static final String jdbcUrl = "jdbc:h2:file:./src/main/resources/test;INIT=RUNSCRIPT FROM 'classpath:scripts/create.sql'";
	private static final String SELECT = "SELECT * FROM EMPRESAS";
	private static final String INSERT = "INSERT INTO EMPRESAS (nombre,fechaCreacion)";
	private static final String DELETE = "DELETE * FROM EMPRESAS";
	
	H2Connection manager = new H2Connection();
	
	public Company search(Company ObjectInFormulary) {
		Company CompanyInDatabase= null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement(SELECT + " WHERE nombre = ?");
			prepareStatement.setString(1, ObjectInFormulary.getName());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				CompanyInDatabase = new Company();
				CompanyInDatabase.setName(resultSet.getString(1));
				CompanyInDatabase.setCreationDate(resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			
		}
		manager.close(conn);
		return CompanyInDatabase;
	}
	
	public List<Company> searchAll() {
		List<Company> listCompanys= null;
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
			listCompanys= new ArrayList<Company>();
			conn = manager.open(jdbcUrl);
			prepareStatement = conn.prepareStatement(SELECT);
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				Company CompanyInDatabase = new Company();
				CompanyInDatabase.setName(resultSet.getString(1));
				CompanyInDatabase.setCreationDate(resultSet.getString(2));
				listCompanys.add(CompanyInDatabase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
		}
		manager.close(conn);
		return listCompanys;
	}

	public void insert(Company CompanyInFormulary) {
		Connection conn = manager.open(jdbcUrl);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(INSERT + " VALUES (?, ?)");
			preparedStatement.setString(1, CompanyInFormulary.getName());
			preparedStatement.setDate(2, new java.sql.Date(CompanyInFormulary.getCreationDate().getTime()));
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(preparedStatement);
		}
		manager.close(conn);
	}
	
	public void delete(Company CompanyInFormulary) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			preparedStatement = conn.prepareStatement(DELETE + " WHERE nombre = ?");
			preparedStatement.setString(1, CompanyInFormulary.getName());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(preparedStatement);
		}
		manager.close(conn);
	}

	public void update(Company CompanyInFormulary) {
		Connection conn = manager.open(jdbcUrl);
		manager.close(conn);
	}

	@Override
	public List<Videogame> searchByRecommendedAge(String recommendedAge) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videogame> searchByConsole(String consoleName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Videogame> orderTitles() {
		// TODO Auto-generated method stub
		return null;
	}

}

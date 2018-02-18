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
	
	private static final String SELECT = "SELECT * FROM EMPRESAS";
	private static final String INSERT = "INSERT INTO EMPRESAS (nombre,fechaCreacion) VALUES (?, ?)";
	private static final String DELETE = "DELETE * FROM EMPRESAS WHERE nombre = ?";
	
	private H2Connection manager = new H2Connection();
	
	public Company search(Company objectInFormulary) {
		Company CompanyInDatabase = new Company();
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		Connection conn = manager.open(jdbcUrl);
		try {
			prepareStatement = conn.prepareStatement(SELECT + " WHERE nombre = ?");
			prepareStatement.setString(1, objectInFormulary.getName());
			resultSet = prepareStatement.executeQuery();
			while(resultSet.next()){
				CompanyInDatabase.setName(resultSet.getString(1));
				CompanyInDatabase.setCreationDate(resultSet.getString(2));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}finally {
			manager.close(resultSet);
			manager.close(prepareStatement);
			manager.close(conn);
			
		}
		return CompanyInDatabase;
	}
	
	public List<Company> searchAll() {
		List<Company> listCompanys = new ArrayList<Company>();
		Connection conn = null;
		ResultSet resultSet = null;
		PreparedStatement prepareStatement = null;
		try {
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
			manager.close(conn);
		}
		return listCompanys;
	}

	public void insert(Company CompanyInFormulary) {
		Connection conn = null;
		PreparedStatement preparedStatement = null;
		try {
			conn = manager.open(jdbcUrl);
			preparedStatement = conn.prepareStatement(INSERT);
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
			preparedStatement = conn.prepareStatement(DELETE);
			preparedStatement.setString(1, CompanyInFormulary.getName());
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

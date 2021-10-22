package com.task.address.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.task.address.model.Address;



public class AddressDao {
	private String jdbcURL = "jdbc:mysql://localhost:3306/dbalamin?useSSL=false";
	private String jdbcUsername = "root";
	private String jdbcPassword = "Alamin@9145";

	private static final String INSERT_ADDRESSES_SQL = "INSERT INTO addresses" + "  (name, email, country,streetline1,streetline2,city,pin,state) VALUES "
			+ " (?, ?, ?,?,?,?,?,?);";

	private static final String SELECT_ADDRESS_BY_ID = "select id,name,email,country,streetline1,streetline2,city,pin,state from users where id =?";
	private static final String SELECT_ALL_ADDRESSES = "select * from addresses";
	private static final String DELETE_ADDRESSES_SQL = "delete from addresses where id = ?;";
	private static final String UPDATE_ADDRESSES_SQL = "update addresses set name = ?,email= ?, country =? ,streetline1 =?,streetline2 =?,city =?,pin =?,state =? where id = ?;";

	public AddressDao() {
	}

	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	public void insertAddress(Address address) throws SQLException {
		System.out.println(INSERT_ADDRESSES_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(INSERT_ADDRESSES_SQL)) {
			preparedStatement.setString(1, address.getName());
			preparedStatement.setString(2, address.getEmail());
			preparedStatement.setString(3, address.getCountry());
			preparedStatement.setString(4, address.getStreetline1());
			preparedStatement.setString(5, address.getStreetline2());
			preparedStatement.setString(6, address.getCity());
			preparedStatement.setInt(7, address.getPin());
			preparedStatement.setString(8, address.getState());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}

	public Address selectAddress(int id) {
		Address address = null;
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();
				// Step 2:Create a statement using connection object
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ADDRESS_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				String streetline1 = rs.getString("streetline1");
				String streetline2 = rs.getString("streetline2");
				String city = rs.getString("city");
				Integer pin = rs.getInt("pin");
				String state = rs.getString("state");
				
				
				address = new Address(id, name, email, country, streetline1, streetline2, city, pin, state);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return address;
	}

	public List<Address> selectAllAddresses() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Address> addresses = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_ADDRESSES);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String country = rs.getString("country");
				String streetline1 = rs.getString("streetline1");
				String streetline2 = rs.getString("streetline2");
				String city = rs.getString("city");
				Integer pin = rs.getInt("pin");
				String state = rs.getString("state");
				addresses.add(new Address(id, name, email, country, streetline1, streetline2, city, pin, state));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return addresses;
	}

	public boolean deleteAddresses(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_ADDRESSES_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}

	public boolean updateAddress(Address address) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_ADDRESSES_SQL);) {
			statement.setString(1, address.getName());
			statement.setString(2, address.getEmail());
			statement.setString(3, address.getCountry());
			statement.setInt(9, address.getId());
			statement.setString(4, address.getStreetline1());
		    statement.setString(5, address.getStreetline2());
			statement.setString(6, address.getCity());
			statement.setInt(7, address.getPin());
			statement.setString(8, address.getState());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

	
	

}

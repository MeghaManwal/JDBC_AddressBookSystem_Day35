package com.multithreading;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AddressBookRepo {

	public void insertMultipleRecord(AddressBookData value) throws SQLException {
		
		Connection connection = null;
		PreparedStatement prepstatement = null;
		
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/AddressBook_System", "root", "");
			try {
				connection.setAutoCommit(false);
				String query = "insert into AddressBook(FirstName,LastName,Address,City,State,ZipCode,PhoneNumber,EmailId,date_added) value(?,?,?,?,?,?,?,?,?)";
				prepstatement = connection.prepareStatement(query);
				prepstatement.setString(1, value.FirstName);
				prepstatement.setString(2, value.LastName);
				prepstatement.setString(3, value.Address);
				prepstatement.setString(4, value.City);
				prepstatement.setString(5, value.State);
				prepstatement.setString(6, value.ZipCode);
				prepstatement.setString(7, value.PhoneNumber);
				prepstatement.setString(8, value.EmailId);
				prepstatement.setString(9, value.date_added);
				
				prepstatement.executeUpdate();
				connection.commit();

		     }catch (SQLException e) {
				     e.printStackTrace();
					 connection.rollback();
					 System.out.println("Rolled back Successfully");
				}catch (Exception e1) {
					e1.printStackTrace();
				}
			    }catch (Exception e) {
				    e.printStackTrace();
			 }finally {
			 	if(connection != null) {
			 		connection.close();
				}
				if(prepstatement != null) {
					prepstatement.close();
				}
			 }
	}

}

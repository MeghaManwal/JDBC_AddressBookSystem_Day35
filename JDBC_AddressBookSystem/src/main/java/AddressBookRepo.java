import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AddressBookRepo {

	public List<Contacts> findAll() throws SQLException {
		 List<Contacts> infos=new ArrayList<>();
		
		 Connection connection = null;
		 PreparedStatement prepstatement = null;
		 try {
		//Step1: Load & Register Driver Class
		 DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
		
		//Step2: Establish a MySql Connection
		 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook_System", "root", "");
		
		//Step3: Create Statement
		  String query =" select * from AddressBook ";
		  prepstatement = connection.prepareStatement(query);
		 
		//Step4: Execute Query
		 ResultSet resultset = prepstatement.executeQuery();
	
		 while(resultset.next()) {
			Contacts information = new Contacts();
			
			int id=resultset.getInt(1);
			information.setContact_Id(id);
			
			String firstname = resultset.getString(2);
			information.setFirstName(firstname);
			
			String lastname = resultset.getString(3);
			information.setLastName(lastname);
			
			String address = resultset.getString(4);
			information.setAddress(address);
			
			String city = resultset.getString(5);
			information.setCity(city);
			
			String state = resultset.getString(6);
			information.setState(state);
			
			String zip = resultset.getString(7);
			information.setZipCode(zip);
			
			String phoneNumber = resultset.getString(8);
			information.setPhoneNumber(phoneNumber);
			
			String emailId = resultset.getString(9);
			information.setEmailId(emailId);
			
			infos.add(information);
		  }
		  }catch (SQLException e) {
			e.printStackTrace();
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
		  return infos;	
	}

	 public void updatedata(int contact_ID, String address) throws SQLException {
		
		    Connection connection = null;
			PreparedStatement prepstate = null;
			try {
			//Step1: Load & Register Driver Class
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
			
			//Step2: Establish a MySql Connection
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook_System", "root", "");
			
			//Step3: Create Statement
			 String query ="Update AddressBook set address=? where contact_ID=?";
			 prepstate = connection.prepareStatement(query);
			 prepstate.setString(1, address);
			 prepstate.setInt(2, contact_ID);
			
			//Step4: Execute Query
			 prepstate.executeUpdate();
			 System.out.print("Records Updated!");
			
			 }catch (SQLException e) {
				e.printStackTrace();
			 }catch (Exception e) {
				e.printStackTrace();
			 }finally {
				if(connection != null) {
				   connection.close();
				}
				if(prepstate != null) {
				   prepstate.close();
				}
			}
	 }

	public List<Contacts> findAllForParticularDate() throws SQLException {

		List<Contacts> infos=new ArrayList<>();
		Connection connection = null;
		PreparedStatement prepstatement = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook_System", "root", "");
			
			String query ="Select * from AddressBook where date_added between Cast('2020-02-01' as date) and date(now())";
			prepstatement = connection.prepareStatement(query);
			
			ResultSet resultset = prepstatement.executeQuery();
			
			while(resultset.next()) {
				Contacts information = new Contacts();
				
				int id=resultset.getInt(1);
				information.setContact_Id(id);
				
				String firstname = resultset.getString(2);
				information.setFirstName(firstname);
				
				String lastname = resultset.getString(3);
				information.setLastName(lastname);
				
				String address = resultset.getString(4);
				information.setAddress(address);
				
				String city = resultset.getString(5);
				information.setCity(city);
				
				String state = resultset.getString(6);
				information.setState(state);
				
				String zip = resultset.getString(7);
				information.setZipCode(zip);
				
				String phoneNumber = resultset.getString(8);
				information.setPhoneNumber(phoneNumber);
				
				String emailId = resultset.getString(9);
				information.setEmailId(emailId);
				
				infos.add(information);
			}
			}catch (SQLException e) {
				e.printStackTrace();
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
			return infos;
	}

	public void findAllForParticularCityorState() throws SQLException {
		
		List<Contacts> infos=new ArrayList<>();
		Connection connection = null;
		PreparedStatement prepstatement = null;
		try {
			DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook_System", "root", "Varsha@!4455");
			
			String query ="Select count(*) from AddressBook where City='Bangalore' or State='Uttarakhand'";
			prepstatement = connection.prepareStatement(query);
			
			ResultSet result = prepstatement.executeQuery();
			
			result.next();
			int count = result.getInt(1);
			System.out.println("Number of Records: "+count);
			}catch (SQLException e) {
				e.printStackTrace();
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

	public void insertRecord(Contacts info) throws SQLException {
	
		Connection connection = null;
		Statement statement = null;
		try {
		//Step1: Load & Register Driver Class
		DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver ());
		
		//Step2: Establish a MySql Connection
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook_System", "root", "");
		
		//Step3: Create Statement
		 statement = connection.createStatement();
		
		//Step4: Execute Query
		String query = "insert into AddressBook(FirstName, LastName, Address, City, State, ZipCode, PhoneNumber, EmailId, date_Added) "
				        + "value('"+info.getFirstName()+"','"+info.getLastName()+"','"+info.getAddress()+"','"+info.getCity()+"','"+info.getState()+"','"+info.getZipCode()+"','"+info.getPhoneNumber()+ "','"+info.getEmailId()+ "','"+info.getDate()+"')";
		int result = statement.executeUpdate(query);
		System.out.print(result);
		
		}catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(connection != null) {
				connection.close();
			}
			if(statement != null) {
				statement.close();
			}
		}
		
	}

}

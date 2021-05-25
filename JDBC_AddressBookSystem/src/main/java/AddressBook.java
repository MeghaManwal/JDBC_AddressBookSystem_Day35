import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	static final Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		System.out.println(" Press 1 to Reterive data\n Press 2 to Update data\n Press 3 to Reterive Data for Particular Date");
		int choice = s.nextInt();
		
		switch(choice) {
		case 1:
			  ReteriveData();
			  break;
		case 2:
			  UpdateData();
			  break;
		case 3:
			  ReteriveDataForParticularDate();
			  break;	  
		}
	}
	
	
	private static void ReteriveData() throws SQLException {
		AddressBookRepo repo = new AddressBookRepo();
		List<Contacts> contact = repo.findAll();
		contact.forEach(System.out::println);
	}
		
	private static void UpdateData() throws SQLException {
		System.out.println("Enter Contact_Id");
	    int Contact_ID = s.nextInt();
		
		System.out.println("Enter Address");
	    String Address = s.next();
		
	    AddressBookRepo repo = new AddressBookRepo();
		repo.updatedata(Contact_ID, Address);
			
	}
	
	private static void ReteriveDataForParticularDate() throws SQLException {
		AddressBookRepo repo = new AddressBookRepo();
		List<Contacts> infos = repo.findAllForParticularDate();
		infos.forEach(System.out::println);
		
	}
}

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	static final Scanner s = new Scanner(System.in);
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		System.out.println(" Press 1 to Reterive data\n Press 2 to Update data\n Press 3 to Reterive Data for Particular Date"+
				           "\n Press 4 to Reterive Data for Particular Date\n Press 5 to Add Data");
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
		case 4:
			  ReteriveDataForParticularCityorState();
			  break;
		case 5:
			  AddData();
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
	
    private static void ReteriveDataForParticularCityorState() throws SQLException {
    	AddressBookRepo repo = new AddressBookRepo();
		 repo.findAllForParticularCityorState();	
	}
    
    private static void AddData() throws SQLException {
    	Contacts info = new Contacts();
    	
    	System.out.println("Enter FirstName");
		info.setFirstName(s.next());
		
		System.out.println("Enter LastName");
		info.setLastName(s.next());
		
		System.out.println("Enter Address");
		info.setAddress(s.next());
		
		System.out.println("Enter City");
		info.setCity(s.next());
		
		System.out.println("Enter State");
		info.setState(s.next());
		
		System.out.println("Enter ZipCode");
		info.setZipCode(s.next());
		
		System.out.println("Enter PhoneNumber");
		info.setPhoneNumber(s.next());
		
		System.out.println("Enter EmailId");
		info.setEmailId(s.next());
		
		System.out.println("Enter Date Added");
		info.setDate(s.next());
			
		AddressBookRepo repo = new AddressBookRepo();
		repo.insertRecord(info);
		
	}
}

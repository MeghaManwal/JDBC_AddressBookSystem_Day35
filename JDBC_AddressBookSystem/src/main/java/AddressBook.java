import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner s = new Scanner(System.in);
		
		AddressBookRepo repo = new AddressBookRepo();
		List<Contacts> contact = repo.findAll();
		contact.forEach(System.out::println);
	}
}

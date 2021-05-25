
public class Contacts {
	   
	   private int Contact_Id;
	   private String FirstName;
	   private String LastName;
	   private String Address;
	   private String City;
	   private String State;
	   private String ZipCode;
	   private String PhoneNumber;
	   private String EmailId;
	   
	public int getContact_Id() {
		return Contact_Id;
	}
	public void setContact_Id(int contact_Id) {
		Contact_Id = contact_Id;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return City;
	}
	public void setCity(String city) {
		City = city;
	}
	public String getState() {
		return State;
	}
	public void setState(String state) {
		State = state;
	}
	public String getZipCode() {
		return ZipCode;
	}
	public void setZipCode(String zipCode) {
		ZipCode = zipCode;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getEmailId() {
		return EmailId;
	}
	public void setEmailId(String emailId) {
		EmailId = emailId;
	}
	@Override
	public String toString() {
		return "Contacts [Contact_Id=" + Contact_Id + ", FirstName=" + FirstName + ", LastName=" + LastName
				+ ", Address=" + Address + ", City=" + City + ", State=" + State + ", ZipCode=" + ZipCode
				+ ", PhoneNumber=" + PhoneNumber + ", EmailId=" + EmailId + "]";
	}
	    
		

}

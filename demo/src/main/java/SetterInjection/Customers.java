package SetterInjection;


import java.util.Properties;

public class Customers {
	private String name;
	private long contact;
	private Properties address;
	public void setAddress(Properties address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public Properties getAddress() {
		return address;
	}
	

	
}

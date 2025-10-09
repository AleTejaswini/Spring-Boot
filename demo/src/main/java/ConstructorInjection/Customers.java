package ConstructorInjection;

import java.util.Map;
import java.util.Properties;

public class Customers {
	private String name;
	private long contact;
	private Properties address;
	public Customers(String name, long contact, Properties address) {
		super();
		this.name = name;
		this.contact = contact;
		this.address = address;
	}
	public Customers(String Companyname, Properties employeenames) {
		System.out.println("Company name: " +Companyname);
		System.out.println("Employee name: " +employeenames);
	}
	
	@Override
	public String toString() {
		return "Customers [name=" + name + ", contact=" + contact + ", address=" + address + "]";
	}
	
	
}

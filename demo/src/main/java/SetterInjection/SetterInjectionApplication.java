package SetterInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("setter.xml");
		Customers cust = (Customers) context.getBean("customer1");
		
		System.out.println("Name: " +cust.getName());
		System.out.println("Contact: " +cust.getContact());
		System.out.println("Address: " +cust.getAddress());
		
		
//		Orders order = (Orders) context.getBean("order1");
//		
//		System.out.println("OrderName: " +order.getOrdername());
//		System.out.println("OrderId: " +order.getOrderid());
//		System.out.println("Customer Name: " +order.getCustomers().getName());
//		System.out.println("Customer Contact: " +order.getCustomers().getContact());
//		System.out.println("Customer Address: " +order.getCustomers().getAddress());
	}

}
